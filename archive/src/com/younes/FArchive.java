/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes;

import com.younes.connection.JavaConnected;
import com.younes.entity.Archives;
import com.younes.service.ArchiveService;
import com.younes.util.TexttableCenter;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BOUKHTACHE
 */
public class FArchive extends javax.swing.JInternalFrame {

    /**
     * Creates new form FHome
     */
    Connection conn;
    PreparedStatement pst,pst1,pst2,pst3=null;
    ResultSet rst,rst1,rst2,rst3=null;
    private Calendar timer=Calendar.getInstance();
    private TexttableCenter tblcenter=new TexttableCenter();
    Archives archive;
    private SimpleDateFormat formt = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat imgform = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
    private String filename;
    private Map<Integer, String> catmap = new HashMap<Integer, String>();
    private Map<Integer, String> catmap1 = new HashMap<Integer, String>();
    private String directory=System.getProperty("user.home");
    private int cat_id;
    private int cat_id1;
    public FArchive() {
        initComponents();
        conn=JavaConnected.getConnectionDB();
       
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi=(BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
               jtextsearch.requestFocus();
            } 
        });
       showAllArchives(); 
     // jcat.setModel(new DefaultComboBoxModel(showCategorie()));
     // jcategorie.setModel(new DefaultComboBoxModel(showCategorie()));
      showCategorie();
      
    }
   public void showInfoArchives(){
        int row=jtablearchive.getSelectedRow();
        if(row==-1){
         JOptionPane.showMessageDialog(null,"choose row...!");
        }else{
        String Table_Click=(jtablearchive.getModel().getValueAt(row, 0)).toString();
        int p_id=Integer.parseInt(Table_Click);
        archive=ArchiveService.getArchive(p_id);
        jid.setText(String.valueOf(archive.getId()));
        jtitle.setText(archive.getTitle());
        jnumber.setText(archive.getNumberarchive());
        jpath.setText(archive.getImage());
        String sql="SELECT * FROM `categories` WHERE `id`=?";
            try {
                pst2=conn.prepareStatement(sql);
                pst2.setInt(1, archive.getCid());
                rst2=pst2.executeQuery();
                while(rst2.next()){
                 jcategorie.setSelectedItem(rst2.getString("name"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
        
        ImageIcon imageIcon=new ImageIcon(new ImageIcon(archive.getImage()).getImage().getScaledInstance(jimage.getWidth(),jimage.getHeight() , Image.SCALE_SMOOTH));
        jimage.setIcon(imageIcon);
        
        }
    }
   public boolean verifyFields(){
        boolean verify=false;
        if( jtitle.getText().trim().isEmpty()||jnumber.getText().trim().isEmpty()
            ||jpath.getText().equals(null)||jcategorie.getSelectedItem().equals("Select Categorie") ){
            return verify=true;
        }else{
            verify=false;
        }
        return verify;
    }
   public void Clear(){
        jid.setText("");
        jtitle.setText("");
        jnumber.setText("");
        jpath.setText("");
        jimage.setIcon(null);
        cat_id=0;
        cat_id1=0;
        filename=null;
        jcategorie.setSelectedItem("Select Categorie");
        jcat.setSelectedItem("Select Categorie");
        jdate1.setDate(null);
        jdate2.setDate(null);
        jsearch.setSelectedItem("Select date");
    }
   private void showAllArchives(){
        DefaultTableModel table=new DefaultTableModel();
        table.addColumn("N°");table.addColumn("Title");table.addColumn("Number Archive");
        table.addColumn("Date");table.addColumn("Image");table.addColumn("Categorie");
        
        String sql="SELECT * FROM `archives` ORDER BY `date_time` DESC";
        try {
            pst=conn.prepareStatement(sql);
            rst=pst.executeQuery();
            while(rst.next()){
                table.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6)});
            }
            jtablearchive.setModel(table);
            jtablearchive.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtablearchive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for(int i=0;i<jtablearchive.getColumnCount();i++){
                 jtablearchive.getColumnModel().getColumn(i).setCellRenderer(tblcenter);
             }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        
    }
   //Create image
   public void AddImage(String path){
       BufferedImage bufferedImage;
       try{
           
        File file=new File(filename);
        FileInputStream fis=new FileInputStream(file);
        bufferedImage=ImageIO.read(fis);
	BufferedImage newbufferedImage=	new  BufferedImage(bufferedImage.getWidth(),bufferedImage.getHeight(),
        BufferedImage.TYPE_INT_RGB);	
        newbufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.white,null);
        ImageIO.write(newbufferedImage, "jpg", new File(path));
        System.out.println("create image success...!");
       }catch(Exception ex){System.out.println("create image failed...!");}
   }
   //show Categorie
   private void showCategorie(){
        
     try {
            String sql="SELECT * FROM `categories`";
            pst3 = conn.prepareStatement(sql);
            rst3 = pst3.executeQuery();
           // jcategorie.removeAllItems();
            jcat.addItem("Select Categorie");
            jcategorie.addItem("Select Categorie");
            while (rst3.next()) {
                   catmap1.put(rst3.getInt("id"), rst3.getString("name"));
                   catmap.put(rst3.getInt("id"), rst3.getString("name"));
                   String name=rst3.getString("name");
                   jcat.addItem(name);
                   jcategorie.addItem(name);
              }
          
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        
   }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablearchive = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jsave = new javax.swing.JButton();
        jupdate = new javax.swing.JButton();
        jdelete = new javax.swing.JButton();
        jclear = new javax.swing.JButton();
        jid = new javax.swing.JTextField();
        jtitle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcategorie = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jsearch = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jtextsearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jdate1 = new com.toedter.calendar.JDateChooser();
        bsearch = new javax.swing.JButton();
        jnumber = new javax.swing.JTextField();
        jdate2 = new com.toedter.calendar.JDateChooser();
        jchoose = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jpath = new javax.swing.JLabel();
        jimage = new javax.swing.JLabel();
        jcat = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 600));
        setPreferredSize(new java.awt.Dimension(750, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(750, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jtablearchive.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtablearchive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtablearchive.setGridColor(new java.awt.Color(255, 255, 255));
        jtablearchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablearchiveMouseClicked(evt);
            }
        });
        jtablearchive.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtablearchiveKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtablearchiveKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtablearchive);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 440, 320));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Archives");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Categorie:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        jsave.setText("Save");
        jsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsaveActionPerformed(evt);
            }
        });
        jPanel1.add(jsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 60, -1));

        jupdate.setText("Update");
        jupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdateActionPerformed(evt);
            }
        });
        jPanel1.add(jupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        jdelete.setText("Delete");
        jdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, -1, -1));

        jclear.setText("Clear");
        jclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jclearActionPerformed(evt);
            }
        });
        jPanel1.add(jclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 70, -1));
        jPanel1.add(jid, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 160, -1));
        jPanel1.add(jtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Title:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ID:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Date2:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jcategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcategorieActionPerformed(evt);
            }
        });
        jPanel1.add(jcategorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Search by:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select date", "day", "week", "2 week", "month" }));
        jsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchActionPerformed(evt);
            }
        });
        jPanel1.add(jsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Search:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jtextsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextsearchKeyReleased(evt);
            }
        });
        jPanel1.add(jtextsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 270, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Date1:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jdate1.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 150, -1));

        bsearch.setText("Search");
        bsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsearchActionPerformed(evt);
            }
        });
        jPanel1.add(bsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 80, -1));
        jPanel1.add(jnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 160, -1));

        jdate2.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 150, -1));

        jchoose.setText("Choose Image");
        jchoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchooseActionPerformed(evt);
            }
        });
        jPanel1.add(jchoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 160, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Number:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Document:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));
        jPanel1.add(jpath, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 190, 20));

        jimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 120, 90));

        jcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcatActionPerformed(evt);
            }
        });
        jPanel1.add(jcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 750, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jtablearchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablearchiveMouseClicked
        showInfoArchives();
        int row=jtablearchive.getSelectedRow();
        if(row==-1){
         JOptionPane.showMessageDialog(null,"choose row...!");
        }else{
        try {
                String Table_Click=(jtablearchive.getModel().getValueAt(row, 4)).toString();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+Table_Click);
                jid.setText((jtablearchive.getModel().getValueAt(row, 0)).toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jtablearchiveMouseClicked

    private void jtablearchiveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablearchiveKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP||evt.getKeyCode()==KeyEvent.VK_DOWN){
            showInfoArchives();
        }
    }//GEN-LAST:event_jtablearchiveKeyPressed

    private void jtablearchiveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablearchiveKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_UP||evt.getKeyCode()==KeyEvent.VK_DOWN){
            showInfoArchives();
        }
    }//GEN-LAST:event_jtablearchiveKeyReleased

    private void jsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsaveActionPerformed
       archive=new Archives();
        String title=jtitle.getText().trim();
        String number=jnumber.getText().trim();
        Date date=new Date();timer.setTime(date);
        String uploadDirectory ="\\Archives\\images";
        String dt1=formt.format(timer.getTime());
        String dtm=imgform.format(timer.getTime());
        String path=uploadDirectory+"\\archive"+number+"_"+dtm+".jpg";
        if(verifyFields()){
            JOptionPane.showMessageDialog(this,  "Opps fill fields...!","Warning !", JOptionPane.ERROR_MESSAGE);
        }else{
                archive.setTitle(title);
                archive.setNumberarchive(number);
                archive.setDatetime(dt1);
                if(filename==null){
                    archive.setImage(null);
                }else{
                    archive.setImage(directory +path);
                    System.out.println(path);
                }
                
                archive.setCid(cat_id);
                int status=ArchiveService.save(archive);
                AddImage(directory +path);
                if(status>0){
                    JOptionPane.showMessageDialog(this,  "save success","Success", JOptionPane.INFORMATION_MESSAGE);
                    showAllArchives();
                    Clear();
                }else{
                    JOptionPane.showMessageDialog(this,  "save failed...!","Save", JOptionPane.ERROR_MESSAGE);
                }  

        }
    }//GEN-LAST:event_jsaveActionPerformed

    private void jupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdateActionPerformed
        archive=new Archives();
        int id=Integer.parseInt(jid.getText());
        String title=jtitle.getText().trim();
        String number=jnumber.getText().trim();
        Date date=new Date();timer.setTime(date);
        String uploadDirectory ="\\Archives\\images";
        String dt1=formt.format(timer.getTime());
        String dtm=imgform.format(timer.getTime());
        String path=uploadDirectory+"\\archive"+number+"_"+dtm+".jpg";
        if(verifyFields()){
            JOptionPane.showMessageDialog(this,  "Opps fill fields...!","Warning !", JOptionPane.ERROR_MESSAGE);
        }else{
                archive.setTitle(title);
                archive.setNumberarchive(number);
                archive.setDatetime(dt1);
                if(filename==null){
                    archive.setImage(null);
                }else{
                    archive.setImage(directory +path);
                    System.out.println(path);
                }
                File file = new File(directory +jpath.getText());
			if(file.exists()) {
				file.delete();
			}
                archive.setCid(cat_id);
                archive.setId(id);
                int status=ArchiveService.update(archive, id);
                AddImage(directory +path);
                if(status>0){
                    JOptionPane.showMessageDialog(this,  "update success","Success", JOptionPane.INFORMATION_MESSAGE);
                    showAllArchives();
                    Clear();
                }else{
                    JOptionPane.showMessageDialog(this,  "update failed...!","Save", JOptionPane.ERROR_MESSAGE);
                }  

        }
    }//GEN-LAST:event_jupdateActionPerformed

    private void jdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeleteActionPerformed
        String iduser=jid.getText();
        if(!iduser.trim().isEmpty()){
            int msg=JOptionPane.showConfirmDialog(null, "are you sure delete...?","Delete",JOptionPane.YES_NO_OPTION);
            if(msg==0){
                int p_id=Integer.parseInt(jid.getText());
                int status=ArchiveService.delete(p_id);
                if(status>0){
                    JOptionPane.showMessageDialog(null,"delete success..!");
                    showAllArchives();
                    Clear();
                }else{
                    JOptionPane.showMessageDialog(null,"");
                }
            } }else{
                JOptionPane.showMessageDialog(null,"fill field...!");
            }
    }//GEN-LAST:event_jdeleteActionPerformed

    private void jclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jclearActionPerformed
        Clear();
    }//GEN-LAST:event_jclearActionPerformed

    private void jchooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchooseActionPerformed
        JFileChooser chooser=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","png");
        chooser.addChoosableFileFilter(filter);
        int ap=chooser.showOpenDialog(null);
        if(ap==JFileChooser.APPROVE_OPTION){
            filename= chooser.getSelectedFile().getAbsolutePath();
            ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(jimage.getWidth(),
                    jimage.getHeight() , Image.SCALE_SMOOTH));
            jimage.setIcon(imageIcon); jpath.setText(filename);
        }  
    }//GEN-LAST:event_jchooseActionPerformed

    private void jcategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcategorieActionPerformed
       
        for (Map.Entry<Integer, String> e : catmap.entrySet()) {
            if (jcategorie.getSelectedItem().toString().equals(e.getValue())) {
                cat_id = e.getKey();
            }
        }
        
    }//GEN-LAST:event_jcategorieActionPerformed

    private void jsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearchActionPerformed
         int days=jsearch.getSelectedIndex();
        try{
            switch(days){
                case 1:
                  ArchiveService.searchArchivesByDay(jtablearchive);
                    break;
                case 2:
                  ArchiveService.searchArchivesByWeek(jtablearchive);
                    break;  
                    case 3:
                  ArchiveService.searchArchivesBy2Week(jtablearchive);
                    break; 
                   case 4:
                  ArchiveService.searchArchivesByMonth(jtablearchive);
                    break;  
                default:
                showAllArchives();   
            }
            
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_jsearchActionPerformed

    private void jtextsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextsearchKeyReleased
        if(jtextsearch.getText().trim().isEmpty()==true||jtextsearch.getText().equals("")){
            showAllArchives();
        }else{
            ArchiveService.searchAllArchives(jtextsearch.getText(), jtablearchive);
        } 
    }//GEN-LAST:event_jtextsearchKeyReleased

    private void bsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsearchActionPerformed
        String date1=((JTextField)jdate1.getDateEditor().getUiComponent()).getText();
        String date2=((JTextField)jdate2.getDateEditor().getUiComponent()).getText();
        if(jdate1.getDate()==null||jdate2.getDate()==null||
                jcat.getSelectedItem().equals("Select Categorie")){
                 JOptionPane.showMessageDialog(null,"Fill Date and Categorie...?!");
             }else{
                 ArchiveService.searchDateArchives(date1, date2, jtablearchive,cat_id1);
             }
    }//GEN-LAST:event_bsearchActionPerformed

    private void jcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcatActionPerformed
        for (Map.Entry<Integer, String> e : catmap1.entrySet()) {
            if (jcat.getSelectedItem().toString().equals(e.getValue())) {
                cat_id1 = e.getKey();
                
            }
        }
        
    }//GEN-LAST:event_jcatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcat;
    private javax.swing.JComboBox<String> jcategorie;
    private javax.swing.JButton jchoose;
    private javax.swing.JButton jclear;
    private com.toedter.calendar.JDateChooser jdate1;
    private com.toedter.calendar.JDateChooser jdate2;
    private javax.swing.JButton jdelete;
    private javax.swing.JTextField jid;
    private javax.swing.JLabel jimage;
    private javax.swing.JTextField jnumber;
    private javax.swing.JLabel jpath;
    private javax.swing.JButton jsave;
    private javax.swing.JComboBox<String> jsearch;
    private javax.swing.JTable jtablearchive;
    private javax.swing.JTextField jtextsearch;
    private javax.swing.JTextField jtitle;
    private javax.swing.JButton jupdate;
    // End of variables declaration//GEN-END:variables
}
