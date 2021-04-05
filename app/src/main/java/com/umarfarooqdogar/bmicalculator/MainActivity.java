package com.umarfarooqdogar.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etName,etAge,etGender,etHeight,etWeight;
    Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

       btnCalculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(isValidated())
               {
                 float bmi=calculateBmi();
                   Intent it=new Intent(MainActivity.this,ShowBmi.class);
                   it.putExtra("bmi",bmi+"");
                   startActivity(it);
                   finish();
               }
           }
       });



    }

    private float calculateBmi() {
        float weight,height;

        height=Integer.parseInt(etHeight.getText().toString().trim());
        weight=Integer.parseInt(etWeight.getText().toString().trim());
        height=(height/100);

        return  (weight/(height*height));
    }

    private boolean isValidated() {
        String name,age ,gender,weight,height;
        name=etName.getText().toString().trim();
        age=etAge.getText().toString().trim();
        gender=etGender.getText().toString().trim();
        height=etHeight.getText().toString().trim();
        weight=etWeight.getText().toString().trim();

        if(name.isEmpty())
        {
            etName.setError("Name is required");
            return false;
        }else if(age.isEmpty() || Integer.parseInt(age)<0)
        {
            etAge.setError("Age can't be empty or negative");
            return false;
        }else if(gender.isEmpty() || ((!gender.equalsIgnoreCase("male")) && (!gender.equalsIgnoreCase("female")))){
            etGender.setError("Gender can only be male or female");
            return false;
        } else if(height.isEmpty() || Integer.parseInt(height)<0)
        {
            etHeight.setError("Height can't be empty or negative");
            return false;
        }else if(weight.isEmpty() || Integer.parseInt(weight)<0)
        {
            etWeight.setError("Weight can't be empty or negative");

            return false;
        }else{
            return  true;
        }

    }

    private void init() {
        etName=findViewById(R.id.name);
        etAge=findViewById(R.id.age);
        etGender=findViewById(R.id.gender);
        etHeight=findViewById(R.id.height);
        etWeight=findViewById(R.id.weight);
        btnCalculate=findViewById(R.id.btnGoBack);
    }


}