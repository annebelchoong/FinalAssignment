package entity;

import entity.Room.RoomStatus;

/**
 *
 * @author yongyang
 */
public class Reservation implements Comparable<Reservation> {
   private int reservationNo = 10000;
   private Room room;
   private TimeSlot timeSlot;
   private Member member;

   public Reservation(int reservationNo, Room room, TimeSlot timeSlot, Member member) {
      this.reservationNo = reservationNo;
      this.room = room;
      this.timeSlot = timeSlot;
      this.member = member;
      // Room.roomStatus = RoomStatus.BOOKED;
   }

   public int getReservationNo() {
      return this.reservationNo;
   }

   public void setReservationNo(int reservationNo) {
      this.reservationNo = reservationNo;
   }

   public Room getRoom() {
      return this.room;
   }

   public void setRoom(Room room) {
      this.room = room;
   }

   public TimeSlot getTimeSlot() {
      return this.timeSlot;
   }

   public void setTimeSlot(TimeSlot timeSlot) {
      this.timeSlot = timeSlot;
   }

   public Member getMember() {
      return this.member;
   }

   public void setMember(Member member) {
      this.member = member;
   }

   @Override
   public String toString() {
      return "\nReservation No: " + getReservationNo() +
            "\nMember ID: " + member.getMemberId() +
            "\nMember Name: " + member.getMemberName() +
            "\nRoom: " + getRoom() +
            "\nTime: " + timeSlot.getTime();
   }

   @Override
   public int compareTo(Reservation o) {
      return (int) (this.reservationNo - o.reservationNo);
   }
}