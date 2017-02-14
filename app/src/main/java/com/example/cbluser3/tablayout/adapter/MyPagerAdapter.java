package com.example.cbluser3.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.cbluser3.tablayout.fragment.CallFragment;
import com.example.cbluser3.tablayout.fragment.ChatFragment;
import com.example.cbluser3.tablayout.fragment.ContactFragment;

/**
 * Created by cbluser3 on 3/2/17.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{
    int tabCount;

    public MyPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.tabCount=tabCount;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CallFragment tab1 = new CallFragment();
                return tab1;
            case 1:
                ChatFragment tab2 = new ChatFragment();
                return tab2;
            case 2:
                ContactFragment tab3 = new ContactFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Calls";
            case 1: return "Chats";
            case 2:  return  "Contacts";
            default:return null;
        }
    }
}
