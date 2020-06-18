package zakuto.tehilimtr.tehilim;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

import zakuto.tehilimtr.MonthlyOrder;
import zakuto.tehilimtr.R;
import zakuto.tehilimtr.RandomTehilim;
import zakuto.tehilimtr.Tehilim;
import zakuto.tehilimtr.TehilimClass;
import zakuto.tehilimtr.TehilimListAdapter;

import static android.content.Context.MODE_PRIVATE;

public class TehilimFragment extends Fragment {
    ListView list;
    String fragmentKey, kitapExtra, layout = "latin";
    ArrayList<String> mylist = new ArrayList<String>();
    int[] passTehilimValues = new int[]{};
    public MonthlyOrder order = new MonthlyOrder();
    public TehilimClass TehilimClass = new TehilimClass();
    int x = 0;
    final FragmentManager mFragmentmanager = getFragmentManager();
    private static final String TAG = "TehilimFragment.java";
    ArrayList<Tehilim> latinAndHebrewList = new ArrayList<>();
    Tehilim[] perek = new Tehilim[153];
    int intSingleTehilim;
    RandomTehilim randomTehilim = new RandomTehilim();
    //Bundle keys
    String singleTehilim;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        Log.i(TAG, "Started");
        Log.i("Current", "TehilimFragment");
        return inflater.inflate(R.layout.fragment_tehilim, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TehilimFragment.this)
                        .navigate(R.id.action_TehilimFragment_to_afterTehilimFragment);
            }
        });*/
        // BookNumber ve BookofDay ayni degeri ayni deger'e, kitap numarasina ihtiyaclari var.

        list = view.findViewById(R.id.listView);
        list.setAdapter(null);
        Intent intent = getActivity().getIntent();
        final Bundle b = intent.getExtras();
        Button next = (Button) view.findViewById(R.id.next);
        Fragment selectedFragment;

        if (b != null) {
            fragmentKey = (String) b.get("fragmentKey");
            if (fragmentKey.equals("singleTehilim")) {
                singleTehilim = (String) b.get("singleTehilim");
                intSingleTehilim = Integer.parseInt(singleTehilim);
                singleTehilimFunction();
                getActivity().setTitle("Tek Teilim");
            } else if (fragmentKey.equals("bookOfDay")) {
                kitapExtra = (String) b.get("bookOfDay");
                kitapFunction();
                //next.setVisibility(View.GONE);
                next.setText("Bitir.");
                getActivity().setTitle("Günün Kitabı");
            } else if (fragmentKey.equals("monthly")) {
                kitapExtra = (String) b.get("kitap");
                Log.i("Niso", kitapExtra);
                kitapFunction();
                getActivity().setTitle("Kitap Düzeni");
            } else if (fragmentKey.equals("bookNumber2")) {
                kitapExtra = (String) b.get("kitap");
                Log.i("Niso", kitapExtra);
                kitapFunction();
                getActivity().setTitle("Kitap Düzeni");
            } else if (fragmentKey.equals("randomTehilim")) {
                singleTehilim = (String) b.get("randomTehilim");
                intSingleTehilim = Integer.parseInt(singleTehilim);
                singleTehilimFunction();
                getActivity().setTitle("Rastgele");
                next.setText("Rastgele");

            }

        }
        setListView();

        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b != null) {
                    fragmentKey = (String) b.get("fragmentKey");
                    if (fragmentKey.equals("singleTehilim")) {
                        intSingleTehilim++;
                        singleTehilimFunction();
                    } else if (fragmentKey.equals("bookOfDay")) {
                        /*kitapExtra = (String) b.get("bookOfDay");
                        kitapFunction();*/
                        getActivity().onBackPressed();
                    } else if (fragmentKey.equals("monthly")) {
                        Fragment nextFrag;
                        nextFrag = new AfterTehilimFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                                .addToBackStack(null)
                                .commit();
                    } else if (fragmentKey.equals("bookNumber2")) {
                        Fragment nextFrag;
                        nextFrag = new AfterTehilimFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                                .addToBackStack(null)
                                .commit();
                    } else if (fragmentKey.equals("randomTehilim")) {
                        intSingleTehilim = randomTehilim.randomNumber();
                        singleTehilimFunction();
                    }
                    setListView();
                }

            }
        });
    }

    public void singleTehilimFunction() {
        latinAndHebrewList.clear();
        perek[intSingleTehilim] = new Tehilim(TehilimClass.getTehilim("tr" + intSingleTehilim), TehilimClass.getTehilim("H_perek" + intSingleTehilim));
        latinAndHebrewList.add(perek[intSingleTehilim]);
    }

    public void kitapFunction() {
        monthlyOrder(Integer.parseInt(kitapExtra));
        if (kitapExtra.equals("23")) {
            perek[116] = new Tehilim(TehilimClass.getTehilim("tr116"), TehilimClass.getTehilim("H_perek116")); //this adds an element to the list.
            perek[117] = new Tehilim(TehilimClass.getTehilim("tr117"), TehilimClass.getTehilim("H_perek117")); //this adds an element to the list.
            perek[118] = new Tehilim(TehilimClass.getTehilim("tr118"), TehilimClass.getTehilim("H_perek118")); //this adds an element to the list.
            perek[151] = new Tehilim(TehilimClass.getTehilim("tr151"), TehilimClass.getTehilim("H_perek151")); //this adds an element to the list.
            latinAndHebrewList.add(perek[116]);
            latinAndHebrewList.add(perek[117]);
            latinAndHebrewList.add(perek[118]);
            latinAndHebrewList.add(perek[151]);

        } else if (kitapExtra.equals("24")) {
            perek[152] = new Tehilim(TehilimClass.getTehilim("tr152"), TehilimClass.getTehilim("H_perek152"));
            latinAndHebrewList.add(perek[152]);
        } else {
            for (int i = passTehilimValues[0]; i < passTehilimValues[0] + passTehilimValues.length; i++) {
                perek[i - 1] = new Tehilim(TehilimClass.getTehilim("tr" + i), TehilimClass.getTehilim("H_perek" + i));
                latinAndHebrewList.add(perek[i - 1]);
            }
        }
    }

    public void setListView() {
        TehilimListAdapter tehilimlistadapter = null;
        //tehilimlistadapter.clear();
        /*x++;
        Log.i("test", "setlistview is called " + String.valueOf(x) + " times.");
        list.setAdapter(null);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mylist);
        list.setAdapter(arrayAdapter);*/
        tehilimlistadapter = new TehilimListAdapter(getActivity(), R.layout.adapter_listview_layout, latinAndHebrewList);
        list.setAdapter(tehilimlistadapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("lastReadBook", kitapExtra);
        myEdit.apply();
    }

    public int[] monthlyOrder(int position) {
        passTehilimValues = new int[]{};
        if (position == 1) {
            passTehilimValues = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
            return passTehilimValues;
        }
        if (position == 2) {
            passTehilimValues = new int[]{9, 10, 11, 12, 14, 15};
            return passTehilimValues;
        }
        if (position == 3) {
            passTehilimValues = new int[]{16, 17, 18, 19};
            return passTehilimValues;
        }
        if (position == 4) {
            passTehilimValues = new int[]{20, 21, 22, 23, 24, 25};
            return passTehilimValues;
        }
        if (position == 5) {
            passTehilimValues = new int[]{26, 27, 28, 29, 30, 31};
            return passTehilimValues;
        }
        if (position == 6) {
            passTehilimValues = new int[]{32, 33, 34, 35};
            return passTehilimValues;
        }
        if (position == 7) {
            passTehilimValues = new int[]{36, 37, 38, 39};
            return passTehilimValues;
        }
        if (position == 8) {
            passTehilimValues = new int[]{40, 41, 42, 43, 44};
            return passTehilimValues;
        }
        if (position == 9) {
            passTehilimValues = new int[]{45, 46, 47, 48, 49};
            return passTehilimValues;
        }
        if (position == 10) {
            passTehilimValues = new int[]{50, 51, 52, 53, 54, 55};
            return passTehilimValues;
        }
        if (position == 11) {
            passTehilimValues = new int[]{56, 57, 58, 59, 60, 61};
            return passTehilimValues;
        }
        if (position == 12) {
            passTehilimValues = new int[]{62, 63, 64, 65, 66, 67};
            return passTehilimValues;
        }
        if (position == 13) {
            passTehilimValues = new int[]{68, 69, 70};
            return passTehilimValues;
        }
        if (position == 14) {
            passTehilimValues = new int[]{71, 72, 73, 74, 75};
            return passTehilimValues;
        }
        if (position == 15) {
            passTehilimValues = new int[]{76, 77, 78};
            return passTehilimValues;
        }
        if (position == 16) {
            passTehilimValues = new int[]{79, 80, 81, 82, 83, 84};
            return passTehilimValues;
        }
        if (position == 17) {
            passTehilimValues = new int[]{85, 86, 87, 88, 89};
            return passTehilimValues;
        }
        if (position == 18) {
            passTehilimValues = new int[]{90, 91, 92, 93, 94, 95};
            return passTehilimValues;
        }
        if (position == 19) {
            passTehilimValues = new int[]{96, 97, 98, 99, 100, 101, 102};
            return passTehilimValues;
        }
        if (position == 20) {
            passTehilimValues = new int[]{103, 104, 105};
            return passTehilimValues;
        }
        if (position == 21) {
            passTehilimValues = new int[]{106, 107, 108};
            return passTehilimValues;
        }
        if (position == 22) {
            passTehilimValues = new int[]{109, 110, 111, 112, 113, 114, 115};
            return passTehilimValues;
        }
        if (position == 23) {
            passTehilimValues = new int[]{116, 117, 118, 1191};
            return passTehilimValues;
        }
        if (position == 24) {
            passTehilimValues = new int[]{1192};
            return passTehilimValues;
        }
        if (position == 25) {
            passTehilimValues = new int[]{120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131};
            return passTehilimValues;
        }
        if (position == 26) {
            passTehilimValues = new int[]{132, 133, 134, 135, 136, 137, 138};
            return passTehilimValues;
        }
        if (position == 27) {
            passTehilimValues = new int[]{139, 140, 141, 142, 143, 144};
            return passTehilimValues;
        }
        if (position == 28) {
            passTehilimValues = new int[]{145, 146, 147, 148, 149, 150};
            return passTehilimValues;
        }

        return passTehilimValues;
    }

}