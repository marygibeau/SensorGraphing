package com.example.sensorgraphing;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor lightsense;
    PlotView plot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightsense = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this, lightsense, 500000);
        plot = findViewById(R.id.plotView);
    }



    public void foo(View view) {
        plot.clearList();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        plot.addPoint(event.values[0]);
        plot.invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
