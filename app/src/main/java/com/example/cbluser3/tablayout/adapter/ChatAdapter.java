package com.example.cbluser3.tablayout.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.model.ChatModel;

import java.util.List;

/**
 * Created by cbluser3 on 11/2/17.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.RecyclerViewHolder> {
    Activity activity;
    List<ChatModel> chatModelList;
    final int statusCodeSender=0;
    final int statusCodeReciever=1;
    final int imageCode=0;
    final int title=2;
    Button button;
    String prevDate=null;

    public ChatAdapter(Activity activity, List<ChatModel> chatModelList) {
        this.chatModelList=chatModelList;
        this.activity=activity;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case statusCodeSender:
                return new RecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_right, parent, false));
            default:
                return new RecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_left, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        switch (getItemViewType(position)){

            case statusCodeSender:

                if (chatModelList.get(position).getType()==0) {
                    if (chatModelList.get(position).getImageUrl() != null) {
                       /* Picasso.with(activity).load(chatModelList.get(position).getImageUrl()).resize(120, 60).into(holder.ivSend);*/
                        holder.imageViewChat.setImageURI(Uri.parse(chatModelList.get(position).imageUrl));
                        holder.tvSend.setVisibility(View.GONE);
                    }

                }
                else{
                    holder.tvSend.setText(chatModelList.get(position).getChats());
                    holder.imageViewChat.setVisibility(View.GONE);
                    String currTime;
                    currTime=chatModelList.get(position).getDate();

                    if (holder.getAdapterPosition()>0) {
                        prevDate = chatModelList.get(position-1).getDate();
                    }

                    if (prevDate==null || !prevDate.equals(currTime) ) {
                        holder.tvTime.setText(currTime);
                    } else {
                        holder.tvTime.setVisibility(View.GONE);
                    }

                }


                break;

            default:
                holder.tvRecieve.setText(chatModelList.get(position).getChats());

                break;
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(chatModelList.get(position).getStatusCode()==statusCodeSender){
            return statusCodeSender;
        }

        else {
            return statusCodeReciever;
        }
    }

    @Override
    public int getItemCount() {
        return chatModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvSend,tvRecieve,tvTime;
        ImageView ivSend,ivRecieve;
        AppCompatImageView imageViewChat;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvRecieve=(TextView)itemView.findViewById(R.id.tvRecieve);
            tvSend=(TextView)itemView.findViewById(R.id.tvSend);
            tvTime=(TextView)itemView.findViewById(R.id.tvTime);
            imageViewChat=(AppCompatImageView)itemView.findViewById(R.id.ivChatImage);
        }
    }
}
