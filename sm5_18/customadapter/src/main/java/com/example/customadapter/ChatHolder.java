package com.example.customadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatHolder {
    public ImageView typeImageView;
    public TextView nameView;
    public TextView dateView;
    public TextView contentView;

    public ChatHolder(View root){
        typeImageView = root.findViewById(R.id.img);
        nameView = root.findViewById(R.id.name);
        dateView = root.findViewById(R.id.date);
        contentView = root.findViewById(R.id.content);
    }
}
