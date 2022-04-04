/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import modules.*;
import utility.Utility;
import java.util.Scanner;

/**
 *
 * @author annebelchoong
 */
public class KaraokeSession {
    public static Scanner input = new Scanner(System.in);
    public static SessionModule playlist = new SessionModule();
    public static SongModule songLib = new SongModule();
    public static RoomModule room = new RoomModule();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utility.clearScreen();
        initData();
        welcome();
        startSession();

    }

    public static void welcome(){
        System.out.println("----------------------------------------------------");
        System.out.println("|                                                  |");
        System.out.println("|    Welcome to Room " + room.getRoomList().getEntry(1).getRoomNo() + " for your karaoke session!   |");
        System.out.println("|                                                  |");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println();
    }

    public static void initData() {
       playlist.initPlaylistData();
       playlist.initSongData();
       playlist.initPlaylistSongData();
       room.initRoomData();
    }

    public static void startSession() {
        boolean isQuit = false;
        do {
                // homeMenu();
                System.out.println(" M   E   N   U");
                System.out.println("===============");
                System.out.println("[1] Select song");
                System.out.println("[2] Playlist");
                System.out.println("[3] Display song queue");
                System.out.println("[0] Exit Sesion\n\n");
                System.out.print("Enter your choice: ");
                String menuChoice = input.nextLine();
                System.out.println();
                System.out.println();
                switch (menuChoice) {
                    case "1":
                        playlist.promptSelectSong();
                        // Utility.cont();
                        break;
                    case "2":
                        playlist.playlistMenu();
                        break;
                    case "3":
                        Utility.clearScreen();
                        if (playlist.emptySongQueue()){
                            playlist.checkSongQueue();
                            break;
                        } else{
                            playlist.songQueueMenu();
                            break;
                        }
                    case "0": 
                        System.out.println("Ending session....\n\n");
                        isQuit = true;
                        break;
                    default:
                        Utility.clearScreen();
                        System.out.println("Invalid input. Please try again. \n");
                        break;
                }

        } while (!isQuit);

    }

}
