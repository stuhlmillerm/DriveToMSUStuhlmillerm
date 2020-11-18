package com.csit551.drivetomsustuhlmillerm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGo(View view) {
        /*
        Set up an intent for navigation to the location defined in the strings resources map_navigation_url
         */
        Uri gmmIntentUri = Uri.parse(getString(R.string.map_navigation_url));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage(getString(R.string.map_package));

        // Use try/catch to make sure that the maps app is installed.
        try {
            startActivity(mapIntent);
        } catch (ActivityNotFoundException e) {
            // If the map intent failed to find an app, show a toast message that maps need to be installed
            Toast.makeText(getApplicationContext(), getString(R.string.map_missing), Toast.LENGTH_SHORT).show();
        }
    }
}