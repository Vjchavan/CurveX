package com.example.curvex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class tt extends AppCompatActivity {
    EditText amt;
    Spinner s1,s2;
    Button convert,clear;
    TextView out;
    String [] arr = {"Mili-Seconds","Seconds","Minutes","Hours","Days"};
    int count=0;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference node = db.getReference("Time_History");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tt);

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


//                ***********Mili-seconds to Other Coonversion****************

                    if(s1.getSelectedItem().toString() == "Mili-Seconds" && s2.getSelectedItem().toString() == "Seconds")
                    {
                        tot = amount/1000;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" sec");
                    }

                    else if(s1.getSelectedItem().toString() == "Mili-Seconds" && s2.getSelectedItem().toString() == "Minutes")
                    {
                        tot = amount/(1000*60);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Min");
                    }

                    else if(s1.getSelectedItem().toString() == "Mili-Seconds" && s2.getSelectedItem().toString() == "Hours")
                    {
                        tot = amount/3600000;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Hrs");
                    }

                    else if(s1.getSelectedItem().toString() == "Mili-Seconds" && s2.getSelectedItem().toString() == "Days")
                    {
                        tot = amount/(3600000*24);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Days");
                    }

                    else if(s1.getSelectedItem().toString() == "Mili-Seconds" && s2.getSelectedItem().toString() == "Mili-Seconds")
                    {
                        out.setText(String.format("%.2f",amount)+" ms");
                    }

//                **********Seconds to Other Conversion*************

                    if(s1.getSelectedItem().toString() == "Seconds" && s2.getSelectedItem().toString() == "Mili-Seconds")
                    {
                        tot = amount*1000;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" ms");
                    }

                    else if(s1.getSelectedItem().toString() == "Seconds" && s2.getSelectedItem().toString() == "Minutes")
                    {
                        tot = amount/60;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Min");
                    }

                    else if(s1.getSelectedItem().toString() == "Seconds" && s2.getSelectedItem().toString() == "Hours")
                    {
                        tot = amount/(60*60);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Hrs");
                    }

                    else if(s1.getSelectedItem().toString() == "Seconds" && s2.getSelectedItem().toString() == "Days")
                    {
                        tot = amount/(3600*24);
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Days");
                    }

                    else if(s1.getSelectedItem().toString() == "Seconds" && s2.getSelectedItem().toString() == "Seconds")
                    {
                        out.setText(String.format("%.2f",amount)+" Sec");
                    }
//                    **********Minutes to Other Conversion*************

                    if(s1.getSelectedItem().toString() == "Minutes" && s2.getSelectedItem().toString() == "Mili-Seconds")
                    {
                        tot = amount*60000;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" ms");
                    }

                    else if(s1.getSelectedItem().toString() == "Minutes" && s2.getSelectedItem().toString() == "Seconds")
                    {
                        tot = amount*60;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Sec");
                    }

                    else if(s1.getSelectedItem().toString() == "Minutes" && s2.getSelectedItem().toString() == "Hours")
                    {
                        tot = amount/60;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Hrs");
                    }

                    else if(s1.getSelectedItem().toString() == "Minutes" && s2.getSelectedItem().toString() == "Days")
                    {
                        tot = amount/1440;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Days");
                    }

                    else if(s1.getSelectedItem().toString() == "Minutes" && s2.getSelectedItem().toString() == "Minutes")
                    {
                        out.setText(String.format("%.2f",amount)+" Mins");
                    }
//                    **********Hours to Other Conversion*************

                    if(s1.getSelectedItem().toString() == "Hours" && s2.getSelectedItem().toString() == "Mili-Seconds")
                    {
                        tot = amount/3600;
                        Double inr = Double.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" ms");
                    }

                    else if(s1.getSelectedItem().toString() == "Hours" && s2.getSelectedItem().toString() == "Seconds")
                    {
                        tot = amount*3600;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Sec");
                    }

                    else if(s1.getSelectedItem().toString() == "Hours" && s2.getSelectedItem().toString() == "Minutes")
                    {
                        tot = amount*60;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Hrs");
                    }

                    else if(s1.getSelectedItem().toString() == "Hours" && s2.getSelectedItem().toString() == "Days")
                    {
                        tot = amount/24;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Days");
                    }

                    else if(s1.getSelectedItem().toString() == "Hours" && s2.getSelectedItem().toString() == "Hours")
                    {
                        out.setText(String.format("%.2f",amount)+" Hrs");
                    }
//                    **********Days to Other Conversion*************

                    if(s1.getSelectedItem().toString() == "Days" && s2.getSelectedItem().toString() == "Mili-Seconds")
                    {
                        tot = amount/86400000;
                        Double inr = Double.valueOf((tot));
                        out.setText(inr+" ms");
                    }

                    else if(s1.getSelectedItem().toString() == "Days" && s2.getSelectedItem().toString() == "Seconds")
                    {
                        tot = amount/86400;
                        String inr = String.valueOf((tot));
                        out.setText(inr+" Sec");
                    }

                    else if(s1.getSelectedItem().toString() == "Days" && s2.getSelectedItem().toString() == "Minutes")
                    {
                        tot = amount*1440;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Mins");
                    }

                    else if(s1.getSelectedItem().toString() == "Days" && s2.getSelectedItem().toString() == "Hours")
                    {
                        tot = amount*24;
                        String inr = String.valueOf(decimalFormat.format(tot));
                        out.setText(inr+" Hrs");
                    }

                    else if(s1.getSelectedItem().toString() == "Days" && s2.getSelectedItem().toString() == "Days")
                    {
                        out.setText(String.format("%.2f",amount)+" Days");
                    }

                    String in1 = Double.toString(amount);
                    String c1 = s1.getSelectedItem().toString();
                    String c2 = s2.getSelectedItem().toString();
                    String o1 = out.getText().toString();
                    String count1 = Integer.toString(count);

                    t_class obj = new t_class(in1,c1,c2,o1);

                    node.child(count1).setValue(obj);

                }
                catch (Exception e){
                    Toast.makeText(tt.this,"Please Give Input",Toast.LENGTH_SHORT).show();
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
                Intent h = new Intent(tt.this,t_history.class);
                startActivity(h);
                return true;

            case R.id.about:
                Intent i = new Intent(tt.this,about.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}