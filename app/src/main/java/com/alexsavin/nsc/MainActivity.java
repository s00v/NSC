package com.alexsavin.nsc;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button but201;
    Button but407;
    Button but608;
    Button but707;
    Button but778;
    Button but780;
    Button but786;
    Button but788;
    Button but790;
    Button but797;
    Button but809;
    Button but907;

    TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but201 = (Button) findViewById(R.id.but201);
        but407 = (Button) findViewById(R.id.but407);
        but608 = (Button) findViewById(R.id.but608);
        but707 = (Button) findViewById(R.id.but707);
        but778 = (Button) findViewById(R.id.but778);
        but780 = (Button) findViewById(R.id.but780);
        but786 = (Button) findViewById(R.id.but786);
        but788 = (Button) findViewById(R.id.but788);
        but790 = (Button) findViewById(R.id.but790);
        but797 = (Button) findViewById(R.id.but797);
        but809 = (Button) findViewById(R.id.but809);
        but907 = (Button) findViewById(R.id.but907);

//        textV = (TextView) findViewById(R.id.textV);

        but201.setOnClickListener(this);
        but407.setOnClickListener(this);
        but608.setOnClickListener(this);
        but707.setOnClickListener(this);
        but778.setOnClickListener(this);
        but780.setOnClickListener(this);
        but786.setOnClickListener(this);
        but788.setOnClickListener(this);
        but790.setOnClickListener(this);
        but797.setOnClickListener(this);
        but809.setOnClickListener(this);
        but907.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CommonOilData.class);
        switch (v.getId()) {
            case R.id.but201:
                startActivity(intent);
                break;
            case R.id.but407:
                startActivity(intent);
                break;
            case R.id.but608:
                startActivity(intent);
                break;
            case R.id.but707:
                startActivity(intent);
                break;
            case R.id.but778:
                startActivity(intent);
                break;
            case R.id.but780:
                startActivity(intent);
                break;
            case R.id.but786:
                startActivity(intent);
                break;
            case R.id.but788:
                startActivity(intent);
                break;
            case R.id.but790:
                startActivity(intent);
                break;
            case R.id.but797:
                startActivity(intent);
                break;
            case R.id.but809:
                startActivity(intent);
                break;
            case R.id.but907:
                startActivity(intent);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
//        Menu
        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");

        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Auto-generated
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

}