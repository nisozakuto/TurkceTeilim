package zakuto.tehilimtr.ui.user;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import zakuto.tehilimtr.MainActivity;
import zakuto.tehilimtr.R;

import static android.content.Context.MODE_PRIVATE;

public class UserFragment extends Fragment implements View.OnClickListener {
    private UserViewModel notificationsViewModel;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    Button TestButton, submitTehilim;
    TextView text_notifications, date, textView2;
    EditText submitTehilimText;
    int a = 0;
    private WebView webView;
    String personalTehilim = "";
    ArrayList<String> myTehilimList = new ArrayList<String>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myList = database.getReference("perek");
    String testData;

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("name", "24");
        myEdit.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     /*   View view = inflater.inflate(R.layout.fragment_user, container, false);
        date = view.findViewById(R.id.dateInfo);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        date.setText(dateTime);
        submitTehilimText = view.findViewById(R.id.submitTehilimText);
        submitTehilim = view.findViewById(R.id.submitTehilim);
        submitTehilim.setOnClickListener(this);
        textView2 = view.findViewById(R.id.textView2);*/


        //Use this until for the releases it is fully developed
/*        View view = inflater.inflate(R.layout.coming_soon, container, false);

        return view;*/
//        View view = inflater.inflate(R.layout.fragment_user, container, false);
        View view = inflater.inflate(R.layout.fragment_user_two, container, false);
        Log.i("Current", "UserFragment");

       /* TestButton = view.findViewById(R.id.submitTehilimButton);
        TestButton.setOnClickListener(this);
        submitTehilimText = view.findViewById(R.id.submitTehilimText);
        testData = submitTehilimText.getText().toString();*/

       // For more in the webview
        // https://www.youtube.com/watch?v=8ayK3odtP8M
        webView = view.findViewById(R.id.webView);
        webView.loadUrl("https://www.facebook.com/TeilimApp/");
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });

        // Read from the database
        myList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
   /*         case R.id.submitTehilim:
                if (submitTehilimText.getText().toString() != " " || submitTehilimText.getText().toString() != null) {
                    //Fix this, it is not recognizing the null or empty entries.
                    personalTehilim = submitTehilimText.getText().toString();
                    if (Integer.parseInt(personalTehilim) > 150) {
                        submitTehilimText.setText("");
                        Toast.makeText(getActivity(), "Lütfen doğru bir değer girin.", Toast.LENGTH_SHORT).show();
                    } else if (Integer.parseInt(personalTehilim) > 0 && Integer.parseInt(personalTehilim) < 151) {
                        Toast.makeText(getActivity(), "Teilim listeye eklendi", Toast.LENGTH_SHORT).show();
                        Log.i("personalTehilim", personalTehilim);
                        personalTehilim = submitTehilimText.getText().toString();
                        if (myTehilimList.contains(personalTehilim)) {
                            Toast.makeText(getActivity(), "Bu Teilim zaten listeye ekli", Toast.LENGTH_SHORT).show();
                        } else {
                            myTehilimList.add(personalTehilim);
                        }
                        textView2.setText(myTehilimList + "");
                    }
                } else {
                    Toast.makeText(getActivity(), "Lütfen doğru bir değer girin.", Toast.LENGTH_SHORT).show();
                }
                break;*/
            case R.id.submitTehilimButton:
                myList.setValue(testData);
                Log.w("TAG", "Eklendi...");
                break;
        }

    }

    public void onResume() {
        super.onResume();
        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Bilgiler");

    }
}

/*    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
*/