package com.example.applicationjson;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class AdapterCard extends RecyclerView.Adapter< AdapterCard.ViewHolder>
{
    private static final String TAG="MainActivity";
    private ArrayList<CardShowModelClass> listCards;
    private Context context;
    LayoutInflater inflater;

    public AdapterCard(Context context)
    {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        listCards = new ArrayList<>();
    }

    public void add(CardShowModelClass cardShowModelClass){
        listCards.add(cardShowModelClass);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterCard.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardShowModelClass cardShowModelClass = listCards.get(position);
        holder.title.setText(cardShowModelClass.getTitle());
        holder.description.setText(cardShowModelClass.getDescription());
        holder.price.setText(String.valueOf(cardShowModelClass.getPrice()));
        Glide.with(context).load(cardShowModelClass.getThumbnail()).into(holder.imageButton);

        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"jsuis dans le on click");
            }
        });
    }


    @Override
    public int getItemCount()
    {
        return listCards.size() ;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public TextView description;
        public TextView price;
        public ImageButton imageButton;

        public ViewHolder(View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            imageButton = itemView.findViewById(R.id.imageButton);
        }
    }

}