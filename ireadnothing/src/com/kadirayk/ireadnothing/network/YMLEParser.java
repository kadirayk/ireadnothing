package com.kadirayk.ireadnothing.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.app.Fragment;
import android.widget.Toast;

import com.kadirayk.ireadnothing.application.AppController;
import com.kadirayk.ireadnothing.fragments.YMLEFragment;
import com.kadirayk.ireadnothing.model.YMLE;

public class YMLEParser {

	private Context mContext;
	private Fragment currentFragment;
	private YMLETask mYMLETask;
	
	String YMLE_URL = "http://www.eksisozluk.com/debe";
	ProgressDialog mProgressDialog;
	
	
	public YMLEParser(Context context, Fragment fragmet) {
		mContext = context;
		currentFragment = fragmet;
		mYMLETask = new YMLETask();
	}
	
	
	public boolean isConnected(Context mContext) {
		ConnectivityManager connMgr = (ConnectivityManager) mContext.getSystemService(Activity.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected())
			return true;
		else
			return false;
	}
	
	
	public void callYMLETask() {
		if (isConnected(mContext)) {
			mYMLETask.execute();
		} else {
			Toast.makeText(mContext, "Sorun internet baðlantýsýnda, bizle alakasý yok.", Toast.LENGTH_SHORT).show();
		}
	}
	
	//YMLE AsyncTask
	private class YMLETask extends AsyncTask<Void, Void, List<YMLE>> {
		
		List<String> YMLEs = new ArrayList<String>();
		List<YMLE> mYMLEs = new ArrayList<YMLE>();
 
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = new ProgressDialog(mContext);
			mProgressDialog.setTitle("baþlýk var, baþlýk var");
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			mProgressDialog.show();
		}
 
		@Override
		protected List<YMLE> doInBackground(Void... params) {
			try {
				
				Document document = Jsoup.connect(YMLE_URL).get();
				
				Elements YMLETitle = document.select("span[class=\"caption\"]");
				Elements YMLEAuthor = document.select("div[class=\"detail\"]");
				Elements YMLELink = document.select("ol li a");		
				
				int i = 0;
				String today = AppController.getSystemDate();
				for (Element element : YMLELink) {
					YMLE mYMLE = new YMLE();
					
					mYMLE.setPlace(i+1);
		            mYMLE.setTitle(YMLETitle.get(i).text());
		            mYMLE.setAuthor(YMLEAuthor.get(i).text());
					mYMLE.setUrl(element.attr("href"));
					//TODO
					mYMLE.setDate(today);
					
					          
		            mYMLEs.add(mYMLE);
		            
					YMLEs.add(element.attr("href"));
		            
		            i++;
		        }
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return mYMLEs;
		}
 
		@Override
		protected void onPostExecute(List<YMLE> result) {
			if (result == null) {
				Toast.makeText(mContext, "baþaramadýk :(", Toast.LENGTH_SHORT).show();
			} else {
				((YMLEFragment) currentFragment).OnYMLEResponseRecieved(result);
			}
			super.onPostExecute(result);
			mProgressDialog.dismiss();
		}
	}
	
}
