package com.example.moongky_rider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class RequestWorkListView extends LinearLayout {

    TextView text_date;
    TextView text_ridername;

    public RequestWorkListView(Context context) {
        super(context);
        init(context);
    }

    public RequestWorkListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_requestworklist, this, true);
        text_date = (TextView) findViewById(R.id.request_work);
        text_ridername = (TextView) findViewById(R.id.request_ridername);
    }
    public void setText_date(String date) {
        text_date.setText("승인 요청 일자 : "+date);
    }
    public void setText_ridername(String rider_name){ text_ridername.setText("요청자 : "+rider_name);}
}