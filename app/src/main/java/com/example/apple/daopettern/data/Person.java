package com.example.apple.daopettern.data;

/**
 * Created by apple on 16/10/5.
 */
public class Person {

    //建立一個Constroct讓MainActivity可以寫入
    public Person(String a, String b, String c)
    {
        ID = 1;
        this.Name = a;
        this.Tel = b;
        this.Adder = c;
    }
    int ID;
    String Name;
    String Tel;
    String Adder;
}
