/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.*;
import modules.PlaylistModule;
import modules.SongModule;
import utility.Utility;

import java.util.Scanner;

/**
 *
 * @author annebelchoong
 */
public class KaraokeSession {
    public static Scanner input = new Scanner(System.in);
    public static PlaylistModule playlist = new PlaylistModule();
    public static SongModule songLib = new SongModule();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utility.clearScreen();
        welcome();
        initData();
        startSession();

        // QueueInterface<Song> songQueue = new PriorityQueue<>();
        // //Song test = new Song(1111, "Party Rock Anthem", "LMAO",
        // "https://www.youtube.com/watch?v=0WM9Amg7F5s");
        //
        // songQueue.insert(new Song(1111, "Party Rock Anthem", "LMAO",
        // "https://www.youtube.com/watch?v=0WM9Amg7F5s"));
        // songQueue.insert(new Song(2222, "On the Ground", "LMAO",
        // "https://www.youtube.com/watch?v=0WM9Amg7F5s"));
        // songQueue.insert(new Song(3333, "Heaven", "LMAO",
        // "https://www.youtube.com/watch?v=0WM9Amg7F5s"));
        // songQueue.insert(new Song(4444, "Numb", "LMAO",
        // "https://www.youtube.com/watch?v=0WM9Amg7F5s"));
        // songQueue.insert(new Song(5555, "Unknown", "Zara Larrson",
        // "https://www.youtube.com/watch?v=0WM9Amg7F5s"));
        // //songQueue.insert(new Song("Unknown"));
        // System.out.println(songQueue);
        // songQueue.makeFirst(new Song("On the Ground"));
        // System.out.println(songQueue);

    }

    public static void welcome(){
        System.out.println("--------------------------------------------");
        System.out.println("|                                           |");
        System.out.println("|    Welcome to " + "for your karaoke session!   |");
        System.out.println("|                                           |");
        System.out.println("--------------------------------------------");

        System.out.println();
        System.out.println();
    }

    // public static void homeMenu() {

    //     System.out.println(" M   E   N   U");
    //     System.out.println("===============");
    //     System.out.println("[1] Select song");
    //     System.out.println("[2] Select playlist");
    //     System.out.println("[3] Display song queue");
    //     System.out.println("[0] Exit Sesion\n\n");
    //     System.out.print("Enter your choice: ");
    // }

    public static void initData() {
       playlist.initPlaylistData();
       playlist.initSongData();
       playlist.initPlaylistSongData();
    }

    public static void startSession() {
        boolean isQuit = false;
        do {
                // Utility.clearScreen();
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
