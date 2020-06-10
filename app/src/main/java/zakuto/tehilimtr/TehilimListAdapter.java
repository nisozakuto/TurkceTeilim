package zakuto.tehilimtr;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class TehilimListAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> countryList;
    LayoutInflater inflter;
    float fontSize;

    public TehilimListAdapter(Context applicationContext, ArrayList<String> countryList) {
        this.context = applicationContext;
        this.countryList = countryList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.listview_text, null);
        TextView text1 = (TextView) view.findViewById(R.id.text1);
        text1.setText(countryList.get(i));


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String testFontSize = sharedPreferences.getString("font_size_preference", "");
        Log.i("listAdapter", testFontSize);

//      text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.parseFloat(context.getSharedPreferences("PATH", Context.MODE_PRIVATE).getString("p", "Error")));
        text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.valueOf(testFontSize));

        return view;
    }

    private String s;

    public TehilimListAdapter(String s) {
        this.s = s;
    }

    public void showToast(Context c) {
        String pref = c.getSharedPreferences("SHAREDPREFFORADAPTER", Context.MODE_PRIVATE).getString("p", "Error");
        Toast.makeText(c.getApplicationContext(), s + pref, Toast.LENGTH_LONG).show();
        Log.i("fontSize", "adapterde  " + pref);
        fontSize = Integer.parseInt(pref);
    }
}