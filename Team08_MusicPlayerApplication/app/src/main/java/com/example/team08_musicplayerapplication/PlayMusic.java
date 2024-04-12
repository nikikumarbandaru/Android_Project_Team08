package com.example.team08_musicplayerapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class PlayMusic extends AppCompatActivity {
    private ImageView songImageIV;
    private ImageButton pausePlayIB, nextIB, prevIB;
    private Button backBTN;
    private MediaPlayer mediaPlayer;
    private TextView songNameTV, NameTV, ArtistTV;
    private List<MusicModel.Music> musicList;
    private int songIndex;
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
        musicList = (List<MusicModel.Music>) getIntent().getSerializableExtra("SONG_music");
        String songTitle = getIntent().getStringExtra("SONG_TITLE");
        songIndex = -1;
        for (int i = 0; i < musicList.size(); i++) {
            if (musicList.get(i).getTitle().equals(songTitle)) {
                songIndex = i;
                break;
            }
        }
        Log.d("currentSongIndex",String.valueOf(songIndex));
        displaySong(songIndex);
        pausePlayIB.setTag("play");
        pausePlayIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("play".equals(pausePlayIB.getTag())) {
                    Toast.makeText(PlayMusic.this, "Playing song", Toast.LENGTH_SHORT).show();
                    pausePlayIB.setImageResource(R.drawable.pause);
                    NameTV.setText("");
                    mediaPlayer.start();
                    ArtistTV.setText("");
                    updateImage(songIndex);
                    pausePlayIB.setTag("pause");
                } else {
                    Toast.makeText(PlayMusic.this, "Song paused", Toast.LENGTH_SHORT).show();
                    pausePlayIB.setImageResource(R.drawable.play);
                    mediaPlayer.pause();
                    displaySong(songIndex);
                    pausePlayIB.setTag("play");
                }
            }
        });
        nextIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (songIndex == musicList.size() - 1) {
                    MusicModel.Music song = musicList.get(musicList.size() - 1);
                    songNameTV.setText(song.getTitle());
                    NameTV.setText("");
                    ArtistTV.setText("");
                    songImageIV.setImageResource(song.getImage());
                    pausePlayIB.setImageResource(R.drawable.pause);
                    pausePlayIB.setTag("pause");
                    Toast.makeText(PlayMusic.this, "Playing last song", Toast.LENGTH_SHORT).show();
                    playCurrentSong(song.getSong());
                } else {
                    songIndex = (songIndex + 1) % musicList.size();
                    MusicModel.Music song = musicList.get(songIndex);
                    songNameTV.setText(song.getTitle());
                    NameTV.setText("");
                    ArtistTV.setText("");
                    songImageIV.setImageResource(song.getImage());
                    pausePlayIB.setImageResource(R.drawable.pause);
                    pausePlayIB.setTag("pause");
                    Toast.makeText(PlayMusic.this, "Playing next song", Toast.LENGTH_SHORT).show();
                    playCurrentSong(song.getSong());
                }
            }
        });
        prevIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (songIndex == 0) {
                    MusicModel.Music song = musicList.get(0);
                    songNameTV.setText(song.getTitle());
                    NameTV.setText("");
                    ArtistTV.setText("");
                    songImageIV.setImageResource(song.getImage());
                    pausePlayIB.setImageResource(R.drawable.pause);
                    pausePlayIB.setTag("pause");
                    Toast.makeText(PlayMusic.this, "Playing first song", Toast.LENGTH_SHORT).show();
                    playCurrentSong(song.getSong());
                } else {
                    songIndex--;
                    MusicModel.Music song = musicList.get(songIndex);
                    songNameTV.setText(song.getTitle());
                    NameTV.setText("");
                    ArtistTV.setText("");
                    songImageIV.setImageResource(song.getImage());
                    pausePlayIB.setImageResource(R.drawable.pause);
                    pausePlayIB.setTag("pause");
                    Toast.makeText(PlayMusic.this, "Playing previous song", Toast.LENGTH_SHORT).show();
                    playCurrentSong(song.getSong());
                }
            }
        });
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void displaySong(int index) {
        MusicModel.Music song = musicList.get(index);
        songNameTV.setText(song.getTitle());
        NameTV.setText(song.getTitle());
        ArtistTV.setText(song.getArtist());
        songImageIV.setImageResource(song.getImage());
    }
    private void updateImage(int index) {
        MusicModel.Music song = musicList.get(index);
        int image = song.getImage();
        songImageIV.setImageResource(image);
    }
    private void playCurrentSong(int songResource) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
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
