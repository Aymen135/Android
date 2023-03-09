package com.example.conversation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static float coeff = 3.34f;
    EditText val;
    RadioGroup g;
    Button b,quitt,direct;
    TextView t1;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val = findViewById(R.id.value);
        g = findViewById(R.id.radio);
        b = findViewById(R.id.conv_butt);
        t1 = findViewById(R.id.result);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (val.getText().toString().equals("")){
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("donner une valeur");
                    alert.setPositiveButton("ok",null);
                    alert.show();
                }
                else{
                    if (g.getCheckedRadioButtonId() == R.id.radioButton4)
                        t1.setText(String.valueOf(Float.parseFloat(val.getText().toString())/coeff));
                    else
                        t1.setText(String.valueOf(Float.parseFloat(val.getText().toString())*coeff));
                }
            }
        });
        direct = findViewById(R.id.go);
        direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Convertion_Temperature.class);
                startActivity(i);
            }
        });
        quitt = findViewById(R.id.quitter);
        quitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }
}