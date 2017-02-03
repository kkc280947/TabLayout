package com.example.cbluser3.tablayout.fragment;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 3/2/17.
 */
public class FirstFragmentAdapter extends RecyclerView.Adapter<FirstFragmentAdapter.RecyclerViewHolder> {

    Activity activity;
    List<Model> modelList=new ArrayList<>();

    public FirstFragmentAdapter(Activity activity, List<Model> modelList) {
        this.modelList=modelList;
        this.activity=activity;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_first,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tvName.setText(modelList.get(position).name);
        holder.ivImage.setImageResource(modelList.get(position).imageId);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivImage;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvName=(TextView)itemView.findViewById(R.id.tvName);
            ivImage=(ImageView) itemView.findViewById(R.id.ivBimage);
        }
    }
}
