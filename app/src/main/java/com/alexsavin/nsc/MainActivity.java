package com.alexsavin.nsc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    MainButtons mainButtons;
    Cursor cursor;


    LinearLayout linearOne;
    LinearLayout lt201, lt407, lt608, lt707, lt778, lt780, lt786,lt788, lt790,lt797, lt798, lt809, lt907;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(getApplicationContext());
        mDBHelper.create_db();
        mDb = mDBHelper.open();



//        cursor = mDb.query(mDBHelper.TABLE, null, null, null, null, null, null);
//        mainButtons.createButtonTest();
        linearOne = (LinearLayout) findViewById(R.id.linearOne);



        lt201 = (LinearLayout) findViewById(R.id.lt201);
        lt407 = (LinearLayout) findViewById(R.id.lt407);
        lt608 = (LinearLayout) findViewById(R.id.lt608);
        lt707 = (LinearLayout) findViewById(R.id.lt707);
        lt778 = (LinearLayout) findViewById(R.id.lt778);
        lt780 = (LinearLayout) findViewById(R.id.lt780);
        lt786 = (LinearLayout) findViewById(R.id.lt786);
        lt788 = (LinearLayout) findViewById(R.id.lt788);
        lt790 = (LinearLayout) findViewById(R.id.lt790);
        lt797 = (LinearLayout) findViewById(R.id.lt797);
        lt798 = (LinearLayout) findViewById(R.id.lt798);
        lt809 = (LinearLayout) findViewById(R.id.lt809);
        lt907 = (LinearLayout) findViewById(R.id.lt907);


        lt201.setOnClickListener(this);
        lt407.setOnClickListener(this);
        lt608.setOnClickListener(this);
        lt707.setOnClickListener(this);
        lt778.setOnClickListener(this);
        lt780.setOnClickListener(this);
        lt786.setOnClickListener(this);
        lt788.setOnClickListener(this);
        lt790.setOnClickListener(this);
        lt797.setOnClickListener(this);
        lt798.setOnClickListener(this);
        lt809.setOnClickListener(this);
        lt907.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Equipment.class);
        switch (v.getId()) {


            case R.id.lt201:
                intent.putExtra("name", "201");
                intent.putExtra("id", "1");
                startActivity(intent);
                break;
            case R.id.lt407:
                intent.putExtra("id", "2");
                intent.putExtra("name", "407");
                startActivity(intent);
                break;
            case R.id.lt608:
                intent.putExtra("id", "3");
                intent.putExtra("name", "608");
                startActivity(intent);
                break;
            case R.id.lt707:
                intent.putExtra("id", "4");
                intent.putExtra("name", "707");
                startActivity(intent);
                break;
            case R.id.lt778:
                intent.putExtra("id", "5");
                intent.putExtra("name", "778");
                startActivity(intent);
                break;
            case R.id.lt780:
                intent.putExtra("id", "6");
                intent.putExtra("name", "780");
                startActivity(intent);
                break;
            case R.id.lt786:
                intent.putExtra("id", "7");
                intent.putExtra("name", "786");
                startActivity(intent);
                break;
            case R.id.lt788:
                intent.putExtra("id", "8");
                intent.putExtra("name", "788");
                startActivity(intent);
                break;
            case R.id.lt790:
                intent.putExtra("id", "9");
                intent.putExtra("name", "790");
                startActivity(intent);
                break;
            case R.id.lt797:
                intent.putExtra("id", "10");
                intent.putExtra("name", "797");
                startActivity(intent);
                break;
            case R.id.lt798:
                intent.putExtra("id", "11");
                intent.putExtra("name", "798");
                startActivity(intent);
                break;
            case R.id.lt809:
                intent.putExtra("id", "12");
                intent.putExtra("name", "809");
                startActivity(intent);
                break;
            case R.id.lt907:
                intent.putExtra("id", "0");
                intent.putExtra("name", "907");
                startActivity(intent);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");

        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }



}