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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    MainButtons mainButtons;
    Cursor cursor;
    Cursor userCC;

    LinearLayout linearOne;
    LinearLayout lt201, lt407, lt608, lt707, lt778, lt780, lt786,lt788, lt790,lt797, lt798, lt809, lt907;
    TextView tvDate907, tvDate608,tvDate201,tvDate407, tvDate707, tvDate778, tvDate780, tvDate786, tvDate788, tvDate790, tvDate797, tvDate798, tvDate809;
    TextView tvDeep201, tvDeep407, tvDeep608, tvDeep707, tvDeep778, tvDeep780, tvDeep786, tvDeep788, tvDeep790, tvDeep797, tvDeep798, tvDeep809, tvDeep907;
    TextView tvKvt201, tvKvt407, tvKvt608, tvKvt707, tvKvt778, tvKvt780, tvKvt786, tvKvt788, tvKvt790, tvKvt797, tvKvt798, tvKvt809, tvKvt907;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DatabaseHelper(getApplicationContext());
        mDBHelper.create_db();
        mDb = mDBHelper.open();



//        cursor = mDb.query(mDBHelper.TABLE, null, null, null, null, null, null);
//        mainButtons.createButtonTest();
//        linearOne = (LinearLayout) findViewById(R.id.linearOne);

        tvKvt201 =  findViewById(R.id.tvKvt201);
        tvKvt407 =  findViewById(R.id.tvKvt407);
        tvKvt608 =  findViewById(R.id.tvKvt608);
        tvKvt707 =  findViewById(R.id.tvKvt707);
        tvKvt778 =  findViewById(R.id.tvKvt778);
        tvKvt780 =  findViewById(R.id.tvKvt780);
        tvKvt786 =  findViewById(R.id.tvKvt786);
        tvKvt788 =  findViewById(R.id.tvKvt788);
        tvKvt790 =  findViewById(R.id.tvKvt790);
        tvKvt797 =  findViewById(R.id.tvKvt797);
        tvKvt798 =  findViewById(R.id.tvKvt798);
        tvKvt809 =  findViewById(R.id.tvKvt809);
        tvKvt907 =  findViewById(R.id.tvKvt907);

        tvDeep201 =  findViewById(R.id.tvDeep201);
        tvDeep407 =  findViewById(R.id.tvDeep407);
        tvDeep608 =  findViewById(R.id.tvDeep608);
        tvDeep707 =  findViewById(R.id.tvDeep707);
        tvDeep778 =  findViewById(R.id.tvDeep778);
        tvDeep780 =  findViewById(R.id.tvDeep780);
        tvDeep786 =  findViewById(R.id.tvDeep786);
        tvDeep788 =  findViewById(R.id.tvDeep788);
        tvDeep790 =  findViewById(R.id.tvDeep790);
        tvDeep797 =  findViewById(R.id.tvDeep797);
        tvDeep798 =  findViewById(R.id.tvDeep798);
        tvDeep809 =  findViewById(R.id.tvDeep809);
        tvDeep907 =  findViewById(R.id.tvDeep907);

        tvDate201 =  findViewById(R.id.tvDate201);
        tvDate407 =  findViewById(R.id.tvDate407);
        tvDate608 =  findViewById(R.id.tvDate608);
        tvDate707 =  findViewById(R.id.tvDate707);
        tvDate778 =  findViewById(R.id.tvDate778);
        tvDate780 =  findViewById(R.id.tvDate780);
        tvDate786 =  findViewById(R.id.tvDate786);
        tvDate788 =  findViewById(R.id.tvDate788);
        tvDate790 =  findViewById(R.id.tvDate790);
        tvDate797 =  findViewById(R.id.tvDate797);
        tvDate798 =  findViewById(R.id.tvDate798);
        tvDate809 =  findViewById(R.id.tvDate809);
        tvDate907 =  findViewById(R.id.tvDate907);

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

        List<TextView> arrayDateStart = new ArrayList();
        {
            arrayDateStart.add(tvDate907);
            arrayDateStart.add(tvDate201);
            arrayDateStart.add(tvDate407);
            arrayDateStart.add(tvDate608);
            arrayDateStart.add(tvDate707);
            arrayDateStart.add(tvDate778);
            arrayDateStart.add(tvDate780);
            arrayDateStart.add(tvDate786);
            arrayDateStart.add(tvDate788);
            arrayDateStart.add(tvDate790);
            arrayDateStart.add(tvDate797);
            arrayDateStart.add(tvDate798);
            arrayDateStart.add(tvDate809);
        }

        List<TextView> arrayDeep = new ArrayList();
        {
            arrayDeep.add(tvDeep907);
            arrayDeep.add(tvDeep201);
            arrayDeep.add(tvDeep407);
            arrayDeep.add(tvDeep608);
            arrayDeep.add(tvDeep707);
            arrayDeep.add(tvDeep778);
            arrayDeep.add(tvDeep780);
            arrayDeep.add(tvDeep786);
            arrayDeep.add(tvDeep788);
            arrayDeep.add(tvDeep790);
            arrayDeep.add(tvDeep797);
            arrayDeep.add(tvDeep798);
            arrayDeep.add(tvDeep809);
        }

        List<TextView> arrayKvt = new ArrayList();
        {
            arrayKvt.add(tvKvt907);
            arrayKvt.add(tvKvt201);
            arrayKvt.add(tvKvt407);
            arrayKvt.add(tvKvt608);
            arrayKvt.add(tvKvt707);
            arrayKvt.add(tvKvt778);
            arrayKvt.add(tvKvt780);
            arrayKvt.add(tvKvt786);
            arrayKvt.add(tvKvt788);
            arrayKvt.add(tvKvt790);
            arrayKvt.add(tvKvt797);
            arrayKvt.add(tvKvt798);
            arrayKvt.add(tvKvt809);
        }

        logCursC(getTableDB(userCC, mDBHelper.TABLE), 0, arrayDateStart, arrayOilWellMain);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_DEEP), 0, arrayDeep, arrayDeepDB);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ENGINE), 0, arrayKvt, arrayKvtDB);


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

    // Метод для получения названий колонок
    public String getColumn(List<String> strCol, int i){
        return strCol.get(i);
    }

    public Cursor getTableDB(Cursor c, String tableName){
        c = mDb.query(tableName, null, null, null, null, null, null);
        return c;
    }

    // Достаём данные из курсора
    @SuppressLint("Range")
    void logCursC(Cursor c, int i, List<TextView> tv, List<String> tableDB) {

        if (c != null) {
            if (c.moveToFirst()) {
                int x = 0;
                String str;
                do{


                str = c.getString(c.getColumnIndex(getColumn(tableDB, i)));

                tv.get(x).setText(str);
                x++;
                }while(c.moveToNext());
            }
        } else
            tv.get(0).setText("null");
    }

    List<String> arrayOilWellMain = new ArrayList<>();
    {
        arrayOilWellMain.add(mDBHelper.COLUMN_STARTDATA);
    }

    List<String> arrayDeepDB = new ArrayList<>();
    {
        arrayDeepDB.add(mDBHelper.COLUMN_DEEP);
    }

    List<String> arrayKvtDB = new ArrayList<>();
    {
        arrayKvtDB.add(mDBHelper.COLUMN_KVT);
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

    @Override
    public void onDestroy(){
        super.onDestroy();
        mDb.close();
//        userCursor.close();
//        userC.close();
//        userCC.close();
    }

}