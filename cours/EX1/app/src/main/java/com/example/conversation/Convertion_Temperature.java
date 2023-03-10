package com.example.conversation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Convertion_Temperature extends AppCompatActivity {
    static int value = 32;
    EditText t1;
    RadioGroup g2;
    RadioButton rb1,rb2;
    Button b;
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
        rb1 = findViewById(R.id.radioButton5);
        rb2 = findViewById(R.id.radioButton6);
        rb1.setOnCreateContextMenuListener(this);
        rb2.setOnCreateContextMenuListener(this);
        rb1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        rb2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        g2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.radioButton6)
                    Toast.makeText(Convertion_Temperature.this,"Vous aver choisir Celcius → Fahrenheit ",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Convertion_Temperature.this,"Vous aver choisir Fahrenheit → Celcius ",Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Euro <---> Dinars");
        menu.add(0,2,0,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1:{
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
            }break;
            case 2:{
                finishAffinity();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,1,0,"Celcius → Fahrenheit");
        menu.add(0,2,0,"Fahrenheit → Celcius");

    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:{
                Toast.makeText(Convertion_Temperature.this, "+32", Toast.LENGTH_SHORT).show();
            }break;
            case 2:{
                Toast.makeText(Convertion_Temperature.this, "-32", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onContextItemSelected(item);
    }
}