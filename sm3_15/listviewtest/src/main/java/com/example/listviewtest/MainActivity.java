package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayList<ListItem> items = new ArrayList<>();
        items.add(new ListItem("icon2", "홍길동", "잘지내시죠"));
        items.add(new ListItem("icon1", "강은진", "땡큐가 베리 망치"));
        items.add(new ListItem("icon3", "김가현", "안녕!!!"));
        items.add(new ListItem("icon3", "이유진", "아니!"));
        items.add(new ListItem("icon2", "임채영", "잘지내시죠~~~"));
        items.add(new ListItem("icon2", "정나영", "유지나~~"));
        items.add(new ListItem("icon3", "조한슬", "피곤하다"));
        items.add(new ListItem("icon1", "하늘새미", "잘지내시죠!"));
        items.add(new ListItem("icon2", "한다원", "잘지내시죠"));

        MyAdapter myAdapter = new MyAdapter(items);
        listView.setAdapter(myAdapter);
    }
}
