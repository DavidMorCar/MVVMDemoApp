package com.app.davidmoreno.demoapp.appmodules.main.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.app.davidmoreno.demoapp.R;
import com.app.davidmoreno.demoapp.domain.model.Image;
import com.bumptech.glide.Glide;

import java.util.Date;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Image> images;
    private int size;
    private Context context;

    public MainAdapter(Context applicationContext, List<Image> images) {
        this.context = applicationContext;
        this.images = images;
        this.size = images.size();
    }

    public void setValues(List<Image> values) {
        images.clear();
        images.addAll(values);
        size = values.size();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new MainAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder holder, int position) {

        holder.idTV.setText(images.get(position).getTitle());
        holder.urlTV.setText(images.get(position).getUrl());
        if(images.get(position).getUrl() == null){
            holder.imageView.setVisibility(View.INVISIBLE);
        }else
            Glide.with(context).load(images.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView idTV;
        final TextView urlTV;
        final ImageView imageView;

        ViewHolder(View view) {
            super(view);
            mView = view;
            idTV = view.findViewById(R.id.id);
            urlTV = view.findViewById(R.id.url);
            imageView = view.findViewById(R.id.imageView);
        }
    }
}
