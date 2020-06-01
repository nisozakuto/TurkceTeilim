package zakuto.tehilimtr;

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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;


public class FullBookFragment extends Fragment {

    private MonthlyViewModel mViewModel;
    int[] passTehilimValues = new int[]{};
    String[] tehilimArray = new String[150];
    public TehilimClass Teilim = new TehilimClass();

    public static FullBookFragment newInstance() {
        return new FullBookFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_book, container, false);

        for (int i = 1; i < 151; i++) {
            tehilimArray[i - 1] = i + ".Teilim";
        }

        ListView fullBookListView = (ListView) view.findViewById(R.id.monthlyFragmentListView);
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tehilimArray);
        fullBookListView.setAdapter(listviewAdapter);
        fullBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                position += 1;
                Toast.makeText(getActivity(), " " + position + ".Teilim açılıyor!", Toast.LENGTH_SHORT).show();
                Log.i("position", String.valueOf(position));
                Intent intent = new Intent(getActivity(), ReadActivity.class);
                intent.putExtra("tehilim", String.valueOf(position));
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
}