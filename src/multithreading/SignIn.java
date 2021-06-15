/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
  
class SignIn extends JFrame implements ActionListener {
  
    // Components of the Form
    private Container c;
    private JLabel title;
    
    
    private JLabel name;
    static private JTextField textname;
  
    
    private JLabel oldpass;
    static private JTextField told;

    private JButton sub; 

    
   
 
  
   private String index;
   private Socket s4;
   
    public SignIn(Socket s,String ind)
    {
        this.s4=s;
        this.index=ind;
        
        setTitle("Sign In Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
  
        c = getContentPane();
        c.setLayout(null);
  
        title = new JLabel("Sign In Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
  
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);
  
        textname = new JTextField();
        textname.setFont(new Font("Arial", Font.PLAIN, 15));
        textname.setSize(190, 20);
        textname.setLocation(200, 100);
        c.add(textname);
        
        
       oldpass= new JLabel("Password");
       oldpass.setFont(new Font("Arial", Font.PLAIN, 20));
       oldpass.setSize(100, 20);
       oldpass.setLocation(100, 150);
       c.add(oldpass);
  
        told = new JTextField();
        told.setFont(new Font("Arial", Font.PLAIN, 15));
        told.setSize(190, 20);
        told.setLocation(200, 150);
        c.add( told );
  
    
  
        
        
        
   
        
  
  
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
  

  
    
      
  
        setVisible(true);
    }
  
   /*   public static void UpdateName() throws ClassNotFoundException{
           
          
                 
                   
        
      Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   
                       
                        String sql = "update Person set username = ? where username = ? and password=? ";
                      
                         PreparedStatement pstmt=con.prepareStatement(sql);
                       
                       
                         String s=textcnic.getText();
                         
                char[] encryption = s.toCharArray();
                encryption[0] = (char) ((int)encryption[0] +0);
                encryption[2] = (char) ((int)encryption[2] +2);
                encryption[3] = (char) ((int)encryption[3] +3);
                encryption[4] = (char) ((int)encryption[4] +4);
                String str = String.valueOf(encryption);
               
                         
                              pstmt.setString(1,tpass.getText());
                               pstmt.setString(2,textname.getText());
                               pstmt.setString(3,str);
                                 
                         r=pstmt.executeUpdate();
                        
            
                }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }
}

*/
  
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == sub) {
            
           
         
            
            try {
            DataOutputStream dos = new DataOutputStream(s4.getOutputStream()); 
            String s1=textname.getText();
            String s2=told.getText();
            System.out.println(s1);
            System.out.println(s2);
            
          
          
            
            String tosend ="5"+":"+s1+":"+s2;  
            dos.writeUTF(tosend);
            }
            
            catch (IOException ex) {
                Logger.getLogger(Insertion.class.getName()).log(Level.SEVERE, null, ex);
            }

        
      
            
        }

    }
  
       
    }

  
// Driver Code
