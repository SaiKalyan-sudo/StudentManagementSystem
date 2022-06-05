package main;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements ActionListener
{

    Frame f;
    Button b1,b2,b3;
    Main()
    {
        f=new Frame("VIT INSTITUTION");
        f.setSize(400, 400);
        f.setLayout(null); //1
        f.setVisible(true);
        b1=new Button("Faculty Login");
        b1.setBounds(150, 120, 100, 50);
        f.add(b1);
        b1.addActionListener(this);//reference variable
        b2=new Button("Student Login");
        b2.setBounds(150, 220, 100, 50);
        f.add(b2);
        b2.addActionListener(this);
        b3=new Button("Exit");
        b3.setBounds(150, 320, 100, 50);
        f.add(b3);
        b3.addActionListener(this);
    }
    
    public static void main(String[] args)
    {
        
        Main obj=new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            Staff_login slobj=new Staff_login();
        }
        else if(e.getSource()==b2)
        {
            Stu_login slobj1=new Stu_login();
        }
        else if(e.getSource()==b3)
        {
            f.dispose();
        }
    }
}
