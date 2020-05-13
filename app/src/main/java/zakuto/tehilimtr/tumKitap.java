package zakuto.tehilimtr;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import zakuto.tehilimtr.R;

public class tumKitap extends AppCompatActivity {
    public TextView printTeilim;
ListView teilimListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tum_kitap);

        String teilim1 = getResources().getString(R.string.perek1);
        String teilim2 = getResources().getString(R.string.perek2);
        String teilim3 = getResources().getString(R.string.perek3);
        String teilim4 = getResources().getString(R.string.perek4);
        String teilim5 = getResources().getString(R.string.perek5);
        String teilim6 = getResources().getString(R.string.perek6);
        String teilim7 = getResources().getString(R.string.perek7);
        String teilim8 = getResources().getString(R.string.perek8);
        String teilim9 = getResources().getString(R.string.perek9);
        String teilim10 = getResources().getString(R.string.perek10);

        String array1[] = {teilim1,
                teilim2,
                teilim3,
                teilim4,
                teilim5,
                teilim6,
                teilim7,
                teilim8,
                teilim9,
                teilim10};

        teilimListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.content_tum_kitap, R.id.textViewForTeilim, array1);
        teilimListView.setAdapter(arrayAdapter);



        // printTeilim = findViewById(R.id.printTeilim);
       // printTeilim.setText(R.stritextViewForTeilimng.perek1);
       // printTeilim.append(printTeilim + getResources().getString(R.string.perek2));
    }

}
