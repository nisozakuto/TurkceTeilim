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
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TehilimListAdapter extends ArrayAdapter<Tehilim> {
    private Context mContext;
    int mresource;
    String testFontSize = "16";

    public TehilimListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Tehilim> objects) {
        super(context, resource, objects);
        mContext = context;
        mresource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String latin = getItem(position).getLatin();
        String hebrew = getItem(position).getHebrew();
        Tehilim perek = new Tehilim(latin, hebrew);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mresource, parent, false);
        TextView leftText = (TextView) convertView.findViewById(R.id.leftText);
        TextView rightText = (TextView) convertView.findViewById(R.id.rightText);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        testFontSize = sharedPreferences.getString("font_size_preference", "14");

        leftText.setText(latin);
        rightText.setText(hebrew);
        leftText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Float.valueOf(testFontSize));
        rightText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Float.valueOf(testFontSize));
        return convertView;
    }

}


















