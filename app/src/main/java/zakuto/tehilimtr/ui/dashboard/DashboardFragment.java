package zakuto.tehilimtr.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import zakuto.tehilimtr.R;
import zakuto.tehilimtr.readTehilim;

/*

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
*/

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment<position> extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int[] passTehilimValues = new int[]{};

    String[] monthlyTehilimArray = {"1.Kitap 1-9", "2.Kitap 10-17", "3.Kitap 18-22", "4.Kitap 23-28", "5.Kitap 29-34", "6.Kitap 35-38", "7.Kitap 39-43", "8.Kitap 44-48", "9.Kitap 49-54", "10.Kitap 55-59", "11.Kitap 60-65", "12.Kitap 66-68", "13.Kitap 69-71", "14.Kitap 72-76", "15.Kitap 77-78", "16.Kitap 79-82", "17.Kitap 83-87", "18.Kitap 88-89", "19.Kitap 90-96", "20.Kitap 97-103", "21.Kitap 104-105", "22.Kitap 106-107", "23.Kitap 108-112", "24.Kitap 113-118", "25.Kitap 119-1-96", "26.Kitap 119-97-176", "27.Kitap 120-134", "28.Kitap 135-139", "29.Kitap 140-144", "30.Kitap 145-150"};
    private String[] dailyTehilimArray = {"1.Gün", "2.Gün", "3.Gün", "4.Gün", "5.Gün", "6.Gün", "7.Gün", "8.Gün", "9.Gün", "10.Gün", "11.Gün", "12.Gün", "13.Gün", "14.Gün", "15.Gün", "16.Gün", "17.Gün", "18.Gün", "19.Gün", "20.Gün", "21.Gün", "22.Gün", "23.Gün", "24.Gün", "25.Gün", "26.Gün", "27.Gün", "28.Gün"};

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SmsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ListView listView = (ListView) view.findViewById(R.id.orderListView);
        /*        listView.setOnClickListener(new AdapterView.OnItemClickListener()){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
            int position, long arg3) {
                // TODO Auto-generated method stub
                String category = categories[position];
                Class activityClass = lookupActivityClass_byName(category);
                //You could lookup by position, but "name" is more general
                Intent intent = new Intent(getActivity(), activityClass);
                startActivity(intent);
            }
        });
    };*/
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, monthlyTehilimArray);
        listView.setAdapter(listviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                position += 1;
                //Toast.makeText(getActivity(), "Stop Clicking me"+ position, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Stop Clicking me" + position, Toast.LENGTH_SHORT).show();
                // Then you start a new Activity via Intent
                Intent readTehilimIntent = new Intent(getActivity(), readTehilim.class);
                monthlyOrder(position);
                readTehilimIntent.putExtra("tehilimNumbers", passTehilimValues);
                //readTehilimIntent.putExtra("month", position);
                startActivity(readTehilimIntent);
            }
        });
        return view;
    }

    public int[] monthlyOrder(int position) {
        passTehilimValues = new int[]{};
        int index = 0;
        if (position == 1) {
            Log.i("position", String.valueOf(position));
            passTehilimValues = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            return passTehilimValues;
        }
        if (position == 2) {
            passTehilimValues = new int[]{10, 11, 12, 14, 15, 16, 17};
            return passTehilimValues;
        }

        if (position == 3) {
            passTehilimValues = new int[]{18, 19, 20, 21, 22};
            return passTehilimValues;
        }
        if (position == 4) {
            passTehilimValues = new int[]{23, 24, 25, 26, 27, 28};
            return passTehilimValues;
        }
        if (position == 5) {
            passTehilimValues = new int[]{29, 30, 31, 32, 33, 34};
            return passTehilimValues;
        }
        if (position == 6) {
            passTehilimValues = new int[]{35, 36, 37, 38};
            return passTehilimValues;
        }
        if (position == 7) {
            passTehilimValues = new int[]{39, 40, 41, 42, 43};
            return passTehilimValues;
        }
        if (position == 8) {
            passTehilimValues = new int[]{44, 45, 46, 47, 48};
            return passTehilimValues;
        }
        if (position == 9) {
            passTehilimValues = new int[]{49, 50, 51, 52, 53, 54};
            return passTehilimValues;
        }
        if (position == 10) {
            passTehilimValues = new int[]{55, 56, 57, 58, 59};
            return passTehilimValues;
        }
        if (position == 11) {
            passTehilimValues = new int[]{60, 61, 62, 63, 64, 65};
            return passTehilimValues;
        }
        if (position == 12) {
            passTehilimValues = new int[]{66, 67, 68};
            return passTehilimValues;
        }
        if (position == 13) {
            passTehilimValues = new int[]{69, 70, 71};
            return passTehilimValues;
        }
        if (position == 14) {
            passTehilimValues = new int[]{72, 73, 74, 75, 76};
            return passTehilimValues;
        }
        if (position == 15) {
            passTehilimValues = new int[]{77, 78};
            return passTehilimValues;
        }
        if (position == 16) {
            passTehilimValues = new int[]{79, 80, 81, 82};
            return passTehilimValues;
        }
        if (position == 17) {
            passTehilimValues = new int[]{83, 84, 85, 86, 87};
            return passTehilimValues;
        }
        if (position == 18) {
            passTehilimValues = new int[]{88, 89};
            return passTehilimValues;
        }
        if (position == 19) {
            passTehilimValues = new int[]{90, 91, 92, 93, 94, 95, 96};
            return passTehilimValues;
        }
        if (position == 20) {
            passTehilimValues = new int[]{97, 98, 99, 100, 101, 102, 103};
            return passTehilimValues;
        }
        if (position == 21) {
            passTehilimValues = new int[]{104, 105};
            return passTehilimValues;
        }
        if (position == 22) {
            passTehilimValues = new int[]{106, 107};
            return passTehilimValues;
        }
        if (position == 23) {
            passTehilimValues = new int[]{108, 109, 110, 111, 112};
            return passTehilimValues;
        }
        if (position == 24) {
            passTehilimValues = new int[]{113, 114, 115, 116, 117, 118};
            return passTehilimValues;
        }
        if (position == 25) {
            passTehilimValues = new int[]{119};
            return passTehilimValues;
        }
        if (position == 26) {
            passTehilimValues = new int[]{119};
            return passTehilimValues;
        }
        if (position == 27) {
            passTehilimValues = new int[]{120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134};
            return passTehilimValues;
        }
        if (position == 28) {
            passTehilimValues = new int[]{135, 136, 137, 138, 139};
            return passTehilimValues;
        }
        if (position == 29) {
            passTehilimValues = new int[]{140, 141, 142, 143, 144};
            return passTehilimValues;
        }
        if (position == 30) ;
        {
            passTehilimValues = new int[]{145, 146, 147, 148, 149, 150};
            return passTehilimValues;
        }
    }
   /* @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }*/
}
