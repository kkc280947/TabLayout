package com.example.cbluser3.tablayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cbluser3.tablayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 3/2/17.
 */
public class CallFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.call_fragment,container,false);

        return view;
    }




}
