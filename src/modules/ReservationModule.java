package modules;

import java.time.LocalTime;
import java.util.Scanner;

import adt.YongYang.SortedArrayList;
import adt.YongYang.SortedListInterface;
import entity.Member;
import entity.Reservation;
import entity.Room;
import entity.TimeSlot;
import utility.Utility;

/**
 *
 * @author yongyang
 */
public class ReservationModule {
    public static Scanner scan = new Scanner(System.in);
    private static boolean exit;

    // public SortedListInterface<Room> roomList = new SortedArrayList<>();
    // public SortedListInterface<TimeSlot> timeSlots = new SortedArrayList<>();
    public SortedListInterface<Room> roomList = RoomModule.getRoomList();
    public SortedListInterface<TimeSlot> timeSlots = RoomModule.getTimeSlots();
    public SortedListInterface<Reservation> reservationList = new SortedArrayList<>();

    public static adt.Guna.SortedListInterface<Member> memberList = MemberModule.getMemberList();

    public ReservationModule() {
        // this.reserveList = reserveList;
        // this.roomList = roomList;
        // this.timeSlots = timeSlots;
    }

    // public ReservationModule(SortedListInterface<Room> roomList,
    // SortedListInterface<TimeSlot> timeSlots,
    // SortedListInterface<Reservation> reservationList) {
    // this.roomList = roomList;
    // this.timeSlots = timeSlots;
    // this.reservationList = reservationList;
    // }

    public void reservationMenu() {
        do {
            Utility.clearScreen();
            showMainMenu();
            switch (scan.nextLine()) {
                case "1":
                    printReservations();
                    Utility.cont();
                    break;
                case "2":
                    // addReservationMenu();
                    break;
                case "3":
                    // editReservationMenu();
                    break;
                case "4":
                    // deleteReservationMenu();
                    break;
                case "5":
                    // generateReservationMenu();
                    break;
                case "0":
                    exit = true;
                    Utility.clearScreen();
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        } while (!exit);
    }

    public void showMainMenu() {
        System.out.println(Utility.printHeaderLines() + "\t\tReservation Menu" + Utility.printHeaderLines());
        System.out.println("[1] View Reservations");
        System.out.println("[2] Add Reservation");
        System.out.println("[3] Edit Reservation");
        System.out.println("[4] Delete Reservation");
        System.out.println("[5] Generate Daily Report");
        System.out.println("[0] Go back");
        System.out.print("\nEnter choice: ");
    }

    public void initReservationData() {
        reservationList.add(new Reservation(10001, roomList.getEntry(1), memberList.getEntry(1)));
        reservationList.add(new Reservation(10002, roomList.getEntry(2), memberList.getEntry(2)));

    }

    // private void viewRoomStatus() {
    // System.out.println("=".repeat(85));
    // System.out.print("TimeSlot ");
    // for (int r = 1; r <= roomList.getNumOfEntries(); r++) {
    // System.out.printf("| Room %-5s", roomList.getEntry(r).getRoomNo());
    // }
    // System.out.println("\n" + "=".repeat(85));
    // for (int t = 1; t <= timeSlots.getNumOfEntries(); t++) {
    // System.out.printf(" %-5s ", timeSlots.getEntry(t).getTime());
    // for (int b = 1; b <= roomList.getNumOfEntries(); b++) {
    // System.out.printf(" |" + " %-7s ", roomList.getEntry(b).getRoomStatus());
    // }
    // System.out.println("");
    // }
    // System.out.println("=".repeat(85));
    // }

    private void printReservations() {
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
        // for (int i = 1; i <= reservationList.getNumOfEntries(); i++) {
        // System.out.print(reservationList.getEntry(i));
        // }
    }

    @Override
    public String toString() {
        return "{";
    }

}