package zakuto.tehilimtr.tehilim;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import zakuto.tehilimtr.R;

public class AfterTehilimFragment extends Fragment {
    TextView afterTehilimText;
    Button close;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_after_tehilim, container, false);
        afterTehilimText = view.findViewById(R.id.afterTehilimText);
        afterTehilimText.setMovementMethod(new ScrollingMovementMethod());
        afterTehilimText.setText(R.string.afterTehilimText);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      /*  view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AfterTehilimFragment.this)
                        .navigate(R.id.action_First2Fragment_to_Second2Fragment);
            }
        });
*/
      view.findViewById(R.id.closeButton).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              getActivity().finish();
          }
      });
    }
}