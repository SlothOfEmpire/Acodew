package com.ppl.acode.application;

import android.app.Application;

/**
 * Created by user on 2017/2/27.
 */

public class MyApplication extends Application {
	private static MyApplication instance = null;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}
	public static MyApplication getInstance(){
		return instance;
	}
}
