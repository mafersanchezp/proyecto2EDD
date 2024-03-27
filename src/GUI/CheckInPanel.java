/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Classes.Booking;
import Classes.State;
import DataStructures.BST;
import DataStructures.HashTable;
import DataStructures.List;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Mafer
 */
public class CheckInPanel extends javax.swing.JPanel {
    private BST bookingBST;
    private HashTable stateTable;
    
    public CheckInPanel(BST bookingBST, HashTable stateTable) {
        initComponents();
        this.bookingBST = bookingBST;    
        this.stateTable = stateTable;
        
        errorLabel.setText("");
        
    }


    private void setImg(JLabel label, String root){
          ImageIcon img = new ImageIcon(root);        
          Icon icon = new ImageIcon(
              img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)
          );
          label.setIcon(icon);
          this.repaint();        
    }
    
    private String getAvaibleRoom(){
        List[] table = stateTable.getTable();
        
        List rooms = new List();
        for (List bucket: table) {
            for (int i = 0; i < bucket.getSize(); i++) {
                State auxState = (State) bucket.get(i);
                
                rooms.append(auxState.getRoomNum());
            }
        }
        System.out.println(rooms);
        
        for (int i = 1; i <= 300; i++) {
            if(!rooms.contains(Integer.toString(i))){
                return Integer.toString(i);
            }
        }
        return null;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputId = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        imgCheckIn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 252, 252));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setPreferredSize(new java.awt.Dimension(450, 350));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputId.setBackground(new java.awt.Color(252, 252, 252));
        inputId.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        inputId.setForeground(new java.awt.Color(153, 153, 153));
        inputId.setText("Ingrese cedula");
        inputId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        inputId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputIdFocusLost(evt);
            }
        });
        add(inputId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 260, 30));

        search.setBackground(new java.awt.Color(153, 153, 153));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Buscar");
        search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 90, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error Label");
        add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 20));
        add(imgCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 60, 60));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Check-In");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void inputIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputIdFocusGained
        if(inputId.getText().equals("Ingrese cedula")){
            inputId.setText("");
            inputId.setForeground(Color.black);
        }
    }//GEN-LAST:event_inputIdFocusGained

    private void inputIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputIdFocusLost
        if(inputId.getText().isBlank()){
            inputId.setText("Ingrese cedula");
            inputId.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_inputIdFocusLost

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        errorLabel.setForeground(Color.red);
        errorLabel.setText("");

        
        String id = inputId.getText();        
        
        if(id.isBlank()){
            errorLabel.setText("Error: Ingrese todos los campos del formulario");
        }
        else{
            Booking booking = (Booking) bookingBST.get(id, "id");
            bookingBST.remove(id, "id");
            
            if(booking == null){
                errorLabel.setText("Error: no se encontro el cliente");
            }
            else{
                String name = booking.getName();
                String lastName = booking.getLastName();
                String email = booking.getEmail();
                String sex = booking.getSex();
                String phone = booking.getPhone();
                String dateIn = booking.getDateIn();
                
                String roomNum = getAvaibleRoom();
                
                State newState = new State(id, roomNum, name, lastName, email, sex, phone, dateIn);
                stateTable.insert(newState, "name", "lastName");
                
                errorLabel.setForeground(Color.green);
                errorLabel.setText("EL check-in se ha realizado con exito!");
            }
        }
        
        inputId.setText("Ingrese nombre");
        inputId.setForeground(new Color(153, 153, 153));
        
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel imgCheckIn;
    private javax.swing.JTextField inputId;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
