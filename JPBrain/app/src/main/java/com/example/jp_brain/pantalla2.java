package com.example.jp_brain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class pantalla2 extends AppCompatActivity {
    public int temps2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        final int temps1 = bundle.getInt("temps");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Timer reloj = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                temps2 = temps2 + 1 ;
            }
        };
        reloj.schedule(task, 1000,1000);
        Button boto2 = findViewById(R.id.boto2);

        boto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla2.this, AdsMobExemple.class);
                i.putExtra("temps1", temps1);
                i.putExtra("temps2", temps2);
                startActivity(i);

            }
        });
    }

}