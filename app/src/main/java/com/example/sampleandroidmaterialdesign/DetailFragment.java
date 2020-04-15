package com.example.sampleandroidmaterialdesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        //activated clickable item toolbar
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar           toolbar  = view.findViewById(R.id.tb_detail);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setHomeButtonEnabled(true);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //show back btn in toolbar

        CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.collapsingToolbarLayout_detail);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
        //hide title toolbar in collapsingToolbar
        collapsingToolbarLayout.setTitle("Lorem ipsum");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            getActivity().onBackPressed();
        //set action for item menu
        return super.onOptionsItemSelected(item);
    }
}
