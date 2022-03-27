package entity;

/**
 *
 * @author yongyangboon
 */
public class Room implements Comparable<Room> {
    private int roomNo;
    private Boolean booked;
    public static RoomStatus roomStatus;

    public Room() {

    }

    public Room(int roomNo, boolean booked) {
        this.roomNo = roomNo;
        this.booked = booked;
        roomStatus = RoomStatus.AVAILABLE;
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

        private static RoomStatus getRoomStatus() {
            return roomStatus;
        }

        @Override
        public String toString() {
            switch (RoomStatus.getRoomStatus()) {
                case BOOKED:
                    return "Booked";
                case SERVICE:
                    return "Service ";
                case AVAILABLE:
                default:
                    return "Available";
            }
        }

    }
}
