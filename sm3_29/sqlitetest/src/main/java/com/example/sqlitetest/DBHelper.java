package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VARSION = 1;
    public DBHelper(@Nullable Context context) {
        super(context, "memo_db", null, DATABASE_VARSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tb_memo (_id integer primary key autoincrement, title not null, content not null)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VARSION){
            db.execSQL("DROP TABLE tb_memo");
            onCreate(db);
        }
    }
}
