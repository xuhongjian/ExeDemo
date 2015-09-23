package com.example.exedemo.activity;

import com.example.exedemo.ExeApplication;
import com.example.exedemo.R;
import com.example.exedemo.db.LocalDBInterface;
import com.example.exedemo.entity.User;
import com.example.exedemo.entity.User.ROLE;
import com.example.exedemo.manager.StudentManager;
import com.example.exedemo.manager.TeacherManager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@ContentView(R.layout.activity_login)
public class LoginActivity extends Activity {
	@ViewInject(R.id.edt_name)
	private EditText edtName;
	@ViewInject(R.id.edt_pwd)
	private EditText edtPwd;
	@ViewInject(R.id.btn_login)
	private Button btnLogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		ExeApplication.currentUser = LocalDBInterface.getLastLoginInfo();
		if(ExeApplication.currentUser != null){
			edtName.setText(ExeApplication.currentUser.getName());
			edtPwd.setText(ExeApplication.currentUser.getPwd());
		}else{
			ExeApplication.currentUser = new User();
		}
	}
	
	@OnClick(R.id.btn_login)
	private void onClick(View view){
		String userName = edtName.getText().toString().trim();
		String userPwd = edtPwd.getText().toString().trim();
		
		if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(userPwd)){
			Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_LONG).show();
			return;
		}
		
		if(!"teacher".equals(userName) && !"student".equals(userName)){
			Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_LONG).show();
			return;
		}
		
		if("teacher".equals(userName)){
			ExeApplication.currentUser.setRole(ROLE.TEACHER.value);
			ExeApplication.currentUser.setManager(new TeacherManager());
		} else if("student".equals(userName)){
			ExeApplication.currentUser.setRole(ROLE.STUDENT.value);
			ExeApplication.currentUser.setManager(new StudentManager());
		}
		
		ExeApplication.currentUser.setName(userName);
		ExeApplication.currentUser.setPwd(userPwd);
		ExeApplication.currentUser.save();
		
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
		finish();
	}
}
