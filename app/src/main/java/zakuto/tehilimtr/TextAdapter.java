package zakuto.tehilimtr;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TextAdapter extends ArrayAdapter<BerahaText> {

    private Context mContext;
    int mResource;
    String testFontSize = "16";


    public TextAdapter(@NonNull Context context, int resource, @NonNull ArrayList<BerahaText> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String text = getItem(position).getText();
        BerahaText berahaText = new BerahaText(text);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        testFontSize = sharedPreferences.getString("font_size_preference", "14");

        TextView textView = (TextView) convertView.findViewById(R.id.adapterText);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Float.valueOf(testFontSize));
        return convertView;
    }
}
