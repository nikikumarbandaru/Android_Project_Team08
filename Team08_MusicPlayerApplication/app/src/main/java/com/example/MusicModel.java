package com.example.musicplayer;

import java.io.Serializable;

public class MusicModel  {
    public static class Music implements Serializable{
        private String title;
        private String artist;
        private int image;
        private int song;
        private int Id;
        public Music(String title, String artist,int image,int song) {
            this.title = title;
            this.artist = artist;
            this.image=image;
            this.song=song;
            this.Id=Id;
        }
        public String getTitle() {
            return title;
        }
        public String getArtist() {
            return artist;
        }
        public int getImage() {
            return image;
        }
        public int getSong() {
            return song;
        }
        public int getId() {return Id;}
    }
}

