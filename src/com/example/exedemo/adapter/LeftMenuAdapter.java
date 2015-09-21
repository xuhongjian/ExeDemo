package com.example.exedemo.adapter;

import com.example.exedemo.R;
import com.example.exedemo.entity.User;
import com.example.exedemo.utils.Constant;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LeftMenuAdapter extends BaseAdapter {
	
	private Context context;
	private int role;
	private String[] menuList;
	
	/**
	 * @param context
	 * @param role  0老师  1学生
	 */
	public LeftMenuAdapter(Context context,int role){
		this.context = context;
		this.role = role;
		initMenuData();
	}
	
	private void initMenuData(){
		if(role == User.ROLE.TEACHER.value){
			menuList = Constant.teacherLeftMenu;
		}else if(role == User.ROLE.STUDENT.value){
			menuList = Constant.studentLeftMenu;
		}
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuList.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return menuList[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HoldView view = null;
		if(convertView == null){
			view = new HoldView();
			convertView = LayoutInflater.from(context).inflate(R.layout.item_left_menu, null);
			view.tvMenu = (TextView) convertView.findViewById(R.id.tv_menu);
			convertView.setTag(view);
		}else{
			view = (HoldView) convertView.getTag();
		}
		view.tvMenu.setText(menuList[position]);
		return convertView;
	}
	
	private class HoldView{
		public TextView tvMenu;
	}
}
