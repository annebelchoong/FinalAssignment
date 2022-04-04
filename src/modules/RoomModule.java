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

    public SortedListInterface<Room> roomList = new SortedArrayList<>();
    public SortedListInterface<TimeSlot> timeSlots = new SortedArrayList<>();

    public SortedListInterface<Room> getRoomList() {
        return roomList;
    }

    public SortedListInterface<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void roomMenu() {
        Utility.clearScreen();
        do {
            exit = false;
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
                    Utility.clearScreen();
                    break;
                case "2":
                    changeRoomStatusMenu();
                    break;
                case "0":
                    Utility.clearScreen();
                    return;
                default:
                    Utility.clearScreen();
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        } while (!exit);
    }

    public void viewRoomStatus() {
        System.out.println("=".repeat(85));
        System.out.print("TimeSlot ");
        for (int r = 1; r <= roomList.getNumOfEntries(); r++) {
            System.out.printf("|    Room %-5s", roomList.getEntry(r).getRoomNo());
        }
        System.out.println("\n" + "=".repeat(85));
        for (int t = 1; t <= timeSlots.getNumOfEntries(); t++) {
            System.out.printf(" %-5s ", timeSlots.getEntry(t).getTime());
            for (int b = 1; b <= roomList.getNumOfEntries(); b++) {
                // System.out.printf(" |" + " %-7s ",
                // roomList.getEntry(b).getRoomStatusinString());
                System.out.printf("  |" + "  %-7s ",
                        timeSlots.getEntry(b).getRoomList().getEntry(b).getRoomStatusinString());
            }
            System.out.println("");
        }
        System.out.println("=".repeat(85));
    }

    public void changeRoomStatusMenu() {
        int roomNo = -1;
        TimeSlot timeSlot = null;
        RoomStatus roomStatus = null;
        boolean goGetTimeSlot = false, goGetStatus = false, changeDone = false;
        do {
            Utility.clearScreen();
            System.out.println(printRoomHeader());
            viewRoomStatus();
            System.out.println("Which room would you like to change? [1] to [5]");
            System.out.print("\nChoose Room: ");
            String room = scan.nextLine();
            switch (room) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    roomNo = Integer.parseInt(room);
                    goGetTimeSlot = true;
                    Utility.clearScreen();
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        } while (!goGetTimeSlot);
        do {
            Utility.clearScreen();
            System.out.println(printRoomHeader());
            selectTimeSlot(roomNo);
            System.out.println("Which timeslot would you like to change for Room " + roomNo + "? [1] to [6]");
            System.out.print("\nChoose Timeslot: ");
            String time = scan.nextLine();
            switch (time) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    timeSlot = timeSlots.getEntry(Integer.parseInt(time));
                    goGetStatus = true;
                    Utility.clearScreen();
                    break;
                case "null":
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        } while (!goGetStatus);
        do {
            Utility.clearScreen();
            System.out.println(printRoomHeader());
            System.out.println("[1] set to Booked");
            System.out.println("[2] set to Available");
            System.out.println("[3] set to Service");
            System.out.println("\nWhich status would you like to change for Room " + roomNo + " at "
                    + timeSlot + "? [1] to [3]");
            System.out.print("\nEnter choice: ");
            String status = scan.nextLine();
            switch (status) {
                case "1":
                    status = "BOOKED";
                    break;
                case "2":
                    status = "AVAILABLE";
                    break;
                case "3":
                    status = "SERVICE";
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
            if (status == "BOOKED" || status == "AVAILABLE" || status == "SERVICE") {
                roomStatus = RoomStatus.valueOf(status.toUpperCase());
                changeDone = true;
            }
        } while (!changeDone);
        if (changeSpecificRoomWithTime(roomNo, timeSlot, roomStatus)) {
            System.out.println(
                    "Room " + roomNo + " for " + timeSlot + " has been changed to " + roomStatus);
            Utility.cont();
            Utility.clearScreen();
        } else {
            System.out.println("Something wong");
        }

    }

    public void selectTimeSlot(int roomNo) {
        System.out.println("=".repeat(30));
        System.out.print("   TimeSlot ");
        for (int r = 1; r <= roomNo; r++) {
            if (r == roomNo) {
                System.out.printf("|    Room %-5s", roomList.getEntry(r).getRoomNo());
            }
        }
        System.out.println("\n" + "=".repeat(30));
        for (int t = 1; t <= timeSlots.getNumOfEntries(); t++) {
            System.out.print("[" + t + "]");
            System.out.printf(" %-5s ", timeSlots.getEntry(t).getTime());
            for (int b = 1; b <= roomNo; b++) {
                if (b == roomNo) {
                    System.out.printf("  |" + "  %-7s ", roomList.getEntry(b).getRoomStatusinString());
                }
            }
            System.out.println("");
        }
        System.out.println("=".repeat(30));
    }

    private boolean changeSpecificRoomWithTime(int roomNo, TimeSlot timeSlot, RoomStatus roomStatus) {
        // roomList.getEntry(roomNo).setRoomStatus(roomStatus);
        int t = timeSlots.getPosition(timeSlot);
        timeSlots.getEntry(roomNo).getRoomList().getEntry(t).setRoomStatus(roomStatus);
        return true;
    }

    public void initRoomData() {
        roomList.clear();
        for (int i = 1; i <= 5; i++) {
            roomList.add(new Room(i));
        }

        timeSlots.clear();
        timeSlots.add(new TimeSlot(LocalTime.of(12, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(14, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(16, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(18, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(20, 0), roomList));
        timeSlots.add(new TimeSlot(LocalTime.of(22, 0), roomList));
    }

    private String printRoomHeader() {
        return Utility.printHeaderLines() +
                "\t\tRoom Menu" +
                Utility.printHeaderLines();
    }
}
