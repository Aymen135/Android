package com.example.conversation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
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

public class MainActivity extends AppCompatActivity {
    static float coeff = 3.34f;
    EditText val;
    RadioGroup g;
    Button b;
    TextView t1;
    RadioButton rb1,rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val = findViewById(R.id.value);
        g = findViewById(R.id.radio);
        b = findViewById(R.id.conv_butt);
        t1 = findViewById(R.id.result);
        rb1 = findViewById(R.id.radioButton3);
        rb2 = findViewById(R.id.radioButton4);

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
        rb1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        rb1.setOnCreateContextMenuListener(this);
        rb2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        rb2.setOnCreateContextMenuListener(this);
        g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
               if (i==R.id.radioButton4)
                   Toast.makeText(MainActivity.this,"Vous aver choisir Dinar → Euro ",Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(MainActivity.this,"Vous aver choisir Euro → Dinar ",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Celcius<-->Fahrenheit");
        menu.add(0,2,0,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1:{
                Intent i = new Intent(this,Convertion_Temperature.class);
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
        menu.add(0,1,0,"Dinar → Euro");
        menu.add(0,2,0,"Euro → Dinar");

    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:{
                Toast.makeText(MainActivity.this, "3.34", Toast.LENGTH_LONG).show();
            }break;
            case 2:{
                Toast.makeText(MainActivity.this, "0.3", Toast.LENGTH_LONG).show();
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main);
        }

        // Reinitialize your views here
        val = findViewById(R.id.value);
        g = findViewById(R.id.radio);
        b = findViewById(R.id.conv_butt);
        t1 = findViewById(R.id.result);
        rb1 = findViewById(R.id.radioButton3);
        rb2 = findViewById(R.id.radioButton4);
    }
}