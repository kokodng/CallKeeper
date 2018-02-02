package com.example.adyu.callkeeper;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.adyu.callkeeper.POJO.PhoneCall;

import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallRetrofit extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String type = intent.getStringExtra("type");
        String number = intent.getStringExtra("number");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
        Date start = new Date();
        start.setTime(intent.getLongExtra("start", 0));
        Date end = new Date();
        end.setTime(intent.getLongExtra("end", 0));

        String url = "http://10.0.2.2:3000/";
        //String url = "https://json-server-kokozv.c9users.io/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CallInterface onlineService = retrofit.create(CallInterface.class);
        Call<Void> call = onlineService.add(new PhoneCall(type, number, start, end));

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.v("xyzyx", "SUCCESS");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("xyzyx", "FAIL");
            }
        });

        return START_REDELIVER_INTENT;
    }

}
