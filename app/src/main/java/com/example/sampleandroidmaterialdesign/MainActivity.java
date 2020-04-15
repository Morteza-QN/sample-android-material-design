package com.example.sampleandroidmaterialdesign;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_main_fragmentContainer, new MainFragment());
        fragmentTransaction.commit();
        //first fragment don't add backStack

        //setSupportActionBar((Toolbar) findViewById(R.id.tb_main));
        //set toolbar to activity
    }
}
