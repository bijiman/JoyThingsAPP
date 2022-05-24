package com.biji.joythingsapp.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.biji.joythingsapp.R;
import com.biji.joythingsapp.databinding.FindmeFragmentBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class FindmeFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private FindmeFragmentBinding binding;

    public static FindmeFragment newInstance() {
        return new FindmeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FindmeFragmentBinding.inflate(inflater, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return binding.getRoot();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        List<Marker> markers = new ArrayList<>();
        markers.add(googleMap.addMarker(new MarkerOptions()
        .position(new LatLng(-6.900685071228499, 107.6457770577908))
        .title("Rumah Joy")));
        for(Marker m: markers)
            {
                builder.include(m.getPosition());
            }
            LatLngBounds bounds = builder.build();

            int padding = 0;
            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds,512,200,padding);

            googleMap.moveCamera(cu);
//        LatLng delichip = new LatLng(-6.831668,107.614997);
//        googleMap.addMarker(new MarkerOptions().position(delichip).title("delichip"));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(delichip));
    }

}