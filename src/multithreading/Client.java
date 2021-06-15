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
  
public class Client
{
    public static void main(String args[])
    {

        String address="127.0.0.1";
        int port=5000;
        
    Socket socket            = null;
    DataInputStream  input   = null;
    DataOutputStream out     = null;
        
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
  
              NewClass c=new NewClass(socket);
                NewClass d=new NewClass(socket);
              
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        
    }
}