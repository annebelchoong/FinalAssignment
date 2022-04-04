package entity;

/**
 *
 * @author yongyangboon
 */
public class Room implements Comparable<Room> {
    private int roomNo;
    private Boolean booked;
    private RoomStatus roomStatus;

    public Room() {

    }

    public Room(int roomNo
    ) {
        this.roomNo = roomNo;
        this.setAvailable();
        // roomStatus = RoomStatus.AVAILABLE;
        getRoomStatus();
    }

    public int getRoomNo() {
        return this.roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public boolean getBooked() {
        return this.booked;
    }

    public String getRoomStatusinString() {
        switch (roomStatus) {
            case BOOKED:
                return "   Booked";
            case SERVICE:
                return " Service ";
            case AVAILABLE:
            default:
                return "Available";
        }
    }

    public RoomStatus getRoomStatus() {
        if(booked == null){
            roomStatus = RoomStatus.SERVICE;
        } else if (booked){
            roomStatus = RoomStatus.BOOKED;
        }else {
            roomStatus = RoomStatus.AVAILABLE;
        }
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus status) {
        roomStatus = status;
    }

    public void setBooked() {
        this.booked = true;
    }

    public void setAvailable() {
        this.booked = false;
    }

    @Override
    public String toString() {
        return String.valueOf(getRoomNo());
    }

    @Override
    public int compareTo(Room o) {
        return (int) (this.roomNo - o.roomNo);
    }

    public enum RoomStatus {
        AVAILABLE, BOOKED, SERVICE;

        // private RoomStatus getRoomStatus(Room room) {
        //     return room.roomStatus;
        // }

        // @Override
        // public String toString() {
        // switch (RoomStatus.getRoomStatus()) {
        // case BOOKED:
        // return "Booked";
        // case SERVICE:
        // return "Service ";
        // case AVAILABLE:
        // default:
        // return "Available";
        // }
        // }

    }
}
