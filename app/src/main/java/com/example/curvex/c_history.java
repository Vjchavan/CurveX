package com.example.curvex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class c_history extends AppCompatActivity {

    ListView mylist;
    List<c_class> hlist;
    Button clear;

    DatabaseReference href;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_history);

        mylist = findViewById(R.id.l1);
        hlist = new ArrayList<>();
        clear = findViewById(R.id.hclear);

        href = FirebaseDatabase.getInstance().getReference("Currency_History");

        href.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                hlist.clear();
                for(DataSnapshot ds: snapshot.getChildren()){
                    c_class c = ds.getValue(c_class.class);
                    hlist.add(c);
                }
                list_Adapter adapter = new list_Adapter(c_history.this,hlist);
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