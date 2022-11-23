package com.example.moonky_rider;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RequestActivity2 extends AppCompatActivity {

    Button approval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        approval = findViewById(R.id.request_btn);
        approval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestActivity2.this, RequestWorkFragment.class);
                startActivity(intent);
            }
        });

    }
}