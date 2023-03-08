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

public class Convertion_Temperature extends AppCompatActivity {
    static int value = 32;
    EditText t1;
    RadioGroup g2;
    RadioButton selectedButton;
    Button b,quitt,direct;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertion_temperature);
        t1 = findViewById(R.id.val1);
        g2 = findViewById(R.id.radio_grp2);
        b = findViewById(R.id.button);
        result = findViewById(R.id.result2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t1.getText().toString().equals("")) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(Convertion_Temperature.this);
                    alert.setMessage("donner une valeur");
                    alert.setPositiveButton("ok", null);
                    alert.show();
                }
                else{
                    if (g2.getCheckedRadioButtonId() == R.id.radioButton6)
                        result.setText(String.valueOf(Integer.parseInt(t1.getText().toString())+value));
                    else
                        result.setText(String.valueOf(Integer.parseInt(t1.getText().toString())-value));
                }
            }
        });
        direct = findViewById(R.id.go);
        direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Convertion_Temperature.this,MainActivity.class);
                startActivity(i);
            }
        });
        quitt = findViewById(R.id.quitter);
        quitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}