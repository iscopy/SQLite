package com.win.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Vector;

/**
 * Created by Administrator on 2018/3/22 0022.
 * 在这里创建一个 SQLite 数据库
 */

public class MySQLite  extends SQLiteOpenHelper {

    private static final String DB_NAME = "School.db"; //数据库名称
    private static final int DB_VERSION = 1;                 //版本

    public MySQLite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建一个 student 数据表 （id、name、sex、age）
        String student = "create table student(" +
                "id integer primary key autoincrement," +
                "name varchar2 not null," +
                "sex varchar2 not null," +
                "age integer not null)";
        db.execSQL(student);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //插入数据方法
    public void insertStudent(StudentModel sm, SQLiteDatabase db){
        //实例化常量值
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", sm.getName());
        contentValues.put("sex", sm.getSex());
        contentValues.put("age", sm.getAge());
        Log.i("name", sm.getName());
        Log.i("sex", sm.getSex());
        Log.i("age", ""+sm.getAge());
        db.insert("student", null, contentValues);
    }

    //查询数据方法
    public Vector<StudentModel> querys(SQLiteDatabase db){
        //定义一个 Vector<StudentModel>
        Vector<StudentModel> vector = new Vector<StudentModel>();
        StudentModel sm = null;

        //获取查询光标（用 query()方法将所有都查出来）
        Cursor cursor = db.query("student", null, null, null, null, null, null);

        //移动光标到第一个
        if(cursor.moveToFirst()){
            //将数据放入 StudentModel 对象，并放入 vector 集合
            sm = new StudentModel();
            sm.setId(cursor.getInt(cursor.getColumnIndex("id")));
            sm.setName(cursor.getString(cursor.getColumnIndex("name")));
            sm.setSex(cursor.getString(cursor.getColumnIndex("sex")));
            sm.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            vector.add(sm);
            //如果有下一个
            while(cursor.moveToNext()){
                sm = new StudentModel();
                sm.setId(cursor.getInt(cursor.getColumnIndex("id")));
                sm.setName(cursor.getString(cursor.getColumnIndex("name")));
                sm.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                sm.setAge(cursor.getInt(cursor.getColumnIndex("age")));
                vector.add(sm);
            }
        }
        //关闭光标
        cursor.close();
        //返回 StudentModel 对象集合
        return vector;
    }

}
