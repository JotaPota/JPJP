package com.example.jp_brain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public int temps1 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.solucio);
        final EditText Resultat1 = findViewById(R.id.Resultat1);
        GraphView graph = (GraphView) findViewById(R.id.grafico);
        Timer reloj = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                temps1 = temps1 + 1 ;
            }
        };
        reloj.schedule(task, 1000,1000);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, pantalla2.class);
                if  (Integer.parseInt(Resultat1.getText().toString()) == 9){
                    notificacio();
                    i.putExtra("temps", temps1);
                    startActivity(i);
                }

                else
                {
                    notificacio();
                    Toast.makeText(getApplicationContext(),"Prova una altre vegada noob",Toast.LENGTH_LONG).show();

                }

            }
        });


    }

    public void notificacio(){
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_check_black_24dp)
                .setContentTitle("NOTIFICATION")
                .setContentText("AHHAHAHAHA")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }

}

