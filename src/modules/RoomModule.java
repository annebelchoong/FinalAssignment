package modules;

import java.time.LocalTime;
import java.util.Scanner;

import adt.YongYang.SortedArrayList;
import adt.YongYang.SortedListInterface;
import entity.Room;
import entity.TimeSlot;
import utility.Utility;

public class RoomModule {
    public static Scanner scan = new Scanner(System.in);
    private static boolean exit;

    public static SortedListInterface<Room> roomList = new SortedArrayList<>();
    public static SortedListInterface<TimeSlot> timeSlots = new SortedArrayList<>();

    public RoomModule() {
    }

    public RoomModule(SortedListInterface<Room> roomList, SortedListInterface<TimeSlot> timeSlots) {
        // roomList = roomList;
        // timeSlots = timeSlots;
    }

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

    @Override
    public String toString() {
        return "{" +
                " roomList='" + getRoomList() + "'" +
                ", timeSlots='" + getTimeSlots() + "'" +
                "}";
    }

    public void roomMenu() {
        do {
            Utility.clearScreen();
            System.out.println(Utility.printHeaderLines() + "\t\tRoom Menu" + Utility.printHeaderLines());
            System.out.println("[1] View Rooms");
            System.out.println("[2] Change Room Status");
            System.out.println("[0] Go back");
            System.out.print("\nEnter choice: ");
            switch (scan.nextLine()) {
                case "1":
                    viewRoomStatus();
                    Utility.cont();
                    break;
                case "2":
                    changeRoomStatusMenu();
                    break;
                // case "3":
                //     // addReservationMenu();
                //     break;
                // case "4":
                //     // deleteReservationMenu();
                //     break;
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

    private boolean changeRoomStatusMenu() {
        for (int b = 1; b <= roomList.getNumOfEntries(); b++) {
            System.out.printf("%-7s ", roomList.getEntry(b).getRoomStatus());
        }
        System.out.println("Which room would you like to change?");
        System.out.print("\nEnter choice: ");

        return false;
    }

}
