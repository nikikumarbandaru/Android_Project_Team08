package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;
    private List<MusicModel.Music> musicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        musicList = new ArrayList<>();
        musicList.add(new MusicModel.Music("Too Sad to Dance", "Jung Kook",R.drawable.toosadtodance,R.raw.toosadtodance));
        musicList.add(new MusicModel.Music("Life goes on", "BTS",R.drawable.lifegoeson,R.raw.lifegoeson));
        musicList.add(new MusicModel.Music("The Astronaut", "Jin",R.drawable.astronaut,R.raw.astronaut));
        musicList.add(new MusicModel.Music("Equal Sign", "J-Hope",R.drawable.equalsign,R.raw.equalsign));
        musicList.add(new MusicModel.Music("Amygdala", "AgustD",R.drawable.amygdala,R.raw.amygdala));
        musicList.add(new MusicModel.Music("Promise", "Jimin",R.drawable.promise,R.raw.promise));
        musicList.add(new MusicModel.Music("Sweet Night", "V",R.drawable.sweetnight,R.raw.sweetnight));
        musicList.add(new MusicModel.Music("Akuma No ko", "Ai Higuchi",R.drawable.akumanoko,R.raw.akumanoko));
        musicList.add(new MusicModel.Music("Fast Car", "Luke Combs",R.drawable.fastcar,R.raw.fastcar));
        musicList.add(new MusicModel.Music("All too well", "Taylor Swift",R.drawable.alltoowell,R.raw.alltoowell));
        musicList.add(new MusicModel.Music("Wild Flower", "RM",R.drawable.wildflower,R.raw.wildflower));
        musicList.add(new MusicModel.Music("Shallow", "Lady Gaga & Bradley Cooper",R.drawable.shallow,R.raw.shallow));
        musicAdapter = new MusicAdapter(musicList, MainActivity.this);
        recyclerView.setAdapter(musicAdapter);
    }
}
