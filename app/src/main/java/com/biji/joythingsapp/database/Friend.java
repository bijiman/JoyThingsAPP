package com.biji.joythingsapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
@Entity
public class Friend {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="friend_name")
    public String friendName;

    @ColumnInfo(name ="code_name")
    public String nickname;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Friend(String friendName,String nickname,String imagename){
        this.friendName = friendName;
        this.nickname = nickname;
        this.imagename = imagename;
    }

    public static Friend[] isiData(){
        return new Friend[]{
                new Friend("Denden Triana","Den","denden"),
                new Friend("Tiyo Haryo S","Nyolo","nyolo"),
                new Friend("Najib Raffi Irdhana","Njib","najib"),
                new Friend("Tri Tafriyadi","TERI","tri"),
                new Friend("Rheza Pramana","Reja","reja"),
        };
    }


}
