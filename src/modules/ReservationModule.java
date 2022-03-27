package modules;

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

    // public SortedListInterface<Reservation> getReservationList() {
    // return reservationList;
    // }

    public void reservationMenu() {
        do {
            Utility.clearScreen();
            System.out.println(printReservationHeader());
            showMainMenu();
            switch (scan.nextLine()) {
                case "1":
                    Utility.clearScreen();
                    System.out.println(reservationList);
                    Utility.cont();
                    break;
                case "2":
                    Utility.clearScreen();
                    addReservationMenu();
                    Utility.cont();
                    break;
                case "3":
                    // editReservationMenu();
                    break;
                case "4":
                    // cancelReservationMenu();
                    break;
                // case "5":
                // // generateReservationMenu();
                // break;
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

    private void addReservationMenu() {
        int roomNo = -1;
        int timeSlot = 0;
        do {
            Utility.clearScreen();
            System.out.println(printReservationHeader());
            RoomModule.viewRoomStatus();
            System.out.println("Which room would you like to use? [1] to [5]");
            System.out.print("\nEnter choice: ");
            String room = scan.nextLine();
            switch (room) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    roomNo = Integer.parseInt(room);
                    // break;
                    // case "0":
                    exit = true;
                    Utility.clearScreen();
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        } while (!exit);
        do {
            Utility.clearScreen();
            System.out.println(printReservationHeader());
            RoomModule.selectTimeSlot(roomNo);
            System.out.println("[1] 12:00\n[2] 14:00\n[3] 16:00\n[4] 18:00\n[5] 2:000\n[6] 22:00");
            System.out.println("Which time? [1] to [6]");
            System.out.print("\nEnter choice: ");
            String time = scan.nextLine();
            switch (time) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    timeSlot = Integer.parseInt(time);
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
        do {
            Utility.clearScreen();
            System.out.println(printReservationHeader());
            System.out.print("Enter Member ID: ");
            String memberID = scan.nextLine();
            Member member = MemberModule.getMember(Integer.parseInt(memberID));
            if (member != null) {
                int rID = 10000 + reservationList.getNumOfEntries() + 1;
                reservationList.add(new Reservation(rID,
                        roomList.getEntry(roomNo), timeSlots.getEntry(timeSlot), member));
                System.out.println("Success");
                System.out.println(reservationList);
            }
        } while (!exit);
    }

    public void showMainMenu() {
        System.out.println();
        System.out.println("[1] View Reservations");
        System.out.println("[2] Add Reservation");
        System.out.println("[3] Edit Reservation");
        System.out.println("[4] Delete Reservation");
        System.out.println("[0] Go back");
        System.out.print("\nEnter choice: ");
    }

    public void initReservationData() {
        reservationList
                .add(new Reservation(10001, roomList.getEntry(1), timeSlots.getEntry(1), memberList.getEntry(4)));
        reservationList
                .add(new Reservation(10002, roomList.getEntry(2), timeSlots.getEntry(4), memberList.getEntry(3)));
        reservationList
                .add(new Reservation(10003, roomList.getEntry(3), timeSlots.getEntry(4), memberList.getEntry(2)));
        reservationList
                .add(new Reservation(10004, roomList.getEntry(4), timeSlots.getEntry(2), memberList.getEntry(1)));
        reservationList
                .add(new Reservation(10005, roomList.getEntry(5), timeSlots.getEntry(5), memberList.getEntry(5)));
        reservationList
                .add(new Reservation(10006, roomList.getEntry(5), timeSlots.getEntry(3), memberList.getEntry(6)));
    }

    private String printReservationHeader() {
        return Utility.printHeaderLines() + "\t\tReservation Menu" + Utility.printHeaderLines();
    };

}