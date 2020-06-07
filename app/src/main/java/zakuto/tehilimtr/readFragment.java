package zakuto.tehilimtr;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class readFragment extends Fragment implements View.OnClickListener {

    private ReadViewModel mViewModel;
    TextView randomTextView;
    Button randomButton;
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

        randomTextView = root.findViewById(R.id.randomFragment);
        randomTextView.setMovementMethod(new ScrollingMovementMethod());
        randomTextView.setText(TehilimClass.getTehilim("tr" + RandomTeilim.randomNumber()));
        randomButton = root.findViewById(R.id.randomButton);
        randomButton.setOnClickListener(this);
        return root;
        //Make the button round edged = This is done.
    }

    public void Randomtehilimtr() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ReadViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.randomButton:
                randomTextView.setText(TehilimClass.getTehilim("tr" + RandomTeilim.randomNumber()));
                break;
        }
    }
}
