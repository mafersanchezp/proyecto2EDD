/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Mafer
 */
public class State extends Client{
    private String roomNum;
    private String phone;

    public State(String id, String roomNum, String name, String lastName, String email, String sex, String phone, String dateIn) {
        super(id, name, lastName, email, sex, dateIn);
        this.roomNum = roomNum;
        this.phone = phone;
    }
    
    public State(String roomNum, String name, String lastName, String email, String sex, String phone, String dateIn) {
        super(name, lastName, email, sex, dateIn);
        this.roomNum = roomNum;
        this.phone = phone;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
}
