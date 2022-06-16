package com.example.sp20_bse_012_assign3;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link videoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class videoFragment extends Fragment {
    DataViewModal dataViewModal;
    VideoView videoView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public videoFragment() {
        // Required empty public constructor
    }

    public static videoFragment newInstance() {
        return new videoFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        videoView = view.findViewById(R.id.vv);

        dataViewModal = new ViewModelProvider(requireActivity()).get(DataViewModal.class);

        dataViewModal.getPlayingVideoIndex().observe(requireActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer playingVideoIndex) {
                if(playingVideoIndex == null) {
                    return;
                }

                videoData video = dataViewModal.getvideoData()[playingVideoIndex];
                Uri uri = Uri.parse("android.resource://" + requireActivity().getPackageName() + "/" + video.id);
                videoView.setVideoURI(uri);
                videoView.start();
            }
        });
        return view;
    }
}