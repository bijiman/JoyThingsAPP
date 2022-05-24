package com.biji.joythingsapp.ui.music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.biji.joythingsapp.MainActivity;
import com.biji.joythingsapp.R;
import com.biji.joythingsapp.databinding.FragmentMusicBinding;
import com.google.android.material.tabs.TabLayout;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class MusicFragment extends Fragment {
    private FragmentMusicBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMusicBinding.inflate(inflater, container, false);
        ((MainActivity)getActivity()).updateStatusBarColor("#0D2818");
        View root = binding.getRoot();
        TextView textTitle = getActivity().findViewById(R.id.appbar_title);
        textTitle.setText(R.string.title_music);

        TabLayout tabLayout = binding.musicLayout;
        selectedTab(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectedTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return root;


    }

    private void selectedTab(int position) {
        Fragment tabFragment;
        if(position == 1){
            tabFragment = new VideosFragment();
        } else {
            tabFragment = new SongsFragment();
        }

        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.music_linear, tabFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}