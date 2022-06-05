
package main;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Stu_login extends Frame implements ActionListener
{

    Frame f;
    Label l1,l2,l3;
    TextField t1,t2;
    Button b1,b2,b3,b4;
    Connection c;
    Statement s;
    ResultSet r1;
    String s1;
    Stu_login()
    {
        f=new Frame("Student Login");
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        l1=new Label("Username");
        l1.setBounds(50, 100, 100, 50);
        f.add(l1);
        t1=new TextField("");
        t1.setBounds(150,100,150,50);
        f.add(t1);
        l2=new Label("Password");
        l2.setBounds(50, 200, 100, 50);
        f.add(l2);
        t2=new TextField("");
        t2.setBounds(150,200,150,50);
        f.add(t2);
        t2.setEchoChar('*');
        b1=new Button("Login");
        b1.setBounds(50, 300, 80, 30);
        f.add(b1);
        b1.addActionListener(this);
        b2=new Button("Clear");
        b2.setBounds(160, 300, 80, 30);
        f.add(b2);
        b2.addActionListener(this);
        b3=new Button("Exit");
        b3.setBounds(260, 300, 80, 30);
        f.add(b3);
        b3.addActionListener(this);
        b4=new Button("Sign up");
        b4.setBounds(160, 350, 80, 30);
        f.add(b4);
        b4.addActionListener(this);
        try
        {
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
                String name=t1.getText();
                String roll=t2.getText();
                String dbname;
                String dbroll;
                
                s1="select * from studetails";
                r1=s.executeQuery(s1);
                while(r1.next())
                {
                    dbroll=r1.getString(12);
                    dbname=r1.getString(2);
                    if(name.equals(dbname) && roll.equals(dbroll))
                    {
                        Student sobj1=new Student();
                        f.dispose();
                    }
                    else 
                    {
                        l3=new Label("** Invalid Username or Password");
                        l3.setForeground(Color.RED);
                        f.add(l3);
                        l3.setBounds(50, 250, 200, 50); 
                        System.out.println("Unsuccessful");
                    }
                }
                    
                
            }
            else if(e.getSource()==b2)
            {
                t1.setText("");
                t2.setText("");
            }
            else if(e.getSource()==b3)
            {
                f.dispose();
            }
            
            else if(e.getSource()==b4)
            {
                Sign_up suboj=new Sign_up();
                f.dispose();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
