package com.example.exedemo.adapter;

import java.util.List;

import com.example.exedemo.R;
import com.example.exedemo.entity.StudentTestPaper;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StudentTestPaperAdapter extends BaseAdapter {

	private Context context;
	private List<StudentTestPaper> testPapers;
	
	public StudentTestPaperAdapter(Context context,List<StudentTestPaper> testPapers){
		this.context = context;
		this.testPapers = testPapers;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return testPapers.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return testPapers.get(position);
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
			convertView = LayoutInflater.from(context).inflate(R.layout.item_stu_testpaper, null);
			view.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
			view.tvType = (TextView) convertView.findViewById(R.id.tv_type);
			view.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
			view.tvDate = (TextView) convertView.findViewById(R.id.tv_date);
			view.tvStatu = (TextView) convertView.findViewById(R.id.tv_statu);
			convertView.setTag(view);
		}else{
			view = (HoldView) convertView.getTag();
		}
		view.tvTitle.setText(testPapers.get(position).getTestTitle());
		view.tvType.setText("科目："+testPapers.get(position).getTestTypeStr());
		view.tvTime.setText("时间："+testPapers.get(position).getLongTime()+"分钟");
		view.tvDate.setText("开考时间："+testPapers.get(position).getExamStartTime());
		view.tvStatu.setText("状态："+testPapers.get(position).getStatuStr());
		return convertView;
	}
	
	private class HoldView{
		public TextView tvTitle;
		public TextView tvType;
		public TextView tvTime;
		public TextView tvDate;
		public TextView tvStatu;
	}
}
