package com.example.team08_musicplayerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;
    private List<MusicModel.Music> musicList;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        loginBTN = findViewById(R.id.loginBTN);
        registerBTN = findViewById(R.id.registerBTN);
        
        registerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        
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
    private void registerUser() {
        String email = emailET.getText().toString().trim();
        String pass = passwordET.getText().toString().trim();

        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, NoteActivity.class));
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void loginUser() {
        String email = emailET.getText().toString().trim();
        String pass = passwordET.getText().toString().trim();

        auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, NoteActivity.class));
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
