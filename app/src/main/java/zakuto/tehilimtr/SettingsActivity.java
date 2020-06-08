package zakuto.tehilimtr;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
    private static final String TAG = SettingsActivity.class.getSimpleName();
int fontSize = 14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("fontSize", fontSize);
        myEdit.apply();
    }
}

    /*
    public static class FontFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.font_preferences, rootKey);

            *//*EditTextPreference signaturePreference = findPreference("fontKey");
            if (signaturePreference != null) {
                signaturePreference.setVisible(true);
            }
            EditTextPreference countingPreference = findPreference("fontKey");

            if (countingPreference != null) {
                countingPreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                    @Override
                    public CharSequence provideSummary(EditTextPreference preference) {
                        String text = preference.getText();
                        if (TextUtils.isEmpty(text)){
                            return "Not set";
                        }
                        return "Length of saved value: " + text.length();
                    }
                });
            }*//*
        }
    }
}*/