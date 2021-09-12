/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author BOUKHTACHE
 */
public class CreateDB {
      private static final String user="root";   private static final String pass="password";
     // private static final String url ="jdbc:mysql://localhost?useSSL=false";
      private static String url="jdbc:h2:./myarchive;IFEXISTS=TRUE";
      public static Connection connectionDBS() { 
      
          String sqld = "CREATE DATABASE  myarchive  CHARACTER SET 'utf8' COLLATE utf8_general_ci"; 
        Statement st = null;
        Connection conn = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.h2.Driver");
             conn = DriverManager.getConnection(url,user,pass);
            st = conn.createStatement();
            st.executeUpdate(sqld);
            // JOptionPane.showMessageDialog(null, "success!");
            System.out.println(" create db success!");
            conn.close();
            return conn;
        } catch (Exception ex) {

          System.out.println("  db exist!");

            return null;
        } finally {
            try {
                st.close(); conn.close();
            } catch (Exception ex) {
            }
        }
    }  
}
