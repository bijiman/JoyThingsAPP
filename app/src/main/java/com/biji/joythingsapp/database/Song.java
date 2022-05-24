package com.biji.joythingsapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
@Entity
public class Song {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="imagename")
    public String imagename;

    @ColumnInfo(name ="titlesong")
    public String titlesong;

    @ColumnInfo(name ="artistname")
    public String artistname;

    public Song(String imagename,String titlesong,String artistname){
        this.imagename = imagename;
        this.titlesong = titlesong;
        this.artistname = artistname;
    }

    public static Song[] isiLagu(){
        return new Song[]{
                new Song("nirvana","Something In The Way","Nirvana"),
                new Song("rollingstones","Paint It, Black","The Rolling Stones"),
                new Song("olivertree","I'm Gone","Oliver Tree"),
                new Song("joji","R.I.P.","Trippie Redd"),
                new Song("refused","New Noise","Refused"),
                new Song("lowroar","\"I'll Keep Coming\"","Low Roar"),
        };
    }
}
