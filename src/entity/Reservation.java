package entity;

/**
 *
 * @author yongyang
 */
public class Reservation implements Comparable<Reservation> {
   private int reservationNo = 10000;
   private Room room;
   private Member member;

   public Reservation(int reservationNo, Room room, Member member) {
      this.reservationNo = reservationNo;
      this.room = room;
      this.member = member;
      // this.room.setBooked();
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

   public Member getMember() {
      return this.member;
   }

   public void setMember(Member member) {
      this.member = member;
   }

   @Override
   public String toString() {
      return "\nReservation No: " + getReservationNo()
            + "room=" + getRoom() + "'" +
            ", member='" + getMember() + "'" +
            "}";
   }

   @Override
   public int compareTo(Reservation o) {
      return (int) (this.reservationNo - o.reservationNo);
   }
}