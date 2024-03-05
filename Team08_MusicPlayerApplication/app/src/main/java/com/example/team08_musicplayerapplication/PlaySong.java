package com.example.team08_musicplayerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlaySong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
    }
    public void addFav(View view)
    {
        Intent intent = new Intent(this, FavSongsList.class);


        startActivity(intent);
    }
    public void reportIssue(View view)
    {
        Intent intent = new Intent(this, ReportIssue.class);


        startActivity(intent);
    }
}