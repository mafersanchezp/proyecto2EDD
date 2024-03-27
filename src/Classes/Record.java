/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Mafer
 */
public class Record extends Client{
    private String roomNum;

    public Record(String id, String name, String lastName, String email, String sex, String dateIn, String roomNum) {
        super(id, name, lastName, email, sex, dateIn);
        this.roomNum = roomNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
    
    
    
    
}
