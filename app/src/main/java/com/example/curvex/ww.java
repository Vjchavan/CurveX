package com.example.curvex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class ww extends AppCompatActivity {


    EditText amt;
    Spinner s1,s2;
    Button convert,clear;
    TextView out;
    String [] arr = {"Miligram","Gram","Kilogram","Ton",};
    int count=0;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference node = db.getReference("Weight_History");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ww);

        amt = findViewById(R.id.input);
        s1 = findViewById(R.id.sp1);
        s2 = findViewById(R.id.sp2);
        convert = findViewById(R.id.con);
        clear = findViewById(R.id.clr);
        out = findViewById(R.id.op);

        final DecimalFormat decimalFormat = new DecimalFormat("###.####");

        ArrayAdapter ad1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arr);
        s1.setAdapter(ad1);

        ArrayAdapter ad2 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arr);
        s2.setAdapter(ad2);



        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                try {
                    Double tot;
                    Double amount = Double.parseDouble(amt.getText().toString());

                    //***********Miligram to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Miligram" && s2.getSelectedItem().toString() == "Gram")
                    {
                        tot = amount/1000;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" g");
                    }

                    else if(s1.getSelectedItem().toString() == "Miligram" && s2.getSelectedItem().toString() == "Kilogram")
                    {
                        tot = amount/(1000*1000);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Kg");
                    }

                    else if(s1.getSelectedItem().toString() == "Miligram" && s2.getSelectedItem().toString() == "Ton")
                    {
                        tot = amount/(1000*1000*1000);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Ton");
                    }

                    else if(s1.getSelectedItem().toString() == "Miligram" && s2.getSelectedItem().toString() == "Miligram")
                    {
                        out.setText(String.format("%.2f",amount)+" mg");
                    }

                    //***********Gram to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Gram" && s2.getSelectedItem().toString() == "Miligram")
                    {
                        tot = amount*1000;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" mg");
                    }

                    else if(s1.getSelectedItem().toString() == "Gram" && s2.getSelectedItem().toString() == "Kilogram")
                    {
                        tot = amount/1000;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Kg");
                    }

                    else if(s1.getSelectedItem().toString() == "Gram" && s2.getSelectedItem().toString() == "Ton")
                    {
                        tot = amount/(1000*1000);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Ton");
                    }

                    else if(s1.getSelectedItem().toString() == "Gram" && s2.getSelectedItem().toString() == "Gram")
                    {
                        out.setText(String.format("%.2f",amount)+" gram");
                    }

                    //***********Kilogram to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Kilogram" && s2.getSelectedItem().toString() == "Miligram")
                    {
                        tot = amount*(1000*1000);
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" mg");
                    }

                    else if(s1.getSelectedItem().toString() == "Kilogram" && s2.getSelectedItem().toString() == "Gram")
                    {
                        tot = amount*1000;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" gram");
                    }

                    else if(s1.getSelectedItem().toString() == "Kilogram" && s2.getSelectedItem().toString() == "Ton")
                    {
                        tot = amount/1000;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Ton");
                    }

                    else if(s1.getSelectedItem().toString() == "Kilogram" && s2.getSelectedItem().toString() == "Kilogram")
                    {
                        out.setText(String.format("%.2f",amount)+" Kg");
                    }

                    //***********Ton to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Ton" && s2.getSelectedItem().toString() == "Miligram")
                    {
                        tot = amount*(1000*1000*1000);
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" mg");
                    }

                    else if(s1.getSelectedItem().toString() == "Ton" && s2.getSelectedItem().toString() == "Gram")
                    {
                        tot = amount*(1000*1000);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" gram");
                    }

                    else if(s1.getSelectedItem().toString() == "Ton" && s2.getSelectedItem().toString() == "Kilogram")
                    {
                        tot = amount*1000;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Kg");
                    }

                    else if(s1.getSelectedItem().toString() == "Ton" && s2.getSelectedItem().toString() == "Ton")
                    {
                        out.setText(String.format("%.2f",amount)+" Ton");
                    }

                    String in1 = Double.toString(amount);
                    String c1 = s1.getSelectedItem().toString();
                    String c2 = s2.getSelectedItem().toString();
                    String o1 = out.getText().toString();
                    String count1 = Integer.toString(count);

                    w_class obj = new w_class(in1,c1,c2,o1);

                    node.child(count1).setValue(obj);

                }
                catch (Exception e){
                    Toast.makeText(ww.this,"Please Give Input",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.history_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.history:
                Intent h = new Intent(ww.this,w_history.class);
                startActivity(h);
                return true;

            case R.id.about:
                Intent i = new Intent(ww.this,about.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}