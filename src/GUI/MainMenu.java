/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Mafer
 */
public class MainMenu extends javax.swing.JFrame {
    private int xMouse, yMouse;
    
    
    public MainMenu() {
        initComponents();
        this.setLocationRelativeTo(this);
                
        SearchClientPanel scPanel = new SearchClientPanel();
        scPanel.setSize(rightContainer.getWidth(), rightContainer.getHeight());
        scPanel.setLocation(0, 0);
        
        rightContainer.removeAll();
        rightContainer.add(scPanel, BorderLayout.CENTER);
        rightContainer.revalidate();
        rightContainer.repaint();
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroud = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        leftContainer = new javax.swing.JPanel();
        CheckOut = new javax.swing.JButton();
        searchClient = new javax.swing.JButton();
        SearchBooking = new javax.swing.JButton();
        searchRoomRecord = new javax.swing.JButton();
        CheckIn = new javax.swing.JButton();
        rightContainer = new javax.swing.JPanel();

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
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        backgroud.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 50));

        leftContainer.setBackground(new java.awt.Color(229, 229, 229));
        leftContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        leftContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CheckOut.setBackground(new java.awt.Color(11, 134, 209));
        CheckOut.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CheckOut.setForeground(new java.awt.Color(255, 255, 255));
        CheckOut.setText("Check-Out");
        CheckOut.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        leftContainer.add(CheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 150, 70));

        searchClient.setBackground(new java.awt.Color(11, 134, 209));
        searchClient.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchClient.setForeground(new java.awt.Color(255, 255, 255));
        searchClient.setText("Buscar Cliente");
        searchClient.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        leftContainer.add(searchClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 70));

        SearchBooking.setBackground(new java.awt.Color(11, 134, 209));
        SearchBooking.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        SearchBooking.setForeground(new java.awt.Color(255, 255, 255));
        SearchBooking.setText("Buscar Reservacion");
        SearchBooking.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        leftContainer.add(SearchBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 150, 70));

        searchRoomRecord.setBackground(new java.awt.Color(11, 134, 209));
        searchRoomRecord.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchRoomRecord.setForeground(new java.awt.Color(255, 255, 255));
        searchRoomRecord.setText("Historial Habitacion");
        searchRoomRecord.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        leftContainer.add(searchRoomRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 150, 70));

        CheckIn.setBackground(new java.awt.Color(11, 134, 209));
        CheckIn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CheckIn.setForeground(new java.awt.Color(255, 255, 255));
        CheckIn.setText("Check-In");
        CheckIn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        leftContainer.add(CheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 150, 70));

        backgroud.add(leftContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 150, 350));

        rightContainer.setBackground(new java.awt.Color(252, 252, 252));
        rightContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout rightContainerLayout = new javax.swing.GroupLayout(rightContainer);
        rightContainer.setLayout(rightContainerLayout);
        rightContainerLayout.setHorizontalGroup(
            rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        rightContainerLayout.setVerticalGroup(
            rightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
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
        
        this.setLocation(x- xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

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
    private javax.swing.JButton CheckIn;
    private javax.swing.JButton CheckOut;
    private javax.swing.JButton SearchBooking;
    private javax.swing.JPanel backgroud;
    private javax.swing.JButton exit;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel leftContainer;
    private javax.swing.JPanel rightContainer;
    private javax.swing.JButton searchClient;
    private javax.swing.JButton searchRoomRecord;
    // End of variables declaration//GEN-END:variables
}
