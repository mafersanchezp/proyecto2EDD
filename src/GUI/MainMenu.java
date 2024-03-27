/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Classes.Booking;
import Classes.ExcelReader;
import Classes.Record;
import Classes.State;
import DataStructures.BST;
import DataStructures.HashTable;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mafer
 */
public class MainMenu extends javax.swing.JFrame {
    private int xMouse, yMouse;
    private HashTable stateTable;
    private BST bookingBST;
    private BST recordBST;
    private BST roomGroupBST;
    
    
    public MainMenu() {        
        initComponents();
        this.setLocationRelativeTo(this);
        this.stateTable = ExcelReader.getState();
        this.bookingBST = ExcelReader.getBooking();
        this.recordBST = ExcelReader.getRecord();
        this.roomGroupBST = ExcelReader.getRoomGroup();
                
  
        setImg(imgHotel, "src/Images/hotel_icon.png");
        setImg(iconHotel, "src/Images/hotel_icon.png");
        
    }

    private void setImg(JLabel label, String root){
          ImageIcon img = new ImageIcon(root);        
          Icon icon = new ImageIcon(
              img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)
          );
          label.setIcon(icon);
          this.repaint();        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        backgroud = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        iconHotel = new javax.swing.JLabel();
        leftContainer = new javax.swing.JPanel();
        checkOut = new javax.swing.JToggleButton();
        searchClient = new javax.swing.JToggleButton();
        searchBooking = new javax.swing.JToggleButton();
        searchRecord = new javax.swing.JToggleButton();
        checkIn = new javax.swing.JToggleButton();
        rightContainer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        imgHotel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        backgroud.setBackground(new java.awt.Color(250, 250, 250));
        backgroud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setBackground(new java.awt.Color(255, 0, 51));
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 2, new java.awt.Color(0, 0, 0)));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        header.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 0, 50, 50));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Sistema Hotel");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        iconHotel.setBackground(new java.awt.Color(255, 153, 0));
        iconHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.add(iconHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 40, 40));

        backgroud.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 50));

        leftContainer.setBackground(new java.awt.Color(229, 229, 229));
        leftContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        leftContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkOut.setBackground(new java.awt.Color(51, 153, 255));
        buttonGroup.add(checkOut);
        checkOut.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        checkOut.setForeground(new java.awt.Color(255, 255, 255));
        checkOut.setText("Check-out");
        checkOut.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        checkOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutActionPerformed(evt);
            }
        });
        leftContainer.add(checkOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 150, 70));

        searchClient.setBackground(new java.awt.Color(51, 153, 255));
        buttonGroup.add(searchClient);
        searchClient.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchClient.setForeground(new java.awt.Color(255, 255, 255));
        searchClient.setText("Buscar Cliente");
        searchClient.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        searchClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClientActionPerformed(evt);
            }
        });
        leftContainer.add(searchClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 70));

        searchBooking.setBackground(new java.awt.Color(51, 153, 255));
        buttonGroup.add(searchBooking);
        searchBooking.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchBooking.setForeground(new java.awt.Color(255, 255, 255));
        searchBooking.setText("Buscar Reserva");
        searchBooking.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        searchBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookingActionPerformed(evt);
            }
        });
        leftContainer.add(searchBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 150, 70));

        searchRecord.setBackground(new java.awt.Color(51, 153, 255));
        buttonGroup.add(searchRecord);
        searchRecord.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchRecord.setForeground(new java.awt.Color(255, 255, 255));
        searchRecord.setText("Buscar Historial");
        searchRecord.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        searchRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRecordActionPerformed(evt);
            }
        });
        leftContainer.add(searchRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 150, 70));

        checkIn.setBackground(new java.awt.Color(51, 153, 255));
        buttonGroup.add(checkIn);
        checkIn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        checkIn.setForeground(new java.awt.Color(255, 255, 255));
        checkIn.setText("Check-In");
        checkIn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        checkIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInActionPerformed(evt);
            }
        });
        leftContainer.add(checkIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 150, 70));

        backgroud.add(leftContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 150, 350));

        rightContainer.setBackground(new java.awt.Color(252, 252, 252));
        rightContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Bienvenido al sistema del hotel");

        imgHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout rightContainerLayout = new javax.swing.GroupLayout(rightContainer);
        rightContainer.setLayout(rightContainerLayout);
        rightContainerLayout.setHorizontalGroup(
            rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightContainerLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel2)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rightContainerLayout.setVerticalGroup(
            rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightContainerLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        backgroud.add(rightContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 450, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void searchRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRecordActionPerformed
        SearchRecordPanel panel = new SearchRecordPanel(roomGroupBST);
        panel.setSize(rightContainer.getWidth(), rightContainer.getHeight());
        panel.setLocation(0, 0);

        rightContainer.removeAll();
        rightContainer.add(panel, BorderLayout.CENTER);
        rightContainer.revalidate();
        rightContainer.repaint();
    }//GEN-LAST:event_searchRecordActionPerformed

    private void searchClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchClientActionPerformed
        SearchClientPanel panel = new SearchClientPanel(stateTable);
        panel.setSize(rightContainer.getWidth(), rightContainer.getHeight());
        panel.setLocation(0, 0);

        rightContainer.removeAll();
        rightContainer.add(panel, BorderLayout.CENTER);
        rightContainer.revalidate();
        rightContainer.repaint();
    }//GEN-LAST:event_searchClientActionPerformed

    private void searchBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookingActionPerformed
        SearchBookingPanel panel = new SearchBookingPanel(bookingBST);panel.setSize(rightContainer.getWidth(), rightContainer.getHeight());
        panel.setLocation(0, 0);

        rightContainer.removeAll();
        rightContainer.add(panel, BorderLayout.CENTER);
        rightContainer.revalidate();
        rightContainer.repaint();
    }//GEN-LAST:event_searchBookingActionPerformed

    private void checkInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInActionPerformed
        CheckInPanel panel = new CheckInPanel(bookingBST, stateTable);
        panel.setSize(rightContainer.getWidth(), rightContainer.getHeight());
        panel.setLocation(0, 0);

        rightContainer.removeAll();
        rightContainer.add(panel, BorderLayout.CENTER);
        rightContainer.revalidate();
        rightContainer.repaint();
    }//GEN-LAST:event_checkInActionPerformed

    private void checkOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutActionPerformed
        CheckOutPanel panel = new CheckOutPanel(stateTable, recordBST);
        panel.setSize(rightContainer.getWidth(), rightContainer.getHeight());
        panel.setLocation(0, 0);

        rightContainer.removeAll();
        rightContainer.add(panel, BorderLayout.CENTER);
        rightContainer.revalidate();
        rightContainer.repaint();
    }//GEN-LAST:event_checkOutActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroud;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JToggleButton checkIn;
    private javax.swing.JToggleButton checkOut;
    private javax.swing.JButton exit;
    private javax.swing.JPanel header;
    private javax.swing.JLabel iconHotel;
    private javax.swing.JLabel imgHotel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel leftContainer;
    private javax.swing.JPanel rightContainer;
    private javax.swing.JToggleButton searchBooking;
    private javax.swing.JToggleButton searchClient;
    private javax.swing.JToggleButton searchRecord;
    // End of variables declaration//GEN-END:variables
}
