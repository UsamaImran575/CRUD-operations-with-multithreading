/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author Usama Sheikh
 */
// Java program to implement
// a Simple Registration Form
// using Java Swing
  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
  
class Insertion
    extends JFrame
    implements ActionListener {
  
    // Components of the Form
    private Container c;
    
    private JLabel insertionTtitle;
    
      private JLabel CNIC;
      private JTextField textCNIC;
    
    private JLabel name;
    private JTextField textName;
    
    
    
    private JButton sub;
    private JButton reset;

    private JLabel res;
    private JTextArea resadd;
  public String index;
   private Socket s;
    // constructor, to initialize the components
    // with default values.
    public Insertion(Socket s1,String s222)
    {
        this.s=s1;
        this.index=s222;
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
  
        c = getContentPane();
        c.setLayout(null);
  
        insertionTtitle = new JLabel("Insertion Form");
        insertionTtitle.setFont(new Font("Arial", Font.PLAIN, 30));
        insertionTtitle.setSize(300, 30);
        insertionTtitle.setLocation(300, 30);
        c.add(insertionTtitle);
  
        name = new JLabel(" UserName");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(200, 100);
        c.add(name);
  
        textName = new JTextField();
        textName.setFont(new Font("Arial", Font.PLAIN, 15));
        textName.setSize(150, 20);
        textName.setLocation(400, 100);
        c.add(textName);
  
      
       
    
  
        CNIC = new JLabel("Password");
        CNIC.setFont(new Font("Arial", Font.PLAIN, 20));
        CNIC.setSize(100, 20);
        CNIC.setLocation(200, 250);
        c.add(CNIC);
  
        textCNIC = new JTextField();
        textCNIC.setFont(new Font("Arial", Font.PLAIN, 15));
        textCNIC.setSize(150, 20);
        textCNIC.setLocation(400, 250);
        c.add(textCNIC);
  
      
  
   
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(300, 450);
        sub.addActionListener(this);
        c.add(sub);
  
        
       
       
  
        setVisible(true);
    }
    
  /* static char[] Encryption(int i)
            
    {
        
        
        
             //   char[] encryption = password[i].toCharArray();
               
                encryption[0] = (char) ((int)encryption[0] + 0 );
                
                encryption[2] = (char) ((int)encryption[2] +2);
                
                encryption[3] = (char) ((int)encryption[3] + 3);
                
                encryption[4] = (char) ((int)encryption[4] + 4);
                
                return encryption;
        
    }
    */
     static char[] Decryption(char[]encryption)
            
     {             
                encryption[0] = (char) ((int)encryption[0] -0);
                encryption[2] = (char) ((int)encryption[2] -2);
                encryption[3] = (char) ((int)encryption[3] -3);
                encryption[4] = (char) ((int)encryption[4] -4);
                
                return encryption;
        
    }

  
 
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == sub) {
            
           
         
            
            try {
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
            String s1=textName.getText();
            String s2=textCNIC.getText();
            String tosend =index+":"+s1+":"+s2;  
            
            dos.writeUTF(tosend);
            } catch (IOException ex) {
                Logger.getLogger(Insertion.class.getName()).log(Level.SEVERE, null, ex);
            }

         
            //  Insert(textName.getText(),textCNIC.getText());
            
            JOptionPane.showMessageDialog( null, "Record Inserted" );
            
            
        }

    }
    
    
}
    
  
              
        
   
    


  
// Driver Code

