package com.example.sp20_bse_012_assign3;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModal extends ViewModel {
    private MutableLiveData<Integer> playingVideos=new MutableLiveData<>();
   private final videoData[] videos = {
       new videoData(R.raw.baby, "baby"),
       new videoData(R.raw.chuckling,"chuckling"),
      new videoData(R.raw.king,"king"),
      new videoData(R.raw.parrot,"parrot"),
      new videoData(R.raw.whale,"whale"),
    new videoData(R.raw.baby,"baby2"),
    };
   public videoData[] getvideoData() { return videos;}
    public MutableLiveData<Integer> getPlayingVideoIndex() {
        return playingVideos;
    }

    public void setPlayingVideoIndex(int index) {
        this.playingVideos.setValue(index);
    }







}
