package com.example.sm3_29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class misson1_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misson1_result);
        TextView nameView = findViewById(R.id.result_name);
        TextView emailView = findViewById(R.id.result_email);
        TextView phoneView = findViewById(R.id.result_phone);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT name, phone, email FROM contactDB ORDER BY _id DESC LIMIT 1", null);

        while(cursor.moveToNext()){
            nameView.setText(cursor.getString(0));
            phoneView.setText(cursor.getString(1));
            emailView.setText(cursor.getString(2));
        }

        cursor.close();
        db.close();
    }
}