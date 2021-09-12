/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes.service;

import com.younes.connection.JavaConnected;
import com.younes.entity.Archives;
import com.younes.util.TexttableCenter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BOUKHTACHE
 */
public class ArchiveService {
    public static TexttableCenter tblcenter=new TexttableCenter();
    public static int save(Archives archive){
       int st=0;
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="INSERT INTO `archives`(`title`, `number_archive`,`date_time`,`image`,`cat_id`) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            pst.setString(1, archive.getTitle());
            pst.setString(2, archive.getNumberarchive());
            pst.setString(3, archive.getDatetime());
            pst.setString(4, archive.getImage());
            pst.setInt(5, archive.getCid());
            st=pst.executeUpdate();
            if(st>0){
                conn.close();
                System.out.println("save success...!");
            }else{
                System.out.println("save failed...!");
            }
        } catch (Exception ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
        return st;
    }
    public static int update(Archives archive,Integer id){
       int st=0;
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="UPDATE `archives` SET `title`=?, `number_archive`=?,"
                    + "`date_time`=?,`image`=?,`cat_id`=? WHERE `id`=?";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            pst.setString(1, archive.getTitle());
            pst.setString(2, archive.getNumberarchive());
            pst.setString(3, archive.getDatetime());
            pst.setString(4, archive.getImage());
            pst.setInt(5, archive.getCid());
            pst.setLong(6, id);
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
    public static int delete(Integer id){
       int st=0;
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="DELETE FROM `archives` WHERE `id`=?";
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
    public static List<Archives> fetchAllArchive(){
         List<Archives> list=new ArrayList<>();
        try {
            Connection conn=JavaConnected.getConnectionDB();
            String sql="SELECT * FROM `archives` ORDER BY ASC";
            PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                list.add(new Archives(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),
                rst.getString(5), rst.getInt(6)));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      return list;
    }
    public static Archives getArchive(int id){
    Archives archive=new Archives();
    try{
       String sql = "SELECT * FROM `archives` WHERE `id`=?";
	Connection con = JavaConnected.getConnectionDB();
	PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
	pst.setLong(1, id);
        ResultSet rst = pst.executeQuery();
        while(rst.next()){
            archive.setId(rst.getInt(1));
            archive.setTitle(rst.getString(2));
            archive.setNumberarchive(rst.getString(3));
            archive.setDatetime(rst.getString(4));
            archive.setImage(rst.getString(5));
            archive.setCid(rst.getInt(6));
        }
        con.close();
    }catch (Exception e) {e.printStackTrace();}
    return archive;
}
 
  public static void searchAllArchives(String txt,JTable jtable_archives){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("N°");table.addColumn("Title");table.addColumn("Number Archive");
        table.addColumn("Date");table.addColumn("Image");table.addColumn("Categorie");
         Connection conn = JavaConnected.getConnectionDB();
        String sql="SELECT * FROM `archives` WHERE concat(title,number_archive,date_time) LIKE '%"+txt+"%' ORDER BY `date_time` DESC";
        try {
           PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                table.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6)});
            }
            jtable_archives.setModel(table);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for(int i=0;i<jtable_archives.getColumnCount();i++){
                 jtable_archives.getColumnModel().getColumn(i).setCellRenderer(tblcenter);
             }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }  
    public static void searchDateArchives(String date1,String date2,JTable jtable_archives,Integer cid){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("N°");table.addColumn("Title");table.addColumn("Number Archive");
        table.addColumn("Date");table.addColumn("Image");table.addColumn("Categorie");
         Connection conn = JavaConnected.getConnectionDB();
        String sql="SELECT * FROM `archives` WHERE `date_time` BETWEEN '"+date1+"' AND '"
                +date2+"' AND `cat_id`=? ORDER BY `date_time` DESC";
        try {
           PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
           pst.setInt(1, cid);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                table.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6)});
            }
            jtable_archives.setModel(table);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for(int i=0;i<jtable_archives.getColumnCount();i++){
                 jtable_archives.getColumnModel().getColumn(i).setCellRenderer(tblcenter);
             }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }  
    public static void searchArchivesByDay(JTable jtable_archives){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("N°");table.addColumn("Title");table.addColumn("Number Archive");
        table.addColumn("Date");table.addColumn("Image");table.addColumn("Categorie");
         Connection conn = JavaConnected.getConnectionDB();
        String sql="SELECT * FROM `archives` WHERE `date_time` >= CURRENT_DATE() ORDER BY `date_time` DESC";
        try {
           PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                table.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6)});
            }
            jtable_archives.setModel(table);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for(int i=0;i<jtable_archives.getColumnCount();i++){
                 jtable_archives.getColumnModel().getColumn(i).setCellRenderer(tblcenter);
             }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }  
    public static void searchArchivesByWeek(JTable jtable_archives){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("N°");table.addColumn("Title");table.addColumn("Number Archive");
        table.addColumn("Date");table.addColumn("Image");table.addColumn("Categorie");
         Connection conn = JavaConnected.getConnectionDB();
        String sql="SELECT * FROM `archives` WHERE `date_time` >=DATE_SUB(NOW(),INTERVAL 8 DAY) ORDER BY `date_time` DESC";
        try {
           PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                table.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6)});
            }
            jtable_archives.setModel(table);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for(int i=0;i<jtable_archives.getColumnCount();i++){
                 jtable_archives.getColumnModel().getColumn(i).setCellRenderer(tblcenter);
             }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }  
    public static void searchArchivesBy2Week(JTable jtable_archives){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("N°");table.addColumn("Title");table.addColumn("Number Archive");
        table.addColumn("Date");table.addColumn("Image");table.addColumn("Categorie");
         Connection conn = JavaConnected.getConnectionDB();
        String sql="SELECT * FROM `archives` WHERE `date_time` >=DATE_SUB(NOW(),INTERVAL 16 DAY) ORDER BY `date_time` DESC";
        try {
           PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                table.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6)});
            }
            jtable_archives.setModel(table);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for(int i=0;i<jtable_archives.getColumnCount();i++){
                 jtable_archives.getColumnModel().getColumn(i).setCellRenderer(tblcenter);
             }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }  
    public static void searchArchivesByMonth(JTable jtable_archives){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("N°");table.addColumn("Title");table.addColumn("Number Archive");
        table.addColumn("Date");table.addColumn("Image");table.addColumn("Categorie");
         Connection conn = JavaConnected.getConnectionDB();
        String sql="SELECT * FROM `archives` WHERE `date_time` >=DATE_SUB(NOW(),INTERVAL 31 DAY) ORDER BY `date_time` DESC";
        try {
           PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                table.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6)});
            }
            jtable_archives.setModel(table);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtable_archives.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for(int i=0;i<jtable_archives.getColumnCount();i++){
                 jtable_archives.getColumnModel().getColumn(i).setCellRenderer(tblcenter);
             }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    } 
public static void findCountArchivesByCategory(JLabel label,JLabel label2,Integer cid){
    Connection conn = JavaConnected.getConnectionDB();
        String sql="SELECT count(`id`) FROM `archives` WHERE `cat_id`=? ";
        String sql1="SELECT `name` FROM `categories` WHERE `id`=? ";
        try {
           PreparedStatement pst=(PreparedStatement)conn.prepareStatement(sql);
           pst.setInt(1, cid);
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                label.setText(rst.getString("count(`id`)"));
                
            }
            PreparedStatement pst1=(PreparedStatement)conn.prepareStatement(sql1);
             pst1.setInt(1, cid);
            ResultSet rst1=pst1.executeQuery();
            while(rst1.next()){
               label2.setText(rst1.getString("name"));
                System.out.println(rst1.getString("name"));
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
}
    
}
