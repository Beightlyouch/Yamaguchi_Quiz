package com.beightlyouch.yamaguchi;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private String[] city;
    private int[] check;

    public CustomRecyclerAdapter(){}
    public CustomRecyclerAdapter(String[] city, int[] check){this.city= city; this.check= check;}


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.result_city.setText(city[position]);

        if(check[position] == 0){
            holder.result_correct.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/notright"));
        }else if(check[position] == 1){
            holder.result_correct.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/right"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }


    @Override
    public int getItemCount() {
        return city.length;
    }
}
