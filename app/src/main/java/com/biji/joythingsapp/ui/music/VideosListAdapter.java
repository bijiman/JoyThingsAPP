package com.biji.joythingsapp.ui.music;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.biji.joythingsapp.R;
import com.biji.joythingsapp.database.Videos;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

// Tanggal Pengerjaan   : 05 - 05 - 2022
// Nama                 : Joyson Sitorus
// NIM                  : 10119218
// Kelas                : IF-6
public class VideosListAdapter extends RecyclerView.Adapter<VideosListAdapter.VideosViewHolder> {
    private List<Videos> videoList;
    private Lifecycle lifecycle;

    public VideosListAdapter(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setVideosList(List<Videos> list) {
        this.videoList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_videos_rows, parent, false);
        lifecycle.addObserver(youTubePlayerView);

        return new VideosViewHolder(youTubePlayerView);
    }

    @Override
    public void onBindViewHolder(@NonNull VideosViewHolder holder, int position) {
        holder.cueVideo(this.videoList.get(position).videoid);
    }

    @Override
    public int getItemCount() {
        return this.videoList.size();
    }

    public class VideosViewHolder extends RecyclerView.ViewHolder{
        private YouTubePlayerView youTubePlayerView;
        private YouTubePlayer youTubePlayer;
        private String currentVideoId;

        VideosViewHolder(YouTubePlayerView playerView) {
            super(playerView);
            youTubePlayerView = playerView;

            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer initializedYouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer;
                    youTubePlayer.cueVideo(currentVideoId, 0);
                }
            });
        }

        void cueVideo(String videoId) {
            currentVideoId = videoId;

            if(youTubePlayer == null)
                return;

            youTubePlayer.cueVideo(videoId, 0);
        }
    }
}

