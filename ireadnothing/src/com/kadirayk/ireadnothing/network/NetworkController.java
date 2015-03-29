package com.kadirayk.ireadnothing.network;

import java.util.List;

import com.kadirayk.ireadnothing.model.YMLE;

public class NetworkController {

	public NetworkController() {

	}

	public interface OnTitleResponseRecievedListener {
		public void OnTitleResponseRecieved(String response);
		//TODO String?
	}
	
	public interface OnYMLEResponseRecievedListener {
		public void OnYMLEResponseRecieved(List<YMLE> YMLEs);
	}
	
}
