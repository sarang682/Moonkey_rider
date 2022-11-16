package com.example.moonky_rider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DelAccountActivity extends AppCompatActivity {

    Button Delete;
    EditText ID, PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strID=ID.getText().toString();
                String strPW=PW.getText().toString();

                if (strID.replace(" ", "").equals("") || //공백 체크
                        strPW.replace(" ", "").equals("")) {
                    Toast.makeText(getApplicationContext(), "빈칸을 확인해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(true){// pw가 일치하면 회원 탈퇴

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"비밀번호를 확인하세요",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}