/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes;

import com.younes.connection.CreateDB;
import com.younes.connection.JavaConnected;
import com.younes.connection.UserDB;
import com.younes.util.LockApp;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author BOUKHTACHE
 */

public class Intro {
      private static  ResultSet rst=null;private static PreparedStatement pst=null;
      private static  Statement st;
      private static  Connection conn,conn1,conn2,conn3=null;
      private static  LockApp lk=new LockApp("MyArchive");
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        try{
            String directory=System.getProperty("user.home");
            String upload = directory+ "\\Archives";
            File rev = new File(upload);
	    if (!rev.exists()) {
				rev.mkdirs();
				}
            
            String uploadimages = directory + "\\Archives\\images";
            File dirp = new File(uploadimages);
	    if (!dirp.exists()) {
				dirp.mkdirs();
				}
            
           String uploadfilecsv = directory + "\\Archives\\FilesCSV";
            File dir = new File(uploadfilecsv);
	    if (!dir.exists()) {
				dir.mkdirs();
				}
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
        lk.appClosable();
        conn=CreateDB.connectionDBS();
        conn1=JavaConnected.getConnectionDB();
        conn2=UserDB.createUser();
        conn3=UserDB.createUserInfo();
        Login lg=new Login();
        lg.setVisible(true);
       
    }
}
