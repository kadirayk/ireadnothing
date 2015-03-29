package com.kadirayk.ireadnothing.fragments;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.kadirayk.ireadnothing.R;
import com.kadirayk.ireadnothing.adapters.YMLEAdapter;
import com.kadirayk.ireadnothing.application.AppController;
import com.kadirayk.ireadnothing.network.NetworkController.OnTitleResponseRecievedListener;
import com.kadirayk.ireadnothing.network.NetworkController.OnYMLEResponseRecievedListener;
import com.kadirayk.ireadnothing.network.YMLEParser;
import com.kadirayk.ireadnothing.network.model.YMLE;

public class YMLEFragment extends Fragment implements OnItemClickListener, OnTitleResponseRecievedListener, OnYMLEResponseRecievedListener{

	private View mView;
	private ListView fragment_ymle_listview;
	private TextView fragment_ymle_textview;
	
	private List<YMLE> YMLEList;
	private YMLE YMLEListItem;
	private YMLEAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mView = inflater.inflate(R.layout.fragment_ymle, container, false);
		setUI();
		
		if(AppController.getLastYMLEDay(getActivity()) == ""){
			//first time we check YMLE
			AppController.storeLastYMLEDay(getActivity(), "today");
			YMLEParser networkHandler = new YMLEParser(getActivity(), this);
			networkHandler.callYMLETask();
		}else if(AppController.getLastYMLEDay(getActivity()).equals("today")){
			Toast.makeText(getActivity(), "it said todaaay", Toast.LENGTH_SHORT).show();
		}
				
		return mView;
	}
	
	private void setUI(){
		fragment_ymle_textview = (TextView) mView.findViewById(R.id.fragment_ymle_textview);
		fragment_ymle_listview = (ListView) mView.findViewById(R.id.fragment_ymle_listview);
		fragment_ymle_listview.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnTitleResponseRecieved(String response) {
		
		fragment_ymle_textview.setText(response);
		
	}

	@Override
	public void OnYMLEResponseRecieved(List<YMLE> YMLEs) {

		Toast.makeText(getActivity(), YMLEs.get(0).getTitle(), Toast.LENGTH_SHORT).show();
		
		mAdapter = new YMLEAdapter(getActivity(), YMLEs);
		fragment_ymle_listview.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
		
	}
	
}
