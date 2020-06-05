package zakuto.tehilimtr;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import zakuto.tehilimtr.ui.Browse.BrowseFragment;
import zmanim.ComplexZmanimCalendar;
import zmanim.util.GeoLocation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public int[] destinationTehilimArray;
    private AdView mAdView;
    int teilimNumber = 0;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);




        /*SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        StringBuilder builder = new StringBuilder();
        builder.append("\n" + "Perform Sync:\t" + sharedPrefs.getBoolean("perform_sync", false));
        builder.append("\n" + "Sync Intervals:\t" + sharedPrefs.getString("sync_interval", "-1"));
        builder.append("\n" + "Name:\t" + sharedPrefs.getString("full_name", "Not known to us"));
        builder.append("\n" + "Email Address:\t" + sharedPrefs.getString("email_address", "No EMail Address Provided"));
        builder.append("\n" + "Customized Notification Ringtone:\t" + sharedPrefs.getString("notification_ringtone", ""));
        builder.append("\n\nClick on Settings Button at bottom right corner to Modify Your Prefrences");
        You have to add the textview
        TextView settingsTextView = (TextView) findViewById(R.id.preference_text);
        settingsTextView.setText(builder.toString());*/

        //Test with Pixel
       /* List<String> testDeviceIds = Arrays.asList("F2F51C5D2BA7B325DC8FAA267BF930DE");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);*/

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("AD", "ad is here!");
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
       /*
        //Bottom Navigation code
        BottomNavigationView bottomNavigation = findViewById(R.id.nav_view);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));
        */
       /* tumKitap = findViewById(R.id.tumKitapButton);
        tumKitap.setOnClickListener(this);
    }
    /* public void openFragment(Fragment fragment) {
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
            */

 /*   @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();
        myEdit.putString(
                "name",
                "24");
        myEdit.commit();
    }
*/



/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }
*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
/*            case R.id.action_refresh:
                Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
                        .show();
                break;*/
            // action with ID action_settings was selected
            case R.id.action_settings:
                Intent settingIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingIntent);
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }
        return true;
    }

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