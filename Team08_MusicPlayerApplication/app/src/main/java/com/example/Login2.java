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

public class Login2 extends AppCompatActivity {
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
        musicList.add(new MusicModel.Music("Butta Bomma", "Armaan Malik", R.drawable.butta_bomma, R.raw.butta_bomma));
        musicList.add(new MusicModel.Music("Ala Vaikunthapurramuloo", "Anurag Kulkarni", R.drawable.ala_vaikunthapurramuloo, R.raw.ala_vaikunthapurramuloo));
        musicList.add(new MusicModel.Music("Samajavaragamana", "Sid Sriram", R.drawable.samajavaragamana, R.raw.samajavaragamana));
        musicList.add(new MusicModel.Music("Ramulo Ramula", "Anurag Kulkarni, Mangli", R.drawable.ramulo_ramula, R.raw.ramulo_ramula));
        musicList.add(new MusicModel.Music("Butta Bomma (DJ)", "Armaan Malik", R.drawable.butta_bomma_dj, R.raw.butta_bomma_dj));
        musicList.add(new MusicModel.Music("Saranga Dariya", "Mangli", R.drawable.saranga_dariya, R.raw.saranga_dariya));
        musicList.add(new MusicModel.Music("Maguva Maguva", "Sid Sriram", R.drawable.maguva_maguva, R.raw.maguva_maguva));
        musicList.add(new MusicModel.Music("Neeli Neeli Aakasam", "Sid Sriram", R.drawable.neeli_neeli_aakasam, R.raw.neeli_neeli_aakasam));
        musicList.add(new MusicModel.Music("Nee Kannu Neeli Samudram", "Javed Ali", R.drawable.nee_kannu_neeli_samudram, R.raw.nee_kannu_neeli_samudram));
        musicList.add(new MusicModel.Music("Rowdy Baby", "Dhanush, Dhee", R.drawable.rowdy_baby, R.raw.rowdy_baby));

        musicAdapter = new MusicAdapter(musicList, Login2.this);
        recyclerView.setAdapter(musicAdapter);


        Button signoutButton = findViewById(R.id.signoutBTN);

        Button backButton = findViewById(R.id.backBTN);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });
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
        Intent intent = new Intent(Login2.this, MainActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(Login2.this, Playlists.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }

}