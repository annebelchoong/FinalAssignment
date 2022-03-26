/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.Annebel.*;
import entity.*;
import utility.Utility;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author annebelchoong
 */
public class Playlist {
    // private int numberOfSongs;
    Scanner input = new Scanner(System.in);
    QueueInterface<Song> songQueue = new PriorityQueue<>();
    public SongModule songData = new SongModule();
    public Song song;

    public Playlist() {
        songData.initSongData();
    }

    public Playlist(SongModule songData, Song song) {
        this.songData = songData;
        this.song = song;
    }

    public void displayPlaylistMenu() {
        System.out.println(" Playlist Menu");
        System.out.println("===================");
        System.out.println("[1] Play Song from queue");
        System.out.println("[2] Skip current song");
        System.out.println("[3] Make song play next");
        System.out.println("[4] Delete Song from queue");
        System.out.println("[5] Back \n\n");
        System.out.print("Enter your choice: ");
    }

    public void playlistMenu() {
        Utility.clearScreen();
        do {
            displayPlaylist();
            displayPlaylistMenu();
            int menuChoice = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println();
            switch (menuChoice) {
                case 1:
                    playSong();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
            }
        } while (true);

    }

    public void promptSelectSong() {
        Utility.clearScreen();
        do {
            playlistHeader();
            songData.displaySongList();
            try {
                System.out.print("\nEnter songID to select song or 0 to return: ");
                int songChoice = input.nextInt();
                input.nextLine();

                if (songChoice == 0) {
                    return;
                } else {
                    Iterator<Song> it = songData.songList.getIterator();
                    while (it.hasNext()) {
                        Song songIt = it.next();
                        if (songChoice == songIt.getSongID()) {
                            // System.out.println("\n\n"+songIt.getSongID() + "\t" + songIt.getSongName() +
                            // "\t" + songIt.getArtist() + "\t" + songIt.getSongURL() + "\n");
                            addSong(new Song(songIt.getSongID(), songIt.getSongName(), songIt.getArtist(),
                                    songIt.getSongURL()));
                            break;
                        } 
                        // else {
                        //     System.out.println("\nInvalid Song ID\n");
                        //     break;
                        // }
                    }

                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } while (true);

    }

    public void displayArtist() {

    }

    public void addSong(Song newSong) {
        // retrive song name from song library
        songQueue.insert(newSong);

        System.out.println("\nSong \"" + newSong.getSongName() + "\" has added to queue\n\n");
    }

    public void displayPlaylist() {
        playlistHeader();
        System.out.println(songQueue);
    }

    public void playSong() {
        System.out.println("Song playing now: ");
        playlistHeader();
        System.out.println(songQueue.removeMin());
    }

    public Song skipSong() {
        // songQueue.removeMin();
        return songQueue.removeMin();

    }

    public void playNext(Song song) {
        songQueue.makeFirst(song);
    }

    public void deleteSong(String song) {

    }

    public void playlistHeader() {
        System.out.printf("%-10s %-30s %-20s %-20s\n", "Song ID", "Song Name", "Artist", "URL");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------");
    }
}
