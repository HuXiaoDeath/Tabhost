package com.example.zzztabhost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements OnCheckedChangeListener  {

	private TabHost mHost;
	private Intent mMBlogIntent;
	private Intent mMoreIntent;
	private Intent mInfoIntent;
	private Intent mSearchIntent;
	private Intent mUserInfoIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// ~~~~~~~~~~~~ 初始化
		this.mMBlogIntent = new Intent(this, HomeActivity.class);
		this.mSearchIntent = new Intent(this, HomeActivity2.class);
		this.mInfoIntent = new Intent(this, HomeActivity3.class);
		this.mUserInfoIntent = new Intent(this, HomeActivity4.class);
		this.mMoreIntent = new Intent(this, HomeActivity5.class);

		initRadios();

		setupIntent();
	}

	/**
	 * 初始化底部按钮
	 */
	private void initRadios() {
		((RadioButton) findViewById(R.id.radio_button0))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_button1))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_button2))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_button3))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_button4))
				.setOnCheckedChangeListener(this);
	}

	/**
	 * 切换模块
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
		switch (buttonView.getId()) {
		case R.id.radio_button0:
			this.mHost.setCurrentTabByTag("mblog_tab");
			break;
		case R.id.radio_button1:
			this.mHost.setCurrentTabByTag("message_tab");
			break;
		case R.id.radio_button2:
			this.mHost.setCurrentTabByTag("userinfo_tab");
			break;
		case R.id.radio_button3:
			this.mHost.setCurrentTabByTag("search_tab");
			break;
		case R.id.radio_button4:
			this.mHost.setCurrentTabByTag("more_tab");
			break;
		}
	}
		
	}
	

	private void setupIntent() {
		this.mHost = getTabHost();
		TabHost localTabHost = this.mHost;

		localTabHost.addTab(buildTabSpec("mblog_tab", "main_home",
				R.drawable.ic_launcher, this.mMBlogIntent));

		localTabHost.addTab(buildTabSpec("message_tab", "main_news",
				R.drawable.ic_launcher, this.mInfoIntent));

		localTabHost.addTab(buildTabSpec("userinfo_tab", "main_my_info",
				R.drawable.ic_launcher, this.mUserInfoIntent));

		localTabHost.addTab(buildTabSpec("search_tab", "menu_search",
				R.drawable.ic_launcher, this.mSearchIntent));

		localTabHost.addTab(buildTabSpec("more_tab", "more",
				R.drawable.ic_launcher, this.mMoreIntent));

	}

	private TabHost.TabSpec buildTabSpec(String tag, String resLabel,
			int resIcon, final Intent content) {
		return this.mHost.newTabSpec(tag)
				.setIndicator(resLabel, getResources().getDrawable(resIcon))
				.setContent(content);
	}



	

}
