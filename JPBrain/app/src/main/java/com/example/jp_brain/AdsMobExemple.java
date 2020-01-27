package com.example.jp_brain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.health.TimerStat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Timer;
import java.util.TimerTask;


public class AdsMobExemple extends AppCompatActivity {
    public AdView mAdView;
    public int sum = 0;
    public int tSuma = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_mob_exemple);
        Timer reloj = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sum = sum + 1;

                if (sum == 5){
                     Intent i = new Intent(AdsMobExemple.this, pantalla3.class);
                     startActivity(i);
                 }
            }
        };
        Toast.makeText(getApplicationContext(),"L'anunci marxara en 5 segons",Toast.LENGTH_LONG).show();

        reloj.schedule(task, 1000, 1000);




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        };



    }


