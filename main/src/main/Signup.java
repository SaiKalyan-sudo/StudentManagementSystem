package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hp
 */
public class Signup extends Frame implements ActionListener
{
    
    Frame f;
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    Button b1,b2,b3,b4;
    Connection c;
    Statement s;
    ResultSet r1;
    String s1;
    Signup()
    {
        System.out.println("Hello Signup");
        f=new Frame("Faculty Details");
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        l1=new Label("Faculty Reg_no");
        l1.setBounds(50, 100, 100, 50);
        f.add(l1);
        t1=new TextField("");
        t1.setBounds(200, 110, 100, 30);
        f.add(t1);
        l2=new Label("Faculty Name");
        l2.setBounds(50, 130, 100, 50);
        f.add(l2); 
        t2=new TextField("");
        t2.setBounds(200, 140, 100, 30);
        f.add(t2);
        l3=new Label("New Password");
        l3.setBounds(50, 160, 100, 50);
        f.add(l3); 
        t3=new TextField("");
        t3.setBounds(200, 170, 100, 30);
        f.add(t3);
        l4=new Label("G-Mail");
        l4.setBounds(50, 190, 100, 50);
        f.add(l4); 
        t4=new TextField("");
        t4.setBounds(200, 200, 100, 30);
        f.add(t4);
        l5=new Label("Phone Number");
        l5.setBounds(50, 220, 100, 50);
        f.add(l5); 
        t5=new TextField("");
        t5.setBounds(200, 230, 100, 30);
        f.add(t5);
        l6=new Label("Course");
        l6.setBounds(50, 250, 100, 50);
        f.add(l6); 
        t6=new TextField("");
        t6.setBounds(200, 260, 100, 30);
        f.add(t6);
        b1=new Button("Insert");
        b1.setBounds(30, 330, 100, 30);
        f.add(b1);
        b1.addActionListener(this);
        b2=new Button("Clear");
        b2.setBounds(140, 330, 100, 30);
        f.add(b2);
        b2.addActionListener(this);
        b3=new Button("Exit");
        b3.setBounds(250, 330, 100, 30);
        f.add(b3);
        b3.addActionListener(this);
        
        
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
    
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            if(e.getSource()==b1)
            {
                String id=t1.getText();
                String name=t2.getText();
                String password=t3.getText();
                String mail=t4.getText();
                String number=t5.getText();
                String course=t6.getText();
                System.out.println(name);
                int m=Integer.parseInt(number);
                    s1="insert into Staffdetails(Staff_id,Staff_name,Staff_Password,Staff_Mail,Staff_Number,Staff_Course) values('"+id+"','"+name+"','"+password+"','"+mail+"','"+number+"','"+course+"')";        
                    s=c.createStatement();
                    s.executeUpdate(s1);
                    System.out.println("Insert Success");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                 
                 
            }
            
            else if(e.getSource()==b2)
                {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
        
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
