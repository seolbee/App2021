package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.custom_listView);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_chat", null);

        ArrayList<ChatVO> datas = new ArrayList<>();

        while(cursor.moveToNext()) {
            ChatVO vo = new ChatVO();
            vo.content = cursor.getString(3);
            vo.name = cursor.getString(1);
            vo.date = cursor.getString(2);
            datas.add(vo);
        }
        db.close();
        ChatAdapter adapter = new ChatAdapter(this, R.layout.custom_item, datas);
        listView.setAdapter(adapter);
    }
}