package com.ppl.acode.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ppl.acode.R;
import com.ppl.acode.view.fragment.BaseFragment;
import com.ppl.acode.view.fragment.HomeFragment;
import com.ppl.acode.view.fragment.MessageFragment;
import com.ppl.acode.view.fragment.MineFragment;

/**
* File description :
* @author user
* Created at 2017/2/27 11:06.
*/
public class HomeActivity extends BaseActivity implements View.OnClickListener{


	private FragmentManager fm;
	private HomeFragment mHomeFragment;
	private MessageFragment mMessageFragment;
	private MineFragment mMineFragment;

	private RelativeLayout mHomeLayout;
	private RelativeLayout mMessageLayout;
	private RelativeLayout mMineLayout;
	private TextView mHomeView;
	private TextView mMessageView;
	private TextView mMineView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		changeStatusBarColor(R.color.color_fed952);
		setContentView(R.layout.activity_home_layout);
		initView();

		mHomeFragment = new HomeFragment();
		fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.content_layout,mHomeFragment);
		transaction.commit();

	}

	private void initView() {
		mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
		mHomeLayout.setOnClickListener(this);
		mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
		mMessageLayout.setOnClickListener(this);
		mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
		mMineLayout.setOnClickListener(this);

		mHomeView = (TextView) findViewById(R.id.home_image_view);
		mMessageView = (TextView) findViewById(R.id.message_image_view);
		mMineView = (TextView) findViewById(R.id.mine_image_view);
		mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
	}

	@Override
	public void onClick(View view) {
		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		switch (view.getId()){
			case R.id.home_layout_view:
				changeStatusBarColor(R.color.color_fed952);
				 hideFragment(fragmentTransaction,mMessageFragment);
				 hideFragment(fragmentTransaction,mMineFragment);
				mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
				mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
				mMineView.setBackgroundResource(R.drawable.comui_tab_person);

				if (mHomeFragment==null){
					mHomeFragment = new HomeFragment();
					fragmentTransaction.add(R.id.content_layout,mHomeFragment);
				}else{
					fragmentTransaction.show(mHomeFragment);
				}
				break;
			case R.id.message_layout_view:
				changeStatusBarColor(R.color.color_e3e3e3);
				hideFragment(fragmentTransaction,mHomeFragment);
				 hideFragment(fragmentTransaction,mMineFragment);
				mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
				mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
				mMineView.setBackgroundResource(R.drawable.comui_tab_person);

				if (mMessageFragment==null){
					mMessageFragment = new MessageFragment();
					fragmentTransaction.add(R.id.content_layout,mMessageFragment);
				}else{
					fragmentTransaction.show(mMessageFragment);
				}
				break;
			case R.id.mine_layout_view:
				changeStatusBarColor(R.color.white);
				mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);
				mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
				mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
				hideFragment(fragmentTransaction,mMessageFragment );
				hideFragment(fragmentTransaction,mHomeFragment);
				if (mMineFragment == null) {
					mMineFragment = new MineFragment();
					fragmentTransaction.add(R.id.content_layout, mMineFragment);
				} else {
					fragmentTransaction.show(mMineFragment);
				}
				break;

		}
		fragmentTransaction.commit();
	}

	private void hideFragment(FragmentTransaction fragmentTransaction, BaseFragment mMessageFragment) {
		if (mMessageFragment!=null){
			fragmentTransaction.hide(mMessageFragment);
		}
	}
}
