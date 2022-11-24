package com.example.moonky_rider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OngoingActivity extends AppCompatActivity {

    private TextView tv_fee,tv_destination,tv_store,tv_address,tv_requested,tv_sphone,tv_cphone;
    private Button call_store,call_customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing);
        Store store= (Store) getIntent().getSerializableExtra("store");
        Delivery delivery=(Delivery)getIntent().getSerializableExtra("delivery");
        String phone=getIntent().getStringExtra("phone");
        Log.i("store",store.getName());

        tv_fee=findViewById(R.id.tv_fee);
        tv_destination=findViewById(R.id.tv_destination);
        tv_store=findViewById(R.id.tv_store);
        tv_address=findViewById(R.id.tv_address);
        tv_requested=findViewById(R.id.tv_requested);
        tv_cphone=findViewById(R.id.tv_cphone);
        tv_sphone=findViewById(R.id.tv_sphone);

        call_store=findViewById(R.id.call_store);
        call_customer=findViewById(R.id.call_customer);

        tv_fee.setText(Integer.toString(delivery.getPay())+"원");
        tv_destination.setText(delivery.getAddress());
        tv_store.setText(store.getName());
        tv_address.setText(store.getAddress());
        if(delivery.getRequests().equals("null")) tv_requested.setText("");
        else tv_requested.setText(delivery.getRequests());
        tv_cphone.setText(phone);
        tv_sphone.setText(store.getContact());
        call_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+store.getContact()));
                startActivity(tt);
            }
        });

        call_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(tt);
            }
        });
    }
}