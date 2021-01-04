package zakuto.tehilimtr;

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
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import zakuto.tehilimtr.tehilim.BeforeTehilimFragment;
import zakuto.tehilimtr.tehilim.TehilimFragment;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    int[] passTehilimValues = new int[]{};
    String fragmentKey = "readActivity", singleTehilim, kitapExtra = "1", tehilimExtra = "1", layout = "latin", dailyTehilim = "1", bookOfDay = "null", fontSize;
    Integer teilimNumber = 23, changeScript = 1;
    ArrayList<String> mylist = new ArrayList<String>();
    ListView list;
    ArrayList<String> myTehilimList = new ArrayList<String>();
    public TehilimClass TehilimClass = new TehilimClass();
    ArrayList<Tehilim> latinAndHebrewList = new ArrayList<>();
    Tehilim[] perek = new Tehilim[153];
    private static final String TAG = "ReadActivity.java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Log.i(TAG, "Started");
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            //actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        Fragment selectedFragment;
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            fragmentKey = (String) b.get("fragmentKey");
            if (fragmentKey.equals("singleTehilim")) {
                selectedFragment = new TehilimFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).
                        commit();
            }
            if (fragmentKey.equals("bookOfDay")) {
                selectedFragment = new TehilimFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).
                        commit();
            }
            if (fragmentKey.equals("monthly")) {
                selectedFragment = new BeforeTehilimFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).
                        commit();
                fragmentKey = "monthlyStarted";
            }
            if (fragmentKey.equals("readActivity")) {
                selectedFragment = new TehilimFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).
                        commit();
            }
            if (fragmentKey.equals("randomTehilim")) {
                selectedFragment = new TehilimFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).
                        commit();
            }
        }
    }

    public void singleTehilimFunction() {
        perek[Integer.parseInt(singleTehilim)] = new Tehilim(TehilimClass.getTehilim("tr" + Integer.parseInt(singleTehilim)), TehilimClass.getTehilim("H_perek" + Integer.parseInt(singleTehilim)));
        latinAndHebrewList.add(perek[Integer.parseInt(singleTehilim)]);
    }

    public void kitapFunction() {
        monthlyOrder(Integer.parseInt(kitapExtra));
        if (kitapExtra.equals("23")) {
            perek[116] = new Tehilim(TehilimClass.getTehilim("tr116"), TehilimClass.getTehilim("H_perek116")); //this adds an element to the list.
            perek[117] = new Tehilim(TehilimClass.getTehilim("tr117"), TehilimClass.getTehilim("H_perek117")); //this adds an element to the list.
            perek[118] = new Tehilim(TehilimClass.getTehilim("tr118"), TehilimClass.getTehilim("H_perek118")); //this adds an element to the list.
            perek[151] = new Tehilim(TehilimClass.getTehilim("tr151"), TehilimClass.getTehilim("H_perek151")); //this adds an element to the list.
            latinAndHebrewList.add(perek[116]);
            latinAndHebrewList.add(perek[117]);
            latinAndHebrewList.add(perek[118]);
            latinAndHebrewList.add(perek[151]);

        } else if (kitapExtra.equals("24")) {
            perek[152] = new Tehilim(TehilimClass.getTehilim("tr152"), TehilimClass.getTehilim("H_perek152"));
            latinAndHebrewList.add(perek[152]);
        } else {
            for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                Log.i("tehilimNumber1", ""+ passTehilimValues[i]);
                perek[i - 1] = new Tehilim(TehilimClass.getTehilim("tr" + i), TehilimClass.getTehilim("H_perek" + i));
                latinAndHebrewList.add(perek[i - 1]);
            }
        }
    }

    public void chooseLayout() {
        if (layout.equals("latin")) {
            latinTehilim();
            Log.i("Test", "Latin");
        }
        if (layout.equals("hebrew")) {
            hebrewTehilim();
            Log.i("Test", "Hebrew");
        }
    }

    public void both() {
        if (kitapExtra != null) {
            if (kitapExtra == "23") {
                mylist.add(TehilimClass.getTehilim("H_perek116")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek117")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek118")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek1191")); //this adds an element to the list.
            } else if (kitapExtra == "24") {
                mylist.add(TehilimClass.getTehilim("H_perek1192")); //this adds an element to the list.
            } else {
                for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                    Log.i("tehilimNumber", ""+ passTehilimValues[i]);

                    perek[i - 1] = new Tehilim(TehilimClass.getTehilim("tr" + i), TehilimClass.getTehilim("H_perek" + i));
                    latinAndHebrewList.add(perek[i - 1]);
                }
            }
        }
        setListView();
    }

    public void latinTehilim() {
        if (tehilimExtra != null) {
            mylist.clear();
            teilimNumber = Integer.parseInt(tehilimExtra);
            mylist.add(TehilimClass.getTehilim("tr" + teilimNumber)); //this adds an element to the list.
            Log.i("teilimNumber", String.valueOf(teilimNumber));
        } else if (kitapExtra != null) {
            monthlyOrder(Integer.parseInt(kitapExtra));
            mylist.clear();
            if (kitapExtra == "23") {
                mylist.add(TehilimClass.getTehilim("tr116")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("tr117")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("tr118")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("tr1191")); //this adds an element to the list.
            } else if (kitapExtra == "24") {
                mylist.add(TehilimClass.getTehilim("tr1192")); //this adds an element to the list.
            } else {
                for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                    Log.i("tehilimNumber", ""+ passTehilimValues[i]);

                    mylist.add(TehilimClass.getTehilim("tr" + i)); //this adds an element to the list.
                }
            }

        }
        setListView();
    }

    public void hebrewTehilim() {
        if (tehilimExtra != null) {
            mylist.clear();
            teilimNumber = Integer.parseInt(tehilimExtra);
            mylist.add(TehilimClass.getTehilim("H_perek" + teilimNumber)); //this adds an element to the list.
        } else if (kitapExtra != null) {
            monthlyOrder(Integer.parseInt(kitapExtra));
            mylist.clear();
            if (kitapExtra == "23") {
                mylist.add(TehilimClass.getTehilim("H_perek116")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek117")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek118")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek1191")); //this adds an element to the list.
            } else if (kitapExtra == "24") {
                mylist.add(TehilimClass.getTehilim("H_perek1192")); //this adds an element to the list.
            } else {
                for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                    Log.i("tehilimNumber", ""+ passTehilimValues[i]);
                    mylist.add(TehilimClass.getTehilim("H_perek" + i)); //this adds an element to the list.
                }
            }
        }
        if (dailyTehilim != null) {
            monthlyOrder(Integer.parseInt(dailyTehilim));
            mylist.clear();
            for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                mylist.add(TehilimClass.getTehilim("tr" + i)); //this adds an element to the list.
            }
        }
        setListView();
    }

    public void setListView() {
           TehilimListAdapter tehilimlistadapter = new TehilimListAdapter(this, R.layout.adapter_listview_layout, latinAndHebrewList);
        list.setAdapter(tehilimlistadapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("lastReadBook", kitapExtra);
        myEdit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String s1 = sh.getString("name", "");

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this /* Activity context */);
        String testFontSize = sharedPreferences.getString("font_size_preference", "");
        //Toast.makeText(this, "Font Size: " + testFontSize, Toast.LENGTH_SHORT).show();

        SharedPreferences fontSizePref = this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        fontSize = fontSizePref.getString("fontSize", "");
        Log.i("fontSize", "yukarida " + fontSize);
        //TehilimListAdapter TehilimListAdapter = new TehilimListAdapter("Preference ");
        getSharedPreferences("SHAREDPREFFORADAPTER", MODE_PRIVATE)
                .edit()
                .putString("p", fontSize)
                .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().popBackStackImmediate()) {
            return true;
        }
        return super.onSupportNavigateUp();
    }

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

    public int[] monthlyOrder(int position) {
        passTehilimValues = new int[]{};
        if (position == 1) {
            passTehilimValues = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
            return passTehilimValues;
        }
        if (position == 2) {
            passTehilimValues = new int[]{9, 10, 11, 12, 14, 15};
            return passTehilimValues;
        }
        if (position == 3) {
            passTehilimValues = new int[]{16, 17, 18, 19};
            return passTehilimValues;
        }
        if (position == 4) {
            passTehilimValues = new int[]{20, 21, 22, 23, 24, 25};
            return passTehilimValues;
        }
        if (position == 5) {
            passTehilimValues = new int[]{26, 27, 28, 29, 30, 31};
            return passTehilimValues;
        }
        if (position == 6) {
            passTehilimValues = new int[]{32, 33, 34, 35};
            return passTehilimValues;
        }
        if (position == 7) {
            passTehilimValues = new int[]{36, 37, 38, 39};
            return passTehilimValues;
        }
        if (position == 8) {
            passTehilimValues = new int[]{40, 41, 42, 43, 44};
            return passTehilimValues;
        }
        if (position == 9) {
            passTehilimValues = new int[]{45, 46, 47, 48, 49};
            return passTehilimValues;
        }
        if (position == 10) {
            passTehilimValues = new int[]{50, 51, 52, 53, 54, 55};
            return passTehilimValues;
        }
        if (position == 11) {
            passTehilimValues = new int[]{56, 57, 58, 59, 60, 61};
            return passTehilimValues;
        }
        if (position == 12) {
            passTehilimValues = new int[]{62, 63, 64, 65, 66, 67};
            return passTehilimValues;
        }
        if (position == 13) {
            passTehilimValues = new int[]{68, 69, 70};
            return passTehilimValues;
        }
        if (position == 14) {
            passTehilimValues = new int[]{71, 72, 73, 74, 75};
            return passTehilimValues;
        }
        if (position == 15) {
            passTehilimValues = new int[]{76, 77, 78};
            return passTehilimValues;
        }
        if (position == 16) {
            passTehilimValues = new int[]{79, 80, 81, 82, 83, 84};
            return passTehilimValues;
        }
        if (position == 17) {
            passTehilimValues = new int[]{85, 86, 87, 88, 89};
            return passTehilimValues;
        }
        if (position == 18) {
            passTehilimValues = new int[]{90, 91, 92, 93, 94, 95};
            return passTehilimValues;
        }
        if (position == 19) {
            passTehilimValues = new int[]{96, 97, 98, 99, 100, 101, 102};
            return passTehilimValues;
        }
        if (position == 20) {
            passTehilimValues = new int[]{103, 104, 105};
            return passTehilimValues;
        }
        if (position == 21) {
            passTehilimValues = new int[]{106, 107, 108};
            return passTehilimValues;
        }
        if (position == 22) {
            passTehilimValues = new int[]{109, 110, 111, 112, 113, 114, 115};
            return passTehilimValues;
        }
        if (position == 23) {
            passTehilimValues = new int[]{116, 117, 118, 1191};
            return passTehilimValues;
        }
        if (position == 24) {
            passTehilimValues = new int[]{1192};
            return passTehilimValues;
        }
        if (position == 25) {
            passTehilimValues = new int[]{120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131};
            return passTehilimValues;
        }
        if (position == 26) {
            passTehilimValues = new int[]{132, 133, 134, 135, 136, 137, 138};
            return passTehilimValues;
        }
        if (position == 27) {
            passTehilimValues = new int[]{139, 140, 141, 142, 143, 144};
            return passTehilimValues;
        }
        if (position == 28) {
            passTehilimValues = new int[]{145, 146, 147, 148, 149, 150};
            return passTehilimValues;
        }

        return passTehilimValues;
    }

    @Override
    public void onClick(View view) {
    }
}