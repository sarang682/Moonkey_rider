package com.example.moonky_rider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DeliveryListActivity extends AppCompatActivity {

    private ListView lView;
    private DeliveryListActivity.ItemAdapter adapter;
    private ArrayList<DeliveryItem> items = new ArrayList<DeliveryItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_deliverylist);
        lView=findViewById(R.id.delivery_lv);
        adapter=new DeliveryListActivity.ItemAdapter(items);
        items.add(new DeliveryItem(8,"대구광역시 수성구 초록동 나무아파트",1584600));
        items.add(new DeliveryItem(10,"대구광역시 수성구 노랑동 나무아파트",874200));
        items.add(new DeliveryItem(5,"대구광역시 수성구 파랑동 나무아파트",70000));
        items.add(new DeliveryItem(7,"대구광역시 수성구 빨강동 나무아파트",1010200));

        lView.setAdapter(adapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DeliveryItem item = (DeliveryItem) adapter.getItem(position);
                Intent intent=new Intent(DeliveryListActivity.this, DeliveryDetailActivity.class);
                startActivity(intent);

            }
        });


    }

    class ItemAdapter extends BaseAdapter {

        ArrayList<DeliveryItem> items;

        String user_id;

        public ItemAdapter(ArrayList<DeliveryItem> items){
            this.items=items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(DeliveryItem i){
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
            DeliveryListView view = null;
            if (convertView == null) {
                view = new DeliveryListView(getApplicationContext());
            } else {
                view = (DeliveryListView) convertView;
            }

            DeliveryItem item = items.get(position);
            view.setPrice(Integer.toString(item.getPrice()));
            view.setNum(Integer.toString(item.getNum()));
            view.setAddress(item.getAddress());

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
