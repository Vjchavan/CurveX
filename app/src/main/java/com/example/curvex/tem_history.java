package com.example.curvex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class tem_history extends AppCompatActivity {

    ListView mylist;
    List<tem_class> hlist;
    Button clear;

    DatabaseReference href;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem_history);

        mylist = findViewById(R.id.l1);
        hlist = new ArrayList<>();
        clear = findViewById(R.id.hclear);

        href = FirebaseDatabase.getInstance().getReference("Temperature_History");

        href.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                hlist.clear();
                for(DataSnapshot ds: snapshot.getChildren()){
                    tem_class c = ds.getValue(tem_class.class);
                    hlist.add(c);
                }
                tem_list_Adapter adapter = new tem_list_Adapter(tem_history.this,hlist);
                mylist.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                href.removeValue();
            }
        });
    }
}