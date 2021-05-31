package com.example.sm5_31;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CallLogHolder {
    public ImageView personImageView;
    public TextView nameView;
    public TextView contentView;
    public ImageView dialerImageView;

    public CallLogHolder(View root){
        personImageView = (ImageView) root.findViewById(R.id.main_item_person);
        nameView = (TextView) root.findViewById(R.id.main_item_name);
        contentView = (TextView) root.findViewById(R.id.main_item_date);
        dialerImageView = (ImageView) root.findViewById(R.id.main_item_dialer);
    }
}
