package com.ihrd.anish.mzcandroidapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tv=(TextView)findViewById(R.id.textdisp);
        SharedPreferences preferences=getSharedPreferences("MyData",MODE_PRIVATE);
        String data=preferences.getString("name",null);

        tv.setText("Welcome "+data);



    }
}
