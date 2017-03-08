package com.ppl.acode.activity;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.ppl.acode.util.StatusBarUtil;

/**
 * Created by user on 2017/2/27.
 */

public class BaseActivity extends AppCompatActivity {
	public String Tag;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Tag = getComponentName().getShortClassName();
		Log.i(Tag,Tag+" oncreate");
		reverseStatusColor();
	}
	/**
	 * 隐藏状态栏
	 */
	public void hiddenStatusBar() {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	/**
	 * 改变状态栏颜色
	 *
	 * @param color
	 */
	public void changeStatusBarColor(@ColorRes int color) {
		StatusBarUtil.setStatusBarColor(this, color);
	}

	/**
	 * 调整状态栏为亮模式，这样状态栏的文字颜色就为深模式了。
	 */
	private void reverseStatusColor() {
		StatusBarUtil.statusBarLightMode(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
}
