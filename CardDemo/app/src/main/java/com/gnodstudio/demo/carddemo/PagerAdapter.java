package com.gnodstudio.demo.carddemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DLC on 2018/4/1.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Pos", position);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
