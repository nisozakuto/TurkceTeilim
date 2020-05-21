package zakuto.tehilimtr;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class readTehilim extends AppCompatActivity {
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
       /* Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);*/
        //Intent gelenIntent = getIntent();
        //tehilimlerString = gelenIntent.getStringExtra("Tehilim");
        //List<Integer> tehilimList = (ArrayList<Integer>)getIntent().getSerializableExtra("TehilimList");
        //ArrayList<Integer> test = getIntent().putIntegerArrayListExtra("TehilimList");
        // Extract the array from the Bundle object

        Bundle extras = getIntent().getExtras();
        //int[] myArr = extras.getIntArray("tehilimList");
        //Test:
         int[] tehilimNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //Activate this:
       // int[] tehilimNumbers = extras.getIntArray("tehilimNumbers");
        int singleTehilim = extras.getInt("TehilimNo");
        int month = extras.getInt("month");

        ArrayList<String> mylist = new ArrayList<String>();
        mylist.clear();
        //mylist.add(TehilimClass.getTehilim("tr77")); //this adds an element to the list.
        //Log.i("tehilimNumbers", String.valueOf(tehilimNumbers[0]));

        for (int i = tehilimNumbers[0]; i < tehilimNumbers[0] + tehilimNumbers.length; i++) {
            //readTehilimMap.put("Tehilim", TehilimClass.getTehilim("tr" + i));
            mylist.add(TehilimClass.getTehilim("tr" + i)); //this adds an element to the list.
            Log.i("mylist", String.valueOf(mylist));
            //Log.i("For lop in read tehilim", "For lop in read tehilim: " +  i);
            //Log.i("Value", String.valueOf(readTehilimMap));
        }

        if(singleTehilim == 23)
        {        mylist.clear();
            mylist.add(TehilimClass.getTehilim("tr" + 23)); //this adds an element to the list.
        }
        tehilimtrListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.content_tum_kitap, R.id.textViewFortehilimtr, mylist);
        tehilimtrListView.setAdapter(arrayAdapter);
        Log.i("summy tag", "Dummy comment");
        Log.i("month", String.valueOf(month));
        // printtehilimtr.setText(R.stritextViewFortehilimtrng.perek1);
        // printtehilimtr.append(printtehilimtr + getResources().getString(R.string.perek2));
        int[] test;
        while (MonthlyOrder.getMonthlyOrder("1") != null) {
            test = MonthlyOrder.getMonthlyOrder("1");
            Log.i("values", String.valueOf(test));
        }
    }

    private void setSupportActionBar(Toolbar myToolbar) {
    }
}