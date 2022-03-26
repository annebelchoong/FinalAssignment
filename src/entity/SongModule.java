/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.*;
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
        // SortedListInterface<Song> songList = new SortedLinkedList<>();
        // int songID;
        // String songName;
        // String artist;
        // String songURL;
        Iterator<Song> s = songList.getIterator();

        System.out.println("Enter song ID:");
        songID = scanner.nextInt();
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

            if (!(isValidName(songName))) {
                System.out.println("The song name is invalid");
                System.out.println("Please enter new song Name: ");
                songName = scanner.nextLine();
                scanner.nextLine();
            }
        }
        System.out.println("Enter artist:");
        artist = scanner.nextLine();
        while (s.hasNext()) {
            Song song = s.next();

            if (!(isValidName(artist))) {
                System.out.println("The artist is invalid");
                System.out.println("Please enter new artist: ");
                artist = scanner.nextLine();
                scanner.nextLine();
            }
        }
        System.out.println("Enter song url:");
        songURL = scanner.nextLine();
        while (s.hasNext()) {
            Song song = s.next();

            if (!(isValidUrl(songURL))) {
                System.out.println("The song URL is invalid");
                System.out.println("Please enter new song URL: ");
                songURL = scanner.nextLine();
                scanner.nextLine();
            }
        }
        Date date;

        songList.add(new Song(songID, songName, artist, songURL));

        // if((isValidName(songName) && isValidArtist(artist) && isValidUrl(songUrl)){
        //
        // System.out.printf("Added the song '%1$s' to the playlist.\n", songName);
        // } else {
        // System.out.printf("Error! Song not added. Format of either song id=%1$s or
        // song name=%2$s or song url=%3$s is not correct.\n", songID, songName,
        // songUrl);
        // }

        viewSongLibrary();
    }

    private void deleteSong() {
        System.out.println("===================");
        System.out.println("||  DELETE SONG  ||");
        System.out.println("===================\n\n");
        viewSongLibrary();
        System.out.print("\nEnter song number to delete: ");
        int songID = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        // songList.remove(getSong(songNum));
        // System.out.println(getSong(songNum).getSongName()+ " is removed from database.");
        Iterator<Song> s = songList.getIterator();
        // System.out.println("Song ID\t\tSong Name\t\t\tArtist\t\t\t\tSong URL\t");
        // // System.out.println("No\t" + "Song ID\t\t" + "Song Name\t\t" + "Artist\t\t\t"
        // // + "URL\t");
        // System.out.println(
        //         "---------------------------------------------------------------------------------------------------------------------------------------------");

        // LinkedList<Song> modifiedSongList = new LinkedList<>();
        Utility.songlistHeader();
        while (s.hasNext()) {
            Song song = s.next();

            if (song.getSongID() == songID) {
                songList.remove(song);
                System.out.printf("%-10s %-20s %-20s %-20s\n", song.getSongID(), song.getSongName(),song.getArtist(), song.getSongURL());
            }
        }
        // System.out.println("\nThe song is not in the database");
    }

    private void findSongByName() {
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

    private void viewSongLibrary() {
  
        System.out.println("SONGLIST ");
        System.out.println("=========");
        Iterator<Song> s = songList.getIterator();
        int num = 0;
        Utility.songlistHeaderNum();
        // System.out.println("Song ID\t\tSong Name\t\t\tArtist\t\t\t\tSong URL\t");
        // //System.out.println("No\t" + "Song ID\t\t" + "Song Name\t\t" +
        // "Artist\t\t\t" + "URL\t");
        // System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        while (s.hasNext()) {
            Song song = s.next();
            num++;
            System.out.printf("%-5d %-10s %-20s %-20s %-20s\n", num, song.getSongID(), song.getSongName(), song.getArtist(), song.getSongURL());
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
        songList.add(new Song(1005, "Hall of Fame", "The Script", "http://smarturl.it/TheScriptSpotify?IQid=ScriptHOF"));
        songList.add(new Song(1006, "No Time at All", "Martha Raye", "https://youtu.be/jIfAGN6o3Jg"));
        songList.add(new Song(1007, "FightSong", "Rachel Platten", "https://www.youtube.com/watch?v=XbxNtPiCBK8"));
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("Playlist Operations");
        System.out.println("=====================");
        System.out.println("[1] Display playlist");
        System.out.println("[2] Delete a song from playlist");
        System.out.println("[3] Find a song by name");
        System.out.println("[4] Add a song to the playlist");
        System.out.println("[5] Return to Main Menu");
        // System.out.println("[6] Get song");
        System.out.println();
    }

    public void songLibraryMenu() {
        scanner = new Scanner(System.in);
        boolean exit = false;
        // Song song = new Song();

        while (!exit) {
            Utility.clearScreen();
            displayMenu();
            System.out.print("Enter menu option: ");
            String input = scanner.nextLine();
            System.out.println();
            System.out.println();
            switch (input.trim()) {
                case "1":
                    viewSongLibrary();
                    Utility.cont();
                    break;
                    case "2":
                    Utility.clearScreen();
                    deleteSong();
                    Utility.cont();
                    break;
                case "3":
                    findSongByName();
                    break;
                case "4":
                    addSong();
                    break;
                case "5":
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
        }
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
