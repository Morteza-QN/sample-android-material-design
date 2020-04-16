package com.example.sampleandroidmaterialdesign;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

        Toolbar           toolbar           = view.findViewById(R.id.tb_main);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(toolbar);
        //set toolbar in fragment

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
