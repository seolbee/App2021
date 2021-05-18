package com.example.customadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=8;

    public DBHelper(Context context){
        super(context, "itemDB", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String driverTable="create table tb_chat ("+
                "_id integer primary key autoincrement," +
                "name," +
                "date," +
                "content)";
        db.execSQL(driverTable);
        db.execSQL("insert into tb_chat (name, date, content) values ('홍길동','18/3/5', '안녕하세요 잘 지내시는 지요')");
        db.execSQL("insert into tb_chat (name, date, content) values ('도깨비','18/4/5', '안녕 ~ 도깨비 신부')");
        db.execSQL("insert into tb_chat (name, date, content) values ('서준희','18/6/8', '밥 잘 사주는 예쁜 누나 봐야 되')");
        db.execSQL("insert into tb_chat (name, date, content) values ('이서진','18/7/12', '나 짐꾼하기 싫은데...')");
        db.execSQL("insert into tb_chat (name, date, content) values ('이엄지','18/7/30', '...뭐야?')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_chat");
            onCreate(db);
        }
    }
}
