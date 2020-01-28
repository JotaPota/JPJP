package com.example.jp_brain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class pantalla_final extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;
    public int temps1;
    public int temps2;
    public int temps3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);
        Bundle bundle = getIntent().getExtras();
        temps1 = bundle.getInt("temps1");
        temps2 = bundle.getInt("temps2");
        temps3 = bundle.getInt("temps3");
        GraphView graph = findViewById(R.id.grafico);
        graph.getGridLabelRenderer().setNumHorizontalLabels(4);
        graph.getGridLabelRenderer().setNumVerticalLabels(10);
        graph.getGridLabelRenderer().setHumanRounding(true, true);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graph.addSeries(series);
        /*series.setTitle("segundos");
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setTextSize(50);*/
    }
    private DataPoint[] getDataPoint(){
        DataPoint[] dp = new DataPoint[]
                {
                        new DataPoint(1,0),
                        new DataPoint(2,temps1),
                        new DataPoint(3,temps2),
                        new DataPoint(4,temps3)
                };
        return dp;
    }
}