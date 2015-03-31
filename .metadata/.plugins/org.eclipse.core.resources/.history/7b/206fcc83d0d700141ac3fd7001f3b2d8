package com.kadirayk.ireadnothing.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.kadirayk.ireadnothing.R;
import com.kadirayk.ireadnothing.adapters.ScreenSlidePagerAdapter;


public class ScreenSlideActivity extends FragmentActivity {

    private static final int NUM_PAGES = 5;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @SuppressLint("NewApi")
			@Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
            }
        });
    }

}
