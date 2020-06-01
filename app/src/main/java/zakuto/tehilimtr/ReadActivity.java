package zakuto.tehilimtr;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.ArrayMap;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {
    public TextView printtehilimtr;
    ListView tehilimtrListView;
    int[] passTehilimValues = new int[]{};

    int[] tehilimler;
    String tehilimlerString;
    ArrayAdapter adapter;
    static ArrayMap<String, String> readTehilimMap = new ArrayMap<String, String>();
    String kitapExtra = null, tehilimExtra = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Test Onur");
        Log.i("niso", "55");
        ArrayList<String> mylist = new ArrayList<String>();


        ListView fullBookListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tehilimArray);
        fullBookListView.setAdapter(listviewAdapter);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            tehilimExtra = (String) b.get("tehilim");
            kitapExtra = (String) b.get("kitap");
            textView.setText(tehilimExtra + "" + kitapExtra);
        }
        if (tehilimExtra != null) {
            textView.setText("Kullanici teilim istiyor " + tehilimExtra + ".teilim");
            mylist.clear();
            //mylist.add(TehilimClass.getTehilim("tr77")); //this adds an element to the list.
            //mylist.add(TehilimClass.getTehilim("tr5")); //this adds an element to the list.

        } else if (kitapExtra != null) {
            textView.setText("Kullanici kitap istiyor " + kitapExtra + ".kitap");
            textView.setText("" + monthlyOrder(Integer.parseInt(kitapExtra)));
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

}