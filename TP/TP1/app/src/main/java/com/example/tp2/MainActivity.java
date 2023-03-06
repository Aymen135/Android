package com.example.tp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.txt1);
        b1 = findViewById(R.id.butt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("name",t1.getText().toString());
                startActivity(i);
                Toast.makeText(MainActivity.this,t1.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
        b2 = findViewById(R.id.butt2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Attention !");
                alert.setMessage("Voulez vous quitter ?");
                alert.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                    }
                });
                alert.setNegativeButton("Non",null);
                alert.show();
            }
        });
    }
}