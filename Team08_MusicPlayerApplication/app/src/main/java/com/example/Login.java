package com.example.musicplayer;




import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;
    private List<MusicModel.Music> musicList;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        musicList = new ArrayList<>();
        musicList.add(new MusicModel.Music("As It Was", "Harry Styles", R.drawable.as_it_was, R.raw.as_it_was));
        musicList.add(new MusicModel.Music("About Damn Time", "Lizzo", R.drawable.about_damn_time, R.raw.about_damn_time));
        musicList.add(new MusicModel.Music("Bad Habit", "Steve Lacy", R.drawable.bad_habit, R.raw.bad_habit));
        musicList.add(new MusicModel.Music("Anti-Hero", "Taylor Swift", R.drawable.anti_hero, R.raw.anti_hero));
        musicList.add(new MusicModel.Music("Unholy", "Sam Smith & Kim Petras", R.drawable.unholy, R.raw.unholy));
        musicList.add(new MusicModel.Music("Easy On Me", "Adele", R.drawable.easy_on_me, R.raw.easy_on_me));
        musicList.add(new MusicModel.Music("Heat Waves", "Glass Animals", R.drawable.heat_waves, R.raw.heat_waves));
        musicList.add(new MusicModel.Music("INDUSTRY BABY", "Lil Nas X & Jack Harlow", R.drawable.industry_baby, R.raw.industry_baby));
        musicList.add(new MusicModel.Music("Stay", "The Kid LAROI & Justin Bieber", R.drawable.stay, R.raw.stay));
        musicList.add(new MusicModel.Music("Levitating", "Dua Lipa", R.drawable.levitating, R.raw.levitating));
        musicList.add(new MusicModel.Music("Save Your Tears", "The Weeknd", R.drawable.save_your_tears, R.raw.save_your_tears));
        musicList.add(new MusicModel.Music("Blinding Lights", "The Weeknd", R.drawable.blinding_lights, R.raw.blinding_lights));
        musicAdapter = new MusicAdapter(musicList, Login.this);
        recyclerView.setAdapter(musicAdapter);


       Button signoutButton = findViewById(R.id.signoutBTN);
        Button backButton = findViewById(R.id.backBTN);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });



        // Set click listener for sign-out button
        signoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call signOut() method to sign the user out
                signOutUser();
            }
        });
    }

    // Method to sign the user out
    private void signOutUser() {
        mAuth.signOut(); // Sign out the user

        // Display a toast message indicating successful sign-out
        Toast.makeText(this, "Signed out successfully", Toast.LENGTH_SHORT).show();

        // Optionally, you can navigate to another activity or perform additional actions after sign-out
        // For example:
        Intent intent = new Intent(Login.this, MainActivity.class);
         startActivity(intent);
         finish(); // Finish the current activity
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(Login.this, Playlists.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }


}