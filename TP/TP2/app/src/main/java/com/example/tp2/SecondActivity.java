package com.example.tp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String hello="";
    TextView t1;
    EditText nom,prenom,age;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t1 = findViewById(R.id.msg);
        Bundle extrat = getIntent().getExtras();
        hello= t1.getText().toString()+" "+extrat.getString("name");
        t1.setText(hello);
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        age = findViewById(R.id.age);
        b1 = findViewById(R.id.butt2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SecondActivity.this);
                alert.setMessage("Nom : "+nom.getText().toString());
                alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder alert2 = new AlertDialog.Builder(SecondActivity.this);
                        alert2.setMessage("Prenom : "+prenom.getText().toString());
                        alert2.setPositiveButton("next", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                AlertDialog.Builder alert3 = new AlertDialog.Builder(SecondActivity.this);
                                alert3.setMessage("Age : "+age.getText().toString());
                                alert3.setPositiveButton("OK",null);
                                alert3.show();
                            }
                        });
                        alert2.show();
                    }
                });
                alert.show();
            }
        });
    }
}