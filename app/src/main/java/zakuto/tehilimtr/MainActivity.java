package zakuto.tehilimtr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import zakuto.tehilimtr.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button tumKitap, infoButton, randomtehilimtrButton, textTest, fifthButton, sixthButton;
    public TextView tehilimtrText, randomtehilimtrText;
    public TehilimClass Tehilim = new TehilimClass();
    private AdView mAdView;
    //public int[] destinationTehilimArray = {1, 2, 3, 4, 5};
    //ArrayList<Integer> destinationTehilimArray;
    //destinationTehilimArray.add(1,2,3,4,5);
    String destinationString = "1-100";
    public int[] destinationTehilimArray, tehilimNumbersArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        destinationTehilimArray = new int[]{12, 34, 54, 512};
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

        tehilimtrText = findViewById(R.id.textView2);
        tehilimtrText.setText(R.string.dummmyText);

        randomtehilimtrButton = findViewById(R.id.randomtehilimtrButton);
        randomtehilimtrButton.setOnClickListener(this);
        randomtehilimtrText = findViewById(R.id.randomNumberText);
        Randomtehilimtr();
        RandomTeilim randomtehilimtrObject = new RandomTeilim();
        randomtehilimtrText.setText(String.valueOf(randomtehilimtrObject.randomNumber()));

        fifthButton = findViewById(R.id.fifthButton);
        fifthButton.setOnClickListener(this);

        sixthButton = findViewById(R.id.sixthButton);
        sixthButton.setOnClickListener(this);
    }

    public void Randomtehilimtr() {
        RandomTeilim randomtehilimtrObject = new RandomTeilim();
        randomtehilimtrText.setText(String.valueOf(randomtehilimtrObject.randomNumber()));
    }

    public void tumKitap() {
        Intent tumKitapIntent = new Intent(this, readTehilim.class);
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

            case R.id.randomtehilimtrButton:
                Randomtehilimtr();
                break;

            case R.id.textTest:
                String perek;
                perek = TehilimClass.getTehilim("tr" + 1);
                randomtehilimtrText.setText("Test)");
                randomtehilimtrText.setText(perek);
                break;

            case R.id.fifthButton:
                Intent readTehilimIntent = new Intent(this, readTehilim.class);
                //readTehilimIntent.putIntegerArrayListExtra("myList", (ArrayList<Integer>) destinationTehilimArray );
                //readTehilimIntent.putExtra("tehilimList", destinationTehilimArray);
                tehilimNumbersArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                readTehilimIntent.putExtra("tehilimNumbers", tehilimNumbersArray);
                // Bundle bundle = new Bundle();
                // bundle.putIntegerArrayList("Send Bundle data", destinationTehilimArray);
                //readTehilimIntent.putExtra("Tehilim", destinationTehilimArray.toString());
                //readTehilimIntent.putExtra("Tehilim", destinationString);
                startActivity(readTehilimIntent);
                break;

            case R.id.sixthButton:
                readTehilimIntent = new Intent(this, readTehilim.class);
                tehilimNumbersArray = new int[]{35, 36, 37, 38};
                readTehilimIntent.putExtra("tehilimNumbers", tehilimNumbersArray);
                startActivity(readTehilimIntent);
                break;
        }
    }
}
