package com.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.myapplication.Fragment.MoviesFragment;
import com.myapplication.Fragment.NewsFragment;
import com.myapplication.Fragment.SportsFragment;
import com.myapplication.Fragment.TvFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public MyPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment;

        switch (position) {
            case 0:
                fragment = new MoviesFragment();
                return fragment;
            case 1:
                fragment = new SportsFragment();
                return fragment;
            case 2:
                fragment = new NewsFragment();
                return fragment;
            case 3:
                fragment = new TvFragment();
                return fragment;

        }

        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
