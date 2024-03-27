package Classes;

/**
 *
 * @author Mafer
 */
public class Room implements Comparable<Room>{
    //Atributos de la clase
    private String roomNum;
    private String roomType;
    private String floor;
    
    /**
     * Constructor
     * @param roomNum
     * @param roomType
     * @param floor 
     */
    public Room(String roomNum, String roomType, String floor) {
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.floor = floor;
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
     * Obtiene el tipo de habitacion
     * @return 
     */
    public String getRoomType() {
        return roomType;
    }
    
    /**
     * Cambia el tipo de habitacion
     * @param roomType 
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    /**
     * Obtiene el piso de la habitacion
     * @return 
     */
    public String getFloor() {
        return floor;
    }
    
    /**
     * Cambia el piso de la habitacion
     * @param floor 
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }
    
    /**
     * Metodo para comparar entre objetos Room
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Room o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Metodo que enseña el numero de habitacion, tipo de habitacion y piso de la habitacion
     * @return 
     */
    @Override
    public String toString() {
        return "numeroHab: " + roomNum + " | tipoHab: " + roomType + " | floor: " + floor;
    }
    
    
    
    
}
