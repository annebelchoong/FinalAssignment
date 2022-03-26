package modules;

import java.time.LocalTime;
import java.util.Scanner;

import adt.YongYang.SortedArrayList;
import adt.YongYang.SortedListInterface;
import entity.Member;
import entity.Reservation;
import entity.Room;
import entity.TimeSlot;
// import adt.Guna.SortedListInterface;
import utility.Utility;

/**
 *
 * @author yongyang
 */
public class ReservationModule {
    public static Scanner scan = new Scanner(System.in);
    private static boolean toContinue = true;
    private static boolean toMainMenu = true;

    // public static ReservationModule rDriver = new ReservationModule();

    public SortedListInterface<Room> roomList = new SortedArrayList<>();
    public SortedListInterface<TimeSlot> timeSlots = new SortedArrayList<>();
    public SortedListInterface<Reservation> reservationList = new SortedArrayList<>();

    public static SortedListInterface<Member> memberList = (SortedListInterface<Member>) MemberModule.getMemberList();

    public ReservationModule() {
        // this.reserveList = reserveList;
        // this.roomList = roomList;
        // this.timeSlots = timeSlots;

    }

    public void reservationMenu() {
        while (toContinue) {
            toMainMenu = true;
            switch (showMainMenu()) {
                case "1":
                    // while (toMainMenu)
                    // System.out.print(roomList.printRoomList());
                    printReservationList();
                    break;
                case "2":
                    while (toMainMenu)
                        // addReservationMenu();
                        break;
                case "3":
                    while (toMainMenu)
                        // editReservationMenu();
                        break;
                case "4":
                    while (toMainMenu)
                        // deleteReservationMenu();
                        break;
                case "5":
                    while (toMainMenu)
                        // generateReservationMenu();
                        break;
                case "6":
                    toContinue = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }
    }

    public String showMainMenu() {
        System.out.println(Utility.printHeaderLines() + "\t\tReservation Menu" + Utility.printHeaderLines());
        System.out.println("1. View Reservations");
        System.out.println("2. Add Reservation");
        System.out.println("3. Edit Reservation");
        System.out.println("4. Delete Reservation");
        System.out.println("5. Generate Daily Report");
        System.out.println("6. Go back");
        System.out.print("\nEnter choice: ");
        return scan.nextLine();
    }

    public void initReservationData() {

        roomList.add(new Room(1, false));
        roomList.add(new Room(2, false));
        roomList.add(new Room(3, false));
        roomList.add(new Room(4, false));
        roomList.add(new Room(5, false));

        timeSlots.add(new TimeSlot(LocalTime.of(12, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(14, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(16, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(18, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(20, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(22, 0), roomList));

        reservationList.add(new Reservation(10001, roomList.getEntry(1), memberList.getEntry(1)));
        reservationList.add(new Reservation(10002, roomList.getEntry(2), memberList.getEntry(2)));

    }

    private void viewRoomStatus() {
        System.out.println("=".repeat(85));
        System.out.print("TimeSlot ");
        for (int r = 1; r <= roomList.getNumOfEntries(); r++) {
            System.out.printf("|    Room %-5s", roomList.getEntry(r).getRoomNo());
        }
        System.out.println("\n" + "=".repeat(85));
        for (int t = 1; t <= timeSlots.getNumOfEntries(); t++) {
            System.out.printf(" %-5s ", timeSlots.getEntry(t).getTime());
            for (int b = 1; b <= roomList.getNumOfEntries(); b++) {
                System.out.printf("  |" + "  %-7s ", roomList.getEntry(b).getRoomStatus());
            }
            System.out.println("");
        }
        System.out.println("=".repeat(85));
    }

    private boolean changeRoomStatus(int slot, int Room, boolean booked) {
        System.out.println("Which room would you like to change?");
        // print TODO: rooms?
        System.out.print("\nEnter choice: ");
        return false;
    }

    private void printReservationList() {
        System.out.println("ReservationID\tRoom\tMember Name");
        for (int i = 1; i <= reservationList.getNumOfEntries(); i++) {
            System.out.print(reservationList.getEntry(i));

            System.out.println("done printing list...");
        }

    }

    @Override
    public String toString() {
        return "{";
    }

}