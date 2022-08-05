package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // design layout will be connected with java

        EditText weight,editHeightFoot,editWeightInch;
        Button BMI;
        TextView txt;


        weight = findViewById(R.id.editWeight);
        editHeightFoot = findViewById(R.id.editHeightFoot);
        editWeightInch = findViewById(R.id.editHeightInch);
        BMI = findViewById(R.id.bmiButton);
        txt = findViewById(R.id.editResult);

        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt( weight.getText().toString());
                int htFoot = Integer.parseInt( editHeightFoot.getText().toString());
                int htInch = Integer.parseInt( editWeightInch.getText().toString());
                int totalInch = htFoot * 12 + htInch;
                double totalCentemeter = totalInch * 2.53;
                double totalMeter = totalCentemeter / 100;
                double bmi = wt/(totalMeter*totalMeter);

                if (bmi > 25){
                    txt.setText("Over weight:"+String.format("%.2f",bmi));
                } else if (bmi < 18) {
                    txt.setText("Under Weight:"+String.format("%.2f",bmi));
                }else{
                    txt.setText("Healthy:"+String.format("%.2f",bmi));
                }

            }
        });

    }
}