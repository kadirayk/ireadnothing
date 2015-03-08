package com.kadirayk.ireadnothing.network;

import java.util.List;

import com.kadirayk.ireadnothing.network.model.YMLE;

public class Controller {

	public Controller() {

	}

	public interface OnTitleResponseRecievedListener {
		public void OnTitleResponseRecieved(String response);
		//TODO String?
	}
	
	public interface OnYMLEResponseRecievedListener {
		public void OnYMLEResponseRecieved(List<String> YMLEs);
	}
	
}
