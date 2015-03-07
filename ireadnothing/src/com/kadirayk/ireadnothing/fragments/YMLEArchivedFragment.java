package com.kadirayk.ireadnothing.fragments;

import com.kadirayk.ireadnothing.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class YMLEArchivedFragment extends Fragment implements OnItemClickListener{

	private View mView;
	private ListView fragment_ymle_archived_listview;
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.fragment_ymle_archived, container, false);
		setUI();
		return mView;
	}


	private void setUI(){
		
		fragment_ymle_archived_listview = (ListView) mView.findViewById(R.id.fragment_ymle_archived_listview);
		fragment_ymle_archived_listview.setOnItemClickListener(this);
		
	}
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

}
