package Classes;

import DataStructures.List;

/**
 *
 * @author Mafer
 */

//Clase para agrupar los historicos por habitaciones
public class RoomGroup implements Comparable<RoomGroup>{
    //Atributos de la clase
    private List<Record> group;
    private String roomNum;
    
    /**
     * Constructor 1: se le pide la lista de historicos
     * @param group
     * @param roomNum 
     */
    public RoomGroup(List<Record> group, String roomNum) {
        this.group = group;
        this.roomNum = roomNum;
    }
    
    /**
     * Constructor 2: no se le pide la lista de historicos
     * @param roomNum 
     */
    public RoomGroup(String roomNum) {
        this.group = new List<Record>();
        this.roomNum = roomNum;
    }
    
    /**
     * Obtiene el la lista de historicos
     * @return 
     */
    public List getGroup() {
        return group;
    }
    
    /**
     * Cambia la lista de historicos
     * @param group 
     */
    public void setGroup(List group) {
        this.group = group;
    }
    
    /**
     * Obtiene el numero de habitacion
     * @return 
     */
    public String getRoomNum() {
        return roomNum;
    }
    
    /**
     * Cambia el numero de habitacion
     * @param roomNum 
     */
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    
    /**
     * Metodo para comparar entre objetos RoomGroup
     * @param o
     * @return 
     */
    @Override
    public int compareTo(RoomGroup o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
}
