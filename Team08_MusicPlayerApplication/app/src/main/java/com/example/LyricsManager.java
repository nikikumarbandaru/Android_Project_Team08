package com.example.musicplayer;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LyricsManager {

    private static final String TAG = "LyricsManager";
    private Context context;

    public LyricsManager(Context context) {
        this.context = context;
    }

    public String getLyricsForSong(int songId) {
        String[] jsonFiles = {"telugu_songs.json", "hindi_songs.json", "english_songs.json"};
        for (String filename : jsonFiles) {
            Log.d(TAG, "Loading JSON file: " + filename);
            String jsonString = loadJSONFromAsset(filename);
            if (jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray songs = jsonObject.getJSONArray("songs");

                    for (int i = 0; i < songs.length(); i++) {
                        JSONObject song = songs.getJSONObject(i);
                        Log.d(TAG, "Found song with ID: " + songId);
                        if (song.getInt("id") == songId) {
                            return song.getString("lyrics");
                        }
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Error parsing JSON", e);
                }
            }
        }
        return "Lyrics not available";
    }

    String loadJSONFromAsset(String filename) {
        String json = null;
        try (InputStream is = context.getAssets().open(filename)) {
            int size = is.available();
            byte[] buffer = new byte[size];
            int bytesRead = is.read(buffer);
            if (bytesRead != -1) {
                json = new String(buffer, StandardCharsets.UTF_8);
                Log.d(TAG,"LoadJSONFROMAsset");
            }
        } catch (IOException e) {
            Log.e(TAG, "Error reading JSON file", e);
        }
        return json;
    }
}
