/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usama Sheikh
 */
public class ConnectionProvider {
    
/**
 *
 * @author HP
 */
    private static Connection con;
  
    /**
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection getConnection() throws ClassNotFoundException
    {   
        
        
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try
        {   
            if(con==null)
            {
             con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName= HW_3;;user=sa;password=123456789");
            }
           
                  
        }
        catch(SQLException E)
         {   
                   
                           
                    E.printStackTrace();
         }
        
        
       return con;
       
    }
}
    


