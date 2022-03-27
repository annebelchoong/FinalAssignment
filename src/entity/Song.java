/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Chia Hui Yun
 */
public class Song implements Comparable<Song>{
    //public static int NextID = 1001;
    protected int songID;
    protected String songName;
    protected String artist;
    protected String songURL;

    public Song() {
        
    }
//    public Song(int songID) {
//        this.songID = songID;
//    }

    public Song(int songID, String songName, String artist, String songURL) {
        this.songID = songID;    //NextID++;
        this.songName = songName;
        this.artist = artist;
        this.songURL = songURL;
    }

//    public static int getNextID() {
//        return NextID;
//    }
//
//    public static void setNextID(int NextID) {
//        Song.NextID = NextID;
//    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }
    
    @Override
    public int compareTo(Song s) {
        return (int)(this.songID - s.songID);
    }
    
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-20s %-20s", songID, songName, artist, songURL);
    }
}
