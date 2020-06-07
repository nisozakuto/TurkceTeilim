package zakuto.tehilimtr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity implements InfoFragment.FragmentInfoListener, InfoDetailFragment.FragmentInfoDetailListener {
    private InfoFragment InfoFragment;
    private InfoDetailFragment InfoDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        InfoFragment = new InfoFragment();
        InfoDetailFragment = new InfoDetailFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, InfoFragment)
                .replace(R.id.container_b, InfoDetailFragment)
                .commit();
    }

    @Override
    public void onInputInfoDetailSent(CharSequence input) {
        InfoFragment.updateEditText(input);
    }

    @Override
    public void onInputInfoSent(CharSequence input) {
        InfoDetailFragment.updateEditText(input);
    }
    /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_info,
                container, false);
        return view;
    }
*/
}