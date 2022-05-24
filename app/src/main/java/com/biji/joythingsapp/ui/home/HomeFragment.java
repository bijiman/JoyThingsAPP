package com.biji.joythingsapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.biji.joythingsapp.MainActivity;
import com.biji.joythingsapp.R;
import com.biji.joythingsapp.databinding.FragmentHomeBinding;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        ((MainActivity)getActivity()).updateStatusBarColor("#168E48");
        View root = binding.getRoot();
        TextView textTitle = getActivity().findViewById(R.id.appbar_title);
        textTitle.setText(R.string.title_home);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }
}