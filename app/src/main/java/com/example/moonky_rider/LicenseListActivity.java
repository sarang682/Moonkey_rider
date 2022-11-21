package com.example.moonky_rider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LicenseListActivity extends AppCompatActivity {

    private ListView lView;
    private Button makelicense;
    private LicenseListActivity.ItemAdapter adapter;
    private ArrayList<LicenseItem> items = new ArrayList<LicenseItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_license_list);
        lView=findViewById(R.id.delivery_lv);

        makelicense=findViewById(R.id.make_license);
        adapter=new ItemAdapter(items);
        items.add(new LicenseItem("9909112700000","20221114"));

        lView.setAdapter(adapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DeliveryItem item = (DeliveryItem) adapter.getItem(position);
                Intent intent=new Intent(LicenseListActivity.this, LicenseDetailActivity.class);
                startActivity(intent);

            }
        });

        makelicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LicenseListActivity.this, MakeLicenseActivity.class);
                startActivity(intent);
            }
        });


    }

    class ItemAdapter extends BaseAdapter {

        ArrayList<LicenseItem> items;

        String user_id;

        public ItemAdapter(ArrayList<LicenseItem> items){
            this.items=items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(LicenseItem i){
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
            LicenseListView view = null;
            if (convertView == null) {
                view = new LicenseListView(getApplicationContext());
            } else {
                view = (LicenseListView) convertView;
            }

            LicenseItem item = items.get(position);
            view.setDate(item.getDate());
            view.setNum(item.getNum());

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
