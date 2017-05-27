package cn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.hesky.todolist.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class ToDoItemEditActivity extends Activity {
	private ToDoItem toDoItem;
	private Button dateBtn, timeBtn; // 事件日期和时间
	private EditText taskEditText; // 时间任务
	private TextView alertTimeTextView; // 提醒时间
	private TextView duplicateTextView; // 重复周期
	private TextView priorityTextView; // 优先级
	private RelativeLayout alertLayout, duplicateLayout, priorityLayout;
	private SimpleDateFormat sfDate;
	private SimpleDateFormat sfTime;

	private TableLayout alertTableLayout;
	private ArrayList<Date> alertTimeArray; // 保存ToDoItem提醒时间
	private final String[] dulicates = new String[] { "不重复", "每天", "每周", "每月",
			"每年" }; // 重复事件周期
	private final String[] prioritys = new String[] { "高", "中", "低" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todo_item_edit);

		dateBtn = (Button) findViewById(R.id.dateBtn);
		timeBtn = (Button) findViewById(R.id.timeBtn);
		taskEditText = (EditText) findViewById(R.id.itemTaskEditText);
		alertTimeTextView = (TextView) findViewById(R.id.itemAlertTime);
		duplicateTextView = (TextView) findViewById(R.id.itemDuplicate);
		priorityTextView = (TextView) findViewById(R.id.itemPriority);

		alertLayout = (RelativeLayout) this.findViewById(R.id.alertLayout);
		alertTableLayout = (TableLayout) findViewById(R.id.alertTableLayout); // 添加事件提醒时间的表格布局
		priorityLayout = (RelativeLayout) findViewById(R.id.priorityLayout);
		duplicateLayout = (RelativeLayout) findViewById(R.id.duplicateLayout);
		Date now = new Date();
		sfDate = new SimpleDateFormat("yyyy-MM-dd E", Locale.CHINA);
		sfTime = new SimpleDateFormat("HH:mm", Locale.CHINA);

		alertTimeArray = new ArrayList<Date>();

		// 先判别是否是 新增待办事项，还是修改待办事项
		// 从Intent对象中extras中获取ToDoItem对象，如果为null说明是新增待办事项
		Bundle extras = getIntent().getExtras();
		if (extras == null || extras.get("todoItem") == null) {
			setTitle("新增待办事项");
			// 创建task为空的ToDoItem对象
			toDoItem = new ToDoItem("");
			toDoItem.set_id(-1);
			toDoItem.setCreateDate(now); // 设置ToDoItem创建时间

			// 新建待办事项，将界面中事件时间设置为当前时间
			dateBtn.setText(sfDate.format(now));
			timeBtn.setText(sfTime.format(now));
			toDoItem.setTime(now); // 设置ToDoItem事件时间

			alertTimeTextView.setText("关闭");
			toDoItem.setAlertTime(null); // 设置ToDoItem事件的提醒时间，null表示不提醒；

			// 新建待办事项，将界面中重复事件设置为不重复
			duplicateTextView.setText("不重复");
			toDoItem.setDuplicate(0); // 设置ToDoItem事件是否为重复事件，0表示不重复

			priorityTextView.setText("中");
			toDoItem.setPriority(1); // 设置ToDoItem事件优先级，1表示中优先级
		} else {
			toDoItem = (ToDoItem) extras.get("todoItem");
			taskEditText.setText(toDoItem.getTask());
			Date date = toDoItem.getTime();
			dateBtn.setText(sfDate.format(date));
			timeBtn.setText(sfTime.format(date));
			if (toDoItem.getAlertTime() == null)
				alertTimeTextView.setText("关闭");
			else {
				// --debug--
				Log.i("Hwd", "toDoItem.AlertTime=" + toDoItem.getAlertTime());
				alertTimeArray = ToDoListUtils.dateStringToArrayList(toDoItem
						.getAlertTime());

				for (int i = 0; i < alertTimeArray.size(); i++) {
					addAlertTimeView(alertTimeArray.get(i));
				}
			}
			duplicateTextView.setText(dulicates[toDoItem.getDuplicate()]);
			priorityTextView.setText(prioritys[toDoItem.getPriority()]);
		}
		// 处理事件日期点击事件
		dateBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment calendarFragment = new CalendarFragment(toDoItem
						.getTime()) {

					@Override
					public void onDateSet(DatePicker view, int year,
										  int monthOfYear, int dayOfMonth) {
						super.onDateSet(view, year, monthOfYear, dayOfMonth);
						toDoItem.setTime(year, monthOfYear, dayOfMonth);
						Date date = toDoItem.getTime();
						dateBtn.setText(sfDate.format(date));
						timeBtn.setText(sfTime.format(date));
					}

				};
				calendarFragment.show(getFragmentManager(), "calendarPcker");
				Toast.makeText(getApplicationContext(),
						toDoItem.getTime().toString(), Toast.LENGTH_LONG)
						.show();
			}
		});
		// 处理事件时间点击事件
		timeBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DialogFragment newFragment2 = new TimePickerFragment(toDoItem
						.getTime()) {
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay,
										  int minute) {
						Calendar c = Calendar.getInstance();
						c.setTime(toDoItem.getTime());
						c.set(Calendar.HOUR_OF_DAY, hourOfDay);
						c.set(Calendar.MINUTE, minute);
						toDoItem.setTime(c.getTime());
						timeBtn.setText(sfTime.format(toDoItem.getTime()));
					}
				};
				newFragment2.show(getFragmentManager(), "timePicker");
			}
		});
		// 处理添加事件提醒时间点击事件
		alertLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 提醒时间设置为事件日子和时间前+10分钟
				Date date = null;
				if (alertTimeArray == null || alertTimeArray.size() == 0)
					date = new Date(
							toDoItem.getTime().getTime() - 10 * 60 * 1000);
				else
					date = new Date(
							alertTimeArray.get(0).getTime() - 10 * 60 * 1000);
				alertTimeArray.add(date);
				Log.i("Hwd",
						"alertTimeArray.add="
								+ ToDoListUtils
								.dateArrayToDateString(alertTimeArray));

				// 调用addAlertTime方法在界面中添加时间组件和删除按钮
				addAlertTimeView(date);

			}
		});
		duplicateLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				new AlertDialog.Builder(ToDoItemEditActivity.this)
						.setTitle("重复")
						.setIcon(android.R.drawable.ic_menu_set_as)
						.setSingleChoiceItems(dulicates,
								toDoItem.getDuplicate(),
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
														int which) {
										toDoItem.setDuplicate(which);
										duplicateTextView
												.setText(dulicates[which]);
										dialog.dismiss();
									}
								}).setNegativeButton("取消", null).show();
			}
		});
		// 处理优先级改变事件
		priorityLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(ToDoItemEditActivity.this)
						.setTitle("优先级")
						.setIcon(android.R.drawable.ic_menu_set_as)
						.setSingleChoiceItems(prioritys,
								toDoItem.getPriority(),
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
														int which) {
										toDoItem.setPriority(which);
										priorityTextView
												.setText(prioritys[which]);
										dialog.dismiss();
									}
								}).setNegativeButton("取消", null).show();
			}
		});
	}

	public void addAlertTimeView(Date alertDate) {
		// 更改提醒标志
		alertTimeTextView.setText("开启");
		TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		// 初始化组件
		TableRow row = new TableRow(ToDoItemEditActivity.this); // 行
		final TextView dateTextView = new TextView(ToDoItemEditActivity.this); // 日期
		final TextView timeTextView = new TextView(ToDoItemEditActivity.this); // 时间
		ImageView deleteImage = new ImageView(ToDoItemEditActivity.this); // 删除按钮

		// 将这一组提醒组件的tag设置为alertTimeNo
		row.setTag(alertDate);

		dateTextView.setTextSize(18);
		Drawable drawable = getResources().getDrawable(R.drawable.bell);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		dateTextView.setCompoundDrawables(drawable, null, null, null);
		dateTextView.setText(sfDate.format(alertDate));
		// 设置时间
		timeTextView.setTextSize(18);
		timeTextView.setText(sfTime.format(alertDate));
		// 设置删除按钮
		deleteImage.setAlpha(255.0f);
		deleteImage.setImageResource(R.drawable.minus);

		// 将组件添加到表格行
		row.addView(dateTextView);
		row.addView(timeTextView);
		row.addView(deleteImage);
		// 将表格行添加到表格
		alertTableLayout.addView(row, layoutParams);
		// 事件处理——设置提醒日期
		dateTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Date date = (Date) ((TableRow) v.getParent()).getTag();
				DialogFragment calendarFragment = new CalendarFragment(date) {
					@Override
					public void onDateSet(DatePicker view, int year,
										  int monthOfYear, int dayOfMonth) {
						Calendar c = Calendar.getInstance();
						c.setTime(date);
						c.set(year, monthOfYear, dayOfMonth);
						ToDoListUtils.changeDateFromDateArray(alertTimeArray,
								date, c.getTime());
						toDoItem.setAlertTime(ToDoListUtils
								.dateArrayToDateString(alertTimeArray));
						dateTextView.setText(sfDate.format(c.getTime()));
					}

				};
				calendarFragment.show(getFragmentManager(), "calendarPcker");
			}
		});
		// 事件处理——设置提醒时间
		timeTextView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Date date = (Date) ((TableRow) v.getParent()).getTag();
				DialogFragment timeFragment = new TimePickerFragment(date) {
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay,
										  int minute) {
						Calendar c = Calendar.getInstance();
						c.setTime(date);
						c.set(Calendar.HOUR_OF_DAY, hourOfDay);
						c.set(Calendar.MINUTE, minute);
						ToDoListUtils.changeDateFromDateArray(alertTimeArray,
								date, c.getTime());
						toDoItem.setAlertTime(ToDoListUtils
								.dateArrayToDateString(alertTimeArray));
						timeTextView.setText(sfTime.format(c.getTime()));
					}
				};
				timeFragment.show(getFragmentManager(), "timePicker");
			}
		});
		// 处理删除该提醒时间
		deleteImage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				TableRow tableRow = (TableRow) v.getParent();
				final Date date = (Date) ((TableRow) v.getParent()).getTag();
				ToDoListUtils.deleteDateFromDateArray(alertTimeArray, date);
				alertTableLayout.removeView(tableRow);
				toDoItem.setAlertTime(ToDoListUtils
						.dateArrayToDateString(alertTimeArray));
				if (alertTimeArray == null || alertTimeArray.size() == 0)
					alertTimeTextView.setText("关闭");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getMenuInflater().inflate(R.menu.todo_item_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Uri uri = null;
		long id = toDoItem.get_id();
		switch (item.getItemId()) {
			case R.id.menu_save:
				toDoItem.setTask(taskEditText.getText().toString());
				ContentResolver cr = this.getContentResolver();
				ContentValues values = new ContentValues();
				values.put(ToDoContentProvider.KEY_TASK, toDoItem.getTask());
				values.put(ToDoContentProvider.KEY_CREATION_DATE, toDoItem
						.getCreateDate().getTime());
				values.put(ToDoContentProvider.KEY_ALERT_TIME,
						ToDoListUtils.dateArrayToDateString(alertTimeArray));
				values.put(ToDoContentProvider.KEY_DUPLICATE,
						toDoItem.getDuplicate());
				values.put(ToDoContentProvider.KEY_PRIORITY, toDoItem.getPriority());
				values.put(ToDoContentProvider.KEY_TIME, toDoItem.getTime()
						.getTime());
				if (id == -1) {
					// 新增待办事项
					cr.insert(ToDoContentProvider.CONTENT_TODOLIST_URI, values);

					// 设置闹钟
					if (alertTimeArray != null && alertTimeArray.size() > 0) {

						// for (int i = 0; i < alertTimeSparseArray.size(); i++) {
						Intent intent = new Intent();
						intent.setAction("com.hesky.intent.action.ToDoLIST_ALARM");
						PendingIntent pi = PendingIntent.getBroadcast(this, 0,
								intent, Intent.FLAG_ACTIVITY_NEW_TASK);

						AlarmManager aManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
						aManager.set(AlarmManager.RTC_WAKEUP, alertTimeArray.get(0)
								.getTime(), pi);
						// 设置AlarmManager将在Calendar对应的时间启动指定组件
						// switch (toDoItem.getDuplicate()) {
						// case 0: // 不重复
						// aManager.set(AlarmManager.RTC_WAKEUP,
						// alertTimeSparseArray.get(i).getTime(), pi);
						// break;
						// case 1: // 每天重复
						// aManager.setRepeating(AlarmManager.RTC_WAKEUP,
						// alertTimeSparseArray.get(i).getTime(),
						// 24 * 60 * 60 * 1000, pi);
						// case 2: //每周重复
						// aManager.setRepeating(AlarmManager.RTC_WAKEUP,
						// alertTimeSparseArray.get(i).getTime(),
						// 7*24 * 60 * 60 * 1000, pi);
						// case 3: //每月重复
						// aManager.setRepeating(AlarmManager.RTC_WAKEUP,
						// alertTimeSparseArray.get(i).getTime(),
						// 24 * 60 * 60 * 1000, pi);
						// case 4: //每年重复
						// aManager.setRepeating(AlarmManager.RTC_WAKEUP,
						// alertTimeSparseArray.get(i).getTime(),
						// 24 * 60 * 60 * 1000, pi);
						// }

						// }
					}

				} else {
					// 修改待办事项
					uri = ContentUris.withAppendedId(
							ToDoContentProvider.CONTENT_TODOLIST_URI, id);
					cr.update(uri, values, null, null);
				}

				finish();
				return true;
			case R.id.menu_cancel:
				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// //获取系统所有AlarmClock
	// public void get_system_alarm_info(){
	// final String tag_alarm="Tag_alarm";
	// Uri uri=Uri.parse("content://com.android.alarmclock/alarm");
	// Cursor c=getContentResolver().query(uri, null, null, null, null);
	// Log.i(tag_alarm, "count of records is "+c.getCount());
	// Log.i(tag_alarm, "number of column are "+c.getColumnCount());
	// if(c!=null){
	// String [] names=c.getColumnNames();
	// for(String temp:names)
	// Log.i(tag_alarm, temp);
	// if(c.moveToFirst()){
	// do{
	// for(int j=0;j<c.getColumnCount();j++){
	// Log.i(tag_alarm, c.getColumnName(j)+" which has value "+c.getString(j));
	// }
	// }while(c.moveToNext());
	// }
	// }
	// }
}
