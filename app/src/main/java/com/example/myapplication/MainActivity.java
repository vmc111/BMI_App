package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText wtInput;
        EditText htIn ;
        EditText htFt;
        Button btn ;
        TextView result ;
        LinearLayout clr;

        wtInput = findViewById(R.id.wtInput);
        htIn =  findViewById(R.id.htIn);
        htFt = findViewById(R.id.htFt);
        btn= findViewById(R.id.btn);
        result= findViewById(R.id.result);
        clr = findViewById(R.id.clr);

        EditText finalWtInput = wtInput;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                wtInput.getText(); => this takes input here
//                wt.getText().toString => conver it to string
//                Integer.parseInt(wt.getText().toString) => convert it to integer
//                int wt = Integer.parseInt(wt.getText().toString) => store in variable
                int wt = Integer.parseInt(finalWtInput.getText().toString());
                int ft = Integer.parseInt(htFt.getText().toString());
                int in = Integer.parseInt(htIn.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);

                if (bmi > 25){
                    result.setText("You're OverWeihgth!");
                    clr.setBackgroundColor(getResources().getColor(R.color.overwt));
                }else if (bmi<18){
                    result.setText("You're UnderWeight");
                    clr.setBackgroundColor(getResources().getColor(R.color.underwt));
                }else{
                    result.setText("You're Healthy!");
                    clr.setBackgroundColor(getResources().getColor(R.color.healthy));
                }


            }
        });
    }
}