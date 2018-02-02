package com.example.adyu.callkeeper;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class CallKeeper extends PhoneCallReceiver {

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.v("xyzyx", "incoming call " + number + " " + start.toString() + " - " + end.toString());
        Intent intent = new Intent(ctx, CallRetrofit.class);
        intent.putExtra("type", "incoming");
        intent.putExtra("number", number);
        intent.putExtra("start", start.getTime());
        intent.putExtra("end", end.getTime());
        ctx.startService(intent);
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.v("xyzyx", "outgoing call " + number + " " + start.toString() + " - " + end.toString());
        Intent intent = new Intent(ctx, CallRetrofit.class);
        intent.putExtra("type", "outgoing");
        intent.putExtra("number", number);
        intent.putExtra("start", start.getTime());
        intent.putExtra("end", end.getTime());
        ctx.startService(intent);
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        Log.v("xyzyx", "missed call " + number + " " + start.toString());
        Intent intent = new Intent(ctx, CallRetrofit.class);
        intent.putExtra("type", "missed");
        intent.putExtra("number", number);
        intent.putExtra("start", start.getTime());
        intent.putExtra("end", start.getTime());
        ctx.startService(intent);
    }
}