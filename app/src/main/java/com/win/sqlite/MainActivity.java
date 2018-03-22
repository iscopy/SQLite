package com.win.sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name, sex, age;
    private Button submit, search;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  获取可读写的数据库;
        db = new  MySQLite(this).getReadableDatabase();

        name = (EditText) findViewById(R.id.name);
        sex = (EditText) findViewById(R.id.sex);
        age = (EditText) findViewById(R.id.age);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在这里获取输入的数据，调用方法将数据存入 SQLite 的student表中
                StudentModel sm = new StudentModel();
                sm.setName(name.getText().toString());
                sm.setSex(sex.getText().toString());
                sm.setAge(Integer.parseInt(age.getText().toString()));

                MySQLite mySQLite = new MySQLite(MainActivity.this);
                mySQLite.insertStudent(sm, db);
            }
        });

        //点击了查看，就跳转到 Main2Activity 界面展示数据
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });

    }
}
