/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes.connection;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author BOUKHTACHE
 */
public class JavaConnected {
        private static Connection conn;
        private static String user="root";
        private static String password="password";
     // private static String url="jdbc:mysql://localhost/myarchive?useSSL=false&useUnicode=yes&characterEncoding=UTF-8";
        private static String url="jdbc:h2:./myarchive;IFEXISTS=TRUE";
    public static Connection getConnectionDB(){
        try{
       // Class.forName("com.mysql.jdbc.Driver");
         Class.forName("org.h2.Driver");
        conn=DriverManager.getConnection(url, user, password);
        //System.out.println("connected");
         return conn;
        }catch(Exception ex){
          ex.printStackTrace();
          System.out.println("failed");
          return null;
        }
        
    }
}
