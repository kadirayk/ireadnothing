package com.kadirayk.ireadnothing.network;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.kadirayk.ireadnothing.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class YMLEParser {

	
	private Context mContext;
	private Fragment currentFragment;
	private TitleTask mTitleTask;
	
	String url = "http://www.ururulrllrllrlaurl.com";
	ProgressDialog mProgressDialog;
	
	
	public YMLEParser(Context context, Fragment fragmet) {
		mContext = context;
		currentFragment = fragmet;
		mTitleTask = new TitleTask();
	}
	
	
	public boolean isConnected(Context mContext) {
		ConnectivityManager connMgr = (ConnectivityManager) mContext.getSystemService(Activity.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected())
			return true;
		else
			return false;
	}
	
	public void callLoginTask() {
		if (isConnected(mContext)) {
			mTitleTask.execute();
		} else {
			Toast.makeText(mContext, "L�tfen internet ba�lant�n�z� kontrol ediniz.", Toast.LENGTH_SHORT).show();
		}
	}
	
	// Title AsyncTask
	private class TitleTask extends AsyncTask<Void, Void, Void> {
		String title;
 
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = new ProgressDialog(mContext);
			mProgressDialog.setTitle("Android Basic JSoup Tutorial");
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			mProgressDialog.show();
		}
 
		@Override
		protected Void doInBackground(Void... params) {
			try {
				// Connect to the web site
				Document document = Jsoup.connect(url).get();
				// Get the html document title
				title = document.title();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
 
		@Override
		protected void onPostExecute(Void result) {
			// Set title into TextView
//				TextView txttitle = (TextView) findViewById(R.id.);
//				txttitle.setText(title);
			mProgressDialog.dismiss();
		}
	}
	
}
