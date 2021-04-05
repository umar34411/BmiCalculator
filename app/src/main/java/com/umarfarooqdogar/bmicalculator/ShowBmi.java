package com.umarfarooqdogar.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowBmi extends AppCompatActivity {

    TextView tvBmi,tvCondition,tvAdvice;
    Button btnGoBack;
    String bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi);
       init();

        Intent it=getIntent();
        bmi= it.getStringExtra("bmi");
        setTexts();



    }

    private void setTexts() {

        float num=  Float.parseFloat(bmi);
         float bmiInt=Math.round(num);

        tvBmi.setText(bmiInt+"");
        if(bmiInt<18.5)
        {
            tvCondition.setText("Body mass deficit");
            tvAdvice.setText("Eat Healthy");
            tvCondition.setTextColor(Color.parseColor("#4cb09c"));

        }else if(bmiInt>=18.5 &&  bmiInt<=24.9)
        {
            tvCondition.setText("Normal Body mass");
            tvAdvice.setText("Stay Healthy");
            tvCondition.setTextColor(Color.parseColor("#4cb060"));
        }
        else if(bmiInt>=25 &&  bmiInt<=29.9)
        {
            tvCondition.setText("Excessive Body mass");
            tvAdvice.setText("Go to Gym");
            tvCondition.setTextColor(Color.parseColor("#fc1703"));
        }else
            {
                tvCondition.setText("Obesity Phase");
                tvAdvice.setText("Workout hard");
                tvCondition.setTextColor(Color.parseColor("#fc1703"));
            }


    }

    private void init() {
        tvBmi=findViewById(R.id.bmi);
        tvCondition=findViewById(R.id.condition);
        tvAdvice=findViewById(R.id.advice);
        btnGoBack=findViewById(R.id.btnGoBack);


        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowBmi.this, "hello", Toast.LENGTH_SHORT).show();
                Intent it =new Intent(ShowBmi.this,MainActivity.class);
                startActivity(it);
                finish();
            }
        });
    }


}