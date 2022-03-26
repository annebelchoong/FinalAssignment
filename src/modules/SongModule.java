/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import adt.*;
import adt.HuiYun.SortedLinkedList;
import adt.HuiYun.SortedListInterface;
import entity.Song;
import utility.Utility;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
//import static entity.SongModule.SongPlaylist; //??
import java.net.URL;
import java.util.*;

/**
 *
 * @author Chia Hui Yun
 */
public class SongModule extends Song {
    SortedListInterface<Song> songList = new SortedLinkedList<>();
    private Date dateAdded;
    Scanner scanner = new Scanner(System.in);
    int numberOfSongs = 0;

    public SongModule() {

    }

    // public SongLibrary(Date dateAdded, int songID) {
    // super(songID);
    // this.dateAdded = dateAdded;
    // }

    public SongModule(Date dateAdded, int songID, String songName, String artist, String songURL) {
        super(songID, songName, artist, songURL);
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "\nSong Library" + super.toString() + "\nDate Added: " + dateAdded;
    }

    private void addSong() {
        Iterator<Song> s = songList.getIterator();

        System.out.print("Enter song ID: ");
        songID = scanner.nextInt();
        // scanner.nextLine();
        String ID = Integer.toString(songID);
        if (ID.length() != 4) {
            System.out.println("You have not entered a 4-digit pin");
            System.out.print("Please enter new song ID: ");
            songID = scanner.nextInt();
            scanner.nextLine();
        } else {
            boolean allDigits = true;
            for (int i = 0; i < 4; i++) {
                if (!Character.isDigit(ID.charAt(i))) {
                    allDigits = false;
                    break;
                }
            }
            if (allDigits) {
                // pin is valid
            } else {
                System.out.println("Error use numbers not alphabets or characters");
            }
        }
        scanner.nextLine();

        while (s.hasNext()) {
            Song song = s.next();

            if (song.getSongID() == songID) {
                System.out.println("The song ID have exist in the database");
                System.out.println("Please enter new song ID: ");
                songID = scanner.nextInt();
                scanner.nextLine();
            }
        }

        System.out.println("Enter song name:");
        songName = scanner.nextLine();

        while (s.hasNext()) {
            Song song = s.next();

            if (!isValidName(songName)) {
                System.out.println("The song name is invalid");
                System.out.println("Please enter new song Name: ");
                songName = scanner.nextLine();
                // scanner.nextLine();
            }
        }
        // scanner.nextLine();

        System.out.println("Enter artist:");
        artist = scanner.nextLine();

        while (s.hasNext()) {
            Song song = s.next();

            if (!isValidArtist(artist)) {
                System.out.println("The artist is invalid");
                System.out.println("Please enter new artist: ");
                artist = scanner.nextLine();
                // scanner.nextLine();
            }
        }
        // scanner.nextLine();

        System.out.println("Enter song url:");
        songURL = scanner.nextLine();
        if (isValidUrl(songURL)) {
            // input is valid
        } else {
            System.out.println("The song URL is invalid\n");
            System.out.println("Please enter new song URL: ");
            songURL = scanner.nextLine();
            // scanner.nextLine();
        }

        while (s.hasNext()) {
            Song song = s.next();
        }
        // scanner.nextLine();
        Date date;

        songList.add(new Song(songID, songName, artist, songURL));

        viewSongLibrary();
    }

    private void deleteSong() {
        System.out.println("===================");
        System.out.println("||  DELETE SONG  ||");
        System.out.println("===================\n\n");
        viewSongLibrary();

        System.out.print("\nEnter song ID for delete:");
        int songID = scanner.nextInt();
        System.out.println();

        String ID = Integer.toString(songID);
        if (ID.length() != 4) {
            System.out.println("You have not entered a 4-digit song ID");
            System.out.print("Please enter song ID: ");
            songID = scanner.nextInt();
            scanner.nextLine();
        } else {
            boolean allDigits = true;
            for (int i = 0; i < 4; i++) {
                if (!Character.isDigit(ID.charAt(i))) {
                    allDigits = false;
                    break;
                }
            }
            if (allDigits) {
                // pin is valid
            } else {
                System.out.println("Error use numbers not alphabets or characters");
            }
        }
        scanner.nextLine();

        Iterator<Song> s = songList.getIterator();
        Utility.songlistHeader();
        // System.out.println("No\t" + "Song ID\t\t" + "Song Name\t\t" + "Artist\t\t\t"
        // + "URL\t");

        while (s.hasNext()) {
            Song song = s.next();

            if (song.getSongID() == songID) {
                songList.remove(song);

                System.out.printf("%-10s %-20s %-20s %-20s\n", song.getSongID(), song.getSongName(), song.getArtist(),
                        song.getSongURL());
                scanner.nextLine();
            }

        }
        // System.out.println("\nThe song is not in the database");
    }

    private void findSongByName() {
        // viewSongLibrary();
        System.out.println("\nEnter the name of the song:");
        String songName = scanner.nextLine();

        Iterator<Song> s = songList.getIterator();

        LinkedList<Song> modifiedSongList = new LinkedList<>();
        while (s.hasNext()) {
            Song song = s.next();

            if (song.getSongName().equals(songName)) {
                songList.contains(song);

                System.out.println("The song ID is " + song.getSongID());
            }
        }
        // System.out.println("The song is not in the database");
    }

    public void viewSongLibrary() {

        System.out.println("SONGLIST ");
        System.out.println("=========");
        Iterator<Song> s = songList.getIterator();
        numberOfSongs = 0;
        Utility.songlistHeaderNum();
        // System.out.println("Song ID\t\tSong Name\t\t\tArtist\t\t\t\tSong URL\t");
        // //System.out.println("No\t" + "Song ID\t\t" + "Song Name\t\t" +
        // "Artist\t\t\t" + "URL\t");
        // System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        while (s.hasNext()) {
            Song song = s.next();
            numberOfSongs++;
            System.out.printf("%-5d %-10s %-20s %-20s %-20s\n", numberOfSongs, song.getSongID(), song.getSongName(),
                    song.getArtist(), song.getSongURL());
        }
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------");
    }

    public Song getSong(int givenPosition) {
        // System.out.println();
        // Utility.songlistHeader();
        return songList.getEntry(givenPosition);
    }

    public void initSongData() {
        songList.add(new Song(1001, "Best Song Ever", "One Direction", "https://www.youtube.com/watch?v=o_v9MY_FMcw"));
        songList.add(new Song(1002, "This Is Me", "Keala Settle", "https://atlantic.lnk.to/TheGreatestShowman"));
        songList.add(new Song(1003, "Our Song", "Taylor Swift", "https://youtu.be/7rwnZdbXtTM"));
        songList.add(new Song(1004, "I am What I am", "Gloria Gaynor", "https://youtu.be/MnGouhet2HQ"));
        songList.add(
                new Song(1005, "Hall of Fame", "The Script", "http://smarturl.it/TheScriptSpotify?IQid=ScriptHOF"));
        songList.add(new Song(1006, "No Time at All", "Martha Raye", "https://youtu.be/jIfAGN6o3Jg"));
        songList.add(new Song(1007, "FightSong", "Rachel Platten", "https://www.youtube.com/watch?v=XbxNtPiCBK8"));
    }

    private void displayMenu() {
        // System.out.println();
        System.out.println("Song Module Menu");
        System.out.println("================");
        System.out.println("[1] Display song list");
        System.out.println("[2] Add new song");
        System.out.println("[3] Delete a song");
        System.out.println("[4] Find a song by name");
        System.out.println("[0] Return to Main Menu");
        // System.out.println("[6] Get song");
        System.out.println();
    }

    public void songLibraryMenu() {
        scanner = new Scanner(System.in);
        boolean exit = false;
        // Song song = new Song();

        do {
            Utility.clearScreen();
            displayMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            System.out.println();
            System.out.println();
            switch (input.trim()) {
                case "1":
                    viewSongLibrary();
                    Utility.cont();
                    break;
                case "2":
                    addSong();
                    Utility.cont();
                    break;
                case "3":
                    Utility.clearScreen();
                    deleteSong();
                    Utility.cont();
                    break;
                    case "4":
                    Utility.clearScreen();
                    findSongByName();
                    Utility.cont();
                    break;
                case "0":
                    exit = true;
                    Utility.clearScreen();
                    break;
                // case "6":
                // Utility.clearScreen();
                // viewSongLibrary();
                // System.out.print("\nEnter number: ");
                // System.out.println(getSong(scanner.nextInt())+ "\n");
                // Utility.cont();
                // break;
            }
        } while (!exit);
    }

    // public static void SongPlaylist() {
    // SongModule program = new SongModule();
    // program.songLibraryMenu();
    // }

    private boolean isValidName(String songName) {
        return (songName != null && !"".equals(songName.trim()));
    }

    private boolean isValidArtist(String artist) {
        return (artist != null && !"".equals(artist.trim()));
    }

    private boolean isValidUrl(String songURL) {
        try {
            new URL(songURL).toURI();
            return true;
        } catch (URISyntaxException exception) {
            return false;
        } catch (MalformedURLException exception) {
            return false;
        }
    }

}
