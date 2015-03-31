package com.kadirayk.ireadnothing.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.kadirayk.ireadnothing.fragments.ScreenSlidePageFragment;
import com.kadirayk.ireadnothing.fragments.YMLEFragment;

/**
 * A simple pager adapter that represents 5 {@link ScreenSlidePageFragment} objects, in
 * sequence.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return YMLEFragment.create(position);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
