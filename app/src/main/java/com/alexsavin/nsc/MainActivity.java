package com.alexsavin.nsc;

import static android.view.Gravity.LEFT;

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

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;

    LinearLayout LinearDin;
    LinearLayout linearOne;
    LinearLayout lt201;

    String oilWellNum;
    Cursor cursor;
    Button tv;
    TextView tvc;

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

//        LinearDin = (LinearLayout) findViewById(R.id.LinearDin);
        linearOne = (LinearLayout) findViewById(R.id.linearOne);

        mDBHelper = new DatabaseHelper(getApplicationContext());
        mDBHelper.create_db();
        mDb = mDBHelper.open();

        lt201 = (LinearLayout) findViewById(R.id.lt201);
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

        lt201.setOnClickListener(this);
//        but201.setOnClickListener(this);
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

//        cursor = mDb.query(mDBHelper.TABLE, null, null, null, null, null, null);

//        tvc = findViewById(R.id.tvc);

//        logCursC(cursor);
//        multiButtons(cursor);



    }

    void multiButtons(Cursor c){
        if(c.moveToFirst()) {
            do {

                createButton(c);

            }
            while (c.moveToNext());
        }
    }

    @SuppressLint({"Range", "ResourceAsColor"})
    void createButton(Cursor c){

        String str = "";
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                matchParent, 200);
        Button btnNew = new Button(this);
        btnNew.setPadding(5, 5, 5, 5);

//        btnNew.setBackgroundColor(R.color.black_grey_bgrnd);
//        btnNew.setTextColor(R.color.grey_but_btn);

        btnNew.setBackgroundColor(R.color.black);
        btnNew.requestLayout();
        btnNew.setHeight(60);
        btnNew.setWidth(180);
        btnNew.setTextSize(60);
        btnNew.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        str = c.getString(c.getColumnIndex(mDBHelper.COLUMN_NUMBER));
        btnNew.setText(str);
        btnNew.setOnClickListener(this);

        btnNew.setId(Integer.parseInt(str));
//        Button btnnn = (Button) findViewById(R.id.(btnNew.getId()));

//    LinearDin.setBackgroundColor(R.color.black);
        linearOne.setPadding(30,10,10,30);
        linearOne.addView(btnNew, lParams);
//        LinearDin.addView(btnNew, lParams);
//        linearOne.setLayoutParams(lParams);
        lParams.gravity = Gravity.CENTER_HORIZONTAL;

    }


//        @SuppressLint("Range")
//    void logCursC(Cursor c) {


//        if (c != null) {
//
//            if (c.moveToFirst()) {
//                String str = "";
//                str = c.getString(c.getColumnIndex(mDBHelper.COLUMN_NUMBER));
//                tvc.setText(str);
//            }
//        } else
//            tvc.setText("null");
////        return str;
//    }




    @Override
    public void onClick(View v) {
//Intent intent;


        Intent intent = new Intent(this, Equipment.class);
        switch (v.getId()) {


            case R.id.lt201:
//                intent = new Intent("201");
                intent.putExtra("name", "201");
                startActivity(intent);
                break;
            case R.id.but407:
//                intent = new Intent("407");
                intent.putExtra("name", "407");
                startActivity(intent);
                break;
            case R.id.but608:
//                intent = new Intent("407");
                intent.putExtra("name", "608");
                startActivity(intent);
                break;
            case R.id.but707:
                intent.putExtra("name", "707");
//                intent = new Intent("407");
                startActivity(intent);
                break;
            case R.id.but778:
                intent.putExtra("name", "778");
//                intent = new Intent("407");
                startActivity(intent);
                break;
            case R.id.but780:
                intent.putExtra("name", "780");
//                intent = new Intent("407");
                startActivity(intent);
                break;
            case R.id.but786:
                intent.putExtra("name", "786");
//                intent = new Intent("407");
                startActivity(intent);
                break;
            case R.id.but788:
                intent.putExtra("name", "788");
//                intent = new Intent("407");
                startActivity(intent);
                break;
            case R.id.but790:
                intent.putExtra("name", "790");
//                intent = new Intent("407");
                startActivity(intent);
                break;
            case R.id.but797:
                intent.putExtra("name", "797");
//                intent = new Intent("407");
                startActivity(intent);
                break;
            case R.id.but809:
                intent.putExtra("name", "809");
//                intent = new Intent("407");
                startActivity(intent);
                break;
            case R.id.but907:
                intent.putExtra("name", "907");
//                intent = new Intent("407");
                startActivity(intent);
                break;

        }
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        mDb = mDBHelper.open();
//
//
//    }



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

//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        mDb.close();
//
//    }


}