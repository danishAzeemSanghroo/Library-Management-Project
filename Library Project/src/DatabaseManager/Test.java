/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danish
 */
public class Test {
      static Connection con = null;
        public static Connection getConnection(){
        
            try{
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle","root","root");
                System.out.println("Connection successfull");
            }catch(Exception e){
            
                
            }
            return con;
        }
        
        
        public static void main(String args[]){
        
            Test.getConnection();
        }    
    
}
