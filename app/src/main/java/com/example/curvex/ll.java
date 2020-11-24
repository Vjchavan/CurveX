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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class ll extends AppCompatActivity {

    EditText amt;
    Spinner s1,s2;
    Button convert,clear;
    TextView out;
    String [] arr = {"Kelvin","Fahrenheit","Celsius"};
    int count=0;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference node = db.getReference("Temperature_History");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ll);

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

                    //***********Kelvin to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Kelvin" && s2.getSelectedItem().toString() == "Fahrenheit")
                    {
                        tot = (amount-273.15)*9/5+32;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" F");
                    }

                    else if(s1.getSelectedItem().toString() == "Kelvin" && s2.getSelectedItem().toString() == "Celsius")
                    {
                        tot = amount-273.15;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" C");
                    }

                    else if(s1.getSelectedItem().toString() == "Kelvin" && s2.getSelectedItem().toString() == "Kelvin")
                    {
                        out.setText(String.format("%.2f",amount)+" K");
                    }

                    //***********Fahrenheit to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Fahrenheit" && s2.getSelectedItem().toString() == "Kelvin")
                    {
                        tot = (amount-32)*5/9+273.15;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" K");
                    }

                    else if(s1.getSelectedItem().toString() == "Fahrenheit" && s2.getSelectedItem().toString() == "Celsius")
                    {
                        tot = (amount-32)*5/9;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" C");
                    }

                    else if(s1.getSelectedItem().toString() == "Fahrenheit" && s2.getSelectedItem().toString() == "Fahrenheit")
                    {
                        out.setText(String.format("%.2f",amount)+" F");
                    }

                    //***********Fahrenheit to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Celsius" && s2.getSelectedItem().toString() == "Kelvin")
                    {
                        tot = amount+273.15;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" K");
                    }

                    else if(s1.getSelectedItem().toString() == "Celsius" && s2.getSelectedItem().toString() == "Fahrenheit")
                    {
                        tot = (amount*9/5)+32;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" F");
                    }

                    else if(s1.getSelectedItem().toString() == "Celsius" && s2.getSelectedItem().toString() == "Celsius")
                    {
                        out.setText(String.format("%.2f",amount)+" C");
                    }
                    String in1 = Double.toString(amount);
                    String c1 = s1.getSelectedItem().toString();
                    String c2 = s2.getSelectedItem().toString();
                    String o1 = out.getText().toString();
                    String count1 = Integer.toString(count);

                    tem_class obj = new tem_class(in1,c1,c2,o1);

                    node.child(count1).setValue(obj);

                }
                catch (Exception e){

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
                Intent h = new Intent(ll.this,tem_history.class);
                startActivity(h);
                return true;

            case R.id.about:
                Intent i = new Intent(ll.this,about.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}