/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes;

import com.younes.connection.JavaConnected;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author BOUKHTACHE
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private Connection conn;  
    private JFrame frame;
    private int x,y;
    public Home() {
        initComponents();
        conn=JavaConnected.getConnectionDB();
        FHome home=new FHome();
        jDesktopPane1.add(home).setVisible(true);
        icons();
    }
    private void icons() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/archive.png")));
    }
    
   public void bgPanelExited(JPanel panel){
       panel.setBackground(new Color(26, 36, 107));
   }
   public void bgPanelEntered(JPanel panel){
       panel.setBackground(new Color(43, 63, 156));
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
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jclose = new javax.swing.JLabel();
        jpresize = new javax.swing.JPanel();
        jresize = new javax.swing.JLabel();
        jphide = new javax.swing.JPanel();
        jhide = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jhome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        puser = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pcategorie = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        parchive = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        psetting = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 650));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(31, 0, 63));
        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 50));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(31, 0, 63));
        jPanel5.setMinimumSize(new java.awt.Dimension(160, 50));
        jPanel5.setPreferredSize(new java.awt.Dimension(160, 50));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(31, 0, 63));
        jPanel4.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(50, 50));

        jclose.setBackground(new java.awt.Color(31, 0, 63));
        jclose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jclose.setForeground(new java.awt.Color(255, 255, 255));
        jclose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jclose.setText("X");
        jclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jclose.setMaximumSize(new java.awt.Dimension(50, 50));
        jclose.setMinimumSize(new java.awt.Dimension(50, 50));
        jclose.setPreferredSize(new java.awt.Dimension(50, 50));
        jclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jclose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jclose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        jpresize.setBackground(new java.awt.Color(31, 0, 63));
        jpresize.setMinimumSize(new java.awt.Dimension(50, 50));
        jpresize.setName(""); // NOI18N

        jresize.setBackground(new java.awt.Color(31, 0, 63));
        jresize.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jresize.setForeground(new java.awt.Color(255, 255, 255));
        jresize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jresize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_stop_32px.png"))); // NOI18N
        jresize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jresize.setMaximumSize(new java.awt.Dimension(50, 50));
        jresize.setMinimumSize(new java.awt.Dimension(50, 50));
        jresize.setPreferredSize(new java.awt.Dimension(50, 50));
        jresize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jresizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpresizeLayout = new javax.swing.GroupLayout(jpresize);
        jpresize.setLayout(jpresizeLayout);
        jpresizeLayout.setHorizontalGroup(
            jpresizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpresizeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jresize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpresizeLayout.setVerticalGroup(
            jpresizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpresizeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jresize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(jpresize, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jphide.setBackground(new java.awt.Color(31, 0, 63));
        jphide.setMinimumSize(new java.awt.Dimension(50, 50));
        jphide.setName(""); // NOI18N

        jhide.setBackground(new java.awt.Color(31, 0, 63));
        jhide.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jhide.setForeground(new java.awt.Color(255, 255, 255));
        jhide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jhide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_indeterminate_checkbox_32px.png"))); // NOI18N
        jhide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jhide.setMaximumSize(new java.awt.Dimension(50, 50));
        jhide.setMinimumSize(new java.awt.Dimension(50, 50));
        jhide.setPreferredSize(new java.awt.Dimension(50, 50));
        jhide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jhideMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jphideLayout = new javax.swing.GroupLayout(jphide);
        jphide.setLayout(jphideLayout);
        jphideLayout.setHorizontalGroup(
            jphideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jphideLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jhide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jphideLayout.setVerticalGroup(
            jphideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jphideLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jhide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(jphide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.add(jPanel5, java.awt.BorderLayout.LINE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(26, 36, 107));
        jPanel3.setMinimumSize(new java.awt.Dimension(250, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 600));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jhome.setBackground(new java.awt.Color(26, 36, 107));
        jhome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jhome.setMinimumSize(new java.awt.Dimension(250, 50));
        jhome.setPreferredSize(new java.awt.Dimension(250, 50));
        jhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jhomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jhomeMouseExited(evt);
            }
        });
        jhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_home_32px.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 50));
        jhome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("HOME");
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel3.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 50));
        jhome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, -1));

        jPanel3.add(jhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        puser.setBackground(new java.awt.Color(26, 36, 107));
        puser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        puser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                puserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                puserMouseExited(evt);
            }
        });
        puser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_male_user_32px.png"))); // NOI18N
        jLabel4.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel4.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 50));
        puser.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("User");
        jLabel5.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel5.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel5.setPreferredSize(new java.awt.Dimension(50, 50));
        puser.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, -1));

        jPanel3.add(puser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        pcategorie.setBackground(new java.awt.Color(26, 36, 107));
        pcategorie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pcategorie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pcategorieMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pcategorieMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pcategorieMouseExited(evt);
            }
        });
        pcategorie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_categorize_32px.png"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel6.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel6.setPreferredSize(new java.awt.Dimension(50, 50));
        pcategorie.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Categorie");
        jLabel7.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel7.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel7.setPreferredSize(new java.awt.Dimension(50, 50));
        pcategorie.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, -1));

        jPanel3.add(pcategorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        parchive.setBackground(new java.awt.Color(26, 36, 107));
        parchive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parchiveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                parchiveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parchiveMouseExited(evt);
            }
        });
        parchive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_winrar_32px.png"))); // NOI18N
        jLabel8.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel8.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel8.setPreferredSize(new java.awt.Dimension(50, 50));
        parchive.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Archive");
        jLabel9.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel9.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 50));
        parchive.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, -1));

        jPanel3.add(parchive, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        psetting.setBackground(new java.awt.Color(26, 36, 107));
        psetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        psetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                psettingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                psettingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                psettingMouseExited(evt);
            }
        });
        psetting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_gears_30px.png"))); // NOI18N
        jLabel10.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel10.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel10.setPreferredSize(new java.awt.Dimension(50, 50));
        psetting.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Setting");
        jLabel11.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel11.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel11.setPreferredSize(new java.awt.Dimension(50, 50));
        psetting.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, -1));

        jPanel3.add(psetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel6.setBackground(new java.awt.Color(26, 36, 107));
        jPanel6.setMinimumSize(new java.awt.Dimension(750, 600));

        jDesktopPane1.setBackground(new java.awt.Color(26, 36, 107));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(750, 600));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1000, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
        setOpacity((float) 0.7);
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        setOpacity((float) 1.0);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcloseMouseClicked
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Are you sure Exit...?!",
                "Exit",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jcloseMouseClicked

    private void jhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jhomeMouseClicked
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jDesktopPane1.revalidate();
        FHome home = new FHome();
        jDesktopPane1.add(home).setVisible(true);
    }//GEN-LAST:event_jhomeMouseClicked

    private void jhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jhomeMouseEntered
        bgPanelEntered(jhome);
    }//GEN-LAST:event_jhomeMouseEntered

    private void jhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jhomeMouseExited
        bgPanelExited(jhome);
    }//GEN-LAST:event_jhomeMouseExited

    private void puserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puserMouseClicked
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jDesktopPane1.revalidate();
        FUser user = new FUser();
        jDesktopPane1.add(user).setVisible(true);
    }//GEN-LAST:event_puserMouseClicked

    private void puserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puserMouseEntered
         bgPanelEntered(puser);
    }//GEN-LAST:event_puserMouseEntered

    private void puserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puserMouseExited
         bgPanelExited(puser);
    }//GEN-LAST:event_puserMouseExited

    private void pcategorieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcategorieMouseClicked
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jDesktopPane1.revalidate();
        FCategorie categorie = new FCategorie();
        jDesktopPane1.add(categorie).setVisible(true);
    }//GEN-LAST:event_pcategorieMouseClicked

    private void pcategorieMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcategorieMouseEntered
         bgPanelEntered(pcategorie);
    }//GEN-LAST:event_pcategorieMouseEntered

    private void pcategorieMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcategorieMouseExited
          bgPanelExited(pcategorie);
    }//GEN-LAST:event_pcategorieMouseExited

    private void parchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parchiveMouseClicked
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jDesktopPane1.revalidate();
        FArchive archive = new FArchive();
        jDesktopPane1.add(archive).setVisible(true);
    }//GEN-LAST:event_parchiveMouseClicked

    private void parchiveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parchiveMouseEntered
         bgPanelEntered(parchive);
    }//GEN-LAST:event_parchiveMouseEntered

    private void parchiveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parchiveMouseExited
         bgPanelExited(parchive);
    }//GEN-LAST:event_parchiveMouseExited

    private void psettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psettingMouseClicked
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jDesktopPane1.revalidate();
        FSettings setting = new FSettings();
        jDesktopPane1.add(setting).setVisible(true);
    }//GEN-LAST:event_psettingMouseClicked

    private void psettingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psettingMouseEntered
        bgPanelEntered(psetting);
    }//GEN-LAST:event_psettingMouseEntered

    private void psettingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psettingMouseExited
        bgPanelExited(psetting);
    }//GEN-LAST:event_psettingMouseExited

    private void jresizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jresizeMouseClicked
       if (this.getExtendedState() != Home.MAXIMIZED_BOTH) {
            this.setExtendedState(Home.MAXIMIZED_BOTH);
 
        } else {
            this.setExtendedState(Home.NORMAL);
        }
    }//GEN-LAST:event_jresizeMouseClicked

    private void jhideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jhideMouseClicked
        this.setState(Home.ICONIFIED);
    }//GEN-LAST:event_jhideMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel jclose;
    private javax.swing.JLabel jhide;
    private javax.swing.JPanel jhome;
    private javax.swing.JPanel jphide;
    private javax.swing.JPanel jpresize;
    private javax.swing.JLabel jresize;
    private javax.swing.JPanel parchive;
    private javax.swing.JPanel pcategorie;
    private javax.swing.JPanel psetting;
    private javax.swing.JPanel puser;
    // End of variables declaration//GEN-END:variables
}
