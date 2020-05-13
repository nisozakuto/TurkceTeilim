package zakuto.tehilimtr;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import zakuto.tehilimtr.R;

public class Info extends AppCompatActivity {
ListView infoList;
    private ArrayAdapter aAdapter;
    private String[]  tehilimtrArray = {"1.Kitap 1-9",
            "2.Kitap 10-17",
            "3.Kitap 18-22",
            "4.Kitap 23-28",
            "5.Kitap 29-34",
            "6.Kitap 35-38",
            "7.Kitap 39-43",
            "8.Kitap 44-48",
            "9.Kitap 49-54",
            "10.Kitap 55-59",
            "11.Kitap 60-65",
            "12.Kitap 66-68",
            "13.Kitap 69-71",
            "14.Kitap 72-76",
            "15.Kitap 77-78",
            "16.Kitap 79-82",
            "17.Kitap 83-87",
            "18.Kitap 88-89",
            "19.Kitap 90-96",
            "20.Kitap 97-103",
            "21.Kitap 104-105",
            "22.Kitap 106-107",
            "23.Kitap 108-112",
            "24.Kitap 113-118",
            "25.Kitap 119-1-96",
            "26.Kitap 119-97-176",
            "27.Kitap 120-134",
            "28.Kitap 135-139",
            "29.Kitap 140-144",
            "30.Kitap 145-150"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        infoList = (ListView) findViewById(R.id.infoList);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tehilimtrArray);
        infoList.setAdapter(aAdapter);
    }
}
