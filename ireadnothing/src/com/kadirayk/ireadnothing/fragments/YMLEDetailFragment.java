package com.kadirayk.ireadnothing.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kadirayk.ireadnothing.R;

public class YMLEDetailFragment extends Fragment{

	private View mView;
	private TextView ymle_detail_title_TV;
	private TextView ymle_detail_content_TV;
	private TextView ymle_detail_author_TV;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mView = inflater.inflate(R.layout.fragment_ymle_detail, container, false);
		setUI();
		return mView;
	}
	
	private void setUI(){
		ymle_detail_title_TV = (TextView) mView.findViewById(R.id.ymle_detail_title_TV);
		ymle_detail_content_TV = (TextView) mView.findViewById(R.id.ymle_detail_content_TV);
		ymle_detail_author_TV = (TextView) mView.findViewById(R.id.ymle_detail_author_TV);
	}
	
}
