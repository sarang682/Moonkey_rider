package com.example.moonky_rider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakeLicenseActivity extends AppCompatActivity {

    Button approval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_make_license);

        approval=findViewById(R.id.wait_approval_btn);
        approval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakeLicenseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
