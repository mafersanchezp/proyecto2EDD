package Classes;

/**
 *
 * @author Mafer
 */
public class State extends Client{
    //Atributos de la clase
    private String roomNum;
    private String phone;
    
    /**
     * Constructor 1: crear estado con cedula
     * @param id
     * @param roomNum
     * @param name
     * @param lastName
     * @param email
     * @param sex
     * @param phone
     * @param dateIn 
     */
    public State(String id, String roomNum, String name, String lastName, String email, String sex, String phone, String dateIn) {
        super(id, name, lastName, email, sex, dateIn);
        this.roomNum = roomNum;
        this.phone = phone;
    }
    
    /**
     * Contructor 2: crear estado sin cedula
     * @param roomNum
     * @param name
     * @param lastName
     * @param email
     * @param sex
     * @param phone
     * @param dateIn 
     */
    public State(String roomNum, String name, String lastName, String email, String sex, String phone, String dateIn) {
        super(name, lastName, email, sex, dateIn);
        this.roomNum = roomNum;
        this.phone = phone;
    }
    
    /**
     * Obtiene numero de habitacion
     * @return 
     */
    public String getRoomNum() {
        return roomNum;
    }
    
    /**
     * Cambia numero de habitacion
     * @param roomNum 
     */
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
    
    /**
     * Obtiene numero de telefono
     * @return 
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * Cambia numero de telefono
     * @param phone 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
}
