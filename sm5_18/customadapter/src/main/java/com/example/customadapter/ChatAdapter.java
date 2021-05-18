package com.example.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class ChatAdapter extends ArrayAdapter {
    Context context;
    int resId;
    ArrayList<ChatVO> datas;

    public ChatAdapter(Context context, int resId, ArrayList<ChatVO> datas) {
        super(context, resId);
        this.context = context;
        this.resId = resId;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);
            ChatHolder holder = new ChatHolder(convertView);
            convertView.setTag(holder);
        }

        ChatHolder holder = (ChatHolder)convertView.getTag();
        ImageView imageView = holder.typeImageView;
        TextView nameView = holder.nameView;
        TextView dateView = holder.dateView;
        TextView contentView = holder.contentView;

        final ChatVO vo = datas.get(position);

        imageView.setImageResource(R.drawable.hong);
        nameView.setText(vo.name);
        dateView.setText(vo.date);
        contentView.setText(vo.content);

        convertView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context, vo.name+"님의 메시지를 클릭함", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return convertView;
    }
}
