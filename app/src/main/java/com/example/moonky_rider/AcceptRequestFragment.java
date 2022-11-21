package com.example.moonky_rider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AcceptRequestFragment extends Fragment {

    private ListView listView; //리스트뷰
    private AcceptRequestFragment.Adapter adapter;
    private ArrayList<Work> items;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v=inflater.inflate(R.layout.fragment_request_work, container, false);
        listView=v.findViewById(R.id.request_work_lv);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items = new ArrayList<Work>();
        adapter = new AcceptRequestFragment.Adapter(items);
        //요일 보험 신청자명
        items.add(new Work("20221119","김세모"));
        items.add(new Work("20221118", "김세모"));
        items.add(new Work("20221117", "김세모"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //클릭시 카트에 담김
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Work item=(Work) adapter.getItem(position);
//                Toast.makeText(getActivity().getApplicationContext(),item.getName(), Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(getActivity().getApplicationContext(),CartActivity.class);
//                intent.putExtra("menu",item.getName());
//                intent.putExtra("price",item.getPrice());
//                intent.putExtra("comment",item.getComment());
//                startActivity(intent);
            }
        });
    }

    class Adapter extends BaseAdapter {

        ArrayList<Work> items;

        String user_id;

        public Adapter(ArrayList<Work> items){
            this.items=items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Work i){
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
            RequestWorkListView view = null;
            if (convertView == null) {
                view = new RequestWorkListView(getActivity().getApplicationContext());
            } else {
                view = (RequestWorkListView) convertView;
            }

            Work item = items.get(position);
            view.setText_date(item.getDate());
            view.setText_ridername(item.getRider_name());
            return view;
        }
    }
}
