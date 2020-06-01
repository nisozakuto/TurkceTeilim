package zakuto.tehilimtr;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import zakuto.tehilimtr.ui.Browse.BrowseFragment;

public class MonthlyFragment extends Fragment {

    private MonthlyViewModel mViewModel;
    String[] monthlyTehilimArray = {"1.Kitap 1-9", "2.Kitap 10-17", "3.Kitap 18-22", "4.Kitap 23-28", "5.Kitap 29-34", "6.Kitap 35-38", "7.Kitap 39-43", "8.Kitap 44-48", "9.Kitap 49-54", "10.Kitap 55-59", "11.Kitap 60-65", "12.Kitap 66-68", "13.Kitap 69-71", "14.Kitap 72-76", "15.Kitap 77-78", "16.Kitap 79-82", "17.Kitap 83-87", "18.Kitap 88-89", "19.Kitap 90-96", "20.Kitap 97-103", "21.Kitap 104-105", "22.Kitap 106-107", "23.Kitap 108-112", "24.Kitap 113-118", "25.Kitap 119-1-96", "26.Kitap 119-97-176", "27.Kitap 120-134", "28.Kitap 135-139", "29.Kitap 140-144", "30.Kitap 145-150"};

    public static MonthlyFragment newInstance() {
        return new MonthlyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.monthly_fragment, container, false);

        ListView monthlyListView = (ListView) view.findViewById(R.id.monthlyFragmentListView);
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, monthlyTehilimArray);
        monthlyListView.setAdapter(listviewAdapter);
        monthlyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                position += 1;
                Toast.makeText(getActivity(), "Gün " + position + " açılıyor!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ReadActivity.class);
                intent.putExtra("kitap", String.valueOf(position));
                startActivity(intent);
            }
        });
        return view;
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MonthlyViewModel.class);
        // TODO: Use the ViewModel
    }

}
