package zakuto.tehilimtr;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class readFragment extends Fragment {

    private ReadViewModel mViewModel;
    TextView randomFragment;
    RandomTeilim RandomTeilim = new RandomTeilim();
    public static readFragment newInstance() {
        return new readFragment();
    }
    public TehilimClass TehilimClass = new TehilimClass();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Randomtehilimtr();
        View root = inflater.inflate(R.layout.read_fragment, container, false);
        randomFragment = root.findViewById(R.id.randomFragment);
        randomFragment.setText(TehilimClass.getTehilim("tr" + RandomTeilim.randomNumber()));
        return root;
    }

    public void Randomtehilimtr() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ReadViewModel.class);
        // TODO: Use the ViewModel
    }

}
