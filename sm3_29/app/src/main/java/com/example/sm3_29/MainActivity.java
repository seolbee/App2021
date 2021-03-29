package com.example.sm3_29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameView, phoneView, emailView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameView = findViewById(R.id.edit_name);
        phoneView = findViewById(R.id.edit_phone);
        emailView = findViewById(R.id.edit_email);

        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == addBtn){
            String name = nameView.getText().toString();
            String email = emailView.getText().toString();
            String phone = phoneView.getText().toString();

            if(name == null || name.equals("")){
                Toast.makeText(this, "이름이 입력되지 않았습니다.", Toast.LENGTH_LONG).show();
            } else {
                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("INSERT INTO contactDB(name, email, phone) VALUES (?, ?, ?)", new String[]{name, email, phone});
                db.close();
                Toast.makeText(this, "새로운 주소록이 등록되었습니다.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, misson1_result.class);
                startActivity(intent);
            }
        }
    }
}