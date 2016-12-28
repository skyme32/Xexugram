package com.herokuapp.xexugram.xexugram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseObject gameScore = new ParseObject("GameScore");
        gameScore.put("score", 13);
        gameScore.put("playerName", "Tetesebas");
        gameScore.put("cheatMode", false);
        gameScore.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.i("Parse", "Save Succeeded");
                } else {
                    Log.i("Parse", "Save Failed");
                }
            }
        });

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}
