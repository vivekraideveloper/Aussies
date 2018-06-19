package com.vijayjaidewan01vivekrai.aussies;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by MR VIVEK RAI on 06-06-2018.
 */

public class Receiver extends BroadcastReceiver {

    public InterstitialAd minterstitialAd;

    @Override
    public void onReceive(Context context, Intent intent) {
        minterstitialAd = new InterstitialAd(context);
        minterstitialAd.setAdUnitId("ca-app-pub-8991466099650202/3426421578");
        AdRequest request = new AdRequest.Builder().build();
        minterstitialAd.loadAd(request);
        if (minterstitialAd.isLoaded()){
            minterstitialAd.show();
        }
        Toast.makeText(context, "Interstitial Ads loading", Toast.LENGTH_SHORT).show();
    }

}