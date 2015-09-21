package com.example.exedemo;

import com.example.exedemo.entity.User;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.DbUtils.DaoConfig;
import com.lidroid.xutils.DbUtils.DbUpgradeListener;
import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

public class ExeApplication extends Application {
	private static DbUtils dbUtils;
	private static DaoConfig daoConfig;
	private static String dbName = "exedb";
	private static int dbVersion = 1;
	private static String basePath;
	
	public static User currentUser;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if(!initBasePath()){
			Toast.makeText(this, "没有检测到sdCard，该应用程序需要sdCard支持", Toast.LENGTH_LONG).show();
			return;
		}
		initDBUtils();
	}

	private boolean initBasePath(){
		boolean result = true;
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			basePath = Environment.getExternalStorageDirectory().getPath();
		}else{
			result = false;
		}
		return result;
	}
	
	private void initDBUtils() {
		daoConfig = new DaoConfig(this);
		daoConfig.setDbDir(basePath+"/exebase/");
		daoConfig.setDbName(ExeApplication.dbName);
		daoConfig.setDbVersion(ExeApplication.dbVersion);
		daoConfig.setDbUpgradeListener(new DbUpgradeListener() {
			@Override
			public void onUpgrade(DbUtils arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub
			}
		});
		createDBUtils(daoConfig);
	}

	private static void createDBUtils(DaoConfig config) {
		dbUtils = DbUtils.create(daoConfig);
		dbUtils.configAllowTransaction(true);
		dbUtils.configDebug(false);
	}
	
	public static synchronized DbUtils getDbUtils() {
		if (dbUtils == null) {
			createDBUtils(daoConfig);
		}
		return dbUtils;
	}
	
	public static NiftyDialogBuilder getDialogBuilder(Context context){
		NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(context);
		dialogBuilder
        .withTitle("Dialog")                                  //.withTitle(null)  no title
        .withTitleColor("#FFFFFF")                                  //def
        .withDividerColor("#11000000")                              //def
        .withMessage("This is a Dialog.")                     //.withMessage(null)  no Msg
        .withMessageColor("#000000")                              //def  | withMessageColor(int resid)
        .withDialogColor("#F2F2F2")                               //def  | withDialogColor(int resid)                               //def
        .withIcon(context.getResources().getDrawable(R.drawable.ic_launcher))
        .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
        .withDuration(700)                                          //def
        .withEffect(Effectstype.Fliph);
		return dialogBuilder;
	}
}
