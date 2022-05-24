package com.biji.joythingsapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
@Entity
public class Videos {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="videoid")
    public String videoid;

    public Videos(String videoid){
        this.videoid = videoid;
    }

    public static Videos[] isiVideo(){
        return new Videos[]{
                new Videos("apPsjYs6HmE"),
                new Videos("GlOQnsVOa2o"),
                new Videos("SA2o6Nac9Yg"),
                new Videos("od_PmtmMDV0"),
        };
    }
}
