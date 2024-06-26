package GUI;

import Classes.Booking;
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
public class SearchBookingPanel extends javax.swing.JPanel {
    //Atributos de la clase
    private BST bookingBST;
    
    /**
     * Constructor
     * @param bookingBST 
     */
    public SearchBookingPanel(BST bookingBST) {
        initComponents();
        this.bookingBST = bookingBST;        
        
        errorLabel.setText("");        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputId = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        idOutput = new javax.swing.JLabel();
        nameOutput = new javax.swing.JLabel();
        lastNameOutput = new javax.swing.JLabel();
        emailOutput = new javax.swing.JLabel();
        sexOutput = new javax.swing.JLabel();
        roomTypeOutput = new javax.swing.JLabel();
        phoneOutput = new javax.swing.JLabel();
        dateInOutput = new javax.swing.JLabel();
        dateOutOutput = new javax.swing.JLabel();

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
        add(inputId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 260, 30));

        search.setBackground(new java.awt.Color(153, 153, 153));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Buscar");
        search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 90, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error Label");
        add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, 20));

        idOutput.setText("Cedula:   ");
        add(idOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        nameOutput.setText("Nombre:   ");
        add(nameOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        lastNameOutput.setText("Apellido:   ");
        add(lastNameOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        emailOutput.setText("Email:   ");
        add(emailOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        sexOutput.setText("Genero:   ");
        add(sexOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        roomTypeOutput.setText("Tipo de habitacion:   ");
        add(roomTypeOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        phoneOutput.setText("Celular:   ");
        add(phoneOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        dateInOutput.setText("Fecha de llegada:   ");
        add(dateInOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        dateOutOutput.setText("Fecha de salida:   ");
        add(dateOutOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));
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
        try{
            
            errorLabel.setText("");
            idOutput.setText("Cedula:   ");
            nameOutput.setText("Nombre:   ");
            lastNameOutput.setText("Apellido:   ");
            emailOutput.setText("Email:   ");
            sexOutput.setText("Genero:   ");
            roomTypeOutput.setText("Tipo de habitacion:   ");
            phoneOutput.setText("Celular:   ");
            dateInOutput.setText("Fecha de llegada:   ");
            dateOutOutput.setText("Fecha de salida:   ");

            String id = inputId.getText();        

            if(id.isBlank()){
                errorLabel.setText("Error: Ingrese todos los campos del formulario");
            }
            else{
                Booking booking = (Booking) bookingBST.get(id, "id");

                if(booking == null){
                    errorLabel.setText("Error: no se encontro la reservacion");
                }
                else{
                    idOutput.setText(idOutput.getText() + booking.getId());
                    nameOutput.setText(nameOutput.getText() + booking.getName());
                    lastNameOutput.setText(lastNameOutput.getText() + booking.getLastName());
                    emailOutput.setText(emailOutput.getText() + booking.getEmail());
                    sexOutput.setText(sexOutput.getText() + booking.getSex());
                    roomTypeOutput.setText(roomTypeOutput.getText() + booking.getRoomType());
                    phoneOutput.setText(phoneOutput.getText() + booking.getPhone());
                    dateInOutput.setText(dateInOutput.getText() + booking.getDateIn());
                    dateOutOutput.setText(dateOutOutput.getText() + booking.getDateOut());
                }
            }
            inputId.setText("Ingrese nombre");
            inputId.setForeground(new Color(153, 153, 153));
        }
        catch(Exception e){
            errorLabel.setText("Error: no se encontro la reservacion");
            inputId.setText("Ingrese nombre");
            inputId.setForeground(new Color(153, 153, 153));
        }
        
        
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateInOutput;
    private javax.swing.JLabel dateOutOutput;
    private javax.swing.JLabel emailOutput;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel idOutput;
    private javax.swing.JTextField inputId;
    private javax.swing.JLabel lastNameOutput;
    private javax.swing.JLabel nameOutput;
    private javax.swing.JLabel phoneOutput;
    private javax.swing.JLabel roomTypeOutput;
    private javax.swing.JButton search;
    private javax.swing.JLabel sexOutput;
    // End of variables declaration//GEN-END:variables
}
