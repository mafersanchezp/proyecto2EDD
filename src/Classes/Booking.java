package Classes;

/**
 *
 * @author Mafer
 */
public class Booking extends Client implements Comparable<Booking>{
    //Atributos de la clase
    private String roomType;
    private String phone;
    private String dateOut;
    
    /**
     * Constructor
     * @param id
     * @param name
     * @param lastName
     * @param email
     * @param sex
     * @param roomType
     * @param phone
     * @param dateIn
     * @param dateOut 
     */
    public Booking(String id, String name, String lastName, String email, String sex, String roomType, String phone, String dateIn, String dateOut) {
        super(id, name, lastName, email, sex, dateIn);
        this.roomType = roomType;
        this.phone = phone;
        this.dateOut = dateOut;
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
     * Obtiene el numero de telefono
     * @return 
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * Cambia el numero de telefono
     * @param phone 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * Obtiene la fecha de salida
     * @return 
     */
    public String getDateOut() {
        return dateOut;
    }
    
    /**
     * Cambia la fecha de salida
     * @param dateOut 
     */
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
    
    /**
     * Metodo para comparar entre objetos Booking
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Booking o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Metodo para enseñar nombre, apellido y cedula de la reserva
     * @return 
     */
    @Override
    public String toString() {
        return "Nombre: " + getName() + " | Apellido: " + getLastName() + " | Cedula: " + getId();
    }
    
    
    
    
    
    
}
