package com.example.moonky_rider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AcceptActivity extends AppCompatActivity {

    private TextView tv_fee,tv_destination,tv_store,tv_address,tv_requested,tv_sphone,tv_cphone;
    private Button call_store, take_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptorder);
        Delivery item= (Delivery) getIntent().getSerializableExtra("deliveryItem");

        tv_fee=findViewById(R.id.tv_fee);
        tv_destination=findViewById(R.id.tv_destination);
        tv_store=findViewById(R.id.tv_store);
        tv_address=findViewById(R.id.tv_address);
        tv_requested=findViewById(R.id.tv_requested);
        tv_cphone=findViewById(R.id.tv_cphone);
        tv_sphone=findViewById(R.id.tv_sphone);

        call_store=findViewById(R.id.call_store);
        take_order=findViewById(R.id.take_order);

//        tv_fee.setText(Integer.toString(item.getFee())+"원");
//        tv_destination.setText(item.getDestination());
//        tv_store.setText(item.getStore());
//        tv_address.setText(item.getAddress());
//        tv_requested.setText(item.getRequested());
//        tv_cphone.setText(item.getC_phone());
//        tv_sphone.setText(item.getS_phone());

        call_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+item.getS_phone()));
//                startActivity(tt);
            }
        });

        take_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"접수되었습니다",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}