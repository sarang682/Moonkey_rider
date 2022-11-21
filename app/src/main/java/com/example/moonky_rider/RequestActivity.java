package com.example.moongky_rider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;


public class RequestActivity extends AppCompatActivity {

    Button request_work;

    //탭레이아웃
    private TabLayout tabs;
    private Fragment fragment1, fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_work);

        request_work = findViewById(R.id.rider_application);
        request_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestActivity.this, RequestActivity2.class);
                startActivity(intent);
            }
        });

        //탭레이아웃
        tabs=findViewById(R.id.request_tab);
        fragment1=new RequestWorkFragment();
        //fragment2=new ApprovingFragment();
        fragment3=new AcceptRequestFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frame1,fragment1).commit();

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment selected=null;
                int position=tab.getPosition();
                if(position==0){
                    selected=fragment1;
                }
                else {
                    selected=fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame1,selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
