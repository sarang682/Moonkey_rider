package com.example.moonky_rider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RequestActivity extends AppCompatActivity {

    Button request_work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_work);

        request_work = findViewById(R.id.rider_application);
        request_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(RequestActivity.this, RequestActivity2.class);
//                startActivity(intent);
            }
        });
    }
}
