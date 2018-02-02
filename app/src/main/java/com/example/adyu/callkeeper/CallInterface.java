package com.example.adyu.callkeeper;


import com.example.adyu.callkeeper.POJO.PhoneCall;


import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;


public interface CallInterface {

    @POST("call_log")
    Call<Void> add(@Body PhoneCall phoneCall);
}
