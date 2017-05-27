package cn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ToDoListInitReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "待办事项正在进行！", Toast.LENGTH_LONG).show();
	}
}
