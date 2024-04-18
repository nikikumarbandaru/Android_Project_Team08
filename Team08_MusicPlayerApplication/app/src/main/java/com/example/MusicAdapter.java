package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.List;
public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private List<MusicModel.Music> musicList;
    private Context context;
    public MusicAdapter(List<MusicModel.Music> musicList, Context context) {
        this.musicList = musicList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_layout, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MusicModel.Music music = musicList.get(position);
        holder.titleTV.setText(music.getTitle());
        holder.artistTV.setText(music.getArtist());
        holder.ratingTV.setText("Rating: 5");
        holder.playBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayMusic.class);
                intent.putExtra("SONG_TITLE", music.getTitle());
                intent.putExtra("SONG_ARTIST", music.getArtist());
                intent.putExtra("SONG_music", (Serializable) musicList);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return musicList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, artistTV, ratingTV;
        Button playBTN;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            artistTV = itemView.findViewById(R.id.artistTV);
            ratingTV = itemView.findViewById(R.id.ratingTV);
            playBTN = itemView.findViewById(R.id.playBTN);
        }
    }
}
