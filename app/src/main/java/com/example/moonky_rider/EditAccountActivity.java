package com.example.moonky_rider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditAccountActivity extends AppCompatActivity {

    EditText ID, NickName, Phone, currentPW, newPW;
    Button modify_nick, modify_phone, modify_pw, unregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_account_modify);

        //아이디 입력이 필요한가?

        ID=findViewById(R.id.modify_id);
        NickName=findViewById(R.id.modify_nickname);
        Phone=findViewById(R.id.modify_phoneNum);
        currentPW=findViewById(R.id.modify_currently_pw_edit);
        newPW=findViewById(R.id.modify_new_pw_edit);

        modify_nick=findViewById(R.id.modify_name_btn);
        modify_phone=findViewById(R.id.modify_phoneNum_btn);
        modify_pw=findViewById(R.id.modify_pw_btn);
        unregister=findViewById(R.id.unregister_btn);


        // 닉네임 변경
        modify_nick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!nullCheck(NickName)) {
                    Toast.makeText(getApplicationContext(), "빈칸을 확인해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    if (nick_duplicate_check() == false) {
                        Toast.makeText(getApplicationContext(), "이미 존재하는 닉네임입니다.", Toast.LENGTH_SHORT).show();
                    }else {
                        modify_nickname();
                        Toast.makeText(getApplicationContext(), "닉네임을 성공적으로 변경했습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

        // 전화번호 변경
        modify_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!nullCheck(Phone)) {
                    Toast.makeText(getApplicationContext(), "빈칸을 확인해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    if (phone_duplicate_check() == false) {
                        Toast.makeText(getApplicationContext(), "이미 존재하는 전화번호입니다.", Toast.LENGTH_SHORT).show();
                    }else {
                        modify_phone();
                        Toast.makeText(getApplicationContext(), "전화번호를 성공적으로 변경했습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

        // 비밀번호 변경
        modify_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!nullCheck(currentPW)||!nullCheck(newPW)) {
                    Toast.makeText(getApplicationContext(), "빈칸을 확인해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    if(curPW_check()==false){ //현재 비밀번호가 틀리면
                        Toast.makeText(getApplicationContext(), "현재 비밀번호를 확인해 주세요.", Toast.LENGTH_SHORT).show();
                    }else{
                        if (newPW_check() == false) {
                            Toast.makeText(getApplicationContext(), "비밀번호는 8자 이상의 숫자와 영문, 특수문자 조합이어야 합니다.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "비밀번호를 성공적으로 변경했습니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }
            }
        });

        // 회원 탈퇴
        unregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditAccountActivity.this, UnregisterActivity.class);
                startActivity(intent);
            }
        });


    }

    // 널체크
    public boolean nullCheck(EditText editText) {
        if (editText.getText().toString().replace(" ", "").equals(""))
            return false;
        else return true;
    }

    // 닉네임 중복확인 함수
    public boolean nick_duplicate_check() {
        return true;
    }

    // 전화번호 중복확인 함수
    public boolean phone_duplicate_check() {
        return true;
    }

    // 닉네임 변경
    public void modify_nickname(){

    }

    // 전화번호 변경
    public void modify_phone(){

    }

    // 현재 pw 확인 함수
    public boolean curPW_check() {
        return true;
    }

    // pw 확인 함수
    public boolean newPW_check() {
        String str_Pw=newPW.getText().toString();
        String pattern1 = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
        Matcher match;
        match = Pattern.compile(pattern1).matcher(str_Pw);
        boolean chk = false;

        if(match.find()) {
            chk = true;
        }

        if(chk) return true;
        else {
            return false;
        }

    }

}