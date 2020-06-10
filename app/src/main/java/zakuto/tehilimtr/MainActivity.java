package zakuto.tehilimtr;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
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
    String fontSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        SharedPreferences fontSizePref = this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String fontSize = fontSizePref.getString("fontSize", "");
        Log.i("fontSize", "yukarida " + fontSize);


        TehilimListAdapter TehilimListAdapter = new TehilimListAdapter("Preference ");
        getSharedPreferences("SHAREDPREFFORADAPTER", MODE_PRIVATE)
                .edit()
                .putString("p", fontSize)
                .commit();
       // TehilimListAdapter.showToast(this.getApplicationContext());
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
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
        /*//Bottom Navigation code
        BottomNavigationView bottomNavigation = findViewById(R.id.nav_view);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));*/
        /*tumKitap = findViewById(R.id.tumKitapButton);
        tumKitap.setOnClickListener(this);
    }
    /*public void openFragment(Fragment fragment) {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu_main_activity, menu);
        return true;
    }

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
               /* Intent settingIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingIntent);
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();*/
                break;
            default:
                break;
        }
        return true;
    }

   /* @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences fontSizePref = this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        fontSize = fontSizePref.getString("fontSize", "");
        Log.i("fontSize", fontSize);
    }*/

    @Override
    public void onClick(View view) {

    }
}