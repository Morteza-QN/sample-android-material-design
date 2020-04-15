package com.example.sampleandroidmaterialdesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainFragment extends Fragment {

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
                Toast.makeText(v.getContext(), "fab clocked", Toast.LENGTH_SHORT).show();
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
