package com.example.sp20_bse_012_assign3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class videoListFragment extends Fragment {
    DataViewModal dataViewModel;
    RecyclerView recyclerView;

    public videoListFragment() {
        
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video_list, container, false);
        recyclerView = view.findViewById(R.id.Rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        dataViewModel = new ViewModelProvider(requireActivity()).get(DataViewModal.class);
        Myadptor videoListAdapter = new Myadptor(dataViewModel);
        recyclerView.setAdapter(videoListAdapter);
        return view;
    }
}