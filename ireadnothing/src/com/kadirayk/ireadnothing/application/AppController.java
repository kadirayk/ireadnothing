package com.kadirayk.ireadnothing.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppController extends Application{

	private static AppController mInstance;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
	
	public static synchronized AppController getInstance(){
		return mInstance;
	}
	
	public static String getLastYMLEDay(Context context){
		SharedPreferences mPrefs = context.getSharedPreferences("AppInfo", MODE_PRIVATE);
		String lastYMLEDay = mPrefs.getString("lastDay", "");
		return lastYMLEDay;
	}
	
	public static void storeLastYMLEDay(Context context, String lastYMLEDay){
		SharedPreferences mPrefs = context.getSharedPreferences("AppInfo", MODE_PRIVATE);
		Editor mEditor = mPrefs.edit();
		mEditor.putString("lastDay", lastYMLEDay);
		mEditor.commit();
	}

	
}
