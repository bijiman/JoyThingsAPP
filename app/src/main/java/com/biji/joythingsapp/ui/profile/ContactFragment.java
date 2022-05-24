package com.biji.joythingsapp.ui.profile;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.biji.joythingsapp.databinding.ContactFragmentBinding;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class ContactFragment extends Fragment {
    private ContactFragmentBinding binding;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ContactFragmentBinding .inflate(inflater, container, false);
        TextView waText = binding.wajoy;
        waText.setOnClickListener(view -> {
            String url = "https://api.whatsapp.com/send?phone=+62895376652407";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        TextView emailText = binding.emailjoy;
        emailText.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","joyss234@gmail.com", null));
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });
        TextView igText = binding.igjoy;
        igText.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://instagram.com/_u/joyss.ss");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://instagram.com/quicklybubble158")));
            }
        });
        return binding.getRoot();
    }


}