package com.example.apple.daopettern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.apple.daopettern.data.Person;
import com.example.apple.daopettern.data.PersonDAO;
import com.example.apple.daopettern.data.PersonDAOFileImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonDAO impl = new PersonDAOFileImpl(MainActivity.this);
        impl.add(new Person("Bob", "123", "bb123"));


    }
}
