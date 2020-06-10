package zakuto.tehilimtr.tehilim;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

import zakuto.tehilimtr.MonthlyOrder;
import zakuto.tehilimtr.R;
import zakuto.tehilimtr.TehilimClass;

public class TehilimFragment extends Fragment {
    TextView TehilimText;
    ListView list;
    String kitapExtra, layout = "latin";
    ArrayList<String> mylist = new ArrayList<String>();
    int[] passTehilimValues = new int[]{};
    public MonthlyOrder order = new MonthlyOrder();
    public TehilimClass TehilimClass = new TehilimClass();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_tehilim, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TehilimFragment.this)
                        .navigate(R.id.action_TehilimFragment_to_afterTehilimFragment);
            }
        });
        list = view.findViewById(R.id.listView);
        Intent intent = getActivity().getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            kitapExtra = (String) b.get("kitap");
        }
        if (layout != null) {
            chooseLayout();
        }
    }

    public void chooseLayout() {
        if (layout.equals("latin")) {
            latinTehilim();
        }
        if (layout.equals("hebrew")) {
            hebrewTehilim();
        }
    }

    public void latinTehilim() {
        if (kitapExtra != null) {
            order.monthlyOrder(Integer.parseInt(kitapExtra));
            mylist.clear();
            if (kitapExtra == "23") {
                mylist.add(TehilimClass.getTehilim("tr116")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("tr117")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("tr118")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("tr1191")); //this adds an element to the list.
            } else if (kitapExtra == "24") {
                mylist.add(TehilimClass.getTehilim("tr1192")); //this adds an element to the list.
            } else {
                for (int i = order.monthlyOrder(Integer.parseInt(kitapExtra))[0]; i < order.monthlyOrder(Integer.parseInt(kitapExtra))[0] + order.monthlyOrder(Integer.parseInt(kitapExtra)).length; i++) {
                    mylist.add(TehilimClass.getTehilim("tr" + i)); //this adds an element to the list.
                }
            }

        }
        setListView();
    }

    public void hebrewTehilim() {
        if (kitapExtra != null) {
            order.monthlyOrder(Integer.parseInt(kitapExtra));
            mylist.clear();
            if (kitapExtra == "23") {
                mylist.add(TehilimClass.getTehilim("H_perek116")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek117")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek118")); //this adds an element to the list.
                mylist.add(TehilimClass.getTehilim("H_perek1191")); //this adds an element to the list.
            } else if (kitapExtra == "24") {
                mylist.add(TehilimClass.getTehilim("H_perek1192")); //this adds an element to the list.
            } else {
                for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                    mylist.add(TehilimClass.getTehilim("H_perek" + i)); //this adds an element to the list.
                }
            }
        }
        setListView();
    }

    public void setListView() {
        list.setAdapter(null);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mylist);
        list.setAdapter(arrayAdapter);

    }
}