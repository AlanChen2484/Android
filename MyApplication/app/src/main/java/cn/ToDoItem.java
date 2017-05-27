package cn;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.util.Log;

/**
 * 待办事项对象
 *
 * @author Hesky_Fly Date:2014-09-27
 */
public class ToDoItem implements Serializable {

	private static final long serialVersionUID = 3199251197683853468L;
	private long _id;
	private String task; // 待办事项内容
	private Date createTime; // 创建时间(日期及时间)
	private Date time; // 待办事项时间
	private int duplicate; // 重复周期，0表示不提醒,1表示每天重复，2表示每周重复，
	// 3表示每月重复，4表示每年重复
	private String alertTime; // 提醒时间,将多个提醒时间中间用逗号分隔开来
	private int priority; // 优先级,0表示高优先级，1表示中优先级，2表示低优先级

	public ToDoItem(String task) {
		this(task, new Date(java.lang.System.currentTimeMillis()));
	}

	public ToDoItem(String task, Date createTime) {
		super();
		this.task = task;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		return "(" + sdf.format(createTime) + ")" + task;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getCreateDate() {
		return createTime;
	}

	public void setCreateDate(Date createTime) {
		this.createTime = createTime;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setTime(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		if (time != null)
			c.setTime(time);
		c.set(year, month, day);
		time = c.getTime();
	}

	public String getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(String alertTime) {
		this.alertTime = alertTime;
	}

	// 在最后添加一个提醒时间
	public void addAlertTime(Date date) {
		if (alertTime == null)
			alertTime = String.valueOf(date.getTime());
		else
			alertTime = alertTime + "," + String.valueOf(date.getTime());

		Log.i("Hwd", alertTime);
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getDuplicate() {
		return duplicate;
	}

	public void setDuplicate(int duplicate) {
		this.duplicate = duplicate;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}
}
