package com.example.moonky_rider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class StoreListView extends LinearLayout {
    TextView text_name;
    TextView text_price;
    TextView text_comment;


    public StoreListView(Context context) {
        super(context);
        init(context);
    }

    public StoreListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_storelist, this, true);
        text_price = (TextView) findViewById(R.id.store_price);
        text_name = (TextView) findViewById(R.id.store_name);
        //text_comment=(TextView) findViewById(R.id.store_address);
    }
    public void setName(String name) {
        text_name.setText(name);
    }
    public void setPrice(int price){ text_price.setText(price+"원");}
    public void setComment(String comment){text_comment.setText(comment);}


}
