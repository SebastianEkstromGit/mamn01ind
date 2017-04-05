package com.example.sebastian.compacc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    public void Accelerometer(View view)
    {
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }

    public void Compass(View view)
    {
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
