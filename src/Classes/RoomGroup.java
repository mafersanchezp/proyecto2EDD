
package Classes;

import DataStructures.List;

/**
 *
 * @author Mafer
 */
public class RoomGroup implements Comparable<RoomGroup>{
    private List<Record> group;
    private String roomNum;

    public RoomGroup(List<Record> group, String roomNum) {
        this.group = group;
        this.roomNum = roomNum;
    }
    
    public RoomGroup(String roomNum) {
        this.group = new List<Record>();
        this.roomNum = roomNum;
    }

    public List getGroup() {
        return group;
    }

    public void setGroup(List group) {
        this.group = group;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    

    @Override
    public int compareTo(RoomGroup o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
}
