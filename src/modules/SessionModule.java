/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

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
public class SessionModule {
    Scanner input = new Scanner(System.in);
    QueueInterface<Song> songQueue = new PriorityQueue<>();
    QueueInterface<Song> songList1 = new PriorityQueue<>();
    QueueInterface<Song> songList2 = new PriorityQueue<>();
    QueueInterface<Song> songList3 = new PriorityQueue<>();
    QueueInterface<Playlist> playlist = new PriorityQueue<>();
    public SongModule songData = new SongModule();
    public Playlist songsInPlaylist = new Playlist();
    int numberOfSongs = 0;

    public SessionModule() {

    }

    public void playlistMenu() {
        do {
            Utility.clearScreen();
            System.out.println("Playlist Menu");
            System.out.println("==============");
            System.out.println("[1] Create playlist");
            System.out.println("[2] Select playlist");
            System.out.println("[0] Back\n\n");
            System.out.print("Enter your choice: ");
            String menuChoice = input.nextLine();
            System.out.println();
            System.out.println();
            switch (menuChoice) {
                case "1":
                    Utility.clearScreen();
                    createPlaylist();
                    Utility.cont();
                    break;
                case "2":
                    Utility.clearScreen();
                    displayPlaylists();
                    System.out.print("Enter playlist ID to select playlist: ");
                    String playlistChoice = input.nextLine();
                    promptSelectPlaylist(playlistChoice);
                    break;
                case "0":
                    Utility.clearScreen();
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (true);
    }

    public void playSongMenu(QueueInterface<Song> songList) {
        System.out.println("[1] Play Songs from playlist");
        System.out.println("[0] Back\n\n");
        System.out.print("Enter your choice: ");
        String menuChoice = input.nextLine();
        switch (menuChoice) {
            case "1":
                addSongFromPlaylist(songList);
                Utility.cont();
                break;
            case "0":
                return;

        }
    }

    public void initPlaylistSongData() {
        songList1.insert(
                new Song(1001, "Best Song Ever", "One Direction", "https://www.youtube.com/watch?v=o_v9MY_FMcw"));
        songList1.insert(new Song(1007, "FightSong", "Rachel Platten", "https://www.youtube.com/watch?v=XbxNtPiCBK8"));
        songList2.insert(new Song(1004, "I am What I am", "Gloria Gaynor", "https://youtu.be/MnGouhet2HQ"));
        songList2.insert(
                new Song(1005, "Hall of Fame", "The Script", "http://smarturl.it/TheScriptSpotify?IQid=ScriptHOF"));
        songList2.insert(new Song(1006, "No Time at All", "Martha Raye", "https://youtu.be/jIfAGN6o3Jg"));
        songList3.insert(
                new Song(1001, "Best Song Ever", "One Direction", "https://www.youtube.com/watch?v=o_v9MY_FMcw"));
        songList3.insert(new Song(1002, "This Is Me", "Keala Settle", "https://atlantic.lnk.to/TheGreatestShowman"));
        songList3.insert(new Song(1003, "Our Song", "Taylor Swift", "https://youtu.be/7rwnZdbXtTM"));
        songList3.insert(new Song(1007, "FightSong", "Rachel Platten", "https://www.youtube.com/watch?v=XbxNtPiCBK8"));
    }

    public void initPlaylistData() {
        playlist.insert(new Playlist(1001, "Top Songs", songList1));
        playlist.insert(new Playlist(1002, "Hit Mix", songList2));
        playlist.insert(new Playlist(1003, "Popular Karaoke Songs", songList3));
    }

    public void createPlaylist() {
        System.out.print("Enter playlist name: ");
        String playlistName = input.nextLine();

        int playlistID = playlist.peekMax().getPlaylistID();
        System.out.println();
        System.out.println();

        songData.viewSongLibrary();
        boolean isQuit = false;
        QueueInterface<Song> songList4 = new PriorityQueue<>();
        do {
            System.out.println("Select song ID to add to the new playlist or enter 0 to stop: ");
            String songChoice = input.nextLine();
            if (songChoice.equals("0")) {
                isQuit = true;
                break;
            } else {

                Iterator<Song> it = songData.songList.getIterator();
                while (it.hasNext()) {
                    Song songIt = it.next();
                    if (songChoice.equals(String.valueOf(songIt.getSongID()))) {
                        songList4.insert(songIt);
                        System.out.println("\n--- Song \"" + songIt.getSongName() + "\" has added to playlist!\n");

                        break;
                    } else if (!songChoice.equals(String.valueOf(songIt.getSongID())) && !it.hasNext()) {
                        System.out.println("\n--- Invalid Song ID. Please try again. \n");
                    }
                }
            }
        } while (!isQuit);
        playlist.insert(new Playlist(playlistID + 1, playlistName, songList4));

        System.out.println("\nNew playlist \"" + playlistName + "\" is created!\n");

        playSongMenu(songList4);

    }

    public void displayPlaylists() {
        System.out.println("PLAYLIST");
        System.out.println("=========\n");
        Utility.playlistHeader();
        System.out.print(playlist);
        System.out.print("---------------------------------------------\n\n");
    }

    public void displayPlaylistSong(String songName, QueueInterface<Song> songList4) {
        System.out.println("|   "+songName + " PlayList   |");
        System.out.println("");
        Utility.songlistHeader();
        System.out.print(songList4);
        System.out.print(
                "--------------------------------------------------------------------------------------------------------------\n\n");

    }

    public void addSongFromPlaylist(QueueInterface<Song> songList) {
        Iterator<Song> s = songList.getIterator();
        while (s.hasNext()) {
            Song songs = s.next();
            addSong(songs);
        }
    }

    public void promptSelectPlaylist(String choice) {

        boolean isFound = false;
        QueueInterface<Song> songList = new PriorityQueue<>();
        Iterator<Playlist> it = playlist.getIterator();
        do {
            while (it.hasNext()) {
                Playlist playlistIt = it.next();
                if (choice.equals(String.valueOf(playlistIt.getPlaylistID()))) {
                    System.out.println("\nPlaylist \'" + playlistIt.getPlaylistName() + "\" is selected!\n\n");
                    // System.out.println(playlistIt.getSongList());
                    displayPlaylistSong(playlistIt.getPlaylistName(), playlistIt.getSongList());
                    songList = playlistIt.getSongList();
                    isFound = true;
                    break;

                } else if (!choice.equals(String.valueOf(playlistIt.getPlaylistID())) && !it.hasNext()) {
                    System.out.println("\n---Invalid playlist ID. Please try again. ");
                    isFound = false;
                }
            }
        } while (!isFound);

        playSongMenu(songList);
    }

    // select song from all song available
    public void initSongData() {
        songData.initSongData();
    }

    public void promptSelectSong() {
        Utility.clearScreen();
        songData.viewSongLibrary();
        do {
            System.out.print("\nEnter song ID to select song or 0 to return: ");
            String songChoice = input.nextLine();

            if (songChoice.equals("0")) {
                Utility.clearScreen();
                return;
            } else {
                Iterator<Song> it = songData.songList.getIterator();
                while (it.hasNext()) {
                    Song songIt = it.next();
                    if (songChoice.equals(String.valueOf(songIt.getSongID()))) {
                        addSong(new Song(songIt.getSongID(), songIt.getSongName(), songIt.getArtist(),
                                songIt.getSongURL()));
                        break;
                    } else if (!songChoice.equals(String.valueOf(songIt.getSongID())) && !it.hasNext()) {
                        System.out.println("\n--- Invalid Song ID. Please try again. \n");
                    }
                }
            }
        } while (true);

    }

    // song queue methods
    public void songQueueMenu() {
        do {
            displaySongQueue();
            System.out.println(" Song Queue Menu");
            System.out.println("=================");
            System.out.println("[1] Display current song playing");
            System.out.println("[2] Skip current song");
            System.out.println("[3] Make song play next");
            System.out.println("[4] Delete Song from queue");
            System.out.println("[0] Back \n\n");
            System.out.print("Enter your choice: ");
            int menuChoice = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println();
            switch (menuChoice) {
                case 1:
                    currentSongPlaying();
                    Utility.cont();
                    Utility.clearScreen();
                    break;
                case 2:
                    skipSong();
                    Utility.cont();
                    break;
                case 3:
                    playNext();
                    Utility.cont();
                    break;
                case 4:
                    deleteSong();
                    Utility.cont();
                    break;
                case 0:
                    Utility.clearScreen();
                    return;
            }
        } while (true);

    }

    public boolean emptySongQueue() {
        return songQueue.isEmpty();
    }

    public void checkSongQueue() {
        if (songQueue.isEmpty()) {
            System.out.println("Your playlist is empty. \n\n");
            return;
        } else {
            displaySongQueue();
            playSong();
        }
    }

    private void addSong(Song newSong) {
        // retrive song name from song library
        songQueue.insert(newSong);

        System.out.println("\n--- Song \"" + newSong.getSongName() + "\" has added to song queue!\n");
    }

    public void displaySongQueue() {
        // System.out.println(songQueue);
        System.out.println("SONG QUEUE");
        System.out.println("===========\n");
        Iterator<Song> songQ = songQueue.getIterator();
        numberOfSongs = 0;
        Utility.songlistHeaderNum();
        while (songQ.hasNext()) {
            Song songq = songQ.next();
            numberOfSongs++;
            System.out.printf("%-5d %-10s %-20s %-20s %-20s\n", numberOfSongs, songq.getSongID(), songq.getSongName(),
                    songq.getArtist(), songq.getSongURL());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------\n\n");

    }

    public void playSong() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                songQueue.removeMin();
            }
        }, 1 * 60 * 1000);
    }

    public void currentSongPlaying() {
        if (songQueue.isEmpty()) {
            System.out.println("Your playlist is empty. \n\n");
            return;
        } else {
            System.out.print("Song playing now: ");
            System.out.println(songQueue.removeMin().getSongName());
            displayNextSong();
        }
    }

    public void displayNextSong() {
        if (songQueue.peekMin() == null) {
            System.out.println("The song playing is the last song in the playlist.");
        } else {
            System.out.print("\nNext Song in Queue: ");
            System.out.println(songQueue.peekMin().getSongName());
        }
    }

    public void skipSong() {
        // songQueue.removeMin();
        songQueue.removeMin();
        displaySongQueue();
        currentSongPlaying();
    }

    public void playNext() {
        displaySongQueue();
        boolean isFound = false;
        do {
            System.out.println("Which song would you want to play next? \n");
            System.out.println("Enter the song ID of the song: ");
            String songChoice = input.nextLine();
            Iterator<Song> it = songData.songList.getIterator();
            while (it.hasNext()) {
                Song songIt = it.next();
                if (songChoice.equals(String.valueOf(songIt.getSongID()))) {
                    songQueue.makeFirst(new Song(songIt.getSongID(), songIt.getSongName(), songIt.getArtist(),
                            songIt.getSongURL()));
                    isFound = true;
                    break;
                } else if (!songChoice.equals(String.valueOf(songIt.getSongID())) && !it.hasNext()) {
                    System.out.println("\n--- Invalid Song ID. Please try again. \n");
                }
            }
        } while (!isFound);
    }

    public void deleteSong() {
        displaySongQueue();
        boolean isFound = false;
        do {
            System.out.println("Which song would you want to delete from song Queue? \n");
            System.out.print("Enter the song number of the song: ");
            String songChoice = input.nextLine();

            Iterator<Song> it = songData.songList.getIterator();
            while (it.hasNext()) {
                Song songIt = it.next();

                if (songChoice.equals("1")) {
                    songChoice = "0";
                }

                if (songChoice.equals(String.valueOf(songQueue.getPosition(songIt)))) {
                    songQueue.remove(new Song(songIt.getSongID(), songIt.getSongName(), songIt.getArtist(),
                            songIt.getSongURL()));
                    System.out.println("\n---Song \""+ songIt.getSongName() +"\" has been removed from song queue");
                    isFound = true;
                    break;

                } else if (!songChoice.equals(String.valueOf(songQueue.getPosition(songIt))) && !it.hasNext()) {
                    System.out.println("\n--- Invalid Song ID. Please try again. \n");
                }
            }
        } while (!isFound);
    }

}
