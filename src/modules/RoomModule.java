package modules;

import java.time.LocalTime;
import java.util.Scanner;

import adt.YongYang.SortedArrayList;
import adt.YongYang.SortedListInterface;
import entity.Room;
import entity.Room.RoomStatus;
import entity.TimeSlot;
import utility.Utility;

/**
 *
 * @author yongyangboon
 */
public class RoomModule {
    public static Scanner scan = new Scanner(System.in);
    private static boolean exit;

    public static SortedListInterface<Room> roomList = new SortedArrayList<>();
    public static SortedListInterface<TimeSlot> timeSlots = new SortedArrayList<>();

    public static SortedListInterface<Room> getRoomList() {
        return roomList;
    }

    public static SortedListInterface<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void initRoomData() {
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
    }

    public void roomMenu() {
        do {
            Utility.clearScreen();
            System.out.println(printRoomHeader());
            System.out.println("[1] View Rooms");
            System.out.println("[2] Change Room Status");
            System.out.println("[0] Return to Main Menu");
            System.out.print("\nEnter choice: ");
            switch (scan.nextLine()) {
                case "1":
                    Utility.clearScreen();
                    System.out.println(printRoomHeader());
                    viewRoomStatus();
                    Utility.cont();
                    break;
                case "2":
                    changeRoomStatusMenu();
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

    public static void viewRoomStatus() {
        System.out.println("=".repeat(85));
        System.out.print("TimeSlot ");
        for (int r = 1; r <= roomList.getNumOfEntries(); r++) {
            System.out.printf("|    Room %-5s", roomList.getEntry(r).getRoomNo());
        }
        System.out.println("\n" + "=".repeat(85));
        for (int t = 1; t <= timeSlots.getNumOfEntries(); t++) {
            System.out.printf(" %-5s ", timeSlots.getEntry(t).getTime());
            for (int b = 1; b <= roomList.getNumOfEntries(); b++) {
                System.out.printf("  |" + "  %-7s ", roomList.getEntry(b).getRoomStatusinString());
            }
            System.out.println("");
        }
        System.out.println("=".repeat(85));
    }

    public void changeRoomStatusMenu() {
        int roomNo = -1;
        int timeSlot = 0;
        RoomStatus roomStatus = null;
        do {
            Utility.clearScreen();
            System.out.println(printRoomHeader());
            viewRoomStatus();
            System.out.println("Which room would you like to change? [1] to [5]");
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
            System.out.println(printRoomHeader());
            selectTimeSlot(roomNo);
            System.out.println("[1] 12:00\n[2] 14:00\n[3] 16:00\n[4] 18:00\n[5] 2:000\n[6] 22:00");
            System.out.println("Which time would you like to change? [1] to [6]");
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
            System.out.println(printRoomHeader());
            System.out.println("[1] set to Booked");
            System.out.println("[2] set to Available");
            System.out.println("[3] set to Service");
            System.out.println("Which status would you like to change for this room at this time? [1] to [3]");
            System.out.print("\nEnter choice: ");
            String status = scan.nextLine();
            switch (status) {
                case "1":
                    status = "BOOKED";
                    roomStatus = RoomStatus.valueOf(status.toUpperCase());
                    break;
                case "2":
                    status = "AVAILABLE";
                    roomStatus = RoomStatus.valueOf(status.toUpperCase());
                    break;
                case "3":
                    status = "SERVICE";
                    roomStatus = RoomStatus.valueOf(status.toUpperCase());
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
        if (changeSpecificRoomWithTime(roomNo, timeSlot, roomStatus)) {
            System.out.println(
                    "Room " + roomNo + " for " + timeSlot + " has been changed to " + roomStatus);
            Utility.cont();
        } else {
            System.out.println("Something wong");
        }

    }

    public static void selectTimeSlot(int roomNo) {
        System.out.println("=".repeat(23));
        System.out.print("TimeSlot ");
        for (int r = 1; r <= roomNo; r++) {
            if (r == roomNo) {
                System.out.printf("|    Room %-5s", roomList.getEntry(r).getRoomNo());
            }
        }
        System.out.println("\n" + "=".repeat(23));
        for (int t = 1; t <= timeSlots.getNumOfEntries(); t++) {
            System.out.printf(" %-5s ", timeSlots.getEntry(t).getTime());
            for (int b = 1; b <= roomNo; b++) {
                if (b == roomNo) {
                    System.out.printf("  |" + "  %-7s ", roomList.getEntry(b).getRoomStatusinString());
                }
            }
            System.out.println("");
        }
        System.out.println("=".repeat(23));
    }

    private boolean changeSpecificRoomWithTime(int roomNo, int timeSlot, RoomStatus roomStatus) {
        roomList.getEntry(roomNo).setRoomStatus(roomStatus);
        return true;
    }

    private String printRoomHeader() {
        return Utility.printHeaderLines() + "\t\tRoom Menu" + Utility.printHeaderLines();
    }
}
