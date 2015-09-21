package com.example.exedemo.activity;

import com.example.exedemo.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

@ContentView(R.layout.activity_myinfo)
public class MyInfoActivity extends Activity {
	
	private Context context;
	@ViewInject(R.id.btn_left)
	private ImageView btnLeft;
	@ViewInject(R.id.iv_head)
	private ImageView ivHead;
	@ViewInject(R.id.tv_name)
	private TextView tvName;
	@ViewInject(R.id.tv_age)
	private TextView tvAge;
	@ViewInject(R.id.tv_sex)
	private TextView tvSex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.context = this;
		ViewUtils.inject(this);
		btnLeft.setBackgroundResource(R.drawable.head_back_button_select);
		btnLeft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	@OnClick({R.id.iv_head})
	private void onClick(View view){
		switch (view.getId()) {
		case R.id.iv_head:
			
			break;

		default:
			break;
		}
	}
}
