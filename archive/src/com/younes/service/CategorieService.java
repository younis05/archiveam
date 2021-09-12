/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes.service;

import com.younes.connection.JavaConnected;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.younes.entity.Categories;
/**
 *
 * @author BOUKHTACHE
 */
public class CategorieService {
    public static int save(Categories categorie){
       int st=0;
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="INSERT INTO `categories`(`name`) VALUES (?)";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            pst.setString(1, categorie.getName());
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
    public static int update(Categories categorie,Long id){
       int st=0;
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="UPDATE `categories` SET `name`=? WHERE `id`=?";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            pst.setString(1, categorie.getName());
            pst.setLong(2, id);
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
            String sql="DELETE FROM `categories` WHERE `id`=?";
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
    public static List<Categories> fetchAllCategories(){
         List<Categories> list=new ArrayList<>();
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="SELECT * FROM `categories` ORDER BY ASC";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                list.add(new Categories(rst.getInt(1),rst.getString(2)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      return list;
    }
    public static Categories getCategories(int id){
    Categories categorie=new Categories();
    try{
       String sql = "SELECT * FROM `categories` WHERE `id`=?";
	Connection con = JavaConnected.getConnectionDB();
	PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
	pst.setLong(1, id);
        ResultSet rst = pst.executeQuery();
        while(rst.next()){
            categorie.setId(rst.getInt(1));
            categorie.setName(rst.getString(2));
        }
        con.close();
    }catch (Exception e) {e.printStackTrace();}
    return categorie;
}
}
