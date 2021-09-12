/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author BOUKHTACHE
 */
public class UserDB {
    public static Connection createUser(){
        Connection conn=JavaConnected.getConnectionDB();
        Statement st = null;
        try{
          String sql="CREATE TABLE IF NOT EXISTS `user`"
          + " (`id` INT(11) NOT NULL AUTO_INCREMENT,`username` VARCHAR(255) NULL,"
          + "`password` VARCHAR(255) NULL,PRIMARY KEY (`id`))";
          String sql2="CREATE TABLE IF NOT EXISTS `categories` "
          + "(`id` INT(11) NOT NULL AUTO_INCREMENT,`name` VARCHAR(255) NULL,PRIMARY KEY (`id`))";
          String sql3="CREATE TABLE IF NOT EXISTS `archives` "
          + "(`id` INT(11) NOT NULL AUTO_INCREMENT,`title` VARCHAR(255) NOT NULL,"
          + "`number_archive` VARCHAR(500) NOT NULL,`date_time` DATETIME NOT NULL,"
          + "`image` MEDIUMTEXT NOT NULL,`cat_id` INT(11) NOT NULL,PRIMARY KEY (`id`, `cat_id`),"
          + "CONSTRAINT `fk_archives_table2` "
          + "FOREIGN KEY (`cat_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE "
          + "ON UPDATE CASCADE)";
          
           st=conn.createStatement();
           st.executeUpdate(sql);
           st.executeUpdate(sql2);
           st.executeUpdate(sql3);
          return conn;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }finally{
            try {
                st.close();conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
   public static Connection createUserInfo(){
         Connection conn = null,conn1=null;Statement st = null,st1=null;
         ResultSet rst=null;
         String sql="SELECT max(id) FROM `user`";
         String sql0= "INSERT INTO `user` (`id`, `username`, `password`) VALUES" +
                      "(1, 'admin', 'admin'),(2, 'admin', '1234'),(3, '1', '1');" ;
     try {
            conn = JavaConnected.getConnectionDB();
            conn1 = JavaConnected.getConnectionDB();
            st1=conn1.createStatement();
            st=conn.createStatement();
            rst=st.executeQuery(sql);
            if(rst.next()){
                int id=rst.getInt("max(id)");
                 System.out.println("id:"+id);
                if(id<3){
                    st1.executeUpdate(sql0);
                }else{
                   
                }
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }finally {
            try {
                rst.close(); st.close();
            } catch (Exception ex) {
            } }
        return conn;
 } 
    
}
