package com.example.cbluser3.tablayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cbluser3.tablayout.model.Model;
import com.example.cbluser3.tablayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 3/2/17.
 */
public class Fragment1 extends Fragment{

    List<Model> modelList=new ArrayList<>();
    FirstFragmentAdapter firstFragmentAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.first_fragment,container,false);
        RecyclerView rvFirst = (RecyclerView) view.findViewById(R.id.rvRecyclerFirst);
        if(modelList.isEmpty()) {

            modelList.add(new Model("Adidas", R.drawable.logo_adidas));
            modelList.add(new Model("Aerie", R.drawable.logo_aerie));
            modelList.add(new Model("Aeropostle", R.drawable.logo_aeropostale));
            modelList.add(new Model("Alamo", R.drawable.logo_alamo));
            modelList.add(new Model("Adidas", R.drawable.logo_adidas));
            modelList.add(new Model("Adidas", R.drawable.logo_adidas));

        }


        firstFragmentAdapter = new FirstFragmentAdapter(getActivity(), modelList);
        rvFirst.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvFirst.setAdapter(firstFragmentAdapter);


        return view;
    }




}
