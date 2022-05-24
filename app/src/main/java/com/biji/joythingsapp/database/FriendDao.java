package com.biji.joythingsapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FriendDao {
    @Query("SELECT * FROM friend")
    List<Friend> getAllFriends();

    @Query("DELETE FROM friend")
    void deleteAllFriends();
    @Insert
    void insert(Friend... friends);
}
