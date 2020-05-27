package zakuto.tehilimtr.ui.Browse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import zakuto.tehilimtr.FullBookFragment;
import zakuto.tehilimtr.MonthlyFragment;
import zakuto.tehilimtr.R;


public class BrowseFragment extends Fragment {

    private BrowseViewModel dashboardViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

/*
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(MonthlyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.textViewFortehilimtr);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browse, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) view.findViewById(R.id.result_tabs1);
        tabs.setupWithViewPager(viewPager);
        return view;
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new MonthlyFragment(), "Aylık Düzen");
        adapter.addFragment(new FullBookFragment(), "Tüm Kitap");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

/*

 */
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 * <p>
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 *
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment SmsFragment.
 * <p>
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment SmsFragment.
 *//*

public class DashboardFragment<position> extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String[] monthlyTehilimArray = {"1.Kitap 1-9", "2.Kitap 10-17", "3.Kitap 18-22", "4.Kitap 23-28", "5.Kitap 29-34", "6.Kitap 35-38", "7.Kitap 39-43", "8.Kitap 44-48", "9.Kitap 49-54", "10.Kitap 55-59", "11.Kitap 60-65", "12.Kitap 66-68", "13.Kitap 69-71", "14.Kitap 72-76", "15.Kitap 77-78", "16.Kitap 79-82", "17.Kitap 83-87", "18.Kitap 88-89", "19.Kitap 90-96", "20.Kitap 97-103", "21.Kitap 104-105", "22.Kitap 106-107", "23.Kitap 108-112", "24.Kitap 113-118", "25.Kitap 119-1-96", "26.Kitap 119-97-176", "27.Kitap 120-134", "28.Kitap 135-139", "29.Kitap 140-144", "30.Kitap 145-150"};
    private String[] dailyTehilimArray = {"1.Gün", "2.Gün", "3.Gün", "4.Gün", "5.Gün", "6.Gün", "7.Gün", "8.Gün", "9.Gün", "10.Gün", "11.Gün", "12.Gün", "13.Gün", "14.Gün", "15.Gün", "16.Gün", "17.Gün", "18.Gün", "19.Gün", "20.Gün", "21.Gün", "22.Gün", "23.Gün", "24.Gün", "25.Gün", "26.Gün", "27.Gün", "28.Gün"};

    public DashboardFragment() {
        // Required empty public constructor
    }

    */
/**
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 *
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment SmsFragment.
 *//*

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

        */
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
    };*//*

        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, monthlyTehilimArray);
        listView.setAdapter(listviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                position += 1;
                //Toast.makeText(getActivity(), "Stop Clicking me"+ position, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Gün " + position + " açılıyor!", Toast.LENGTH_SHORT).show();
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
   */
/* @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }*//*
}
*/
