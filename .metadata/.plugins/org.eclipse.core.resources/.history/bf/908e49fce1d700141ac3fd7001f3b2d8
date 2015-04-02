package com.kadirayk.ireadnothing.fragments;

import com.kadirayk.ireadnothing.R;
import com.kadirayk.ireadnothing.adapters.ScreenSlidePagerAdapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class YMLEArchivedFragment extends Fragment implements OnItemClickListener{

	private View mView;
	private ListView fragment_ymle_archived_listview;
	private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.fragment_ymle_archived, container, false);
		setUI();
		return mView;
	}


	private void setUI(){
		
		// Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) mView.findViewById(R.id.fragment_YMLE_archived_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @SuppressLint("NewApi")
			@Override
            public void onPageSelected(int position) {
//                invalidateOptionsMenu();
            }
        });
		
	}
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

}
