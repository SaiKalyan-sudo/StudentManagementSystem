
package main;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Student extends Frame implements ActionListener
{

    Frame f;
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    Button b1,b2,b3,b4;
    Connection c;
    Statement s;
    ResultSet r1;
    String s1;
    Student()
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        c=DriverManager.getConnection("jdbc:odbc:studetails");
        s=c.createStatement();
        System.out.println("Connected");
        f=new Frame("Student Details");
        f.setSize(650, 1000);
        f.setLayout(null);
        f.setVisible(true);
        l1=new Label("Student Reg_no");
        l1.setBounds(50, 100, 100, 50);
        f.add(l1);        
        t1=new TextField("");
        t1.setBounds(150, 100, 150, 50);
        f.add(t1);
        l2=new Label("Student Name");
        l2.setBounds(320, 100, 100, 50);
        f.add(l2); 
        t2=new TextField("");
        t2.setBounds(430, 100, 150, 50);
        f.add(t2);
        t2.setEditable(false);
        l3=new Label("No of Present");
        l3.setBounds(50, 200, 100, 50);
        f.add(l3); 
        t3=new TextField("");
        t3.setBounds(150, 200, 150, 50);
        f.add(t3);
        t3.setEditable(false);
        l4=new Label("No of Absent");
        l4.setBounds(320, 200, 100, 50);
        f.add(l4); 
        t4=new TextField("");
        t4.setBounds(430, 200, 150, 50);
        f.add(t4);
        t4.setEditable(false);
        l8=new Label("Subject");
        l8.setBounds(50, 300, 100, 50);
        f.add(l8);
        t8=new TextField("");
        t8.setBounds(150, 300, 150, 50);
        f.add(t8);
        t8.setEditable(false);
        l5=new Label("Mark");
        l5.setBounds(50, 400, 100, 50);
        f.add(l5); 
        t5=new TextField("");
        t5.setBounds(150, 400, 150, 50);
        f.add(t5);
        t5.setEditable(false);
        l6=new Label("Grade");
        l6.setBounds(320, 400, 100, 50);
        f.add(l6); 
        t6=new TextField("");
        t6.setBounds(430, 400, 150, 50);
        t6.setEditable(false);
        f.add(t6);
        l7=new Label("Assignment");
        l7.setBounds(50, 500, 100, 50);
        f.add(l7); 
        t7=new TextField("");
        t7.setBounds(150, 500, 430, 50);
        f.add(t7);
        t7.setEditable(false);
        l9=new Label("G-Mail");
        l9.setBounds(50, 600, 100, 50);
        f.add(l9); 
        t9=new TextField("");
        t9.setBounds(150, 600, 150, 50);
        f.add(t9);
        t9.setEditable(false);
        l10=new Label("Phone-no");
        l10.setBounds(320, 600, 100, 50);
        f.add(l10); 
        t10=new TextField("");
        t10.setBounds(430, 600, 150, 50);
        f.add(t10);
        t10.setEditable(false);
        l11=new Label("Branch");
        l11.setBounds(50, 700, 100, 50);
        f.add(l11); 
        t11=new TextField("");
        t11.setBounds(150, 700, 150, 50);
        f.add(t11);
        t11.setEditable(false);
        l12=new Label("Address");
        l12.setBounds(320, 700, 100, 50);
        f.add(l12); 
        t12=new TextField("");
        t12.setBounds(430, 700, 150, 50);
        f.add(t12);
        t12.setEditable(false);
        
        b1=new Button("Detail");
        b1.setBounds(20, 900, 120, 50);
        f.add(b1);
        b1.addActionListener(this);
        b2=new Button("Clear");
        b2.setBounds(170, 900, 120, 50);
        f.add(b2);
        b2.addActionListener(this);
        b3=new Button("Exit");
        b3.setBounds(320, 900, 120, 50);
        f.add(b3);
        b3.addActionListener(this);
        b4=new Button("Fees");
        b4.setBounds(470, 900, 120, 50);
        f.add(b4);
        b4.addActionListener(this);
        
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
                    String reg=t1.getText();
                    String dbreg;
                    String dbname;
                    String dbpresent,dbabsent,dbmark,dbgrade;                    
                    String dbass,dbsub,dbgmail,dbpho,dbcou,dbadd;
                    s1="select * from studetails";
                    r1=s.executeQuery(s1);
                    while(r1.next())
                    {
                        dbreg=r1.getString(1);
                        if(dbreg.equals(reg))
                        {
                            dbname=r1.getString(2);
                            dbpresent=r1.getString(3);
                            dbabsent=r1.getString(4);
                            dbmark=r1.getString(5);
                            dbgrade=r1.getString(6);
                            dbass=r1.getString(7);
                            dbsub=r1.getString(17);
                            dbgmail=r1.getString(13);
                            dbpho=r1.getString(14);
                            dbcou=r1.getString(15);
                            dbadd=r1.getString(16);
                            t2.setText(dbname);
                            t3.setText(dbpresent);
                            t4.setText(dbabsent);
                            t5.setText(dbmark);
                            t6.setText(dbgrade);
                            t7.setText(dbass);
                            t8.setText(dbsub);
                            t9.setText(dbgmail);
                            t10.setText(dbpho);
                            t11.setText(dbcou);
                            t12.setText(dbadd);
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
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    t10.setText("");
                    t11.setText("");
                    t12.setText("");
                    
                    
                }
                else if(e.getSource()==b3)
                {
                   
                    f.dispose();
                    
                }
                else if(e.getSource()==b4)
                {
                   
                    Fees obj4=new Fees();
                    
                }
        }
        catch(Exception ex)
        {
            
        }
    }
    
}
