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
import com.biji.joythingsapp.database.Videos;
import com.biji.joythingsapp.databinding.VideosFragmentBinding;
import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.concurrent.Executors;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class VideosFragment extends Fragment {

    private VideosListAdapter videosListAdapter;
    private VideosFragmentBinding binding;
    public static VideosFragment newInstance() {
        return new VideosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = VideosFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        initRecycle();

        loadVideosList();

        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        Handler handler = new Handler(Looper.getMainLooper());

        MaterialButton matButton = binding.clearTable;
        matButton.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() ->
        {
            db.videosDao().deleteAllVideos();
            db.videosDao().insert(Videos.isiVideo());
            handler.post(this::loadVideosList);
        }));

        return root;
    }
    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewVideos;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.VERTICAL,false));

        videosListAdapter = new VideosListAdapter(this.getLifecycle());
        recyclerView.setAdapter((videosListAdapter));
    }

    private void loadVideosList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Videos> videosList = db.videosDao().getAllVideos();
        videosListAdapter.setVideosList(videosList);
    }

}