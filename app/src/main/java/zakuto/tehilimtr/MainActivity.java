package zakuto.tehilimtr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.datatransport.BuildConfig;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import zakuto.tehilimtr.ui.FullBookFragment;
import zakuto.tehilimtr.ui.MonthlyFragment;
import zakuto.tehilimtr.ui.home.HomeFragment;
import zakuto.tehilimtr.ui.user.UserFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AdView mAdView;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Current", "MainActivity");

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(bottomNavListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

        SharedPreferences fontSizePref = this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String fontSize = fontSizePref.getString("fontSize", "");
        Log.i("fontSize", "yukarida " + fontSize);

        TehilimListAdapterBase TehilimListAdapter = new TehilimListAdapterBase("Preference ");
        getSharedPreferences("SHAREDPREFFORADAPTER", MODE_PRIVATE)
                .edit()
                .putString("p", fontSize)
                .apply();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_trBooks:
                    selectedFragment = new MonthlyFragment();
                    break;
                case R.id.navigation_book:
                    selectedFragment = new FullBookFragment();
                    break;
                case R.id.navigation_user:
                    selectedFragment = new UserFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).addToBackStack(null).
                    commit();
            return true;
        }
    };

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu_english, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent settingIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingIntent);
                break;
            case R.id.info:
                Toast.makeText(this, "Versiyon: " + BuildConfig.VERSION_NAME, Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onClick(View view) {

    }
}