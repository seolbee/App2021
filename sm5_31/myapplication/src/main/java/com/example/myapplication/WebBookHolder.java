package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WebBookHolder{
    public ImageView img;
    public TextView title;
    public TextView date;
    public ImageView icon;
    public TextView text;

    public WebBookHolder(View root){
        this.img = (ImageView) root.findViewById(R.id.img);
        this.title = (TextView) root.findViewById(R.id.title);
        this.date = (TextView) root.findViewById(R.id.content);
        this.icon = (ImageView) root.findViewById(R.id.icon);
        this.text = (TextView) root.findViewById(R.id.text);
    }
}
