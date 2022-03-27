package entity;

import java.time.LocalTime;

import adt.YongYang.SortedListInterface;
/**
 *
 * @author yongyangboon
 */
public class TimeSlot implements Comparable<TimeSlot> {
    private LocalTime time;
    private SortedListInterface<Room> roomList;

    public TimeSlot() {
    }

    public TimeSlot(LocalTime time, SortedListInterface<Room> roomList) {
        this.time = time;
        this.roomList = roomList;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public SortedListInterface<Room> getRoomList() {
        return this.roomList;
    }

    public void setRoomList(SortedListInterface<Room> roomList) {
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
