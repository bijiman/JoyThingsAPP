package com.biji.joythingsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.biji.joythingsapp.R;

import java.util.Objects;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, ScreenSlidePagerActivity.class);
            startActivity(intent);
            finish();
        }, 2000);

    }

}
