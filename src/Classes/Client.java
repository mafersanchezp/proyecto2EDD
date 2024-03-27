package Classes;

/**
 *
 * @author Mafer
 */
public class Client {
    //Atributos de la clase
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String sex;
    private String dateIn;
    
    /**
     * Constructor 1: permite crear un cliente con cedula
     * @param id
     * @param name
     * @param lastName
     * @param email
     * @param sex
     * @param dateIn 
     */
    public Client(String id, String name, String lastName, String email, String sex, String dateIn) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.dateIn = dateIn;
    }
    
    /**
     * Constructor 2: permite crear un cliente sin cedula (Cargar del excel)
     * @param name
     * @param lastName
     * @param email
     * @param sex
     * @param dateIn 
     */
    public Client(String name, String lastName, String email, String sex, String dateIn) {
        this.id = null;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.dateIn = dateIn;
    }
    
    /**
     * Obtiene la cedula del cliente
     * @return 
     */
    public String getId() {
        return id;
    }
    
    /**
     * Cambia la cedula del cliente
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene el nombre del cliente
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Cambia el nombre del cliente
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Obtiene el apellido del cliente
     * @return 
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Cambia el apellido del cliente
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Obtiene el email del cliente
     * @return 
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Cambia el email del cliente
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtiene el genero del cliente
     * @return 
     */
    public String getSex() {
        return sex;
    }
    
    /**
     * Cambia el genero del cliente
     * @param sex 
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    /**
     * Obtiene la fecha de llegada del cliente
     * @return 
     */
    public String getDateIn() {
        return dateIn;
    }
    
    /**
     * Cambia la fecha de llegada del cliente
     * @param dateIn 
     */     
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }
    
    
}
