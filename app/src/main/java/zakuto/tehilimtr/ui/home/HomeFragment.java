
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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import zakuto.tehilimtr.R;
import zakuto.tehilimtr.ReadActivity;
import zakuto.tehilimtr.readFragment;
import zmanim.ComplexZmanimCalendar;
import zmanim.ZmanimCalendar;
import zmanim.hebrewcalendar.HebrewDateFormatter;
import zmanim.hebrewcalendar.JewishCalendar;
import zmanim.util.GeoLocation;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    Button FullBook, continueFromTheBook, button4;
    TextView date;
    String lastReadBook = null;
    int hebrewDay;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        FullBook = root.findViewById(R.id.FullBook);
        continueFromTheBook = root.findViewById(R.id.continueFromTheBook);
        date = root.findViewById(R.id.date);
        FullBook.setOnClickListener(this);
        continueFromTheBook.setOnClickListener(this);
        button4 = root.findViewById(R.id.button4);
        button4.setOnClickListener(this);
        String locationName = "New York, NY";
        double latitude = 40.6782; //Lakewood, NJ
        double longitude = -73.9442; //Lakewood, NJ
        double elevation = 0; //optional elevation
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        GeoLocation location = new GeoLocation(locationName, latitude, longitude, elevation, timeZone);
        ComplexZmanimCalendar czc = new ComplexZmanimCalendar(location);
        HebrewDateFormatter hdf = new HebrewDateFormatter();
        JewishCalendar jc = new JewishCalendar();

        Date sunrise = czc.getSunrise();
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
            case R.id.FullBook:
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.nav_host_fragment, readFragment.newInstance()); // newInstance() is a static factory method.
                transaction.commit();
                break;
            case R.id.continueFromTheBook:
                if (lastReadBook != null && lastReadBook != "") {
                    Intent intentlastReadBook = new Intent(getActivity(), ReadActivity.class);
                    intentlastReadBook.putExtra("kitap", String.valueOf(lastReadBook));
                    startActivity(intentlastReadBook);
                } else if (lastReadBook.equals(null) || lastReadBook.equals("")) {
                    Toast.makeText(getActivity(), "Son okuduğun kitap yok.", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i("continueFromTheBook", lastReadBook);
                }
                break;
            case R.id.button4:
                Intent intent = new Intent(getActivity(), ReadActivity.class);
                intent.putExtra("bookOfDay", String.valueOf(hebrewDay));
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sh = this.getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        lastReadBook = sh.getString("lastReadBook", "");

    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }
}