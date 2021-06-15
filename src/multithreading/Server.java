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
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
  
public class Server
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    
    
    
    private DataInputStream in       =  null;
  
    // constructor with port
    public Server(int port) throws ClassNotFoundException
    {
        // starts server and waits for a connection
        try
        {
           
            
            
              server = new ServerSocket(port);   
            
            System.out.println("Server started");
  
            System.out.println("Waiting for a client ...");
  
            while(true){
                
                
              
            socket = server.accept();
            System.out.println("Client accepted");
  
                                                         // takes input from the client 
           DataInputStream dis = new DataInputStream(socket.getInputStream());
           String received = dis.readUTF();
              
           Thread t = new ThreadHelper(received);
           
              t.start();
              
          
            System.out.println("Closing connection");
  
            // close connection
            socket.close();
            in.close();
           
            }
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
    class ThreadHelper extends Thread {

    final String received;

    // Constructor
    public ThreadHelper(String str) {
        this.received = str;
    }

    @Override
    public void run() {
  
  
              String s11[];
              s11=received.split(":");
             
               if(s11[0].equals("5")){
                  
                  
                    try {
                        SignInFF(s11[1],s11[2]);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ThreadHelper.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                      Logger.getLogger(ThreadHelper.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
              
              
              
               if(s11[0].equals("1")){
                  
                  
                    try {
                        Insert(s11[1],s11[2]);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ThreadHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
              }
               
               if(s11[0].equals("2")){
                  
                  
                    try {   
                        UpdateName(s11[1],s11[2],s11[3]);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ThreadHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
              }
              if(s11[0].equals("3")){
                  
                  
                    try {   
                        UpdatePassword(s11[1],s11[2],s11[3]);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ThreadHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
              }


        }

       
    
   public static void Insert(String username, String password) throws ClassNotFoundException{    
      Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   
                       
                    
                    
                    
              String query="Insert into Person(username,password) values(?,?)";                        
              PreparedStatement pstmt=con.prepareStatement(query);
              pstmt.setString(1,username );
                        
                char[] encryption = password.toCharArray();
                encryption[0] = (char) ((int)encryption[0] +0);
                encryption[2] = (char) ((int)encryption[2] +2);
                encryption[3] = (char) ((int)encryption[3] +3);
                encryption[4] = (char) ((int)encryption[4] +4);
                String str = String.valueOf(encryption);
                pstmt.setString(2,str);
                r=pstmt.executeUpdate();
                    
                }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }          
    }
    
    
    
    public static void UpdatePassword(String s1,String s2,String s3) throws ClassNotFoundException{
           
          
                 
                   
        
      Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   
                char[] encryption = s1.toCharArray();
                encryption[0] = (char) ((int)encryption[0] +0);
                encryption[2] = (char) ((int)encryption[2] +2);
                encryption[3] = (char) ((int)encryption[3] +3);
                encryption[4] = (char) ((int)encryption[4] +4);
                String str = String.valueOf(encryption);
                      String sql = "update Person set password = ? where username = ? and password=? ";
                      PreparedStatement pstmt=con.prepareStatement(sql);
                      pstmt.setString(1,str);
                      pstmt.setString(2,s2);
                      pstmt.setString(3,s3);
                      r=pstmt.executeUpdate();
                        
            
                  }
                         catch(SQLException e)
                {
                          e.printStackTrace();
                }
}
  
  
       public static void UpdateName(String s1,String s2,String s3) throws ClassNotFoundException{
           
          
                 
                   
        
      Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   
                       
                String sql = "update Person set username = ? where username = ? and password=? ";
                      
                PreparedStatement pstmt=con.prepareStatement(sql);
                 pstmt.setString(1,s1);
                 pstmt.setString(2,s2);
                 pstmt.setString(3,s3);      
                 r=pstmt.executeUpdate();
                        
                }
                        
             catch(SQLException e)
                {
              e.printStackTrace();
                }
}
   
   
       
    public static void SignInFF(String username, String password) throws ClassNotFoundException, SQLException{    
      Connection con= ConnectionProvider.getConnection();
            int r=0;
             try
                {   
                       
                    
                    
                    
              String query="Select* from Person where username=? and password=?";                        
              PreparedStatement pstmt=con.prepareStatement(query);
            
                        
                char[] encryption = password.toCharArray();
                encryption[0] = (char) ((int)encryption[0] +0);
                encryption[2] = (char) ((int)encryption[2] +2);
                encryption[3] = (char) ((int)encryption[3] +3);
                encryption[4] = (char) ((int)encryption[4] +4);
                String str = String.valueOf(encryption);
                System.out.println(username);
                 System.out.println(str);
                  pstmt.setString(1,username);
                pstmt.setString(2, str);
               ResultSet rs;
 
   rs= pstmt.executeQuery();
       String ss=null;     
        while(rs.next()) 
       {
      if(rs.getString(1).length()!=0)
      {
                JOptionPane.showMessageDialog( null, "Welcome to Your account" ); 
        } 
 
        else
      {
                
                        JOptionPane.showMessageDialog( null, "Incorrect password or username" ); 
           
                }
       }
                }
                 catch(SQLException e)
                {
              e.printStackTrace();
                }
                
       
   }
     
     
    public static void main(String args[]) throws ClassNotFoundException
    {
        Server server = new Server(5000);
    }
}