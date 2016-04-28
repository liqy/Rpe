package com.hotsmall.rpe;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.request.StringRequest;
import com.hotsmall.rpe.client.APIClient;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://apis.baidu.com/wxlink/getfdmtee/getfdmtee?";

        String query = "beginDate=20141231&endDate=20151231&publishDateBegin=20140812&publishDateEnd=20150812&reportType=Q1&field=revenueLY";

        StringRequest request = new StringRequest(Request.Method.GET
                , url + query
                , createReqSuccessListener()
                , createReqErrorListener());

        Map<String, String> headerMap = new Hashtable<>();
        headerMap.put("apikey", "127f474de222708ba4742aa3d61ce79c");
        request.setHeaders(headerMap);

//        Map<String,String> params=new HashMap<>();
//        params.put("","");
//        request.setParams(params);


        APIClient.getRequestQueue().add(request);
    }

    private Response.Listener<String> createReqSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Logger.d(response);
            }
        };
    }
}
