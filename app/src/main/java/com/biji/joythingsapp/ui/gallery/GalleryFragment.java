package com.biji.joythingsapp.ui.gallery;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.biji.joythingsapp.MainActivity;
import com.biji.joythingsapp.R;
import com.biji.joythingsapp.database.AppDatabase;
import com.biji.joythingsapp.database.Gallery;
import com.biji.joythingsapp.databinding.FragmentGalleryBinding;
import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.concurrent.Executors;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class GalleryFragment extends Fragment {

    private GalleryListAdapter galleryListAdapter;
    private FragmentGalleryBinding binding;
    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        ((MainActivity)getActivity()).updateStatusBarColor("#04471C");
        View root = binding.getRoot();

        initRecycle();

        loadGalleryList();

        TextView textTitle = getActivity().findViewById(R.id.appbar_title);
        textTitle.setText(R.string.title_gallery);

        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        Handler handler = new Handler(Looper.getMainLooper());

        MaterialButton matButton = binding.clearTable;
        matButton.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() ->
        {
            db.galleryDao().deleteAllGallery();
            db.galleryDao().insert(Gallery.isiFoto());
            handler.post(this::loadGalleryList);
        }));
        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewGallery;
        recyclerView.setLayoutManager(new GridLayoutManager(binding.getRoot().getContext(),
                2));

        galleryListAdapter = new GalleryListAdapter(binding.getRoot().getContext());
        recyclerView.setAdapter((galleryListAdapter));
    }

    private void loadGalleryList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Gallery> galleryList = db.galleryDao().getAllGallery();
        galleryListAdapter.setGalleryList(galleryList);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}