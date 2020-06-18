
package zakuto.tehilimtr.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import zakuto.tehilimtr.MainActivity;
import zakuto.tehilimtr.R;
import zakuto.tehilimtr.RandomTehilim;
import zakuto.tehilimtr.ReadActivity;
import zakuto.tehilimtr.TehilimOfDay;
import zakuto.tehilimtr.readFragment;
import zakuto.tehilimtr.tehilim.TehilimFragment;
import zmanim.ComplexZmanimCalendar;
import zmanim.hebrewcalendar.HebrewDateFormatter;
import zmanim.hebrewcalendar.JewishCalendar;
import zmanim.util.GeoLocation;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private AdView mAdView;
    private HomeViewModel homeViewModel;
    Button randomButton, continueFromTheBook, bookOfDay, button6;

    TextView date;
    String lastReadBook = null;
    int hebrewDay;
    TehilimFragment nextFrag = new TehilimFragment();
    Bundle bundle = new Bundle();
    RandomTehilim RandomTehilim = new RandomTehilim();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Log.i("Current", "HomeFragment");

        randomButton = root.findViewById(R.id.randomButton);
        //continueFromTheBook = root.findViewById(R.id.continueFromTheBook);
        date = root.findViewById(R.id.date);
        randomButton.setOnClickListener(this);
        // continueFromTheBook.setOnClickListener(this);
        bookOfDay = root.findViewById(R.id.bookOfDay);
        bookOfDay.setOnClickListener(this);

        // TehilimListAdapter.showToast(this.getApplicationContext());
        //Test with Pixel
        /* List<String> testDeviceIds = Arrays.asList("F2F51C5D2BA7B325DC8FAA267BF930DE");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);*/

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("AD", "ad is here!");
            }
        });

        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        String locationName = "Istanbul, TR";
        double latitude = 41.0082; //Lakewood, NJ
        double longitude = 28.979530; //Lakewood, NJ
        double elevation = 0; //optional elevation
        TimeZone timeZone = TimeZone.getTimeZone("TRT/Istanbul");
        GeoLocation location = new GeoLocation(locationName, latitude, longitude, elevation, timeZone);
        ComplexZmanimCalendar czc = new ComplexZmanimCalendar(location);
        HebrewDateFormatter hdf = new HebrewDateFormatter();
        JewishCalendar jc = new JewishCalendar();

        /*settingsButton = root.findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(this);*/
        Date sunrise = czc.getSunrise();
        Log.i("sunrise", String.valueOf(sunrise));
        hebrewDay = jc.getJewishDayOfMonth();
       /* HebrewDateFormatter hdf = new HebrewDateFormatter();
        System.out.println(jd); // prints hebrew date in English chars - 23 Nissan, 5773
        hdf.setHebrewFormat(true); // change formatting to Hebrew
        System.out.println(hdf.format(jd)); // date formatted in Hebrew
        jd.setJewishDate(5729, JewishDate.SHEVAT, 21); // set the date to 21 Shevat, 5729
        System.out.println(hdf.format(jd)); // date formatted in Hebrew
        jd.setJewishDate(5772, JewishDate.NISSAN, 18); // set date to third day of Pesach
        System.out.println(hdf.format(jd));
        System.out.println(hdf.formatYomTov(jd)); //output Chol Hamoed Pesach in Hebrew
        hdf.setHebrewFormat(false); // change formatting to default
        System.out.println(hdf.format(jd)); // prints Hebrew date in English chars - 18 Nissan, 5772
        System.out.println(hdf.formatYomTov(jd)); //output Chol Hamoed Pesach
        */
        date.setText("İbrani takvimi: " + jc);
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
/*            case R.id.continueFromTheBook:
                if (lastReadBook != null && lastReadBook != "") {
                    Intent intentlastReadBook = new Intent(getActivity(), ReadActivity.class);
                    intentlastReadBook.putExtra("kitap", String.valueOf(lastReadBook));
                    startActivity(intentlastReadBook);
                } else if (lastReadBook.equals(null) || lastReadBook.equals("")) {
                    Toast.makeText(getActivity(), "Son okuduğun kitap yok.", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i("continueFromTheBook", lastReadBook);
                }
                break;*/
            case R.id.bookOfDay:
                Intent intent = new Intent(getActivity(), ReadActivity.class);
                if (hebrewDay > 28)
                    hebrewDay = 28;
                intent.putExtra("fragmentKey", "bookOfDay");
                intent.putExtra("bookOfDay", String.valueOf(hebrewDay));
                startActivity(intent);
                 /*
                bundle.putString("bookOfDay", String.valueOf(hebrewDay));
                bundle.putString("fragmentKey", "bookOfDay");
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();*/
                break;

            case R.id.randomButton:
                intent = new Intent(getActivity(), ReadActivity.class);
                intent.putExtra("fragmentKey", "randomTehilim");
                intent.putExtra("randomTehilim", String.valueOf(RandomTehilim.randomNumber()));
                startActivity(intent);
                /*
                bundle.putString("singleTehilim", String.valueOf(RandomTehilim.randomNumber()));
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
                */
                /*
                SharedPreferences settingPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String settingString = settingPrefs.getString("font_size_preference", "No info was found");
                date.setText(" " + settingString);
                Toast.makeText(getActivity(), settingString, Toast.LENGTH_LONG).show();*/
                /*NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_navigation_dashboard_to_TehilimFragment);*/
                break;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sh = this.getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        lastReadBook = sh.getString("lastReadBook", "");

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Ana Sayfa");
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }
}