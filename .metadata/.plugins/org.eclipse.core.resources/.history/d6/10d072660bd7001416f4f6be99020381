package com.kadirayk.ireadnothing.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kadirayk.ireadnothing.R;
import com.kadirayk.ireadnothing.model.YMLE;

public class YMLEAdapter extends BaseAdapter{
	
	private Context mContext;
	private List<YMLE> mYMLEList;
	private LayoutInflater mInflater;
	private View mView;
	
	
	public YMLEAdapter(Context context, List<YMLE> YMLEList) {
		mContext = context;
		mYMLEList = YMLEList;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}

	@Override
	public int getCount() {
		return mYMLEList.size()+1;
	}

	@Override
	public Object getItem(int position) {
		return mYMLEList.get(position - 1);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mHolder = new ViewHolder();
		mView = null;
		
		if(position == 0 ){
			mView = mInflater.inflate(R.layout.ymle_list_header, null);
			return mView;
		}else if(mView == null){
			mView = mInflater.inflate(R.layout.ymle_list_item, null);
		}
		
		mHolder.ymleListItemTitleTV = (TextView) mView.findViewById(R.id.ymleListItemTitleTV);
		mHolder.ymleListAuthorTV = (TextView) mView.findViewById(R.id.ymleListItemAuthorTV);
		
		YMLE item = mYMLEList.get(position-1);
		
		String title = item.getTitle();
		String author = item.getAuthor();
		
		mHolder.ymleListItemTitleTV.setText(title);
		mHolder.ymleListAuthorTV.setText(author);
		
		return mView;
	}
	
	private class ViewHolder {
		TextView ymleListItemTitleTV, ymleListAuthorTV;
	}

}
