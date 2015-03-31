package com.kadirayk.ireadnothing.fragments;

import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kadirayk.ireadnothing.R;
import com.kadirayk.ireadnothing.adapters.YMLEListAdapter;
import com.kadirayk.ireadnothing.application.AppController;
import com.kadirayk.ireadnothing.database.YMLEDataSource;
import com.kadirayk.ireadnothing.model.YMLE;
import com.kadirayk.ireadnothing.network.NetworkController.OnYMLEResponseRecievedListener;
import com.kadirayk.ireadnothing.network.YMLEParser;

public class YMLEFragment extends Fragment implements OnItemClickListener, OnYMLEResponseRecievedListener{

	private View mView;
	private ListView fragment_ymle_listview;
	private TextView fragment_ymle_date;
	
	private YMLEDataSource dataSource;
	private List<YMLE> ymleList;
	
	private YMLEListAdapter mAdapter;
	
	private int mPageNumber;

	public static YMLEFragment create(int date) {
		YMLEFragment fragment = new YMLEFragment();
        Bundle args = new Bundle();
        args.putInt("page", date);
        fragment.setArguments(args);
        return fragment;
    }
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mView = inflater.inflate(R.layout.fragment_ymle, container, false);
		
		mPageNumber = getArguments().getInt("page");
		
		setUI();
		
		dataSource = new YMLEDataSource(getActivity());
		dataSource.open();
		
		String today = AppController.getSystemDate();
		String lastday = AppController.getLastYMLEDay(getActivity());
		
		if(lastday == ""){
			//if it is first time call network task
			AppController.storeLastGroup(getActivity(), 1);
			AppController.storeLastYMLEDay(getActivity(), today);
			YMLEParser networkHandler = new YMLEParser(getActivity(), this);
			networkHandler.callYMLETask();
			
		}else if(lastday.equals(today)){
			//if already stored do not call network task
			
			ymleList  = dataSource.getAllYMLESByDate(lastday);
			updateAdapter(ymleList);
			Toast.makeText(getActivity(), AppController.getSystemDate(), Toast.LENGTH_SHORT).show();
		}else if(!lastday.equals(today)){
			// if another day, increase group call network task
			
			int lastDay = AppController.getLastGroup(getActivity());
			
			AppController.storeLastGroup(getActivity(), lastDay+1);
			AppController.storeLastYMLEDay(getActivity(), today);
			YMLEParser networkHandler = new YMLEParser(getActivity(), this);
			networkHandler.callYMLETask();
		}
				
		return mView;
	}
	
	private void setUI(){
		fragment_ymle_date = (TextView) mView.findViewById(R.id.fragment_ymle_date);
		fragment_ymle_listview = (ListView) mView.findViewById(R.id.fragment_ymle_listview);
		fragment_ymle_listview.setOnItemClickListener(this);
		
	}

	private void updateAdapter(List<YMLE> ymleList){
		mAdapter = new YMLEListAdapter(getActivity(), ymleList);
		fragment_ymle_listview.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void OnYMLEResponseRecieved(List<YMLE> YMLEs) {

		Toast.makeText(getActivity(), YMLEs.get(0).getTitle(), Toast.LENGTH_SHORT).show();
		
		for(YMLE ymle : YMLEs){
			dataSource.createYMLE(ymle.getGroup(), ymle.getPlace(), ymle.getTitle(), ymle.getAuthor(), ymle.getUrl(), ymle.getDate());
		}
		
		ymleList  = dataSource.getAllYMLES();
		updateAdapter(ymleList);
		
	}
	
}
