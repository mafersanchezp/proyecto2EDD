package Classes;

/**
 *
 * @author Mafer
 */
public class Room implements Comparable<Room>{
    private String roomNum;
    private String roomType;
    private String floor;

    public Room(String roomNum, String roomType, String floor) {
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.floor = floor;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public int compareTo(Room o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "numeroHab: " + roomNum + " | tipoHab: " + roomType + " | floor: " + floor;
    }
    
    
    
    
}
