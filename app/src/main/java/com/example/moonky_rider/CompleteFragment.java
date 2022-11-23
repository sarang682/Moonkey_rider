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

public class CompleteFragment extends Fragment {

    private ListView listView; //리스트뷰
    private CompleteFragment.Adapter adapter;
    private ArrayList<Delivery> items;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v=inflater.inflate(R.layout.fragment_request, container, false);
        listView=v.findViewById(R.id.request_lv);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items = new ArrayList<Delivery>();
        adapter=new CompleteFragment.Adapter(items);
        //목적지 요금(int) 가게이름 가게주소
//        items.add(new Delivery("완료-목적지",6000,"완료-가게이름","완료-출발지","문앞에 두고 문자해주세요","01012345678","01098765432"));
//        items.add(new Delivery("경상북도 대동 133",6000,"오천사치킨","대구 신매동","문앞에 두고 문자해주세요","01012345678","01098765432"));
//        items.add(new Delivery("경상북도 사동 사랑으로 103동",5000,"bbq","대구 사월동 123","문앞에 두고 문자해주세요","01012345678","01098765432"));
//        items.add(new Delivery("수성구 사월동 한일유앤 111동~~",9000,"떡볶이집","주소","문앞에 두고 문자해주세요","01012345678","01098765432"));
//        items.add(new Delivery("메뉴4","12000","메뉴4 코멘트"));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //클릭시 카트에 담김
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Delivery item=(Delivery) adapter.getItem(position);
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

        ArrayList<Delivery> items;

        String user_id;

        public Adapter(ArrayList<Delivery> items){
            this.items=items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Delivery i){
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
            RequestListView view = null;
            if (convertView == null) {
                view = new RequestListView(getActivity().getApplicationContext());
            } else {
                view = (RequestListView) convertView;
            }

            Delivery item = items.get(position);
            view.setText_fee(Integer.toString(item.getPay()));
            view.setText_destination(item.getAddress());
            return view;
        }
    }
}
