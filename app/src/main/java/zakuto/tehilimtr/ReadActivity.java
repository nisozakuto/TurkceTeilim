package zakuto.tehilimtr;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {
    public TextView printtehilimtr;
    ListView tehilimtrListView;
    int[] tehilimler;
    String tehilimlerString;
    ArrayAdapter adapter;
    static ArrayMap<String, String> readTehilimMap = new ArrayMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        // Intent gelenIntent = getIntent();
        //tehilimlerString = gelenIntent.getStringExtra("Tehilim");
        //List<Integer> tehilimList = (ArrayList<Integer>)getIntent().getSerializableExtra("TehilimList");
        //ArrayList<Integer> test = getIntent().putIntegerArrayListExtra("TehilimList");
        // Extract the array from the Bundle object



/*
        Bundle extras = getIntent().getExtras();
        int[] tehilimNumbers = {23};
        //int[] myArr = extras.getIntArray("tehilimList");
        // tehilimNumbers = extras.getIntArray("tehilimNumbers");
        ArrayList<String> mylist = new ArrayList<String>();
        mylist.clear();
        //mylist.add(TehilimClass.getTehilim("tr77")); //this adds an element to the list.

        for (int i = tehilimNumbers[0]; i < tehilimNumbers[0] + tehilimNumbers.length; i++) {
            //readTehilimMap.put("Tehilim", TehilimClass.getTehilim("tr" + i));
            mylist.add(TehilimClass.getTehilim("tr" + i)); //this adds an element to the list.
            Log.i("Value", "Test");
            //Log.i("Value", String.valueOf(readTehilimMap));
        }
        tehilimtrListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.content_tum_kitap, R.id.textViewFortehilimtr, mylist);
        tehilimtrListView.setAdapter(arrayAdapter);
*/




        Log.i("summy tag", "Dummy comment");
    }

}