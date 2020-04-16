package com.example.sampleandroidmaterialdesign;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set toolbar to activity
        //setSupportActionBar((Toolbar) findViewById(R.id.tb_main));

      /*  final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_main_fragmentContainer, new MainFragment());
        //first fragment don't add backStack
        fragmentTransaction.commit();*/

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation_main);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        switch (item.getItemId()) {
                            case R.id.menuItem_home:
                                transaction.replace(R.id.frame_main_fragmentContainer, new MainFragment());
                                break;
                            case R.id.menuItem_recent:
                                transaction.replace(R.id.frame_main_fragmentContainer, new RecentFragment());
                                break;
                            case R.id.menuItem_nearby:
                                transaction.replace(R.id.frame_main_fragmentContainer, new NearbyFragment());
                                break;
                        }
                        transaction.commit();
                        return true;
                    }
                });
        bottomNavigationView.setSelectedItemId(R.id.menuItem_home);
        bottomNavigationView
                .setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {
                        //Prevent selected recreations
                        //todo set scroll position on top
                    }
                });
    }
}
