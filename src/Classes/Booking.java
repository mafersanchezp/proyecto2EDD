/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Mafer
 */
public class Booking extends Client {
    private String roomType;
    private String phone;
    private String dateOut;

    public Booking(String id, String name, String lastName, String email, String sex, String roomType, String phone, String dateIn, String dateOut) {
        super(id, name, lastName, email, sex, dateIn);
        this.roomType = roomType;
        this.phone = phone;
        this.dateOut = dateOut;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
    
    
    
    
}
