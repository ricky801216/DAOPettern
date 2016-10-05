package com.example.apple.daopettern.data;

import java.util.List;

/**
 * Created by apple on 16/10/5.
 */
//建立一個DAO讓他可以給其他類別實作方法
public interface PersonDAO {
    public void add (Person p);
    public void delete(Person p);
    public List<Person> getList();
    public void updata(Person p);
}
