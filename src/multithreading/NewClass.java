/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Usama Sheikh
 */

    

  
public class NewClass extends JFrame implements ActionListener {
  
    // Components of the Form
    private Container c;
    private JLabel title;
    
    
    private JLabel input;
    private JTextField textinput;
  
  

    private JButton sub; 
    static  private JTextArea textout;
    
   private Socket s11;
  
  
   
    public NewClass(Socket s1)
    {
        this.s11=s1;
        setTitle("Menu");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
  
        c = getContentPane();
        c.setLayout(null);
  
        title = new JLabel("Menu");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        
        title.setLocation(300, 30);
        c.add(title);
  
       input = new JLabel("Input");
         input.setFont(new Font("Arial", Font.PLAIN, 20));
         input.setSize(100, 20);
        input.setLocation(100, 100);
        c.add( input);
  
        textinput = new JTextField();
        textinput.setFont(new Font("Arial", Font.PLAIN, 15));
       textinput.setSize(190, 20);
        textinput.setLocation(200, 100);
        c.add(textinput);
        
        
      
  
      
  
  
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
  

  
        textout = new JTextArea();
        textout.setFont(new Font("Arial", Font.PLAIN, 15));
        textout.setSize(300, 400);
        textout.setLocation(500, 100);
        textout.setLineWrap(true);
        textout.setEditable(false);
        textout.setText("Press 5 for SignIn"+"\n"
         +"Press 1 for Insert Record"+"\n"
                    +"Press 2 for Update User Name"+"\n"
                    +"Press 3 for Update Password"+"\n"
                    
                 
                 
         );
                 
                 
                 
       
        c.add(textout);
  
      
  
        setVisible(true);
    }
  
   
  
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
           String s=textinput.getText();;
            
                   
                       if(s.equals("5")){
                  
                           SignIn s45= new SignIn(s11,"5");
                       }

               else  if(s.equals("1")){
                     
                     Insertion r=new Insertion(s11,"1");
                 }
                 
            
               else if(s.equals("3")){
                     
                     UpdatePass r=new UpdatePass(s11,"3");
                 }
                
               else  if(s.equals("2")){
                     
                     UpdateUsername r=new UpdateUsername(s11,"2");
                 }
                          
        
}
    }
}
  
// Driver Code

    
    

