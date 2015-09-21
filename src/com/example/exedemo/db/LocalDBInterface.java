package com.example.exedemo.db;

import com.example.exedemo.ExeApplication;
import com.example.exedemo.entity.User;
import com.lidroid.xutils.exception.DbException;
/**
 * 操作本程序的数据库中数据
 * @author Administrator
 *
 */
public class LocalDBInterface {
	
	public static User getLastLoginInfo(){
		User user = null;
		try {
			user = ExeApplication.getDbUtils().findFirst(User.class);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
