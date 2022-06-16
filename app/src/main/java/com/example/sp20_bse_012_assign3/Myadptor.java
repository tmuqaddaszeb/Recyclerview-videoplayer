package com.example.sp20_bse_012_assign3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadptor extends RecyclerView.Adapter<Myadptor.dataholder> {
    DataViewModal dataViewModel;

    public Myadptor(DataViewModal dataViewModal){
        this.dataViewModel = dataViewModal;
    }

   class dataholder extends RecyclerView.ViewHolder{
       ImageView img;
       TextView txt;
       public dataholder(@NonNull View itemView) {
           super(itemView);

           txt=(TextView)itemView.findViewById(R.id.videoname);
//
           txt.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   dataViewModel.setPlayingVideoIndex(getAdapterPosition());
               }
           });
       }
   }
    @NonNull
    @Override
    public dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creating the layout for the single item of recyclerview
        LinearLayout item = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new dataholder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull dataholder holder, int position) {
        TextView txt = holder.txt;
        txt.setText(dataViewModel.getvideoData()[position].name);
    }

    @Override
    public int getItemCount() {

        return dataViewModel.getvideoData().length;
    }


}
