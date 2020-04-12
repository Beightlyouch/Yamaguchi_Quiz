package com.beightlyouch.yamaguchi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView result_correct;
    TextView result_city;

    public ViewHolder(View itemView){
        super(itemView);
        result_correct=itemView.findViewById(R.id.result_correct);
        result_city= itemView.findViewById(R.id.result_city);
    }
}
