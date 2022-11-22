package com.example.moonky_rider;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;


public class MakeLicenseActivity extends AppCompatActivity {

    EditText tv_num, tv_date;
    Button approval, picturefile,bankbookfile, insurancefile;
    Uri uri;
    Bitmap bitmap;
    TextView tv_img, tv_img2, tv_img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_make_license);

        picturefile = findViewById(R.id.picture_file);
        bankbookfile = findViewById(R.id.bankbook_file);
        insurancefile = findViewById(R.id.insurance_file);

        tv_img = findViewById(R.id.attached_picture);
        tv_img2 = findViewById(R.id.attached_bankbook);
        tv_img3 = findViewById(R.id.attached_insure);

        tv_num = findViewById(R.id.license_num);
        tv_date = findViewById(R.id.date);

        approval = findViewById(R.id.wait_approval_btn);

        //등록
        approval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNull(tv_num) || isNull(tv_date)) {
                    Toast.makeText(getApplicationContext(), "빈칸을 확인해 주세요.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "신청되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MakeLicenseActivity.this, LicenseListActivity.class);
                    startActivity(intent);
                }
            }
        });

        //면허증 사진 찾기
        picturefile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityResult.launch(intent);
                Toast.makeText(getApplicationContext(), "파일찾기", Toast.LENGTH_SHORT).show();
            }
        });

        //통장 사본 사진 찾기
        bankbookfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityResult2.launch(intent);
                Toast.makeText(getApplicationContext(), "파일찾기", Toast.LENGTH_SHORT).show();            }
        });

        // 보험 신청서 사진 찾기
        insurancefile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityResult3.launch(intent);
                Toast.makeText(getApplicationContext(), "파일찾기", Toast.LENGTH_SHORT).show();            }
        });
    }
    //사진선택
    ActivityResultLauncher<Intent> startActivityResult=registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                uri=result.getData().getData();
                tv_img.setText(uri.toString());
                try{
                    bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }});
    //사진선택2
    ActivityResultLauncher<Intent> startActivityResult2=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                        uri=result.getData().getData();
                        tv_img2.setText(uri.toString());
                        try{
                            bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }});
    //사진선택
    ActivityResultLauncher<Intent> startActivityResult3=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                        uri=result.getData().getData();
                        tv_img3.setText(uri.toString());
                        try{
                            bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }});


        //널 체크
        public boolean isNull(EditText editText) {
            if (editText.getText().toString().replace(" ", "").equals(""))
                return true;
            else return false;
        }
}
