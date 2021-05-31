package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<WebBookVO> list;

    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;

    WebBookAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);

        helper = new DBHelper(this);
        db = helper.getWritableDatabase();
        cursor = db.rawQuery("SELECT _id, title, book_num, date, size, expire FROM tb_webbook", null);
        while(cursor.moveToNext()){
            WebBookVO vo = new WebBookVO();
            vo.id = cursor.getInt(0);
            vo.title = cursor.getString(1);
            vo.book_num = cursor.getInt(2);
            vo.date = cursor.getString(3);
            vo.size = cursor.getString(4);
            vo.expire = cursor.getInt(5);
            list.add(vo);
        }

        db.close();

        adapter = new WebBookAdapter(this, R.layout.main_item, list);
        listView.setAdapter(adapter);
    }
}