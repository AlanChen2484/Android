package cn;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class ToDoContentProvider extends ContentProvider {
	// 为ToDoContentProvider定义一个Uri，其他应用程序通过ContentResolver使用这个Uri来访问ToDoContentProvider
	public static final Uri CONTENT_TODOLIST_URI = Uri
			.parse("content://com.hesky.todoprovider/todoitems");
	// 定义列名的公有静态变量，这些变量会用在SQLiteOpenHelper类中，用来创建数据库或用于其他应用程序提取你的查询结果集
	public static final String KEY_ID = "_id";
	public static final String KEY_TASK = "task";
	public static final String KEY_CREATION_DATE = "creation_time";
	public static final String KEY_DUPLICATE = "duplicate";
	public static final String KEY_TIME = "time";
	public static final String KEY_ALERT_TIME = "alert_time";
	public static final String KEY_PRIORITY = "priority";

	private MySQLiteOpenHelper myOpenHelper;

	public ToDoContentProvider() {
	}

	@Override
	public boolean onCreate() {
		// 构造底层的数据库
		// 延迟打开数据库，直到需要执行一个查询或事务时再打开
		myOpenHelper = new MySQLiteOpenHelper(getContext(),
				MySQLiteOpenHelper.DATABASE_NAME, null,
				MySQLiteOpenHelper.DATABASE_VERSION);
		return true;
	}

	private static final int ALLROWS = 1;
	private static final int SINGLE_ROW = 2;
	// 创建一个UriMatcher。使得ContentProvider能够区分是全表查询还是针对特定行查询，
	// 在getType方法中根据查询的类型返回争取的MIME类型
	private static final UriMatcher uriMatcher;
	static {
		// 填充UriMatcher对象，以‘element’结尾的URI对应请求全部数据，
		// 以‘elements/[rowID]’结尾的URI对应请求单行数据
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI("com.hesky.todoprovider", "todoitems", ALLROWS);
		uriMatcher.addURI("com.hesky.todoprovider", "todoitems/#", SINGLE_ROW);
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
						String[] selectionArgs, String sortOrder) {
		// 打开一个只读的数据库
		SQLiteDatabase db = myOpenHelper.getReadableDatabase();
		// 必要的话，使用有效地SQL语句替换这些语句
		String groupBy = null;
		String having = null;
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(MySQLiteOpenHelper.DATABASE_TABLE);
		switch (uriMatcher.match(uri)) {
			case SINGLE_ROW:
				String rowID = uri.getPathSegments().get(1);
				queryBuilder.appendWhere(KEY_ID + "=" + rowID);
			default:
				break;
		}
		Cursor cursor = queryBuilder.query(db, projection, selection,
				selectionArgs, groupBy, having, sortOrder);
		return cursor;
	}

	@Override
	// 为一个ContenProvider URI返回一个字符串，它标识了MIME类型
	public String getType(Uri uri) {
		switch (uriMatcher.match(uri)) {
			case ALLROWS:
				return "vnd.android.cursor.dir/vnd.hesky.todos";
			case SINGLE_ROW:
				return "vnd.android.cursor.item/vnd.hesky.todos";
			default:
				throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// 打开一个可读/可写的数据库
		SQLiteDatabase db = myOpenHelper.getWritableDatabase();
		// 要想通过传入一个空的Content
		// Value对象的方式向数据库添加一个空行，必须使用nullColumnHack参数来指定可以设置为null的列名
		String nullColumnHack = null;
		// 向表中插入值
		long id = db.insert(MySQLiteOpenHelper.DATABASE_TABLE, nullColumnHack,
				values);
		// 构造并返回新插入行的URI
		if (id > -1) {
			Uri inserrtID = ContentUris.withAppendedId(CONTENT_TODOLIST_URI, id);
			// 通知所有的观察者，数据集已经改变
			getContext().getContentResolver().notifyChange(inserrtID, null);
			return inserrtID;
		} else
			return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// 打开一个可读/可写的数据库
		SQLiteDatabase db = myOpenHelper.getWritableDatabase();
		// 如果是行URI，限定删除行为为指定的行
		switch (uriMatcher.match(uri)) {
			case SINGLE_ROW:
				String rowID = uri.getPathSegments().get(1);
				selection = KEY_ID
						+ "="
						+ rowID
						+ (!TextUtils.isEmpty(selection) ? " and ( " + selection
						+ ")" : "");
			default:
				break;
		}
		// 要想返回删除的项的数量，必须指定一条where子句。要删除所有的行并返回一个值，则传入“1”
		if (selection == null)
			selection = "1";
		// 执行删除
		int deleteCount = db.delete(MySQLiteOpenHelper.DATABASE_TABLE,
				selection, selectionArgs);
		// 通知所有的观察者，数据集已经改变
		getContext().getContentResolver().notifyChange(uri, null);
		return deleteCount;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
					  String[] selectionArgs) {
		// 打开一个可读/可写的数据库
		SQLiteDatabase db = myOpenHelper.getWritableDatabase();
		// 如果是行URI，限定更新行为为指定的行
		switch (uriMatcher.match(uri)) {
			case SINGLE_ROW:
				String rowID = uri.getPathSegments().get(1);
				selection = KEY_ID
						+ "="
						+ rowID
						+ (!TextUtils.isEmpty(selection) ? " and (" + selection
						+ ")" : "");
			default:
				break;
		}
		// 执行更新
		int updateCount = db.update(MySQLiteOpenHelper.DATABASE_TABLE, values,
				selection, selectionArgs);
		return updateCount;
	}

	private static class MySQLiteOpenHelper extends SQLiteOpenHelper {

		private static final String DATABASE_NAME = "tododatabase.db"; // 数据库名称
		private static final int DATABASE_VERSION = 4; // 数据库版本号
		private static final String DATABASE_TABLE = "todoitemtable"; // To-Do表名

		public MySQLiteOpenHelper(Context context, String name,
								  CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		// 创建数据库的SQL语句
		private static final String DATABASE_CREATE_SQL = "create table "
				+ DATABASE_TABLE + " (" + KEY_ID
				+ " integer primary key autoincrement, " + KEY_TASK
				+ " text not null, " + KEY_CREATION_DATE + " long, "
				+ KEY_DUPLICATE + " integer, " + KEY_TIME + " long, "
				+ KEY_ALERT_TIME + " text, " + KEY_PRIORITY + " integer" + ");";

		// 当在磁盘中没有数据库时调用该方法，辅助类会创建一个新的数据库
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE_SQL);
		}

		// 当数据库版本不匹配时调用该方法将磁盘中数据升级到当前版本
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// 纪录版本升级
			Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion
					+ " to " + newVersion + ", which will destroy all old data");
			// 将现有的数据库升级到新版本，通过比较oldVersion和newVersion的值来处理多个版本。
			// 最简单的方式就是删除旧的表，再创建新表
			db.execSQL("drop table if exists " + DATABASE_TABLE);
			// 创建新表
			onCreate(db);
		}
	}
}
