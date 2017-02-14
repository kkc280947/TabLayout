package com.example.cbluser3.tablayout.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.activity.ChatScreenActivity;
import com.example.cbluser3.tablayout.model.ContactsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 11/2/17.
 */
public class MyContactsListAdapter extends RecyclerView.Adapter<MyContactsListAdapter.RecyclerViewHolder> {

    List<ContactsModel> contacts=new ArrayList<>();
    public Activity activity;
    List<String> strings=new ArrayList<>();
    public MyContactsListAdapter(Activity activity, List<ContactsModel> contacts) {
        this.activity=activity;
        this.contacts=contacts;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_contacts,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tvContactName.setText(contacts.get(position).name);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvContactName;
        public RecyclerViewHolder(final View itemView) {
            super(itemView);
            tvContactName=(TextView)itemView.findViewById(R.id.tvContName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(activity,ChatScreenActivity.class);
                    int pos=contacts.get(getAdapterPosition()).key_id;
                    Log.d("tag",pos+"");
                    intent.putExtra("position",pos);
                    activity.startActivity(intent);

                }
            });
        }
    }
}
