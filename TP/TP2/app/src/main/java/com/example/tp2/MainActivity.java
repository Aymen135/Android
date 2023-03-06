package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String login = "aymen";
    String password = "123";
    EditText t1,t2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.login);
        t2 = findViewById(R.id.pass);
        b = findViewById(R.id.butt1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t1.getText().toString().equals(login)&& t2.getText().toString().equals(password)){
                    Intent i = new Intent(MainActivity.this,SecondActivity.class);
                    i.putExtra("name",t1.getText().toString());
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,"les informations sont incorrectes ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}