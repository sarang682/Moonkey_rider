package com.example.moonky_rider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FindPwActivity extends AppCompatActivity {

    Button btn_find;
    EditText name, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pw);

        name=findViewById(R.id.SearchNamePw);
        id=findViewById(R.id.SearchId);

        btn_find=findViewById(R.id.SearchPwbtn);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}