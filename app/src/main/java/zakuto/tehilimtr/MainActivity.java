package zakuto.tehilimtr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import zakuto.tehilimtr.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button tumKitap, infoButton, randomtehilimtrButton,textTest;
    public TextView tehilimtrText, randomtehilimtrText;
    public TehilimClass Tehilim = new TehilimClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        tumKitap = findViewById(R.id.tumKitapButton);
        tumKitap.setOnClickListener(this);

        infoButton = findViewById(R.id.infoButton);
        infoButton.setOnClickListener(this);

        textTest = findViewById(R.id.textTest);
        textTest.setOnClickListener(this);

        tehilimtrText = findViewById(R.id.textView2);
        tehilimtrText.setText(R.string.dummmyText);

        randomtehilimtrButton = findViewById(R.id.randomtehilimtrButton);
        randomtehilimtrButton.setOnClickListener(this);
        randomtehilimtrText = findViewById(R.id.randomNumberText);

        Randomtehilimtr();
        RandomTeilim randomtehilimtrObject = new RandomTeilim();
        randomtehilimtrText.setText(String.valueOf(randomtehilimtrObject.randomNumber()));
    }

    public void Randomtehilimtr() {
        RandomTeilim randomtehilimtrObject = new RandomTeilim();
        randomtehilimtrText.setText(String.valueOf(randomtehilimtrObject.randomNumber()));
    }

    public void tumKitap() {
        Intent tumKitapIntent = new Intent(this, tumKitap.class);
        startActivity(tumKitapIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tumKitapButton:
                tumKitap();
                break;
            case R.id.infoButton:
                Intent infoIntent = new Intent(this, Info.class);
                startActivity(infoIntent);
                break;
            case R.id.randomtehilimtrButton:
                Randomtehilimtr();
                break;
            case R.id.textTest:
                String perek;
                perek = TehilimClass.getTehilim("tr" + 1);
                randomtehilimtrText.setText("Test)");
                randomtehilimtrText.setText(perek);

                break;
        }
    }
}
