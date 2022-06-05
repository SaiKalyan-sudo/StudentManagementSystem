
package main;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Fees extends Frame implements ActionListener
{

    Frame f;
    Label l1,l2,l3,l4,l5,l6,l7;
    TextField t1,t2,t3,t4,t5,t6;
    Button b1,b2,b3;
    Connection c;
    Statement s;
    ResultSet r1;
    String s1;
    Fees()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        c=DriverManager.getConnection("jdbc:odbc:studetails");
        s=c.createStatement();
        System.out.println("Connected");
        f=new Frame("Student Fees Details");
        f.setSize(400, 700);
        f.setLayout(null);
        f.setVisible(true);
        l1=new Label("Reg_no");
        l1.setBounds(50, 100, 100, 50);
        f.add(l1);
        t1=new TextField("");
        t1.setBounds(150,100,150,50);
        f.add(t1);
        l2=new Label("Student Name");
        l2.setBounds(50, 200, 100, 50);
        f.add(l2);
        t2=new TextField("");
        t2.setBounds(150,200,150,50);
        f.add(t2);
        t2.setEditable(false);
        l3=new Label("Actual Fees");
        l3.setBounds(50, 300, 100, 50);
        f.add(l3);
        t3=new TextField("");
        t3.setBounds(150,300,150,50);
        f.add(t3);
        t3.setEditable(false);
        l4=new Label("Fees Pay");
        l4.setBounds(50, 400, 100, 50);
        f.add(l4);
        t4=new TextField("");
        t4.setBounds(150,400,150,50);
        f.add(t4);
        t4.setEditable(false);
        l5=new Label("Balance");
        l5.setBounds(50, 500, 100, 50);
        f.add(l5);
        t5=new TextField("");
        t5.setBounds(150,500,150,50);
        f.add(t5);
        t5.setEditable(false);
        b1=new Button("Check");
        b1.setBounds(50,600,80,30);
        f.add(b1);
        b1.addActionListener(this);
        b2=new Button("Clear");
        b2.setBounds(150,600,80,30);
        f.add(b2);
        
        b2.addActionListener(this);
         b3=new Button("Exit");
        b3.setBounds(250,600,80,30);
        f.add(b3);
        b3.addActionListener(this);
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        c=DriverManager.getConnection("jdbc:odbc:studetails");
        s=c.createStatement();
        System.out.println("Connected");
        }   
        catch(Exception ex)
        {
            
        }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       try
       {
            if(e.getSource()==b1)
            {
                if(e.getSource()==b1)
                {
                    String reg=t1.getText();
                    String dbreg;
                    String dbname;
                    String dbfees,dbpayfees,dbbalance;                    
                    s1="select * from studetails";
                    r1=s.executeQuery(s1);
                    while(r1.next())
                    {
                        dbreg=r1.getString(1);
                        if(dbreg.equals(reg))
                        {
                            dbname=r1.getString(2);
                            dbfees=r1.getString(8);
                            dbpayfees=r1.getString(9);
                            dbbalance=r1.getString(10);
                            t2.setText(dbname);
                            t3.setText(dbfees);
                            t4.setText(dbpayfees);
                            t5.setText(dbbalance);
                                
                        }
                        
                    }
            }
       }
            else if(e.getSource()==b2)
                {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                   
                }
                else if(e.getSource()==b3)
                {
                   
                    f.dispose();
                    
                }
            
       }
       catch(Exception ex)
       {
           
       }
    }
        
}
