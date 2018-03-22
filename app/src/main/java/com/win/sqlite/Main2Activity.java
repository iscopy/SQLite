package com.win.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Vector;

public class Main2Activity extends AppCompatActivity {

    private ListView list_item;
    private Vector<StudentModel> vector;
    private StudentModel sm = null;
    private String[] data;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //  获取可读写的数据库;
        db = new  MySQLite(this).getReadableDatabase();

        list_item = (ListView) findViewById(R.id.list_item);

        //查询 SQLite 中的数据
        MySQLite mySQLite = new MySQLite(Main2Activity.this);
        vector = mySQLite.querys(db);
        data = new String[vector.size()];
        for(int i=0;i<vector.size();i++){
            sm = vector.get(i);
            int id = sm.getId();
            String name = sm.getName();
            String sex = sm.getSex();
            int age = sm.getAge();
            data[i] = "id:"+id+" name:"+name+" sex:"+sex+" age:"+age;
        }
        //通过 ListView 展示数据
        list_item.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
    }
}
