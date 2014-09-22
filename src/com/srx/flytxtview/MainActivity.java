package com.srx.flytxtview;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
	private FlyTxtView flyTxtView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupViews();
	}
	
	protected void setupViews(){
		flyTxtView=(FlyTxtView)findViewById(R.id.fly_txt);
		flyTxtView.setTexts("我是一只小小小小鸟,想要飞呀飞 却飞也飞不高,我寻寻觅觅寻寻觅觅一个温暖的怀抱,这样的要求算不算太高");
		flyTxtView.startAnimation();
	}



}
