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
import java.util.Timer;
import java.util.TimerTask;

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
        System.out.println("[1] Display current song playing");
        System.out.println("[2] Skip current song");
        System.out.println("[3] Make song play next");
        System.out.println("[4] Delete Song from queue");
        System.out.println("[0] Back \n\n");
        System.out.print("Enter your choice: ");
    }

    public void playlistMenu() {
        Utility.clearScreen();
        displayPlaylist();
        do {
            displayPlaylistMenu();
            int menuChoice = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println();
            switch (menuChoice) {
                case 1:
                    currentSongPlaying();
                    Utility.cont();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    return;
            }
        } while (true);

    }

    public boolean emptyPlaylist(){
        return songQueue.isEmpty();
    }

    public void checkPlaylist(){
        if (songQueue.isEmpty()){
            System.out.println("Your playlist is empty. \n\n");
            return;
        } else{
            displayPlaylist();
            playSong();
        }
    }

    public void promptSelectSong() {
        Utility.clearScreen();
        songData.viewSongLibrary();
        do {
            try {
                System.out.print("\nEnter songID to select song or 0 to return: ");
                String songChoice = input.nextLine();

                if (songChoice.equals("0")) {
                    Utility.clearScreen();
                    return;
                } else {
                    Iterator<Song> it = songData.songList.getIterator();
                    while (it.hasNext()) {
                        Song songIt = it.next();
                        if (songChoice.equals(String.valueOf(songIt.songID))) {
                            addSong(new Song(songIt.getSongID(), songIt.getSongName(), songIt.getArtist(),
                                    songIt.getSongURL()));
                            break;
                        } else if (!songChoice.equals(String.valueOf(songIt.songID)) && !it.hasNext()){
                            System.out.println("\n--- Invalid Song ID. Please try again. \n");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                // break;
            }
        } while (true);

    }

    public void displayArtist() {

    }

    private void addSong(Song newSong) {
        // retrive song name from song library
        songQueue.insert(newSong);

        System.out.println("\n--- Song \"" + newSong.getSongName() + "\" has added to song queue!\n");
    }

    public void displayPlaylist() {
        Utility.songlistHeader();
        System.out.println(songQueue);
    }
    
    public void playSong(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                songQueue.removeMin();
            }
        }, (1/2)*60*1000);
    }
    public void currentSongPlaying() {
        System.out.print("Song playing now: ");
        System.out.println(songQueue.removeMin().getSongName());
        displayNextSong();
    }

    public void displayNextSong(){

        System.out.print("\nNext Song in Queue: ");
        System.out.println(songQueue.peekMin().getSongName());
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

}
