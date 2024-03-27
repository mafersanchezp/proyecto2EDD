package Classes;

/**
 *
 * @author Mafer
 */
public class Record extends Client implements Comparable<Record>{
    //Atributos de la clase
    private String roomNum;
    
    /**
     * Constructor
     * @param id
     * @param name
     * @param lastName
     * @param email
     * @param sex
     * @param dateIn
     * @param roomNum 
     */
    public Record(String id, String name, String lastName, String email, String sex, String dateIn, String roomNum) {
        super(id, name, lastName, email, sex, dateIn);
        this.roomNum = roomNum;
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
     * Enseña el nombre, cedula y numero de habitacion del historial
     * @return 
     */
    @Override
    public String toString() {
        return "Nombre: " + getName() + " | Ci: " + getId() + " | numHab: " + roomNum;
    }

    
    /**
     * Metodo para comparar entre objetos Record
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Record o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
