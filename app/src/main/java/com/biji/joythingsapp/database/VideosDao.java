package com.biji.joythingsapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VideosDao {
    @Query("SELECT * FROM videos")
    List<Videos> getAllVideos();

    @Query("DELETE FROM videos")
    void deleteAllVideos();
    @Insert
    void insert(Videos... Videos);
}
