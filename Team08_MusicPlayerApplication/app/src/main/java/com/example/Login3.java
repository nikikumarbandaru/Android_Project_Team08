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

public class Login3 extends AppCompatActivity {
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
        musicList.add(new MusicModel.Music("Raataan Lambiyan", "Jubin Nautiyal & Asees Kaur", R.drawable.raataan_lambiyan, R.raw.raataan_lambiyan));
        musicList.add(new MusicModel.Music("Kesariya", "Arijit Singh", R.drawable.kesariya, R.raw.kesariya));
        musicList.add(new MusicModel.Music("Ranjha", "B Praak & Jasleen Royal", R.drawable.ranjha, R.raw.ranjha));
        musicList.add(new MusicModel.Music("Pasoori", "Ali Sethi & Shae Gill", R.drawable.pasoori, R.raw.pasoori));
        musicList.add(new MusicModel.Music("Srivalli", "Javed Ali", R.drawable.srivalli, R.raw.srivalli));
        musicList.add(new MusicModel.Music("Ghalat Fehmi", "Asim Azhar & Zenab Fatimah Sultan", R.drawable.ghalat_fehmi, R.raw.ghalat_fehmi));
        musicList.add(new MusicModel.Music("Tum Hi Ho", "Arijit Singh", R.drawable.tum_hi_ho, R.raw.tum_hi_ho));
        musicList.add(new MusicModel.Music("Apna Time Aayega", "Ranveer Singh", R.drawable.apna_time_aayega, R.raw.apna_time_aayega));
        musicList.add(new MusicModel.Music("Burj Khalifa", "Shashi & Dj Khushi", R.drawable.burj_khalifa, R.raw.burj_khalifa));
        musicList.add(new MusicModel.Music("Bekhayali", "Sachet Tandon", R.drawable.bekhayali, R.raw.bekhayali));
        musicList.add(new MusicModel.Music("Dil Galti Kar Baitha Hai", "Jubin Nautiyal", R.drawable.dil_galti_kar_baitha_hai, R.raw.dil_galti_kar_baitha_hai));
        musicList.add(new MusicModel.Music("Shayad", "Arijit Singh", R.drawable.shayad, R.raw.shayad));
        musicAdapter = new MusicAdapter(musicList, Login3.this);
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
        Intent intent = new Intent(Login3.this, MainActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }
    private void navigateToMainActivity() {
        Intent intent = new Intent(Login3.this, Playlists.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }



}