package com.zakuto.teilim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button tumKitap, infoButton, randomTeilimButton;
    public TextView teilimText, randomTeilimText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        tumKitap = findViewById(R.id.tumKitapButton);
        tumKitap.setOnClickListener(this);

        infoButton = findViewById(R.id.infoButton);
        infoButton.setOnClickListener(this);

        teilimText = findViewById(R.id.textView2);
        teilimText.setText(R.string.dummmyText);

        randomTeilimButton = findViewById(R.id.randomTeilimButton);
        randomTeilimButton.setOnClickListener(this);
        randomTeilimText = findViewById(R.id.randomNumberText);
        RandomTeilim();
        RandomTeilim randomTeilimObject = new RandomTeilim();
        randomTeilimText.setText(String.valueOf(randomTeilimObject.randomNumber()));
    }

    public void RandomTeilim() {
        RandomTeilim randomTeilimObject = new RandomTeilim();
        randomTeilimText.setText(String.valueOf(randomTeilimObject.randomNumber()));
    }

    public void tumKitap() {
        Intent tumKitapIntent = new Intent(this, tumKitap.class);
        startActivity(tumKitapIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tumKitapButton:
                tumKitap();
                break;
            case R.id.infoButton:
                Intent infoIntent = new Intent(this, Info.class);
                startActivity(infoIntent);
                break;
            case R.id.randomTeilimButton:
                RandomTeilim();
                break;
        }
    }
}
