package com.win.sqlite;

/**
 * Created by Administrator on 2018/3/22 0022.
 */

public class StudentModel {

    private int id;         //学生id
    private String name;    //学生姓名
    private String sex;     //学生性别
    private int age;        //学生年龄

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
