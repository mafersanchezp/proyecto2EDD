package GUI;

import Classes.Record;
import Classes.RoomGroup;
import Classes.State;
import DataStructures.BST;
import DataStructures.HashTable;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Mafer
 */
public class CheckOutPanel<T extends Comparable<T>> extends javax.swing.JPanel {
    //Atributos de la clase
    private HashTable stateTable;
    private BST<RoomGroup> roomGroupBST;
    
    /**
     * Constructor
     * @param stateTable
     * @param recordBST 
     */
    public CheckOutPanel(HashTable stateTable, BST roomGroupBST) {
        initComponents();
        this.stateTable = stateTable;    
        this.roomGroupBST = roomGroupBST;
        
        errorLabel.setText("");                
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputLastName = new javax.swing.JTextField();
        inputName = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 252, 252));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setPreferredSize(new java.awt.Dimension(450, 350));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputLastName.setBackground(new java.awt.Color(252, 252, 252));
        inputLastName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        inputLastName.setForeground(new java.awt.Color(153, 153, 153));
        inputLastName.setText("Ingrese apellido");
        inputLastName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        inputLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputLastNameFocusLost(evt);
            }
        });
        add(inputLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 260, 30));

        inputName.setBackground(new java.awt.Color(252, 252, 252));
        inputName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        inputName.setForeground(new java.awt.Color(153, 153, 153));
        inputName.setText("Ingrese nombre");
        inputName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        inputName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputNameFocusLost(evt);
            }
        });
        add(inputName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 260, 30));

        search.setBackground(new java.awt.Color(153, 153, 153));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Buscar");
        search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 90, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error Label");
        add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Check-Out");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void inputNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNameFocusGained
        if(inputName.getText().equals("Ingrese nombre")){
            inputName.setText("");
            inputName.setForeground(Color.black);
        }
    }//GEN-LAST:event_inputNameFocusGained

    private void inputNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNameFocusLost
        if(inputName.getText().isBlank()){
            inputName.setText("Ingrese nombre");
            inputName.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_inputNameFocusLost

    private void inputLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputLastNameFocusGained
        if(inputLastName.getText().equals("Ingrese apellido")){
            inputLastName.setText("");
            inputLastName.setForeground(Color.black);
        }
    }//GEN-LAST:event_inputLastNameFocusGained

    private void inputLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputLastNameFocusLost
        if(inputLastName.getText().isBlank()){
            inputLastName.setText("Ingrese apellido");
            inputLastName.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_inputLastNameFocusLost

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try{
            
            errorLabel.setForeground(Color.red);
            errorLabel.setText("");

            String name = inputName.getText();
            String lastName = inputLastName.getText();

            if(name.isBlank() || lastName.isBlank()){
                errorLabel.setText("Error: Ingrese todos los campos del formulario");
            }
            else{
                State state = (State) stateTable.get(name, lastName, "name", "lastName");  
                stateTable.remove(name, lastName, "name", "lastName");

                if(state == null){
                    errorLabel.setText("Error: no se encontro el cliente");
                }
                else{
                    String id = state.getId();
                    String email = state.getEmail();
                    String sex = state.getSex();
                    String dateIn = state.getDateIn();
                    String roomNum = state.getRoomNum();

                    Record record = new Record(id, name, lastName, email, sex, dateIn, roomNum);

                    RoomGroup rg = (RoomGroup) roomGroupBST.get((T) roomNum, "roomNum");
                    System.out.println(rg);
                    rg.getGroup().append(record);

                    errorLabel.setForeground(Color.green);
                    errorLabel.setText("Check-out realizado con exito!");
                }
            }

            inputName.setText("Ingrese nombre");
            inputName.setForeground(new Color(153, 153, 153));
            inputLastName.setText("Ingrese apellido");
            inputLastName.setForeground(new Color(153, 153, 153));        
        }
        catch(Exception e){
            System.out.println("catch");
            inputName.setText("Ingrese nombre");
            inputName.setForeground(new Color(153, 153, 153));
            inputLastName.setText("Ingrese apellido");
            inputLastName.setForeground(new Color(153, 153, 153)); 
            errorLabel.setText("Error: no se encontro el cliente");
        }
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField inputLastName;
    private javax.swing.JTextField inputName;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
