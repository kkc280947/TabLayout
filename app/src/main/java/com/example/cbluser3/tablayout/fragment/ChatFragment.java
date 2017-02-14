package com.example.cbluser3.tablayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cbluser3.tablayout.R;
import com.example.cbluser3.tablayout.adapter.MyContactsListAdapter;
import com.example.cbluser3.tablayout.databaseHandler.ContactDatabaseHandler;
import com.example.cbluser3.tablayout.adapter.MyChatFragAdapter;
import com.example.cbluser3.tablayout.databaseHandler.DatabaseHandler;
import com.example.cbluser3.tablayout.model.ContactsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 3/2/17.
 */
public class ChatFragment extends Fragment{
    List<ContactsModel> contacts=new ArrayList<>();
    DatabaseHandler db;
    ContactDatabaseHandler chatDb;
    Button button;
    EditText etName;
    EditText etPhone;
    int contactCount;
    int chatCount;

    MyChatFragAdapter myChatFragAdapter;
    MyContactsListAdapter myContactsListAdapter;
    ContactsModel contactsModel;
    RecyclerView recyclerViewChatFrag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.chat_fragment,container,false);

         db=new DatabaseHandler(getActivity());
         chatDb=new ContactDatabaseHandler(getActivity());
         contactCount=db.getContactCount();
         for(int i=0;i<=contactCount;i++){

             chatCount=chatDb.getChatCount(i);
             if(chatCount!=0){
                /*contactsModel=db.getContact(i);
                 contacts.add(contactsModel);*/

                 contacts.add(db.getContact(i));
             }
         }


        recyclerViewChatFrag=(RecyclerView)view.findViewById(R.id.rvChat);
        myContactsListAdapter=new MyContactsListAdapter(getActivity(),contacts);
        myContactsListAdapter.notifyDataSetChanged();
        recyclerViewChatFrag.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerViewChatFrag.setAdapter(myContactsListAdapter);

        return view;
    }

}
