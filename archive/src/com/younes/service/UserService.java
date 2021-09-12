/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes.service;

import com.younes.connection.JavaConnected;
import com.younes.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BOUKHTACHE
 */
public class UserService {
    public static int save(User user){
       int st=0;
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="INSERT INTO `user`(`username`, `password`) VALUES (?,?)";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            st=pst.executeUpdate();
            if(st>0){
                conn.close();
                System.out.println("save success...!");
            }else{
                System.out.println("save failed...!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }
    public static int update(User user,Long id){
       int st=0;
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="UPDATE `user` SET `username`=?, `password`=? WHERE `id`=?";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setLong(3, id);
            st=pst.executeUpdate();
            if(st>0){
                conn.close();
                System.out.println("update success...!");
            }else{
                System.out.println("update failed...!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }
    public static int delete(Long id){
       int st=0;
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="DELETE FROM `user` WHERE `id`=?";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            pst.setLong(1, id);
            st=pst.executeUpdate();
            if(st>0){
                conn.close();
                System.out.println("delete success...!");
            }else{
                System.out.println("delete failed...!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }
    public static List<User> fetchAllUser(){
         List<User> list=new ArrayList<>();
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="SELECT * FROM `user` ORDER BY ASC";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                list.add(new User(rst.getInt(1),rst.getString(2),rst.getString(3)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      return list;
    }
    public static User getUser(int id){
    User user=new User();
    try{
       String sql = "SELECT * FROM `user` WHERE `id`=?";
	Connection con = JavaConnected.getConnectionDB();
	PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
	pst.setLong(1, id);
        ResultSet rst = pst.executeQuery();
        while(rst.next()){
            user.setId(rst.getInt(1));
            user.setUsername(rst.getString(2));
            user.setPassword(rst.getString(3));
        }
        con.close();
    }catch (Exception e) {e.printStackTrace();}
    return user;
}
}
