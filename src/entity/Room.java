package entity;

/**
 *
 * @author yongyang
 */
public class Room implements Comparable<Room> {
    private int roomNo;
    private boolean booked;

    public Room() {

    }

    public Room(int roomNo, boolean booked) {
        this.roomNo = roomNo;
        this.booked = booked;
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

    public String getRoomStatus() {
        return getBooked() ? "Booked" : "Available";
    }

    public void setBooked() {
        this.booked = true;
    }

    public void setAvailable() {
        this.booked = false;
    }

    @Override
    public String toString() {
        String roomStatus = getBooked() ? "Booked" : "Available";
        return "  " + getRoomNo() + "\t" + roomStatus;
    }

    @Override
    public int compareTo(Room o) {
        return (int) (this.roomNo - o.roomNo);
    }
}