package GUI;

import Classes.Record;
import Classes.RoomGroup;
import DataStructures.BST;
import DataStructures.List;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mafer
 */
public class SearchRecordPanel extends javax.swing.JPanel {
    //Atributos de la clase
    DefaultTableModel rooms = new DefaultTableModel();
    BST roomGroupBST;
    
    /**
     * Constructor
     * @param roomGroupBST 
     */
    public SearchRecordPanel(BST roomGroupBST) {
        initComponents();
        this.roomGroupBST = roomGroupBST;
        errorLabel.setText("");
        setModel();
        
    }
    
    /**
     * Metodo para iniciar el encabezado del JTable
     */
    private void setModel(){                
        String[] header = {"Ci", "Nombre", "Apellido", "Genero", "Fecha", "NumHab"};
        rooms.setColumnIdentifiers(header);
        table.setModel(rooms);
    }
    
    /**
     * Metodo para rellenar el JTable
     * @param rg 
     */
    private void setData(RoomGroup rg){
        rooms.setRowCount(0);
        
        Object[] row = new Object[table.getColumnCount()];
        
        List<Record> roomsList = rg.getGroup();
        for (int i = 0; i < roomsList.getSize(); i++) {
            Record auxRecord = roomsList.get(i);
            
            row[0] = auxRecord.getId();
            row[1] = auxRecord.getName();
            row[2] = auxRecord.getLastName();
            row[3] = auxRecord.getSex();
            row[4] = auxRecord.getDateIn();
            row[5] = auxRecord.getRoomNum();
            rooms.addRow(row);
        }
        table.setModel(rooms);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomNumInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 252, 252));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomNumInput.setBackground(new java.awt.Color(252, 252, 252));
        roomNumInput.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        roomNumInput.setForeground(new java.awt.Color(153, 153, 153));
        roomNumInput.setText("Ingrese numero de habitacion");
        roomNumInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        roomNumInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roomNumInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomNumInputFocusLost(evt);
            }
        });
        add(roomNumInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 290, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 410, 210));

        search.setBackground(new java.awt.Color(153, 153, 153));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Buscar");
        search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error Label");
        add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void roomNumInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNumInputFocusGained
        if(roomNumInput.getText().equals("Ingrese numero de habitacion")){
            roomNumInput.setText("");
            roomNumInput.setForeground(Color.black);
        }
    }//GEN-LAST:event_roomNumInputFocusGained

    private void roomNumInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNumInputFocusLost
        if(roomNumInput.getText().isBlank()){
            roomNumInput.setText("Ingrese numero de habitacion");
            roomNumInput.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_roomNumInputFocusLost

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try{
            errorLabel.setText("");

            String roomNum = roomNumInput.getText();

            if(roomNum.isBlank()){
                errorLabel.setText("Error: Ingrese todos los campos del formulario");
            }
            else{            
                RoomGroup rg = (RoomGroup) roomGroupBST.get(roomNum, "roomNum");
                setData(rg);

            }

            table.setModel(rooms);            
        }
        catch(Exception e){
            errorLabel.setText("Error: no se pudo encontrar el historial");
        }

    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField roomNumInput;
    private javax.swing.JButton search;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
