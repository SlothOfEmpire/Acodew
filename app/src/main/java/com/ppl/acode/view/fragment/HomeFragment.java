package com.ppl.acode.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ppl.acode.R;

/**
* File description :
* @author user
* Created at 2017/2/27 10:55.
*/

public class HomeFragment extends BaseFragment {

	private View mContentView;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mContext = getActivity();
		mContentView = inflater.inflate(R.layout.fragment_home_layout,container,false);
		return mContentView;
	}
}
