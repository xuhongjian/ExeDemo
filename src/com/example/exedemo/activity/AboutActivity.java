package com.example.exedemo.activity;

import com.example.exedemo.ExeApplication;
import com.example.exedemo.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

@ContentView(R.layout.activity_about)
public class AboutActivity extends Activity {
	@ViewInject(R.id.btn_left)
	private ImageView btnLeft;
	@ViewInject(R.id.btn_check)
	private Button btn_check;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
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
	
	@OnClick(R.id.btn_check)
	private void onClick(View view){
		final NiftyDialogBuilder builder = ExeApplication.getDialogBuilder(this);
		builder.withTitle("提示");
		builder.withMessage("已经是最新版本！");
		builder.withButton1Text("确定");
		builder.setButton1Click(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.dismiss();
			}
		});
		builder.show();
	}
}
