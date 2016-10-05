package com.example.apple.daopettern.data;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/10/5.
 */

//這邊是處理資料的類別部分
public class PersonDAOFileImpl implements PersonDAO {
    Context context;
    //必須要他取得 否則無法繼續下去
    public PersonDAOFileImpl(Context context)
    {
        this.context = context;
    }
    @Override
    public void add(Person p) {
        //新增一個List為一個ArrayList
        ArrayList<Person> mylist = (ArrayList)getList();
        mylist.add(p);
        Type listOfTestObject = new TypeToken<List<Person>>(){}.getType();
        Gson gson = new Gson();
        String s = gson.toJson(mylist, listOfTestObject);
        Log.d("ADD", s);

        //將資料寫入外部存擋讀檔
        File file =  new File(context.getFilesDir().getAbsolutePath(),
                "person.txt");
        //代表輸出串流 byte
        FileOutputStream fOut = null;
        try {
            //這個會直接在資料夾裡開一個檔名
            fOut = new FileOutputStream(file);
            //會用此方法接outputStream
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            //將字串轉成位元組陣列轉進去
            osw.write(s);
            //寫完後關閉
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Person p) {

    }

    @Override
    //取得檔案前須先在gradle中設定gson，getlist讓他抓取資料
    public List<Person> getList() {
        //建立ArrayList讓他跑到file
        ArrayList<Person> mylist = new ArrayList();

        char[] buffer = new char[1];
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();
        //先建一個物件並將物件指向檔案
        File file = new File(context.getFilesDir().getAbsolutePath(), "test.txt");
        try {
            //讀到檔案
            fr = new FileReader(file);
            //跑完後會一點一點讀進去
            while (fr.read(buffer)!= -1){
                sb.append(new String(buffer));
            }
            /*寫入gson讓Arraylist可以讀到Gson裡頭的資料，否則會null時會跑至例外程式去*/
            Gson gson = new Gson();
            mylist = gson.fromJson(sb.toString(), new TypeToken<List<Person>>(){}.getType());

        }
        catch (IOException e) {

        } finally{
            try{
                fr.close();//關閉檔案
            //將IOException更改為Exception
            } catch (Exception e) {

            }
        }
        /*抓取完畢回傳list*/
        return mylist;
    }

    @Override
    public void updata(Person p) {

    }
}
