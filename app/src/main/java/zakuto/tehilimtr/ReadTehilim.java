package zakuto.tehilimtr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.ArrayMap;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import zakuto.tehilimtr.R;

public class ReadTehilim extends AppCompatActivity {
    public TextView printtehilimtr;
    ListView tehilimtrListView;
    int[] tehilimler;
    String tehilimlerString;
    ArrayAdapter adapter;
    static ArrayMap<String, String> readTehilimMap = new ArrayMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_tehilim);

        // Intent gelenIntent = getIntent();
        //tehilimlerString = gelenIntent.getStringExtra("Tehilim");
        //List<Integer> tehilimList = (ArrayList<Integer>)getIntent().getSerializableExtra("TehilimList");
        //ArrayList<Integer> test = getIntent().putIntegerArrayListExtra("TehilimList");
        // Extract the array from the Bundle object

        Bundle extras = getIntent().getExtras();
        int[] tehilimNumbers = {23};
        //int[] myArr = extras.getIntArray("tehilimList");
       // tehilimNumbers = extras.getIntArray("tehilimNumbers");
        ArrayList<String> mylist = new ArrayList<String>();
        mylist.clear();
        //mylist.add(TehilimClass.getTehilim("tr77")); //this adds an element to the list.

        for (int i = tehilimNumbers[0]; i < tehilimNumbers[0]+tehilimNumbers.length; i++) {
            //readTehilimMap.put("Tehilim", TehilimClass.getTehilim("tr" + i));
            mylist.add(TehilimClass.getTehilim("tr" + i)); //this adds an element to the list.
            Log.i("Value","Test");
            //Log.i("Value", String.valueOf(readTehilimMap));
        }
        tehilimtrListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.content_tum_kitap, R.id.textViewFortehilimtr, mylist);
        tehilimtrListView.setAdapter(arrayAdapter);
        Log.i("summy tag","Dummy comment");
    }
}