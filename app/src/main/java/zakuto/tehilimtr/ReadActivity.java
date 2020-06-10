package zakuto.tehilimtr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    int[] passTehilimValues = new int[]{};
    String kitapExtra = null, tehilimExtra = null, layout = "latin", fontSize;
    Button next, back;
    Integer teilimNumber = 23, changeScript = 1;
    ArrayList<String> mylist = new ArrayList<String>();
    ListView list;
    ArrayList<String> myTehilimList = new ArrayList<String>();
    String testcountryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
    ArrayList<String> countryList = new ArrayList<String>(5);
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_for_full_book);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        list = findViewById(R.id.listView);
        final Button next = findViewById(R.id.next);
        final Button back = findViewById(R.id.back);

        countryList.add(0, "India NewZealand");
        countryList.add(1, "India Neealand");
        countryList.add(2, "Indiaaland");
        countryList.add(3, "IewZealand");
        countryList.add(4, "India NewZealand");


        back.setOnClickListener(this);
        next.setOnClickListener(this);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            tehilimExtra = (String) b.get("tehilim");
            kitapExtra = (String) b.get("kitap");
        }
        if (kitapExtra != null) {

            ViewGroup nextlayout = (ViewGroup) next.getParent();
            nextlayout.removeView(next);
            ViewGroup backlayout = (ViewGroup) back.getParent();
            backlayout.removeView(back);
            list.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        }

        chooseLayout();
    }

    public void chooseLayout() {
        if (layout == "latin") {
            latinTehilim();
        }
        if (layout == "hebrew") {
            hebrewTehilim();
        }
    }

    public void latinTehilim() {
        if (tehilimExtra != null) {
            mylist.clear();
            teilimNumber = Integer.parseInt(tehilimExtra);
            mylist.add(TehilimClass.getTehilim("tr" + teilimNumber)); //this adds an element to the list.
        } else if (kitapExtra != null) {
            monthlyOrder(Integer.parseInt(kitapExtra));
            mylist.clear();
            for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                mylist.add(TehilimClass.getTehilim("tr" + i)); //this adds an element to the list.
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
            for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                mylist.add(TehilimClass.getTehilim("H_perek" + i)); //this adds an element to the list.
            }
        }
        setListView();
    }


    public void setListView() {
        /*list.setAdapter(null);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , mylist);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_text, mylist);
        list.setAdapter(arrayAdapter);*/
        /*SharedPreferences settingPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String settingString = settingPrefs.getString("font_size_preference", "No info was found");*/

        TehilimListAdapter tehilimlistadapter = new TehilimListAdapter(getApplicationContext(), mylist);
        list.setAdapter(tehilimlistadapter);

    }
        /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
//Intent gelenIntent = getIntent();
//tehilimlerString = gelenIntent.getStringExtra("Tehilim");
//List<Integer> tehilimList = (ArrayList<Integer>)getIntent().getSerializableExtra("TehilimList");
//ArrayList<Integer> test = getIntent().putIntegerArrayListExtra("TehilimList");
// Extract the array from the Bundle object
        /*
        int[] tehilimNumbers = {23};
        //int[] myArr = extras.getIntArray("tehilimList");
        // tehilimNumbers = extras.getIntArray("tehilimNumbers");

        for (int i = tehilimNumbers[0]; i < tehilimNumbers[0] + tehilimNumbers.length; i++) {
            //readTehilimMap.put("Tehilim", TehilimClass.getTehilim("tr" + i));
            mylist.add(TehilimClass.getTehilim("tr" + i)); //this adds an element to the list.
            Log.i("Value", "Test");
            //Log.i("Value", String.valueOf(readTehilimMap));
        }
        */

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("lastReadBook", kitapExtra);
        myEdit.commit();
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
        TehilimListAdapter TehilimListAdapter = new TehilimListAdapter("Preference ");
        getSharedPreferences("SHAREDPREFFORADAPTER", MODE_PRIVATE)
                .edit()
                .putString("p", fontSize)
                .commit();
        setListView();
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
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (changeScript == 1) {
            menu.findItem(R.id.latin).setVisible(false);
            menu.findItem(R.id.latinAndHebrew).setVisible(false);
            layout = "latin";
            chooseLayout();
        }
        if (changeScript == 2) {
            menu.findItem(R.id.latin).setVisible(false);
            menu.findItem(R.id.hebrew).setVisible(false);
            layout = "hebrew";
            chooseLayout();
        }
        if (changeScript == 3) {
            menu.findItem(R.id.latinAndHebrew).setVisible(false);
            menu.findItem(R.id.hebrew).setVisible(false);
            layout = "latinAndHebrew";
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.latin:
                changeScript = 1;
                invalidateOptionsMenu();
                break;
            case R.id.hebrew:
                changeScript = 2;
                invalidateOptionsMenu();
                break;
            case R.id.latinAndHebrew:
                changeScript = 3;
                invalidateOptionsMenu();
                break;
            case R.id.action_settings:
                Intent settingIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingIntent);
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    public int[] monthlyOrder(int position) {
        passTehilimValues = new int[]{};
        if (position == 1) {
            passTehilimValues = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            return passTehilimValues;
        }
        if (position == 2) {
            passTehilimValues = new int[]{10, 11, 12, 14, 15, 16, 17};
            return passTehilimValues;
        }
        if (position == 3) {
            passTehilimValues = new int[]{18, 19, 20, 21, 22};
            return passTehilimValues;
        }
        if (position == 4) {
            passTehilimValues = new int[]{23, 24, 25, 26, 27, 28};
            return passTehilimValues;
        }
        if (position == 5) {
            passTehilimValues = new int[]{29, 30, 31, 32, 33, 34};
            return passTehilimValues;
        }
        if (position == 6) {
            passTehilimValues = new int[]{35, 36, 37, 38};
            return passTehilimValues;
        }
        if (position == 7) {
            passTehilimValues = new int[]{39, 40, 41, 42, 43};
            return passTehilimValues;
        }
        if (position == 8) {
            passTehilimValues = new int[]{44, 45, 46, 47, 48};
            return passTehilimValues;
        }
        if (position == 9) {
            passTehilimValues = new int[]{49, 50, 51, 52, 53, 54};
            return passTehilimValues;
        }
        if (position == 10) {
            passTehilimValues = new int[]{55, 56, 57, 58, 59};
            return passTehilimValues;
        }
        if (position == 11) {
            passTehilimValues = new int[]{60, 61, 62, 63, 64, 65};
            return passTehilimValues;
        }
        if (position == 12) {
            passTehilimValues = new int[]{66, 67, 68};
            return passTehilimValues;
        }
        if (position == 13) {
            passTehilimValues = new int[]{69, 70, 71};
            return passTehilimValues;
        }
        if (position == 14) {
            passTehilimValues = new int[]{72, 73, 74, 75, 76};
            return passTehilimValues;
        }
        if (position == 15) {
            passTehilimValues = new int[]{77, 78};
            return passTehilimValues;
        }
        if (position == 16) {
            passTehilimValues = new int[]{79, 80, 81, 82};
            return passTehilimValues;
        }
        if (position == 17) {
            passTehilimValues = new int[]{83, 84, 85, 86, 87};
            return passTehilimValues;
        }
        if (position == 18) {
            passTehilimValues = new int[]{88, 89};
            return passTehilimValues;
        }
        if (position == 19) {
            passTehilimValues = new int[]{90, 91, 92, 93, 94, 95, 96};
            return passTehilimValues;
        }
        if (position == 20) {
            passTehilimValues = new int[]{97, 98, 99, 100, 101, 102, 103};
            return passTehilimValues;
        }
        if (position == 21) {
            passTehilimValues = new int[]{104, 105};
            return passTehilimValues;
        }
        if (position == 22) {
            passTehilimValues = new int[]{106, 107};
            return passTehilimValues;
        }
        if (position == 23) {
            passTehilimValues = new int[]{108, 109, 110, 111, 112};
            return passTehilimValues;
        }
        if (position == 24) {
            passTehilimValues = new int[]{113, 114, 115, 116, 117, 118};
            return passTehilimValues;
        }
        if (position == 25) {
            passTehilimValues = new int[]{119};
            return passTehilimValues;
        }
        if (position == 26) {
            passTehilimValues = new int[]{119};
            return passTehilimValues;
        }
        if (position == 27) {
            passTehilimValues = new int[]{120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134};
            return passTehilimValues;
        }
        if (position == 28) {
            passTehilimValues = new int[]{135, 136, 137, 138, 139};
            return passTehilimValues;
        }
        if (position == 29) {
            passTehilimValues = new int[]{140, 141, 142, 143, 144};
            return passTehilimValues;
        }
        if (position == 30) ;
        {
            passTehilimValues = new int[]{145, 146, 147, 148, 149, 150};
            return passTehilimValues;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                if (teilimNumber == 150) {
                    teilimNumber = 1;
                } else {
                    teilimNumber++;
                }
                mylist.clear();
                mylist.add(TehilimClass.getTehilim("tr" + teilimNumber)); //this adds an element to the list.
                setListView();
                break;
            case R.id.back:
                if (teilimNumber == 1) {
                    teilimNumber = 150;
                } else {
                    teilimNumber--;
                }
                mylist.clear();
                mylist.add(TehilimClass.getTehilim("tr" + teilimNumber)); //this adds an element to the list.
                setListView();
                break;
        }
    }
}