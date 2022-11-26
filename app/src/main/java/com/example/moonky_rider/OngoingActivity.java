package com.example.moonky_rider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class OngoingActivity extends AppCompatActivity {

    private TextView tv_fee,tv_destination,tv_store,tv_address,tv_requested,tv_sphone,tv_cphone;
    private Button call_store,call_customer,delivery_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing);
        Store store= (Store) getIntent().getSerializableExtra("store");
        Delivery delivery=(Delivery)getIntent().getSerializableExtra("delivery");
        String phone=getIntent().getStringExtra("phone");
        Log.i("store",store.getName());

        tv_fee=findViewById(R.id.tv_fee);
        tv_destination=findViewById(R.id.tv_destination);
        tv_store=findViewById(R.id.tv_store);
        tv_address=findViewById(R.id.tv_address);
        tv_requested=findViewById(R.id.tv_requested);
        tv_cphone=findViewById(R.id.tv_cphone);
        tv_sphone=findViewById(R.id.tv_sphone);

        call_store=findViewById(R.id.call_store);
        call_customer=findViewById(R.id.call_customer);

        tv_fee.setText(Integer.toString(delivery.getPay())+"원");
        tv_destination.setText(delivery.getAddress());
        tv_store.setText(store.getName());
        tv_address.setText(store.getAddress());
        if(delivery.getRequests().equals("null")) tv_requested.setText("");
        else tv_requested.setText(delivery.getRequests());
        tv_cphone.setText(phone);
        tv_sphone.setText(store.getContact());
        call_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+store.getContact()));
                startActivity(tt);
            }
        });

        call_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(tt);
            }
        });

        //배송완료
        delivery_complete=findViewById(R.id.delivery_complete);
        delivery_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                complete(delivery.getDelivery_id());
            }
        });
    }

    public void complete(long deliveryId){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //http 요청 시 필요한 url 주소를 변수 선언
        String totalUrl = "";
        String UrlData = "http://165.229.86.152:8293/app/delivery/deliveryCheck/"+deliveryId+"";
        totalUrl = UrlData.trim().toString();

        //http 통신을 하기위한 객체 선언 실시
        URL url = null;
        HttpURLConnection conn = null;

        //http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
        String responseData = "";
        BufferedReader br = null;
        StringBuffer sb = null;

        //메소드 호출 결과값을 반환하기 위한 변수
        String returnData = "";
        int responseCode=0;


        try {
            //파라미터로 들어온 url을 사용해 connection 실시
            url = new URL(totalUrl);
            conn = (HttpURLConnection) url.openConnection();

            //http 요청에 필요한 타입 정의 실시
            conn.setRequestMethod("PATCH");
//            conn.setRequestProperty("Content-Type", "application/json"); //post body json으로 던지기 위함
            conn.setRequestProperty("Content-Type", "application/json; utf-8"); //post body json으로 던지기 위함
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true); //OutputStream을 사용해서 post body 데이터 전송;

            //http 요청 실시
            conn.connect();
            System.out.println("http 요청 방식 : "+"POST BODY JSON");
            System.out.println("http 요청 타입 : "+"application/json");
            System.out.println("http 요청 주소 : "+UrlData);
//            System.out.println("http 요청 데이터 : "+data);
            System.out.println("");

            //http 요청 후 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            sb = new StringBuffer();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer에 응답받은 데이터 순차적으로 저장 실시
            }

            //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입 실시
            returnData = sb.toString();

            //http 요청 응답 코드 확인 실시
//            String responseCode = String.valueOf(conn.getResponseCode());
            responseCode = conn.getResponseCode();
            System.out.println("http 응답 코드 : "+responseCode);
            System.out.println("http 응답 데이터 : "+returnData);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (responseCode == 200) {
                Toast.makeText(getApplicationContext(),"완료 처리되었습니다",Toast.LENGTH_SHORT).show();
                call_list();
            }
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
    private void call_list(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

//        StoreItem item = (StoreItem) adapter.getItem(position);

        //http 요청 시 url 주소와 파라미터 데이터를 결합하기 위한 변수 선언
        //http 요청 시 필요한 url 주소를 변수 선언
        String totalUrl = "";
//        String UrlData = "http://165.229.86.152:8293/app/store/" + item.getStoreId() + "/menu/list";
        String UrlData = "http://165.229.86.152:8293/app/delivery/list"; //스토어 id 1 메뉴리스트

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
            ArrayList<Delivery> request_list = new ArrayList<Delivery>();
            ArrayList<Delivery> ongoing_list = new ArrayList<Delivery>();
            ArrayList<Delivery> complete_list = new ArrayList<Delivery>();
            try {
                JSONArray jsonArray = new JSONArray(returnData);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject JsonObject = jsonArray.getJSONObject(i);
                    long delivery_id = JsonObject.getLong("deliveryId");
                    String address = JsonObject.getString("address");
                    boolean call_check=JsonObject.getBoolean("callCheck");
                    int distance = JsonObject.getInt("distance");
                    int pay=JsonObject.getInt("pay");
                    String requests=JsonObject.getString("requests");
                    long order_id = JsonObject.getLong("orderId");
                    long store_id = JsonObject.getLong("storeId");
                    long uid=JsonObject.getLong("uid");
//                    long total_pay=JsonObject.getLong("totalPay");
                    boolean delivery_check=JsonObject.getBoolean("deliveryCheck");

                    if(!call_check&&!delivery_check)
                        request_list.add(new Delivery(delivery_id,address,call_check,distance,pay,requests,order_id,store_id,uid,0,delivery_check));
                    else if(call_check&&!delivery_check)
                        ongoing_list.add(new Delivery(delivery_id,address,call_check,distance,pay,requests,order_id,store_id,uid,0,delivery_check));
                    else if(delivery_check)
                        complete_list.add(new Delivery(delivery_id,address,call_check,distance,pay,requests,order_id,store_id,uid,0,delivery_check));

                }

//                System.out.println("main에서 출력 : " + list.get(0).getMenuName());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("length", Integer.toString(jsonArray.length()));
                intent.putExtra("request_list", request_list);
                intent.putExtra("ongoing_list", ongoing_list);
                intent.putExtra("complete_list", complete_list);
                startActivity(intent);


            } catch (JSONException e) {
                e.printStackTrace();
            }

            //http 요청 응답 코드 확인 실시
            responseCode = conn.getResponseCode();
            System.out.println("http 응답 코드 : " + responseCode);
            System.out.println("http 응답 데이터 : " + returnData);

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