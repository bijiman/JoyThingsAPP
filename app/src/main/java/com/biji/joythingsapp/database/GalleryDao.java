package com.biji.joythingsapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GalleryDao {
    @Query("SELECT * FROM gallery")
    List<Gallery> getAllGallery();

    @Query("DELETE FROM gallery")
    void deleteAllGallery();
    @Insert
    void insert(Gallery... galleries);
}
