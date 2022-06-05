
package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Staff extends Frame implements ActionListener
{

    Frame f;
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    Button b1,b2,b3,b4;
    Connection c;
    Statement s;
    ResultSet r1;
    String s1;
    Staff()
    {
        f=new Frame("Student Details");
        f.setSize(600, 800);
        f.setLayout(null);
        f.setVisible(true);
        l1=new Label("Student Reg_no");
        l1.setBounds(50, 100, 100, 50);
        f.add(l1);        
        t1=new TextField("");
        t1.setBounds(150, 100, 150, 50);
        f.add(t1);
        l2=new Label("Student Name");
        l2.setBounds(50, 160, 100, 50);
        f.add(l2);
        t2=new TextField("");
        t2.setBounds(150, 160, 150, 50);
        f.add(t2);
        l3=new Label("No of Present");
        l3.setBounds(50, 220, 100, 50);
        f.add(l3); 
        t3=new TextField("");
        t3.setBounds(150, 220, 150, 50);
        f.add(t3);
        l4=new Label("No of Absent");
        l4.setBounds(320, 220, 100, 50);
        f.add(l4); 
        t4=new TextField("");
        t4.setBounds(430, 220, 150, 50);
        f.add(t4);
        l5=new Label("Marks");
        l5.setBounds(50, 300, 100, 50);
        f.add(l5); 
        t5=new TextField("");
        t5.setBounds(150, 300, 150, 50);
        f.add(t5);
        l6=new Label("Subject");
        l6.setBounds(320, 300, 100, 50);
        f.add(l6); 
        t6=new TextField("");
        t6.setBounds(430, 300, 150, 50);
        f.add(t6);
        l7=new Label("Assignment");
        l7.setBounds(50, 500, 100, 50);
        f.add(l7); 
        t7=new TextField("");
        t7.setBounds(150, 500, 430, 50);
        f.add(t7);
        l8=new Label("Actual Fees");
        l8.setBounds(50, 400, 100, 50);
        f.add(l8);
        t8=new TextField("");
        t8.setBounds(150, 400, 150, 50);
        f.add(t8);
        l9=new Label("Paid Fees");
        l9.setBounds(320, 400, 100, 50);
        f.add(l9); 
        t9=new TextField("");
        t9.setBounds(430, 400, 150, 50);
        f.add(t9);
        
        
        b1=new Button("Insert");
        b1.setBounds(70, 600, 120, 50);
        f.add(b1);
        b1.addActionListener(this);
        b2=new Button("Clear");
        b2.setBounds(220, 600, 120, 50);
        f.add(b2);
        b2.addActionListener(this);
        b3=new Button("Exit");
        b3.setBounds(370, 600, 120, 50);
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
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            if(e.getSource()==b1)
            {
                String reg=t1.getText();
                String name=t2.getText();
                String present=t3.getText();
                String absent=t4.getText();
                String mark=t5.getText();
                String sub=t6.getText();
                String grade;
                System.out.println("HELLO");
                int m=Integer.parseInt(mark);
                if(m>=90)
                    grade="S";
                else if(m<=89 && m>=80)
                    grade="A";
                else if(m<=60 && m>=79)
                    grade="B";
                else if(m<=45 && m>=59)
                    grade="C";
                else
                    grade="F";
                    
                   String ass=t7.getText();
                   String act=t8.getText();
                   int n=Integer.parseInt(act);          
                   String pai=t9.getText();
                   int o=Integer.parseInt(pai);
                   int x=n-o;
                   String dbroll,s2;
                   //s2="select * from studetails";
                   //s2 = "insert into studetails(Present,Absent,Mark,Grade,Assignment) values ('"+present+"','"+absent+"','"+mark+"','"+grade+"','"+ass+"') where Regno="+reg+")";
                   s2="Update studetails set Present='"+present+"',Absent='"+absent+"',Mark='"+mark+"',Grade='"+grade+"',Assignment='"+ass+"',Subject='"+sub+"',Actual_Fees="+n+",Paid="+o+",Balance="+x+" where Regno='"+reg+"'";
                   
                   int pp=s.executeUpdate(s2);
                   s.executeUpdate(s2);
                   System.out.println("Insert Success");
                   System.out.println(grade);
                   t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                /* while(r1.next())
                {
                    dbroll=r1.getString(1);
                    if(reg.equals(dbroll))
                    {
                        System.out.println(dbroll);
                        s=c.createStatement();
                    System.out.println(dbroll);
                    s1="Update studetails set Present=present and Absent=absent and Mark=mark and Grade=grade and Assignment=ass where Regno=dbroll";

                    System.out.println(dbroll);
                    s.executeUpdate(s1);
                    System.out.println("Insert Success");
                    }
                    else
                    {
                        System.out.println("Not Successful");
                    }
                }*/
                 
            //s1="insert into studetails(Regno,Stuname,Present,Absent,Mark,Grade,Assignment) values('"+reg+"','"+name+"','"+present+"','"+absent+"','"+mark+"','"+grade+"','"+ass+"')";     
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
                    
                    
                    
                }
                else if(e.getSource()==b3)
                {
                   
                    f.dispose();
                    
                }
            
        }
         catch(Exception ex)
        {
            System.out.println(ex);
        }
            
    }
}
            
   
