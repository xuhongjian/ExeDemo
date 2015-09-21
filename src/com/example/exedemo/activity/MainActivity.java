package com.example.exedemo.activity;

import com.example.exedemo.ExeApplication;
import com.example.exedemo.R;
import com.example.exedemo.adapter.LeftMenuAdapter;
import com.example.exedemo.entity.User;
import com.example.exedemo.entity.User.ROLE;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {
	private long mExitTime;
	private Context context;
	private SlidingMenu menu;
	@ViewInject(R.id.btn_left)
	private ImageView btnLeft;
	@ViewInject(R.id.lv_main)
	private PullToRefreshListView mainList;
	private ListView lvLeftMenu;
	private LeftMenuAdapter leftMenuAdapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = this;
		ViewUtils.inject(this);
		initLeftMenu();
		initLeftMenuClickEvent();
		
	}

	private void initLeftMenu(){
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		menu.setMenu(R.layout.left);
		ImageView btnMenuLeft = (ImageView) menu.findViewById(R.id.btn_left);
		btnMenuLeft.setBackgroundResource(R.drawable.ic_launcher);
		TextView tvMenuTitle = (TextView) menu.findViewById(R.id.tv_title);
		tvMenuTitle.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
		tvMenuTitle.setText("掌上考试");
		lvLeftMenu = (ListView) menu.findViewById(R.id.lv_left);
		
		leftMenuAdapter = new LeftMenuAdapter(this, ExeApplication.currentUser.getRole());
		lvLeftMenu.setAdapter(leftMenuAdapter);
		leftMenuAdapter.notifyDataSetChanged();
	}
	
	private void initLeftMenuClickEvent(){
		lvLeftMenu.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(ExeApplication.currentUser.getRole() == ROLE.TEACHER.value){
					switch (position) {
					case 0:
						Intent myInfoActivity = new Intent(context,MyInfoActivity.class);
						startActivity(myInfoActivity);
						break;
					case 1:
						
						break;
					case 2:
						
						break;
					case 3:
						Intent aboutActivity = new Intent(context,AboutActivity.class);
						startActivity(aboutActivity);
						break;
					default:
						break;
					}
				} else if(ExeApplication.currentUser.getRole() == ROLE.STUDENT.value){
					switch (position) {
					case 0:
						Intent myInfoActivity = new Intent(context,MyInfoActivity.class);
						startActivity(myInfoActivity);
						break;
					case 1:
						
						break;
					case 2:
						
						break;
					case 3:
						Intent aboutActivity = new Intent(context,AboutActivity.class);
						startActivity(aboutActivity);
						break;
					default:
						break;
					}
				}
				menu.toggle();
			}
		});
	}
	
	@OnClick(R.id.btn_left)
	private void onClick(View view) {
		menu.toggle();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if(menu.isMenuShowing()){
				menu.toggle();
				return true;
			}
			if ((System.currentTimeMillis() - mExitTime) > 2000) {
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();
			} else {
				finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
