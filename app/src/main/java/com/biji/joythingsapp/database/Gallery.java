package com.biji.joythingsapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
@Entity
public class Gallery {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Gallery(String imagename){
        this.imagename = imagename;
    }
    public static Gallery[] isiFoto(){
        return new Gallery[]{
                new Gallery("denden"),
                new Gallery("najib"),
                new Gallery("nyolo"),
                new Gallery("tri"),
                new Gallery("reja"),
        };
    }
}
