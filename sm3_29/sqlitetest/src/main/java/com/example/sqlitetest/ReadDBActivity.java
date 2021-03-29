package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ReadDBActivity extends AppCompatActivity {

    TextView title, memo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        title = findViewById(R.id.result_title);
        memo = findViewById(R.id.result_memo);
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT title, content FROM tb_memo ORDER BY _id DESC LIMIT 1", null);
        while(cursor.moveToNext()){
            title.setText("title : " + cursor.getString(0));
            memo.setText("content : " + cursor.getString(1));
        }
    }
}