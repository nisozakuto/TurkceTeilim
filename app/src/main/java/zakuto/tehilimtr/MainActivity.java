package zakuto.tehilimtr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import zakuto.tehilimtr.ui.home.HomeFragment;
import zakuto.tehilimtr.ui.notifications.NotificationsFragment;
import zakuto.tehilimtr.ui.dashboard.DashboardFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import zakuto.tehilimtr.ui.home.HomeFragment;
import zakuto.tehilimtr.ui.notifications.NotificationsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    BottomNavigationView bottomNavigation;

    public Button tumKitap, infoButton, randomtehilimtrButton, textTest, fifthButton, sixthButton,seventhButton;
    public TextView tehilimtrText, date;
    public TextView randomtehilimtrText;
    public TehilimClass Tehilim = new TehilimClass();

    //public int[] destinationTehilimArray = {1, 2, 3, 4, 5};
    //ArrayList<Integer> destinationTehilimArray;
    //destinationTehilimArray.add(1,2,3,4,5);
    String destinationString = "1-100";
    int s = 1;
    int pressed = 0;

    public int[] destinationTehilimArray, tehilimNumbersArray;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (TextView) findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        date.setText(dateTime);


        //Test with Pixel
        List<String> testDeviceIds = Arrays.asList("F2F51C5D2BA7B325DC8FAA267BF930DE");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("AD", "ad is here!");
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("AD","ad is here!");
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        destinationTehilimArray = new int[]{12, 34, 54, 512};
        BottomNavigationView bottomNavigation = findViewById(R.id.nav_view);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

       /* tumKitap = findViewById(R.id.tumKitapButton);
        tumKitap.setOnClickListener(this);

        infoButton = findViewById(R.id.infoButton);
        infoButton.setOnClickListener(this);

        textTest = findViewById(R.id.textTest);
        textTest.setOnClickListener(this);

        randomtehilimtrButton = findViewById(R.id.randomtehilimtrButton);
        randomtehilimtrButton.setOnClickListener(this);*/
        Randomtehilimtr();
    }

    public void Randomtehilimtr() {
        RandomTeilim randomtehilimtrObject = new RandomTeilim();
        //randomtehilimtrText.setText(String.valueOf(randomtehilimtrObject.randomNumber()));
    }

    /*  public void tumKitap() {
          Intent tumKitapIntent = new Intent(this, readTehilim.class);
          startActivity(tumKitapIntent);
      }
  */

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_dashboard:
                            openFragment(DashboardFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_notifications:
                            openFragment(NotificationsFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /*case R.id.tumKitapButton:
              *//*
              Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "www.journaldev.com", Snackbar.LENGTH_LONG);
                snackbar.show();
                *//*
                pressed++;
                randomtehilimtrText.setText("Tum kitaplar yakinda gelicek: " + pressed);
                break;

            case R.id.infoButton:
                Intent infoIntent = new Intent(this, OrderActivity.class);
                infoIntent.putExtra("order", "Monthly");
                startActivity(infoIntent);
                break;

            case R.id.randomtehilimtrButton:
                Randomtehilimtr();
                break;

            case R.id.textTest:
               *//* String perek;
                perek = TehilimClass.getTehilim("tr" + 1);
                tehilimtrText.setText("Test)");
                tehilimtrText.setText(perek);
                if (s == 1) {
                    tehilimtrText.setText(R.string.dummmyText);
                    s = 0;
                } else {
                    tehilimtrText.setText("Test");
                    s = 1;
                }*//*
                Intent readTehilimIntent = new Intent(this, readTehilim.class);
                readTehilimIntent = new Intent(this, readTehilim.class);
                tehilimNumbersArray = new int[]{35, 36, 37, 38};
                readTehilimIntent.putExtra("tehilimNumbers", tehilimNumbersArray);
                startActivity(readTehilimIntent);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
                Log.i("Ad request","Requested?");
                break;*/
        }
    }
}