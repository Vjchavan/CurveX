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

public class w_history extends AppCompatActivity {

    ListView mylist;
    List<w_class> hlist;
    Button clear;

    DatabaseReference href;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_history);

        mylist = findViewById(R.id.l1);
        hlist = new ArrayList<>();
        clear = findViewById(R.id.hclear);

        href = FirebaseDatabase.getInstance().getReference("Weight_History");

        href.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                hlist.clear();
                for(DataSnapshot ds: snapshot.getChildren()){
                    w_class c = ds.getValue(w_class.class);
                    hlist.add(c);
                }
                w_list_Adapter adapter = new w_list_Adapter(w_history.this,hlist);
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