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

public class dd extends AppCompatActivity {
    EditText amt;
    Spinner s1,s2;
    Button convert,clear;
    TextView out;
    String [] arr = {"Centimeter","Meter","Kilometer","Inches","Feet"};
    int count=0;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference node = db.getReference("Distance_History");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dd);

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


//                ***********Centieter to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Centimeter" && s2.getSelectedItem().toString() == "Meter")
                    {
                        tot = amount/100;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Mtr");
                    }

                    else if(s1.getSelectedItem().toString() == "Centimeter" && s2.getSelectedItem().toString() == "Kilometer")
                    {
                        tot = amount/(100*1000);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Km");
                    }

                    else if(s1.getSelectedItem().toString() == "Centimeter" && s2.getSelectedItem().toString() == "Inches")
                    {
                        tot = amount/2.54;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Inch");
                    }

                    else if(s1.getSelectedItem().toString() == "Centimeter" && s2.getSelectedItem().toString() == "Feet")
                    {
                        tot = amount/30.48;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Ft");
                    }

                    else if(s1.getSelectedItem().toString() == "Centimeter" && s2.getSelectedItem().toString() == "Centimeter")
                    {
                        out.setText(String.format("%.2f",amount)+" Cm");
                    }

//                    ***********Meter to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Meter" && s2.getSelectedItem().toString() == "centimeter")
                    {
                        tot = amount*100;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Cm");
                    }

                    else if(s1.getSelectedItem().toString() == "Meter" && s2.getSelectedItem().toString() == "Kilometer")
                    {
                        tot = amount/1000;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Km");
                    }

                    else if(s1.getSelectedItem().toString() == "Meter" && s2.getSelectedItem().toString() == "Inches")
                    {
                        tot = amount*39.37;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Inch");
                    }

                    else if(s1.getSelectedItem().toString() == "Meter" && s2.getSelectedItem().toString() == "Feet")
                    {
                        tot = amount*3.281;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Ft");
                    }

                    else if(s1.getSelectedItem().toString() == "Meter" && s2.getSelectedItem().toString() == "Meter")
                    {
                        out.setText(String.format("%.2f",amount)+" Mtr");
                    }

//                    ***********Kilometer to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "KiloMeter" && s2.getSelectedItem().toString() == "centimeter")
                    {
                        tot = amount*100000;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Cm");
                    }

                    else if(s1.getSelectedItem().toString() == "KiloMeter" && s2.getSelectedItem().toString() == "Meter")
                    {
                        tot = amount*1000;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Mtr");
                    }

                    else if(s1.getSelectedItem().toString() == "KiloMeter" && s2.getSelectedItem().toString() == "Inches")
                    {
                        tot = amount*39370;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Inch");
                    }

                    else if(s1.getSelectedItem().toString() == "KiloMeter" && s2.getSelectedItem().toString() == "Feet")
                    {
                        tot = amount*3281;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Ft");
                    }

                    else if(s1.getSelectedItem().toString() == "KiloMeter" && s2.getSelectedItem().toString() == "KiloMeter")
                    {
                        out.setText(String.format("%.2f",amount)+" Km");
                    }

//                    ***********Inches to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Inches" && s2.getSelectedItem().toString() == "centimeter")
                    {
                        tot = amount*2.54;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Cm");
                    }

                    else if(s1.getSelectedItem().toString() == "Inches" && s2.getSelectedItem().toString() == "Meter")
                    {
                        tot = amount/39.37;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Mtr");
                    }

                    else if(s1.getSelectedItem().toString() == "Inches" && s2.getSelectedItem().toString() == "Kilometer")
                    {
                        tot = amount/39370;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Km");
                    }

                    else if(s1.getSelectedItem().toString() == "Inches" && s2.getSelectedItem().toString() == "Feet")
                    {
                        tot = amount/12;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Ft");
                    }

                    else if(s1.getSelectedItem().toString() == "Inches" && s2.getSelectedItem().toString() == "Inches")
                    {
                        out.setText(String.format("%.2f",amount)+" Inch");
                    }

//                    ***********Feet to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Feet" && s2.getSelectedItem().toString() == "centimeter")
                    {
                        tot = amount*30.48;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Cm");
                    }

                    else if(s1.getSelectedItem().toString() == "Feet" && s2.getSelectedItem().toString() == "Meter")
                    {
                        tot = amount/3.281;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Mtr");
                    }

                    else if(s1.getSelectedItem().toString() == "Feet" && s2.getSelectedItem().toString() == "Kilometer")
                    {
                        tot = amount/3281;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Km");
                    }

                    else if(s1.getSelectedItem().toString() == "Feet" && s2.getSelectedItem().toString() == "Inches")
                    {
                        tot = amount*12;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Inch");
                    }

                    else if(s1.getSelectedItem().toString() == "Feet" && s2.getSelectedItem().toString() == "Feet")
                    {
                        out.setText(String.format("%.2f",amount)+" Ft");
                    }
                    String in1 = Double.toString(amount);
                    String c1 = s1.getSelectedItem().toString();
                    String c2 = s2.getSelectedItem().toString();
                    String o1 = out.getText().toString();
                    String count1 = Integer.toString(count);

                    d_class obj = new d_class(in1,c1,c2,o1);

                    node.child(count1).setValue(obj);
                }
                catch (Exception e){
                    Toast.makeText(dd.this,"Please Give Input",Toast.LENGTH_SHORT).show();
                }


            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amt.setText("");
                out.setText("");
                s1.setSelection(0);
                s2.setSelection(0);
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
                Intent h = new Intent(dd.this,d_history.class);
                startActivity(h);
                return true;

            case R.id.about:
                Intent i = new Intent(dd.this,about.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}