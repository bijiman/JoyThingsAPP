package com.biji.joythingsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.biji.joythingsapp.R;

import java.util.Objects;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class RoutingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        checkFirstRun();
    }
    private void checkFirstRun() {

        final String PREFS_NAME = "MyPrefsFile";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;

        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {

            startActivity();

        } else if (savedVersionCode == DOESNT_EXIST) {

            setContentView(R.layout.activity_splash);
            Objects.requireNonNull(getSupportActionBar()).hide();

            new Handler().postDelayed(() -> {
                Intent intent = new Intent(this, ScreenSlidePagerActivity.class);
                startActivity(intent);
                finish();
            }, 2000);

        } else if (currentVersionCode > savedVersionCode) {

            setContentView(R.layout.activity_splash);
            Objects.requireNonNull(getSupportActionBar()).hide();

            new Handler().postDelayed(() -> {
                Intent intent = new Intent(this, ScreenSlidePagerActivity.class);
                startActivity(intent);
                finish();
            }, 2000);
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();
    }

    private void startActivity() {
        setContentView(R.layout.activity_splash);
        //Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}