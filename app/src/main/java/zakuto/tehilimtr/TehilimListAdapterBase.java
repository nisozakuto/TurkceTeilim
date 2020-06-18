package zakuto.tehilimtr;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TehilimListAdapterBase extends BaseAdapter {
    Context context;
    ArrayList<Tehilim> teilimList;
    LayoutInflater inflter;
    int fontSize = 16;
    String testFontSize = "16";

    public TehilimListAdapterBase(Context applicationContext, ArrayList<Tehilim> latinTeilim) {
        this.context = applicationContext;
        this.teilimList = latinTeilim;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return teilimList.size();
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
        view = inflter.inflate(R.layout.adapter_listview_layout, null);
        TextView leftText = (TextView) view.findViewById(R.id.leftText);
        TextView rightText = (TextView) view.findViewById(R.id.rightText);
        //leftText.setText(teilimList.get(i));

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        testFontSize = sharedPreferences.getString("font_size_preference", "");
        Log.i("Niso", "Test font size: " + testFontSize + "in TehilimListAdapter.java");

        //text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.parseFloat(context.getSharedPreferences("PATH", Context.MODE_PRIVATE).getString("p", "Error")));
        if (testFontSize.equals(""))
            testFontSize = "16";
        leftText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Float.valueOf(testFontSize));
        rightText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Float.valueOf(testFontSize));
        return view;
    }

    private String s;

    public TehilimListAdapterBase(String s) {
        this.s = s;
    }

    public void showToast(Context c) {
        String pref = c.getSharedPreferences("SHAREDPREFFORADAPTER", Context.MODE_PRIVATE).getString("p", "Error");
        Toast.makeText(c.getApplicationContext(), s + pref, Toast.LENGTH_LONG).show();
        Log.i("fontSize", "adapterde  " + pref);
        fontSize = Integer.parseInt(pref);
    }
}