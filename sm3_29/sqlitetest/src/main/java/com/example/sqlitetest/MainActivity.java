package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText title, memo;
    private Button memo_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.edit_title);
        memo = findViewById(R.id.edit_memo);

        memo_btn = findViewById(R.id.memo_btn);

        memo_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        if(v == memo_btn){
//
//        }
        String result_title = title.getText().toString();
        String result_memo = memo.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO tb_memo(title, content) VALUES (?, ?)", new String[]{result_title, result_memo});
        db.close();
        Intent intent = new Intent(this, ReadDBActivity.class);
        startActivity(intent);
    }
}