package zakuto.tehilimtr.tehilim;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import zakuto.tehilimtr.BerahaText;
import zakuto.tehilimtr.R;
import zakuto.tehilimtr.TextAdapter;

public class BeforeTehilimFragment extends Fragment {
    Bundle bundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_before_and_after, container, false);
        Log.i("Current", "BeforeTehilimFragment");

        /* preTehilimText = view.findViewById(R.id.preTehilimText);
        preTehilimText.setMovementMethod(new ScrollingMovementMethod());
        preTehilimText.setText(R.string.preTehilimText);
        preTehilimText.setTextSize(Float.valueOf(fontSize));*/
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String beforeTextString = getString(R.string.beforeTehilimText);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        BerahaText before = new BerahaText(beforeTextString);
        ArrayList<BerahaText> berahaList = new ArrayList<>();
        berahaList.add(before);

        TextAdapter adapter = new TextAdapter(getActivity(), R.layout.adapter_text_layout, berahaList);
        listView.setAdapter(adapter);

        getActivity().setTitle("Kitap Düzeni");
        final Fragment nextFrag = new TehilimFragment();
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   NavHostFragment.findNavController(BeforeTehilimFragment.this)
                        .navigate(R.id.action_PreTehilimFragment_to_TehilimFragment);*/
              /*  bundle.putString("bookNumber", String.valueOf(position));
                bundle.putString("fragmentKey", "bookNumber");
                nextFrag.setArguments(bundle);*/
                bundle.putString("fragmentKey", "monthly");
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}