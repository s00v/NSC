package com.alexsavin.nsc;

import static com.alexsavin.nsc.DatabaseHelper.COLUMN_NUMBER;
import static com.alexsavin.nsc.DatabaseHelper.TABLE_DRIVE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.text.Layout;
import android.widget.AdapterView;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Equipment extends AppCompatActivity implements View.OnClickListener {

    ListView userList;
    ListView userListD;
    Cursor userCursor;
    Cursor userC;
    Cursor userCC;
    SimpleCursorAdapter userAdapter;
    SimpleCursorAdapter userAdapterD;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    TextView dvNameF;
    TextView dvNumF;
    TextView dvLeadF;
    TextView dvSlaveF;
    String drNumN;

    ContentValues cv1;
    Layout layoutdrive;

    Cursor c;
    String tableName;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

//        layoutdrive = findViewById(R.id.layoutdrive);
        dvNameF = findViewById(R.id.dvNameF);
        dvNumF = findViewById(R.id.dvNumF);
        dvLeadF = findViewById(R.id.dvLeadF);
        dvSlaveF = findViewById(R.id.dvSlaveF);

        dvNameF.setText("");

        mDBHelper = new DatabaseHelper(getApplicationContext());
        mDBHelper.create_db();

        userList = findViewById(R.id.list);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("_id",l);
                startActivity(intent);
            }
        });

    }


    @SuppressLint("Range")
    void logCurs(Cursor c) {
        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + " = " + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    dvNameF.setText(str);
                } while (c.moveToNext());
            }
        } else
            dvNameF.setText("null");
    }


    // Метод для получения названий колонок
    public String getColumn(int i){
        List<String> strCol = new ArrayList<>();
        strCol.add(mDBHelper.COLUMN_DRIVENAME);
        strCol.add(mDBHelper.COLUMN_DRIVENUMBER);
        strCol.add(mDBHelper.COLUMN_LEADINGPULLEY);
        strCol.add(mDBHelper.COLUMN_SLAVEPULLEY);
        return strCol.get(i);
    }

    // Получаем таблицу из базы
    public Cursor getTableDB(Cursor c, String tableName){
        c = mDb.query(tableName, null, null, null, null, null, null);
        return c;
    }

    // Достаём данные из курсора
    @SuppressLint("Range")
    void logCursC(Cursor c, int i, TextView tv) {

        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                str = c.getString(c.getColumnIndex(getColumn(i)));
                tv.setText(str);
            }
        } else
            tv.setText("null");
    }

    @SuppressLint("Range")
    @Override
    public void onResume(){
        super.onResume();
        mDb = mDBHelper.open();

//        userCursor = mDb.rawQuery("select * from " + mDBHelper.TABLE + " where " + mDBHelper.COLUMN_ID + " = 2 ", null);
//
//        String[] headers = new String[]{DatabaseHelper.COLUMN_STARTDATA, COLUMN_NUMBER};
//        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
//                userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);
//        userList.setAdapter(userAdapter);

//        userC = mDb.query(mDBHelper.TABLE_DRIVE, null, null, null, null, null, null);
//        userCC = mDb.query(null, null, null, null, null, null, null);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_DRIVE), 0, dvNameF);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_DRIVE), 1, dvNumF);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_DRIVE), 2, dvLeadF);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_DRIVE), 3, dvSlaveF);


    }

    public void add(View view){
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mDb.close();
        userCursor.close();
        userC.close();
        userCC.close();
    }




    @Override
    public void onClick(View view) {

    }
}