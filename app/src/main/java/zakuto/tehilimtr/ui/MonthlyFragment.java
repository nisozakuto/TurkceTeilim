package zakuto.tehilimtr.ui;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import zakuto.tehilimtr.MainActivity;
import zakuto.tehilimtr.MonthlyTehilimActivity;
import zakuto.tehilimtr.MonthlyViewModel;
import zakuto.tehilimtr.R;
import zakuto.tehilimtr.ReadActivity;
import zakuto.tehilimtr.readFragment;
import zakuto.tehilimtr.tehilim.TehilimFragment;

public class MonthlyFragment extends Fragment {

    private MonthlyViewModel mViewModel;
    String[] monthlyTehilimArray = {"1.Kitap 1-8", "2.Kitap 9-15", "3.Kitap 16-19", "4.Kitap 20-25", "5.Kitap 26-31", "6.Kitap 32-35", "7.Kitap 36-39", "8.Kitap 40-44", "9.Kitap 45-49", "10.Kitap 50-55", "11.Kitap 56-61", "12.Kitap 62-67", "13.Kitap 68-70", "14.Kitap 71-75", "15.Kitap 76-78", "16.Kitap 79-84", "17.Kitap 85-89", "18.Kitap 90-95", "19.Kitap 96-102", "20.Kitap 103-105", "21.Kitap 106-108", "22.Kitap 109-115", "23.Kitap 116-119 Zayin", "24.Kitap 119 HET", "25.Kitap 120-131", "26.Kitap 132-138", "27.Kitap 139-144", "28.Kitap 145-150"};
    TehilimFragment nextFrag = new TehilimFragment();
    Bundle bundle = new Bundle();

    public static MonthlyFragment newInstance() {
        return new MonthlyFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.monthly_fragment, container, false);
        Log.i("Current", "MonthlyFragment");
        ListView monthlyListView = (ListView) view.findViewById(R.id.monthlyFragmentListView);
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, monthlyTehilimArray);
        monthlyListView.setAdapter(listviewAdapter);
        monthlyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                position += 1;
                //Toast.makeText(getActivity(), "Gün " + position + " açılıyor!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ReadActivity.class);
                //Bottom two lines fo not work because we use fragments and currently, i am not pulling those values in the fragment
                intent.putExtra("kitap", String.valueOf(position));
                intent.putExtra("fragmentKey", "monthly");
                startActivity(intent);

            /*  TehilimFragment nextFrag = new TehilimFragment();
                bundle.putString("bookNumber", String.valueOf(position));
                bundle.putString("fragmentKey", "bookNumber");
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();*/
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

    public void onResume() {
        super.onResume();
        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Teilim Kitapları");
    }
}