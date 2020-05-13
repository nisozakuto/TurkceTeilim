package zakuto.tehilimtr;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import zakuto.tehilimtr.R;

public class tumKitap extends AppCompatActivity {
    public TextView printtehilimtr;
ListView tehilimtrListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tum_kitap);

        String tehilimtr1 = getResources().getString(R.string.perek1);
        String tehilimtr2 = getResources().getString(R.string.perek2);
        String tehilimtr3 = getResources().getString(R.string.perek3);
        String tehilimtr4 = getResources().getString(R.string.perek4);
        String tehilimtr5 = getResources().getString(R.string.perek5);
        String tehilimtr6 = getResources().getString(R.string.perek6);
        String tehilimtr7 = getResources().getString(R.string.perek7);
        String tehilimtr8 = getResources().getString(R.string.perek8);
        String tehilimtr9 = getResources().getString(R.string.perek9);
        String tehilimtr10 = getResources().getString(R.string.perek10);
        String tehilimtr11 = getResources().getString(R.string.perek11);
        String tehilimtr12 = getResources().getString(R.string.perek12);
        String tehilimtr13 = getResources().getString(R.string.perek13);
        String tehilimtr14 = getResources().getString(R.string.perek14);
        String tehilimtr15 = getResources().getString(R.string.perek15);

        //üzerine ekleme denemesi

        //deneme

        String array1[] = {tehilimtr1,
                tehilimtr2,
                tehilimtr3,
                tehilimtr4,
                tehilimtr5,
                tehilimtr6,
                tehilimtr7,
                tehilimtr8,
                tehilimtr9,
                tehilimtr10};

        tehilimtrListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.content_tum_kitap, R.id.textViewFortehilimtr, array1);
        tehilimtrListView.setAdapter(arrayAdapter);



        // printtehilimtr = findViewById(R.id.printtehilimtr);
       // printtehilimtr.setText(R.stritextViewFortehilimtrng.perek1);
       // printtehilimtr.append(printtehilimtr + getResources().getString(R.string.perek2));
    }

}
