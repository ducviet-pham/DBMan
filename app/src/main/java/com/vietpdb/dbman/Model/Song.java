package com.vietpdb.dbman.Model;

public class Song {
    int songId;
    String songName;
    String songSinger;
    float songTime;

    public Song() {
    }

    public Song(int songId, String songName, String songSinger, float songTime) {
        this.songId = songId;
        this.songName = songName;
        this.songSinger = songSinger;
        this.songTime = songTime;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongSinger() {
        return songSinger;
    }

    public void setSongSinger(String songSinger) {
        this.songSinger = songSinger;
    }

    public float getSongTime() {
        return songTime;
    }

    public void setSongTime(float songTime) {
        this.songTime = songTime;
    }



}
