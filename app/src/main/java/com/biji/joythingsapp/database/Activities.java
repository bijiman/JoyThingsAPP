package com.biji.joythingsapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
@Entity
public class Activities {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="kegiatan")
    public String kegiatan;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Activities(String kegiatan,String imagename){
        this.kegiatan = kegiatan;
        this.imagename = imagename;
    }

    public static Activities[] isiAktifitas(){
        return new Activities[]{
                new Activities("Gaming","gaming1"),
                new Activities("Coding","coding"),
                new Activities("Searching Something New","bruh"),
                new Activities("Editing","editing1"),
        };
    }
}
