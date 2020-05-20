package zakuto.tehilimtr;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import zakuto.tehilimtr.R;

public class OrderActivity extends AppCompatActivity {
    ListView infoList;
    String order;
    private ArrayAdapter aAdapter;
    private String[] monthlyTehilimArray = {"1.Kitap 1-9","2.Kitap 10-17","3.Kitap 18-22", "4.Kitap 23-28","5.Kitap 29-34","6.Kitap 35-38","7.Kitap 39-43","8.Kitap 44-48","9.Kitap 49-54","10.Kitap 55-59","11.Kitap 60-65","12.Kitap 66-68","13.Kitap 69-71","14.Kitap 72-76","15.Kitap 77-78","16.Kitap 79-82","17.Kitap 83-87","18.Kitap 88-89","19.Kitap 90-96","20.Kitap 97-103","21.Kitap 104-105","22.Kitap 106-107","23.Kitap 108-112","24.Kitap 113-118","25.Kitap 119-1-96","26.Kitap 119-97-176","27.Kitap 120-134","28.Kitap 135-139","29.Kitap 140-144","30.Kitap 145-150"};
    private String[] dailyTehilimArray = {"1.Gün","2.Gün","3.Gün","4.Gün","5.Gün","6.Gün","7.Gün","8.Gün","9.Gün","10.Gün","11.Gün","12.Gün","13.Gün","14.Gün","15.Gün","16.Gün","17.Gün","18.Gün","19.Gün","20.Gün","21.Gün","22.Gün","23.Gün","24.Gün","25.Gün","26.Gün","27.Gün","28.Gün"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle extras = getIntent().getExtras();
        order = extras.getString("order");

        infoList = (ListView) findViewById(R.id.infoList);
        if(order == "monthly"){
            aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monthlyTehilimArray);
        }
        if(order == "daily")
        {
            aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dailyTehilimArray);
        }
        infoList.setAdapter(aAdapter);
    }
}
