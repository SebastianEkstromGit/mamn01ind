package com.example.sebastian.compacc;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView viewX;
    private TextView viewY;
    private TextView viewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        viewX = (TextView)findViewById(R.id.accX);
        viewY = (TextView)findViewById(R.id.accY);
        viewZ = (TextView)findViewById(R.id.accZ);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            viewX.setText("X: " + String.valueOf(Math.round(event.values[0]*100)/100D));
            viewY.setText("Y: " + String.valueOf(Math.round(event.values[1]*100)/100D));
            viewZ.setText("Z: " + String.valueOf(Math.round(event.values[2]*100)/100D));
        }
    }
}
