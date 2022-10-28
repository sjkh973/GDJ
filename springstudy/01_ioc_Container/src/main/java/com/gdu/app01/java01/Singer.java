package com.gdu.app01.java01;

public class Singer {

   // field
   private String name;
   private Song song;
   
   // constructor
   public Singer() {

   }

   public Singer(String name, Song song) {
      super();
      this.name = name;
      this.song = song;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Song getSong() {
      return song;
   }

   public void setSong(Song song) {
      this.song = song;
   }
   
   
   
   
}