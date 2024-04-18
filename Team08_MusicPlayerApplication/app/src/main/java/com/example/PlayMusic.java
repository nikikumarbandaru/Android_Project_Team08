package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class PlayMusic extends AppCompatActivity {
    private ImageView songImageIV;
    private ImageButton pausePlayIB, nextIB, prevIB;
    private Button backBTN;
    private MediaPlayer mediaPlayer;
    private TextView songNameTV, NameTV, ArtistTV, lyricsTV;
    private List<MusicModel.Music> musicList;
    private int songIndex;
    private int songId;
    private static final String TAG = "LyricsManager";
    private LyricsManager lyricsManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        mediaPlayer = new MediaPlayer();
        songImageIV = findViewById(R.id.SongImageIV);
        pausePlayIB = findViewById(R.id.PausePlayIB);
        nextIB = findViewById(R.id.nextIB);
        prevIB = findViewById(R.id.prevIB);
        backBTN = findViewById(R.id.backBTN);
        songNameTV = findViewById(R.id.SongNameTV);
        NameTV = findViewById(R.id.NameTV);
        ArtistTV = findViewById(R.id.ArtistTV);
        lyricsTV = findViewById(R.id.lyricsTV);
        lyricsManager = new LyricsManager(this);

        musicList = (List<MusicModel.Music>) getIntent().getSerializableExtra("SONG_music");
        String songTitle = getIntent().getStringExtra("SONG_TITLE");
        songIndex = -1;
        songId=1;
        for (int i = 0; i < musicList.size(); i++) {
            if (musicList.get(i).getTitle().equals(songTitle)) {
                songIndex = i;

                break;
            }
            songId++;
        }
        Log.d("currentSongIndex", String.valueOf(songIndex));
        Log.d("currentLyricindex",String.valueOf(songId));
        displaySong(songIndex,songId);

        if (savedInstanceState == null) {
            playCurrentSong(musicList.get(songIndex).getSong());
        }

        pausePlayIB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayPause(); // Toggle play/pause state
            }
        });

        // Set OnClickListener for the album image
        songImageIV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayPause(); // Toggle play/pause state
            }
        });

        // Set OnClickListener for the next button
        nextIB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                playNextSong();
            }
        });

        // Set OnClickListener for the previous button
        prevIB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                playPreviousSong();
            }
        });

        // Set OnClickListener for the back button
        backBTN.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    // Method to toggle play/pause state
    private void togglePlayPause() {
        if ("play".equals(pausePlayIB.getTag())) {
            // Start playing the song
            playCurrentSong(musicList.get(songIndex).getSong());
            // Update UI to show that the song is playing
            pausePlayIB.setImageResource(R.drawable.pause);
            pausePlayIB.setTag("pause");
        } else {
            // Pause the song
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                // Update UI to show that the song is paused
                pausePlayIB.setImageResource(R.drawable.play);
                pausePlayIB.setTag("play");
            }
        }
    }




    // Method to play the next song
    private void playNextSong() {
        songIndex = (songIndex + 1) % musicList.size();
        songId=songIndex+1;
        displaySong(songIndex,songId);
        playCurrentSong(musicList.get(songIndex).getSong());
    }

    // Method to play the previous song
    private void playPreviousSong() {
        songIndex = (songIndex - 1 + musicList.size()) % musicList.size();
        songId=songIndex+1;
        displaySong(songIndex,songId);
        playCurrentSong(musicList.get(songIndex).getSong());
    }

    // Method to display song information
    private void displaySong(int index, int index2) {
        MusicModel.Music song = musicList.get(index);
        songNameTV.setText(song.getTitle());
        NameTV.setText(song.getTitle());
        ArtistTV.setText(song.getArtist());
        songImageIV.setImageResource(song.getImage());
        String lyrics = lyricsManager.getLyricsForSong(songId);
        lyricsTV = findViewById(R.id.lyricsTV);
        lyricsTV.setText(lyrics);

    }

    // Method to play the current song
    private void playCurrentSong(int songResource) {
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Release any existing MediaPlayer instance
        }
        mediaPlayer = MediaPlayer.create(this, songResource);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        });
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


}
