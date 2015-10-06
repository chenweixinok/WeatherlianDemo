package weatherliandemo.activity;

import weatherliandemo.app.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Toast;

public class LaunchActivity extends Activity{
	
	//private ProgressDialog pDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.launch_activity);
		
		
		/**
		 *
		 * 
		pDialog = new ProgressDialog(this);
		pDialog.setCancelable(false);
		pDialog.setMessage("正在加载...");
		pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pDialog.show();
		 * 
		 */
		
		Toast.makeText(this, "正在加载...", 3000).show();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);//异步线程中不能设置UI
				} catch (Exception e) {
					e.printStackTrace();
				}
				launchSend();
			}
		}).start();
	}
	
	private void launchSend() {
		
		Intent intent = new Intent(LaunchActivity.this, ChooseAreaActivity.class);
		startActivity(intent);
		finish();
		
	}
	
	
	
	
	/**
	 * 拦截返回键
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
}
