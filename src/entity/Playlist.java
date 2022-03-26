/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.Annebel.*;
import java.util.Objects;

/**
 *
 * @author annebelchoong
 */
public class Playlist implements Comparable<Playlist>{
    private int playlistID;
    private String playlistName;
    private QueueInterface songList;

    public Playlist() {
    }

    public Playlist(int playlistID, String playlistName) {
        this.playlistID = playlistID;
        this.playlistName = playlistName;
    }

    public Playlist(int playlistID, String playlistName, QueueInterface songList) {
        this.playlistID = playlistID;
        this.playlistName = playlistName;
        this.songList = songList;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public QueueInterface getSongList() {
        return songList;
    }

    public void setSongList(QueueInterface songList) {
        this.songList = songList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.playlistID;
        hash = 83 * hash + Objects.hashCode(this.playlistName);
        hash = 83 * hash + Objects.hashCode(this.songList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Playlist other = (Playlist) obj;
        if (this.playlistID != other.playlistID) {
            return false;
        }
        if (!Objects.equals(this.playlistName, other.playlistName)) {
            return false;
        }
        if (!Objects.equals(this.songList, other.songList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s",playlistID, playlistName); 
    }
   
    @Override
    public int compareTo(Playlist p) {
        return (int)(this.playlistID - p.playlistID);
    }


}
