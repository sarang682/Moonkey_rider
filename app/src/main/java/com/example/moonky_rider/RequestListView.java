package com.example.moonky_rider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class RequestListView extends LinearLayout {

    TextView text_fee;
    TextView text_destination;

    public RequestListView(Context context) {
        super(context);
        init(context);
    }

    public RequestListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_requestlist, this, true);
        text_fee = (TextView) findViewById(R.id.request_fee);
        text_destination = (TextView) findViewById(R.id.request_destination);
    }
    public void setText_fee(String fee) {
        text_fee.setText("배달료 : "+fee+"원");
    }
    public void setText_destination(String destination){ text_destination.setText("도착지 : "+destination);}
}
