package com.kadirayk.ireadnothing.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RelativeLayout;

import com.kadirayk.ireadnothing.R;
import com.kadirayk.ireadnothing.fragments.FragmentManager.FragmentTransactions;
import com.kadirayk.ireadnothing.fragments.YMLEFragment;

public class HomeActivity extends FragmentActivity implements FragmentTransactions{
	
	private YMLEFragment mYMLEFragment;
	private Fragment currentFragment;
	
	private RelativeLayout homeActivityYmleRL;
	private RelativeLayout homeActivityArchivedYmleRL;
	
	private RelativeLayout homeActivityYmleBottomRL;
	private RelativeLayout homeActivityArchivedYmleBottomRL;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		setUI();
		
		onYMLEFragmentFired();
	}
	
	private void setUI(){
		
		homeActivityYmleRL = (RelativeLayout) findViewById(R.id.homeActivityYmleRL);
		homeActivityYmleBottomRL = (RelativeLayout) findViewById(R.id.homeActivityYmleBottomRL);
		homeActivityArchivedYmleRL = (RelativeLayout) findViewById(R.id.homeActivityArchivedYmleRL);
		homeActivityArchivedYmleBottomRL = (RelativeLayout) findViewById(R.id.homeActivityArchivedYmleBottomRL);
		
	}

	@Override
	public void onYMLEFragmentFired() {

		if (mYMLEFragment == null){
			mYMLEFragment = new YMLEFragment();
		}
		currentFragment = mYMLEFragment;
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.homeActivityFragmentContainer, mYMLEFragment);
		ft.commit();
		
	}

	@Override
	public void onYMLEDetailFragmentFired() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onYMLEArchivedFragmentFired() {
		// TODO Auto-generated method stub
		
	}

}
