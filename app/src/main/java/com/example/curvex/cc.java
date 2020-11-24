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

public class cc extends AppCompatActivity {
    EditText amt;
    Spinner s1,s2;
    Button convert,clear;
    TextView out;
    String [] arr = {"IND","USA","PAK","UK"};

    int count=0;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference node = db.getReference("Currency_History");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cc);

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

//                ***********INR to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "IND" && s2.getSelectedItem().toString() == "USA")
                    {
                        tot = amount*0.013;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" $");
                    }

                    else if(s1.getSelectedItem().toString() == "IND" && s2.getSelectedItem().toString() == "PAK")
                    {
                        tot = amount*2.16;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Rs");
                    }

                    else if(s1.getSelectedItem().toString() == "IND" && s2.getSelectedItem().toString() == "UK")
                    {
                        tot = amount*0.010;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" £");
                    }

                    else if(s1.getSelectedItem().toString() == "IND" && s2.getSelectedItem().toString() == "IND")
                    {
                        out.setText(String.format("%.2f",amount)+" ₹");
                    }

//                **********USD to Other Conversion*************

                    else if(s1.getSelectedItem().toString() == "USA" && s2.getSelectedItem().toString() == "IND")
                    {
                        tot = amount*74.48;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" ₹");
                    }

                    else if(s1.getSelectedItem().toString() == "USA" && s2.getSelectedItem().toString() == "PAK")
                    {
                        tot = amount*160.45;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Rs");
                    }

                    else if(s1.getSelectedItem().toString() == "USA" && s2.getSelectedItem().toString() == "UK")
                    {
                        tot = amount*0.77;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" £");
                    }

                    else if(s1.getSelectedItem().toString() == "USA" && s2.getSelectedItem().toString() == "USA")
                    {
                        out.setText(String.format("%.2f",amount)+" $");
                    }
//                **************PKR to Other Conversion**************

                    if(s1.getSelectedItem().toString() == "PAK" && s2.getSelectedItem().toString() == "IND")
                    {
                        tot = amount*0.46;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" ₹");
                    }

                    else if(s1.getSelectedItem().toString() == "PAK" && s2.getSelectedItem().toString() == "USA")
                    {
                        tot = amount*0.0063;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" $");
                    }

                    else if(s1.getSelectedItem().toString() == "PAK" && s2.getSelectedItem().toString() == "UK")
                    {
                        tot = amount*0.0048;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" £");
                    }

                    else if(s1.getSelectedItem().toString() == "PAK" && s2.getSelectedItem().toString() == "PAK")
                    {
                        out.setText(String.format("%.2f",amount)+" Rs");
                    }

//                *********************UK to other conversion**************************

                    if(s1.getSelectedItem().toString() == "UK" && s2.getSelectedItem().toString() == "IND")
                    {
                        tot = amount*97.34;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" ₹");
                    }

                    else if(s1.getSelectedItem().toString() == "UK" && s2.getSelectedItem().toString() == "USA")
                    {
                        tot = amount*1.31;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" $");
                    }

                    else if(s1.getSelectedItem().toString() == "UK" && s2.getSelectedItem().toString() == "PAK")
                    {
                        tot = amount*208.74;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Rs");
                    }

                    else if(s1.getSelectedItem().toString() == "UK" && s2.getSelectedItem().toString() == "UK")
                    {
                        out.setText(String.format("%.2f",amount)+" £");
                    }

                    String in1 = Double.toString(amount);
                    String c1 = s1.getSelectedItem().toString();
                    String c2 = s2.getSelectedItem().toString();
                    String o1 = out.getText().toString();
                    String count1 = Integer.toString(count);

                    c_class obj = new c_class(in1,c1,c2,o1);
                    
                    node.child(count1).setValue(obj);

                }
                catch (Exception e){
                    Toast.makeText(cc.this,"Please Give Input",Toast.LENGTH_SHORT).show();
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
                Intent h = new Intent(cc.this,c_history.class);
                startActivity(h);
                return true;

            case R.id.about:
                Intent i = new Intent(cc.this,about.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}