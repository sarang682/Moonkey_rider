package com.example.moonky_rider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyPageActivity extends AppCompatActivity {

    private Button my_licenses, modify;
    private TextView name, transport, callnum, grade;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_page);

        my_licenses = findViewById(R.id.my_licenses);
        modify = findViewById(R.id.modify);

        name = findViewById(R.id.rider_name);
        callnum = findViewById(R.id.rider_callnum);
        transport = findViewById(R.id.transport);
        grade = findViewById(R.id.rider_grade);

        spinner = findViewById(R.id.spinner_address_type);


        my_licenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LicenseListActivity.class);
                startActivity(intent);
            }
        });
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditAccountActivity.class);
                startActivity(intent);
            }
        });

        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner_address_type);

        ArrayAdapter addtypeAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_address_type, android.R.layout.simple_spinner_dropdown_item);
        addtypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(addtypeAdapter); //어댑터에 연결해줍니다.


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            } //이 오버라이드 메소드에서 position은 몇번째 값이 클릭됬는지 알 수 있습니다.
            //getItemAtPosition(position)를 통해서 해당 값을 받아올수있습니다.

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });
    }
}