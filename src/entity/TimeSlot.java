package entity;

import java.time.LocalTime;

import adt.YongYang.SortedArrayInterface;
/**
 *
 * @author yongyang
 */
public class TimeSlot implements Comparable<TimeSlot> {
    private LocalTime time;
    private SortedArrayInterface<Room> roomList;

    public TimeSlot() {
    }

    public TimeSlot(LocalTime time, SortedArrayInterface<Room> roomList) {
        this.time = time;
        this.roomList = roomList;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public SortedArrayInterface<Room> getRoomList() {
        return this.roomList;
    }

    public void setRoomList(SortedArrayInterface<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public String toString() {
        return getTime().toString();
    }

    @Override
    public int compareTo(TimeSlot o) {
        return (int) (this.time.compareTo(o.time));
    }

}
