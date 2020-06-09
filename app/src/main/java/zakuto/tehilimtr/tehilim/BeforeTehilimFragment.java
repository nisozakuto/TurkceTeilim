package zakuto.tehilimtr.tehilim;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import zakuto.tehilimtr.R;

public class BeforeTehilimFragment extends Fragment {
    TextView preTehilimText;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_before_tehilim, container, false);
        preTehilimText = view.findViewById(R.id.preTehilimText);
        preTehilimText.setMovementMethod(new ScrollingMovementMethod());
        preTehilimText.setText(R.string.preTehilimText);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(BeforeTehilimFragment.this)
                        .navigate(R.id.action_PreTehilimFragment_to_TehilimFragment);
            }
        });

    }
}