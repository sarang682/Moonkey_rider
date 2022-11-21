package com.example.moonky_rider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MenuAdapter adapter;
    private ArrayList<Store> items = new ArrayList<Store>();
    private NestedScrollView nestedScrollView;
    private LinearLayout linearLayout;

    private ImageView openDrawer, modify, license,history, accept, question, setting;
    private Button logout;
    private TextView address, text_color;
    Switch sw;

    //탭레이아웃
    private TabLayout tabs;
    private Fragment fragment1,fragment2,fragment3;



    //gps
    private GpsTracker gpsTracker;

    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address=findViewById(R.id.tv_address);
        //listView=findViewById(R.id.listView);
        nestedScrollView=findViewById(R.id.nested_scroll_view);


        //스위치(운행중/운행종료)
        sw=findViewById(R.id.sw);
        text_color=findViewById(R.id.rider_state);
        sw.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    text_color.setTextColor(Color.rgb(255,0,0));
                }else{
                    text_color.setTextColor(Color.rgb(0,0,0));
                }
            }
        });

        //탭레이아웃
        tabs=findViewById(R.id.home_tab);
        fragment1=new RequestFragment();
        fragment2=new OngoingFragment();
        fragment3=new CompleteFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frame,fragment1).commit();

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment selected=null;
                int position=tab.getPosition();
                if(position==0){
                    selected=fragment1;
                }
                else if(position==1){
                    selected=fragment2;
                }
                else if(position==2){
                    selected=fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame,selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //리스트뷰
        /*listView=findViewById(R.id.listView);
        adapter=new MenuAdapter(items);
        items.add(new Store(18000,"맛있는 떡볶이집","나무아카데미 1층 로비"));
        items.add(new Store(51000,"로제잘하는집","교육연수원 경비실"));
        listView.setAdapter(adapter);

        //
        nestedScrollView=findViewById(R.id.nested_scroll_view);*/
        /*listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                nestedScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });*/

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Store item = (Store) adapter.getItem(position);
                Intent intent=new Intent(MainActivity.this, MenuDetailActivity.class);
                intent.putExtra("price",item.getPrice());
                intent.putExtra("name",item.getName());
                intent.putExtra("comment",item.getComment());
                startActivity(intent);

            }
        });*/


        //슬라이드 메뉴
        final DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        final View drawerView =findViewById(R.id.ll_drawer);
        openDrawer=findViewById(R.id.iv_hamburger);

        openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }

        });

        license=findViewById(R.id.my_licenses);
        history = findViewById(R.id.history);
        accept = findViewById(R.id.acceptriding);

        question=findViewById(R.id.question);

        logout=findViewById(R.id.btnLogout);
        modify= findViewById(R.id.modify);


        //회원정보수정
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditAccountActivity.class);
                startActivity(intent);
            }
        });
        //마이페이지
        linearLayout=findViewById(R.id.linearLayout5);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MyPageActivity.class);
                startActivity(intent);
            }
        });


        //면허 관리
        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LicenseListActivity.class);
                startActivity(intent);
            }
        });

        //접수내역
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeliveryListActivity.class);
                startActivity(intent);
            }
        });


        //운행 승인 신청
        /*accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });*/

        //로그아웃
       logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //문의사항
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(intent);
            }
        });
        
        //환경 설정
        setting=findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("로그아웃하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNeutralButton("아니오",null);
                builder.create().show();

            }
        });

    }

    class MenuAdapter extends BaseAdapter {

        ArrayList<Store> items;

        String user_id;

        public MenuAdapter(ArrayList<Store> items){
            this.items=items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Store i){
            items.add(i);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 뷰 객체 재사용
            StoreListView view = null;
            if (convertView == null) {
                view = new StoreListView(getApplicationContext());
            } else {
                view = (StoreListView) convertView;
            }

            Store item = items.get(position);
            view.setPrice(item.getPrice());
            view.setName(item.getName());
            view.setComment(item.getAddress());

//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(StoreListActivity.this, StoreDetailActivity.class);
////                    intent.putExtra();
//                    startActivity(intent);
//                    Toast.makeText(getApplicationContext(),"클릭",Toast.LENGTH_SHORT).show();
//                }
//            });

            return view;
        }
    }
}

