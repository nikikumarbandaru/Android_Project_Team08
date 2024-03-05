package com.example.team08_musicplayerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SongsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
    }

    public void sendOnClick(View view)
    {
        Intent intent = new Intent(this, PlaySong.class);


        startActivity(intent);
    }
}