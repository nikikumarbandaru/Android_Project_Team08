package com.example.team08_musicplayerapplication;

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
        musicList.add(new MusicModel.Music("Blinding Lights", "The Weeknd", R.drawable.blinding_lights,R.raw.toosadtodance));
        musicList.add(new MusicModel.Music("Shape of You", "Ed Sheeran", R.drawable.shape_of_you, R.raw.lifegoeson));
        musicList.add(new MusicModel.Music("Someone Like You", "Adele", R.drawable.someone_like_you, R.raw.astronaut));
        musicList.add(new MusicModel.Music("Levitating", "Dua Lipa", R.drawable.levitating, R.raw.equalsign));
        musicList.add(new MusicModel.Music("Thinking Out Loud", "Ed Sheeran", R.drawable.thinking_out_loud, R.raw.amygdala));
        musicList.add(new MusicModel.Music("Watermelon Sugar", "Harry Styles", R.drawable.watermelon_sugar, R.raw.promise));
        musicList.add(new MusicModel.Music("Lose Yourself", "Eminem", R.drawable.lose_yourself, R.raw.sweetnight));
        musicList.add(new MusicModel.Music("Bad Guy", "Billie Eilish", R.drawable.bad_guy, R.raw.akumanoko));
        musicList.add(new MusicModel.Music("Firework", "Katy Perry", R.drawable.firework, R.raw.fastcar));
        musicList.add(new MusicModel.Music("Rolling in the Deep", "Adele", R.drawable.rolling_in_the_deep, R.raw.alltoowell));
        musicList.add(new MusicModel.Music("Don't Start Now", "Dua Lipa", R.drawable.dont_start_now, R.raw.wildflower));
        musicList.add(new MusicModel.Music("Uptown Funk", "Mark Ronson ft. Bruno Mars", R.drawable.uptown_funk, R.raw.shallow));
        musicAdapter = new MusicAdapter(musicList, MainActivity.this);
        recyclerView.setAdapter(musicAdapter);
    }
}
