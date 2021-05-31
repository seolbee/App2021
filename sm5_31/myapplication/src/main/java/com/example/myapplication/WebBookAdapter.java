package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WebBookAdapter extends ArrayAdapter<WebBookVO> {
    public Context context;
    public int resource;
    public ArrayList<WebBookVO> list;
    public WebBookAdapter(@NonNull Context context, int resource, @NonNull ArrayList<WebBookVO> objects) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        list = objects;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(resource, null);

            WebBookHolder holder = new WebBookHolder(convertView);
            convertView.setTag(holder);
        }
        WebBookHolder holder = (WebBookHolder) convertView.getTag();
        TextView title = holder.title;
        TextView date = holder.date;
        TextView text = holder.text;

        title.setText(list.get(position).title + " " + list.get(position).book_num);
        date.setText(list.get(position).date + "  " + list.get(position).size);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).book_num + "화를 보여드립니다.", Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
