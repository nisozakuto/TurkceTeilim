package zakuto.tehilimtr.ui;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import zakuto.tehilimtr.FragmentReadSingle;
import zakuto.tehilimtr.MainActivity;
import zakuto.tehilimtr.MonthlyViewModel;
import zakuto.tehilimtr.R;
import zakuto.tehilimtr.RandomTehilim;
import zakuto.tehilimtr.ReadActivity;
import zakuto.tehilimtr.TehilimClass;
import zakuto.tehilimtr.readFragment;
import zakuto.tehilimtr.tehilim.TehilimFragment;

public class FullBookFragment extends Fragment {

    private MonthlyViewModel mViewModel;
    int[] passTehilimValues = new int[]{};
    String[] tehilimArray = new String[150];
    public TehilimClass Teilim = new TehilimClass();
    TehilimFragment nextFrag = new TehilimFragment();
    Bundle bundle = new Bundle();

    public static FullBookFragment newInstance() {
        return new FullBookFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_book, container, false);
        Log.i("Current", "FullBookFragment");

        for (int i = 1; i < 151; i++) {
            tehilimArray[i - 1] = i + ".Teilim";
        }

        ListView fullBookListView = (ListView) view.findViewById(R.id.fragmentFullBookListView);
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tehilimArray);
        fullBookListView.setAdapter(listviewAdapter);
        fullBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                position += 1;
                //Toast.makeText(getActivity(), " " + position + ".Teilim açılıyor!", Toast.LENGTH_SHORT).show();
                Log.i("Niso", "position" + position);
/*                TehilimFragment nextFrag = new TehilimFragment();
                bundle.putString("singleTehilim", String.valueOf(position));
                bundle.putString("fragmentKey", "singleTehilim");
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();*/
                Intent intent = new Intent(getActivity(), ReadActivity.class);
                intent.putExtra("fragmentKey", "singleTehilim");
                intent.putExtra("singleTehilim", String.valueOf(position));
                startActivity(intent);
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

    public void onResume() {
        super.onResume();
        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Tüm Kitap");

    }
}