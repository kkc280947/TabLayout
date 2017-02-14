package com.example.cbluser3.tablayout.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.model.ContactsModel;

import java.util.List;

/**
 * Created by kris on 13/02/17.
 */
public class MyChatFragAdapter extends RecyclerView.Adapter<MyChatFragAdapter.RecyclerViewHolder>{
    Activity activity;
    List<ContactsModel> contacts;
    public MyChatFragAdapter(Activity activity, List<ContactsModel> contacts) {
        this.activity=activity;
        this.contacts=contacts;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_contacts,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
