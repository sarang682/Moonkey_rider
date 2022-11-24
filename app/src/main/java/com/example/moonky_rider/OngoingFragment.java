package com.example.moonky_rider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class OngoingFragment extends Fragment {

    private ListView listView; //리스트뷰
    private OngoingFragment.Adapter adapter;
    private ArrayList<Delivery> deliveries;
    private Intent intent;

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

        Bundle bundle=getArguments();
        deliveries= (ArrayList<Delivery>) bundle.getSerializable("list");
        adapter=new OngoingFragment.Adapter(deliveries);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //클릭시 카트에 담김
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Delivery item=(Delivery) adapter.getItem(position);
                get_store(item);
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
    public void get_store(Delivery item){
        //http 요청 시 url 주소와 파라미터 데이터를 결합하기 위한 변수 선언
        //http 요청 시 필요한 url 주소를 변수 선언
        String totalUrl = "";
        String UrlData = "http://165.229.86.152:8293/app/store/"+ item.getStore_id() + "/get";
        totalUrl = UrlData.trim().toString();

        int responseCode = 0;

        //http 통신을 하기위한 객체 선언 실시
        URL url = null;
        HttpURLConnection conn = null;

        //http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
        String responseData = "";
        BufferedReader br = null;
        StringBuffer sb = null;

        //메소드 호출 결과값을 반환하기 위한 변수
        String returnData = "";

        try {
            //파라미터로 들어온 url을 사용해 connection 실시
            url = new URL(totalUrl);
            conn = (HttpURLConnection) url.openConnection();

            //http 요청에 필요한 타입 정의 실시
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod("GET");

            //http 요청 실시
            conn.connect();
            System.out.println("http 요청 방식 : " + "GET");
            System.out.println("http 요청 타입 : " + "application/json");
            System.out.println("http 요청 주소 : " + UrlData);
            System.out.println("");

            //http 요청 후 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            sb = new StringBuffer();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer에 응답받은 데이터 순차적으로 저장 실시
            }

            //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입 실시
            returnData = sb.toString();

            //returnData를 json형식으로

            try {
                JSONObject JsonObject=new JSONObject(returnData);
                String name = JsonObject.getString("name");
                String address = JsonObject.getString("address");
                String description = JsonObject.getString("description");
                String category = JsonObject.getString("category");
                String contact = JsonObject.getString("contact");

                Store store=new Store(Long.toString(item.getStore_id()),name,address,description,category,contact);

                intent=new Intent(getActivity().getApplicationContext(),OngoingActivity.class);
                intent.putExtra("store",store);
                intent.putExtra("delivery",item);
                get_user(item.getUid());
                startActivity(intent);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //http 요청 응답 코드 확인 실시
            responseCode = conn.getResponseCode();
            System.out.println("http 응답 코드 : " + responseCode);
            System.out.println("http 응답 데이터 : " + returnData);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //http 요청 및 응답 완료 후 BufferedReader를 닫아줍니다
            try {
                if (br != null) {
                    br.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public  void get_user(long uid){
        //http 요청 시 url 주소와 파라미터 데이터를 결합하기 위한 변수 선언
        //http 요청 시 필요한 url 주소를 변수 선언
        String totalUrl = "";
        String UrlData = "http://165.229.86.152:8293/app/account/"+uid;
        totalUrl = UrlData.trim().toString();

        int responseCode = 0;

        //http 통신을 하기위한 객체 선언 실시
        URL url = null;
        HttpURLConnection conn = null;

        //http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
        String responseData = "";
        BufferedReader br = null;
        StringBuffer sb = null;

        //메소드 호출 결과값을 반환하기 위한 변수
        String returnData = "";

        try {
            //파라미터로 들어온 url을 사용해 connection 실시
            url = new URL(totalUrl);
            conn = (HttpURLConnection) url.openConnection();

            //http 요청에 필요한 타입 정의 실시
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod("GET");

            //http 요청 실시
            conn.connect();
            System.out.println("http 요청 방식 : " + "GET");
            System.out.println("http 요청 타입 : " + "application/json");
            System.out.println("http 요청 주소 : " + UrlData);
            System.out.println("");

            //http 요청 후 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            sb = new StringBuffer();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer에 응답받은 데이터 순차적으로 저장 실시
            }

            //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입 실시
            returnData = sb.toString();

            //returnData를 json형식으로

            try {
                JSONObject JsonObject=new JSONObject(returnData);
                String phone = JsonObject.getString("phone");

                intent.putExtra("phone",phone);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            //http 요청 응답 코드 확인 실시
            responseCode = conn.getResponseCode();
            System.out.println("http 응답 코드 : " + responseCode);
            System.out.println("http 응답 데이터 : " + returnData);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //http 요청 및 응답 완료 후 BufferedReader를 닫아줍니다
            try {
                if (br != null) {
                    br.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}