package zakuto.tehilimtr;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

public class FullBookFragment extends Fragment {

    private MonthlyViewModel mViewModel;
    int[] passTehilimValues = new int[]{};
    String[] monthlyTehilimArray = {"1.Kitap 1-9", "2.Kitap 10-17", "3.Kitap 18-22", "4.Kitap 23-28", "5.Kitap 29-34", "6.Kitap 35-38", "7.Kitap 39-43", "8.Kitap 44-48", "9.Kitap 49-54", "10.Kitap 55-59", "11.Kitap 60-65", "12.Kitap 66-68", "13.Kitap 69-71", "14.Kitap 72-76", "15.Kitap 77-78", "16.Kitap 79-82", "17.Kitap 83-87", "18.Kitap 88-89", "19.Kitap 90-96", "20.Kitap 97-103", "21.Kitap 104-105", "22.Kitap 106-107", "23.Kitap 108-112", "24.Kitap 113-118", "25.Kitap 119-1-96", "26.Kitap 119-97-176", "27.Kitap 120-134", "28.Kitap 135-139", "29.Kitap 140-144", "30.Kitap 145-150"};

    public static FullBookFragment newInstance() {
        return new FullBookFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_book, container, false);
        ListView monthlyListView = (ListView) view.findViewById(R.id.monthlyFragmentListView);
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, monthlyTehilimArray);
        monthlyListView.setAdapter(listviewAdapter);
        monthlyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                position += 1;
                Toast.makeText(getActivity(), "Gün " + position + " açılıyor!", Toast.LENGTH_SHORT).show();
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.monthlyFragmentId, new readFragment());
                fr.commit();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MonthlyViewModel.class);
        // TODO: Use the ViewModel
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
}