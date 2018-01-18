package com.edge.weather.mygallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c2619 on 2018-01-18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<Cell> galleryList;
    private Context context;
    private MainActivity mainActivity;
    public MyAdapter(Context context,List<Cell> galleryList,MainActivity mainActivity){
        this.galleryList=galleryList;
        this.context=context;
        this.mainActivity=mainActivity;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cell,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int i) {
        holder.title.setText(galleryList.get(i).getTitle());
        holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(this.mainActivity).load(new File(galleryList.get(i).getImg())).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,galleryList.get(i).getTitle()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView img;
        public ViewHolder(View view){
            super(view);
            title=(TextView)view.findViewById(R.id.title);
            img=(ImageView)view.findViewById(R.id.img);
        }

    }
    }
