package com.biji.joythingsapp.ui.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.biji.joythingsapp.R;
import com.biji.joythingsapp.database.Gallery;

import java.util.List;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {
    private final Context context;
    private List<Gallery> galleryList;

public GalleryListAdapter(Context context){ this.context =context;}
@SuppressLint("NotifyDataSetChanged")
public void setGalleryList(List<Gallery> list){
        this.galleryList = list;
        notifyDataSetChanged();
        }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_gallery_rows,parent,false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.imagename.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.galleryList.get(position).imagename)));
    }

    @Override
    public int getItemCount() {
        return this.galleryList.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder{
        ImageView imagename;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            imagename =itemView.findViewById(R.id.gallery_recycle_image);
        }
    }
    private int getDrawableByName(String name){
        Resources res = context.getResources();
        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
        return resId;
    }
}
