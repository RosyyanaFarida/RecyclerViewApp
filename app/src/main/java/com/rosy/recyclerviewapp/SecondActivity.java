package com.rosy.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView1 = (TextView) findViewById(R.id.txtnama);
        TextView textView2 = (TextView) findViewById(R.id.txtnim);
        TextView textView3 = (TextView) findViewById(R.id.txtnohp);
        Bundle bundle = getIntent().getExtras();
        textView1.setText(bundle.getString("data1"));
        textView2.setText(bundle.getString("data2"));
        textView3.setText(bundle.getString("data3"));

    }
}
