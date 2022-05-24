package com.biji.joythingsapp.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
@Database(entities = {Friend.class,Activities.class,Gallery.class,Song.class,Videos.class}, version = 5)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FriendDao friendDao();
    public abstract ActivitiesDao activitiesDao();
    public abstract GalleryDao galleryDao();
    public abstract SongDao songDao();
    public abstract VideosDao videosDao();

        private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "joythings")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadExecutor().execute(() -> getDbInstance(context).activitiesDao().insert(Activities.isiAktifitas()));
                            Executors.newSingleThreadExecutor().execute(() -> getDbInstance(context).friendDao().insert(Friend.isiData()));
                            Executors.newSingleThreadExecutor().execute(() -> getDbInstance(context).galleryDao().insert(Gallery.isiFoto()));
                            Executors.newSingleThreadExecutor().execute(() -> getDbInstance(context).songDao().insert(Song.isiLagu()));
                            Executors.newSingleThreadExecutor().execute(() -> getDbInstance(context).videosDao().insert(Videos.isiVideo()));
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}
