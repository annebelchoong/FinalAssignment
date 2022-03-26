/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author annebelchoong
 */
public class Utility {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // cpmmand
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("Cannot clear screen");
        }
    }

    public static void songlistHeaderNum() {
        System.out.printf("%-5s %-10s %-20s %-20s %-20s\n", "No.", "Song ID", "Song Name", "Artist", "URL");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------");
    }

    public static void songlistHeader() {
        System.out.printf("%-10s %-20s %-20s %-20s\n", "Song ID", "Song Name", "Artist", "URL");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------");
    }

    public static void cont() {
        System.out.println("\n\nPress Enter to continue");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
