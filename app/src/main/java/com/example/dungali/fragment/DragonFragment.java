package com.example.dungali.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dungali.buoi12_drawerlayout_fragment_tablayout_viewpager.R;

/**
 * Created by Dung Ali on 6/22/2017.
 */

public class DragonFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dragon_fragment,container,false);
    }
}
