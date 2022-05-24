package com.biji.joythingsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.biji.joythingsapp.R;
import com.google.android.material.button.MaterialButton;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class ScreenSlidePageFragment extends Fragment {

    private ViewGroup vGroup;
    private MaterialButton mButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       vGroup = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

    mButton = vGroup.findViewById(R.id.starthere);
    mButton.setOnClickListener(view -> {
        startActivity(new Intent(getActivity(), MainActivity.class));
    });

    return vGroup;
    }
}