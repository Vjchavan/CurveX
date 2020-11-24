package com.example.curvex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    Button cur,tim,dis,wei,lit,hist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cur = findViewById(R.id.cc);
        tim = findViewById(R.id.tc);
        dis = findViewById(R.id.dc);
        wei = findViewById(R.id.wc);
        lit = findViewById(R.id.lc);

        cur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(home.this,cc.class);
                startActivity(c);
            }
        });

        tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(home.this,tt.class);
                startActivity(t);
            }
        });

        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(home.this,dd.class);
                startActivity(d);
            }
        });

        wei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(home.this,ww.class);
                startActivity(w);
            }
        });

        lit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(home.this,ll.class);
                startActivity(l);
            }
        });
    }
}