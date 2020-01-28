package com.example.jp_brain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.OverScroller;
import android.widget.Scroller;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class pantalla3 extends AppCompatActivity implements  GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private TextView text_gestos;
    private GestureDetector gestureDetector;
    public int temps3= 1;
    public int temps1 = 1;
    public int temps2 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        Bundle bundle = getIntent().getExtras();
        temps1 = bundle.getInt("temps1");
        temps2 = bundle.getInt("temps2");
        Timer reloj = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                temps3 = temps3 + 1 ;
            }
        };
        reloj.schedule(task, 1000,1000);
        text_gestos = (TextView) findViewById(R.id.text_gestos);
        this.gestureDetector = new GestureDetector(this,this);
        gestureDetector.setOnDoubleTapListener(this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        text_gestos.setText("Fes dos clics");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        text_gestos.setText("Llisca amunt");

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        text_gestos.setText("Deixa apretat ");

        return false;
    }
    @Override
    public void onLongPress(MotionEvent e) {
        Intent i = new Intent(pantalla3.this, pantalla_final.class);
        i.putExtra("temps1", temps1);
        i.putExtra("temps2", temps2);
        i.putExtra("temps3", temps3);
        startActivity(i);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

}
