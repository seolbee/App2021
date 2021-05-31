package com.example.sm5_31;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "calldb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql = "create table tb_calllog (" +
                "_id integer primary key autoincrement," +
                "name not null," +
                "photo," +
                "date," +
                "phone)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_calllog (name,photo,date,phone) values ('홍길동','yes','휴대전화,1일전','010000')");
        db.execSQL("insert into tb_calllog (name,photo,date,phone) values ('김길동','yes','휴대전화,2일전','020000')");
        db.execSQL("insert into tb_calllog (name,photo,date,phone) values ('고길동','yes','휴대전화,3일전','030000')");
        db.execSQL("insert into tb_calllog (name,photo,date,phone) values ('윤길동','yes','휴대전화,4일전','040000')");
        db.execSQL("insert into tb_calllog (name,photo,date,phone) values ('노길동','yes','휴대전화,5일전','050000')");
        db.execSQL("insert into tb_calllog (name,photo,date,phone) values ('한길동','yes','휴대전화,6일전','060000')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_calllog");
            onCreate(db);
        }
    }
}
