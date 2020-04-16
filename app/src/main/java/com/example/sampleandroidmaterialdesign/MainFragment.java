package com.example.sampleandroidmaterialdesign;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.tb_main);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(toolbar);
        //set toolbar in fragment

        DrawerLayout drawerLayout = view.findViewById(R.id.drawerLayout_main);
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //set toolbar navigationIcon for drawerToggle and active action

        final MaterialCardView materialCardView = view.findViewById(R.id.card_main_text);
        materialCardView.setChecked(true);
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_main_fragmentContainer, new DetailFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                //ocClickListener for cardView
            }
        });

        FloatingActionButton fab = view.findViewById(R.id.fab_main_fragment);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(getView(), "Material Design Snackbar", Snackbar.LENGTH_INDEFINITE)
                        .setAction("retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i(TAG, "onClick: snackbar");
                            }
                        }).show();
            }
        });
        NavigationView navigationView = view.findViewById(R.id.navigationView_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
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
                return false;
            }
        });
        View     headerView = navigationView.getHeaderView(0);
        TextView textView   = headerView.findViewById(R.id.tv_navigationView_header);
        textView.setText("header view");

    }

    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //checkable cardView
        final MaterialCardView materialCardView =view.findViewById(R.id.card_main_text);
        materialCardView.setChecked(true);
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialCardView.setChecked(!materialCardView.isChecked());
            }
        });
    }*/
}
