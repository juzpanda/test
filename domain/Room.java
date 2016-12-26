package domain;

import java.io.Serializable;
import java.util.Objects;

public class Room implements Serializable{
    private String roomId;
    private String roomType;
    private double roomPrice;
    private String roomStatus;
    private String roomDescription;

    public Room() {
    }

    public Room(String roomId, String roomType, double roomPrice, String roomStatus, String roomDescription) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomStatus = roomStatus;
        this.roomDescription = roomDescription;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
    
    
    
}
