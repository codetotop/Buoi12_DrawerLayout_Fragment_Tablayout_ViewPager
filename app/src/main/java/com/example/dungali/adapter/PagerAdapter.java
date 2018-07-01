package com.example.dungali.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dungali.fragment.ConanFragment;
import com.example.dungali.fragment.DoremonFragment;
import com.example.dungali.fragment.DragonFragment;
import com.example.dungali.model.Story;

import java.util.ArrayList;

/**
 * Created by Dung Ali on 6/22/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Story> arrStory;

    public PagerAdapter(FragmentManager fm, ArrayList<Story> arrStory) {
        super(fm);
        this.arrStory = arrStory;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ConanFragment();
                break;
            case 1:
                fragment = new DoremonFragment();
                break;
            case 2:
                fragment = new DragonFragment();
            default:
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return arrStory.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrStory.get(position).getNameStory();
    }
}
