package com.example.moonky_rider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LicenseListView extends LinearLayout {
    TextView text_price;
    TextView text_num;
    TextView text_address;


    public LicenseListView(Context context) {
        super(context);
        init(context);
    }

    public LicenseListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_licneselist, this, true);
        text_num = (TextView) findViewById(R.id.tv_num);
        text_address = (TextView) findViewById(R.id.tv_address2);
        text_price = (TextView) findViewById(R.id.tv_price);
    }
    public void setNum(String num) {
        text_num.setText("식별번호 : "+num);
    }
    public void setDate(String date){
        text_num.setText("발급일자: "+date);
    }

}