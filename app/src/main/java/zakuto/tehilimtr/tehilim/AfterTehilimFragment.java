package zakuto.tehilimtr.tehilim;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

import zakuto.tehilimtr.BerahaText;
import zakuto.tehilimtr.R;
import zakuto.tehilimtr.TextAdapter;

public class AfterTehilimFragment extends Fragment {
    TextView afterTehilimText;
    Button next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_before_and_after, container, false);
        Log.i("Current", "AfterTehilimFragment");
        next = (Button) view.findViewById(R.id.next);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String beforeTextString = getString(R.string.afterTehilimText);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        BerahaText after = new BerahaText(beforeTextString);
        ArrayList<BerahaText> berahaList = new ArrayList<>();
        berahaList.add(after);

        TextAdapter adapter = new TextAdapter(getActivity(), R.layout.adapter_text_layout, berahaList);
        listView.setAdapter(adapter);

        /*view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AfterTehilimFragment.this)
                        .navigate(R.id.action_First2Fragment_to_Second2Fragment);
            }
        });
        */
        next.setText("Bitir");
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }
}