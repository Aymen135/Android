package com.example.ex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup gender ;
    RadioButton male,female;
    Button display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gender = findViewById(R.id.gender);
        male=findViewById(R.id.male);
        female = findViewById(R.id.female);
        display = findViewById(R.id.button2);
        display.setOnCreateContextMenuListener(this);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(R.id.male == gender.getCheckedRadioButtonId()){
                    Toast.makeText(MainActivity.this,male.getText().toString(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,female.getText().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
        display.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,1,0,"F --> M");
        menu.add(0,2,0,"M --> F");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1 :
                male.setChecked(true);
            break;
            case 2 :
                female.setChecked(true);
            break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"F --> M");
        menu.add(0,2,0,"M --> F");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case 1 :
                male.setChecked(true);
                break;
            case 2 :
                female.setChecked(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}