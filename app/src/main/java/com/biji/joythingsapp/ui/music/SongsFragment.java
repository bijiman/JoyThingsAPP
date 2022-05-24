package com.biji.joythingsapp.ui.music;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.biji.joythingsapp.database.AppDatabase;
import com.biji.joythingsapp.database.Song;
import com.biji.joythingsapp.databinding.SongsFragmentBinding;
import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.concurrent.Executors;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class SongsFragment extends Fragment {

    private SongsListAdapter songsListAdapter;
    private SongsFragmentBinding binding;
    public static SongsFragment newInstance() {
        return new SongsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SongsFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        initRecycle();

        loadSongsList();

        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        Handler handler = new Handler(Looper.getMainLooper());

        MaterialButton matButton = binding.clearTable;
        matButton.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() ->
        {
            db.songDao().deleteAllSongs();
            db.songDao().insert(Song.isiLagu());
            handler.post(this::loadSongsList);
        }));

        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewSongs;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.VERTICAL,false));

        songsListAdapter = new SongsListAdapter(binding.getRoot().getContext());
        recyclerView.setAdapter((songsListAdapter));
    }

    private void loadSongsList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Song> songList = db.songDao().getAllSongs();
        songsListAdapter.setSongsList(songList);
    }

}