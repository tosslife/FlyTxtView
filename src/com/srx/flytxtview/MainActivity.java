package com.srx.flytxtview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private FlyTxtView flyTxtView;
	private TextView resetBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupViews();
		setupListensers();
	}

	protected void setupViews() {
		resetBtn = (TextView) findViewById(R.id.btn_reset);
		flyTxtView = (FlyTxtView) findViewById(R.id.fly_txt);
		flyTxtView.setTextSize(20);
		flyTxtView.setTextColor(Color.GREEN);
		flyTxtView.setTexts("我是一只小小小小鸟,想要飞呀飞 却飞也飞不高,我寻寻觅觅寻寻觅觅一个温暖的怀抱,这样的要求算不算太高");
		flyTxtView.startAnimation();
	}

	protected void setupListensers() {
		resetBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				flyTxtView.setTexts("我是一只来自北方的狼");
				flyTxtView.startAnimation();
			}
		});
	}

}
