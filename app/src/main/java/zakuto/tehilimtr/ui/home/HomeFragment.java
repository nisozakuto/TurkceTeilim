
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
import zmanim.util.GeoLocation;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    Button FullBook;
    TextView date;
    String lastReadBook = null;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //Fragment'ta Button tanimlama yeri:
        FullBook = root.findViewById(R.id.FullBook);
        //Yeni butonu buraya koy
        //Buraya git: public void onClick(View view) {
        //Yeni bir switch koy
        date = root.findViewById(R.id.date);
        FullBook.setOnClickListener(this);
        String locationName = "New York, NY";
        double latitude = 40.6782; //Lakewood, NJ
        double longitude = -73.9442; //Lakewood, NJ
        double elevation = 0; //optional elevation
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        GeoLocation location = new GeoLocation(locationName, latitude, longitude, elevation, timeZone);
        ComplexZmanimCalendar czc = new ComplexZmanimCalendar(location);
        Date sunrise = czc.getSunrise();
        date.setText("Gunes dogumu NY icin: " + String.valueOf(sunrise));
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
           /* Yeni buton'un clicki icin bunlari koy
            Intent intent = new Intent(getActivity(), ReadActivity.class);
            Degeri koy= lastReadBook
            intent.putExtra("kitap", String.valueOf(lastReadBook));
            startActivity(intent);
            Read Activity'e git oradan cek degeri ve ac .
            */
        }
    }
    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences sh
                = this.getActivity().getSharedPreferences("MySharedPref",
                Context.MODE_PRIVATE);

        lastReadBook = sh.getString("lastReadBook", "");
        Toast.makeText(getActivity(), lastReadBook + ".Kitaptan devam et", Toast.LENGTH_SHORT).show();

    }
    private FragmentManager getSupportFragmentManager() {
        return null;
    }
}