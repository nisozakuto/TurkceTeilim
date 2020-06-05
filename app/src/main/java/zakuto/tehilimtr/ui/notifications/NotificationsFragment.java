package zakuto.tehilimtr.ui.notifications;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import zakuto.tehilimtr.R;
import zakuto.tehilimtr.SettingsActivity;

import static android.content.Context.MODE_PRIVATE;

public class NotificationsFragment extends Fragment implements View.OnClickListener {
    private NotificationsViewModel notificationsViewModel;
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

    public NotificationsFragment() {
        // Required empty public constructor
    }

    public static NotificationsFragment newInstance(String param1, String param2) {
        NotificationsFragment fragment = new NotificationsFragment();
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
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        date = view.findViewById(R.id.dateInfo);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        date.setText(dateTime);
        submitTehilimText = view.findViewById(R.id.submitTehilimText);
        submitTehilim = view.findViewById(R.id.submitTehilim);
        submitTehilim.setOnClickListener(this);
        textView2 = view.findViewById(R.id.textView2);


       /*
       Use this until for the releases it is fully developed
       View view = inflater.inflate(R.layout.coming_soon, container, false);
        webView = view.findViewById(R.id.webview);
        startWebView("https://www.facebook.com/TeilimApp/");*/
        return view;
    }


    private void startWebView(String url) {
        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onLoadResource(WebView view, String url) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(getActivity());
                    progressDialog.setMessage("Sayfa Yükleniyor...");
                    progressDialog.show();
                }
            }

            public void onPageFinished(WebView view, String url) {
                try {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitTehilim:
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
                break;
        }
    }
}

/*    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
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