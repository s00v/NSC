package com.alexsavin.nsc;

import static com.alexsavin.nsc.DatabaseHelper.COLUMN_NUMBER;
import static com.alexsavin.nsc.DatabaseHelper.TABLE_DRIVE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.text.Layout;
import android.view.KeyEvent;
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


    TextView eqBreadcrumbs;
    int oilWellNum;
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
    TextView сvCurrDriveD, cvCurrDrNumD, cvTurnD, cvTurn50D;
    String drNumN;

    TextView tvDateStartE, tvDeepE;
    TextView tvPumpE, tvPumpManufE;
    TextView tvElaqq11, tvElaqq12, tvElaqq13;
    TextView tvRotorMaterialE, tvRotorLengthE, tvRotorNumberE;
    TextView tvAnkerE, tvAnkerNumberE, tvAnkerMinDE, tvAnkerMaxDE;
    TextView tvRodsNameE1, tvRodsNameE2, tvRodsNameE3;
    TextView tvRodsQuantityE1, tvRodsQuantityE2, tvRodsQuantityE3;
    TextView tvRodsNoteE1, tvRodsNoteE2, tvRodsNoteE3;




    ContentValues cv1;
    int idOilN;

    Cursor c;
    String tableName;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        eqBreadcrumbs = findViewById(R.id.eqBreadcrumbs);

        eqBreadcrumbs.setText("oilWellNum");
        Intent intent = getIntent();

        String oilWellNum = intent.getStringExtra("name");
        String idOil = intent.getStringExtra("id");


        eqBreadcrumbs.setText(oilWellNum);
        idOilN = Integer.parseInt(idOil);
//        idOilN = 5;

        tvDateStartE = findViewById(R.id.tvDateStartE);

        dvNameF = findViewById(R.id.dvNameF);
        dvNumF = findViewById(R.id.dvNumF);
        dvLeadF = findViewById(R.id.dvLeadF);
        dvSlaveF = findViewById(R.id.dvSlaveF);

        сvCurrDriveD = findViewById(R.id.сvCurrDriveD);
        cvCurrDrNumD = findViewById(R.id.cvCurrDrNumD);
        cvTurnD = findViewById(R.id.cvTurnD);
        cvTurn50D = findViewById(R.id.cvTurn50D);

        tvPumpE = findViewById(R.id.tvPumpE);
        tvPumpManufE = findViewById(R.id.tvPumpManufE);

        tvElaqq11 = findViewById(R.id.tvElaqq11);
        tvElaqq12 = findViewById(R.id.tvElaqq12);
        tvElaqq13 = findViewById(R.id.tvElaqq13);

        tvRotorMaterialE = findViewById(R.id.tvRotorMaterialE);
        tvRotorLengthE = findViewById(R.id.tvRotorLengthE);
        tvRotorNumberE = findViewById(R.id.tvRotorNumberE);

        tvAnkerE = findViewById(R.id.tvAnkerE);
        tvAnkerNumberE = findViewById(R.id.tvAnkerNumberE);
        tvAnkerMinDE = findViewById(R.id.tvAnkerMinDE);
        tvAnkerMaxDE = findViewById(R.id.tvAnkerMaxDE);

        tvRodsNameE1 = findViewById(R.id.tvRodsNameE1);
        tvRodsNameE2 = findViewById(R.id.tvRodsNameE2);
        tvRodsNameE3 = findViewById(R.id.tvRodsNameE3);

        tvRodsQuantityE1 = findViewById(R.id.tvRodsQuantityE1);
        tvRodsQuantityE2 = findViewById(R.id.tvRodsQuantityE2);
        tvRodsQuantityE3 = findViewById(R.id.tvRodsQuantityE3);

        tvRodsNoteE1 = findViewById(R.id.tvRodsNoteE1);
        tvRodsNoteE2 = findViewById(R.id.tvRodsNoteE2);
        tvRodsNoteE3 = findViewById(R.id.tvRodsNoteE3);

        tvDeepE = findViewById(R.id.tvDeepE);

        dvNameF.setText("");

        mDBHelper = new DatabaseHelper(getApplicationContext());
        mDBHelper.create_db();

//        userList = findViewById(R.id.list);
//        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
//                intent.putExtra("_id",l);
//                startActivity(intent);
//            }
//        });

    }


//    @SuppressLint("Range")
//    void logCurs(Cursor c) {
//        if (c != null) {
//            if (c.moveToFirst()) {
//                String str;
//                do {
//                    str = "";
//                    for (String cn : c.getColumnNames()) {
//                        str = str.concat(cn + " = " + c.getString(c.getColumnIndex(cn)) + "; ");
//                    }
//                    dvNameF.setText(str);
//                } while (c.moveToNext());
//            }
//        } else
//            dvNameF.setText("null");
//    }


    List<String> tableDataEngine = new ArrayList<>();
    {
        tableDataEngine.add(mDBHelper.COLUMN_ENGINENAME);
        tableDataEngine.add(mDBHelper.COLUMN_ENGNUMBER);
        tableDataEngine.add(mDBHelper.COLUMN_TURNMIN);
        tableDataEngine.add(mDBHelper.COLUMN_TURNGC);
    }

    List<String> tableDrive = new ArrayList<>();
    {
        tableDrive.add(mDBHelper.COLUMN_DRIVENAME);
        tableDrive.add(mDBHelper.COLUMN_DRIVENUMBER);
        tableDrive.add(mDBHelper.COLUMN_LEADINGPULLEY);
        tableDrive.add(mDBHelper.COLUMN_SLAVEPULLEY);
    }

    List<String> arrayTablePump = new ArrayList<>();
    {
        arrayTablePump.add(mDBHelper.COLUMN_PUMPMANUFACTURER);
        arrayTablePump.add(mDBHelper.COLUMN_PUMPNAME);

    }

    List<String> arrayTableStator = new ArrayList<>();
    {
        arrayTableStator.add(mDBHelper.COLUMN_ELASTOMER);
        arrayTableStator.add(mDBHelper.COLUMN_LENGTHSTATOR);
        arrayTableStator.add(mDBHelper.COLUMN_NUMBERSTATOR);
    }

    List<String> arrayTableRotor = new ArrayList<>();
    {
        arrayTableRotor.add(mDBHelper.COLUMN_ROTORMATERIAL);
        arrayTableRotor.add(mDBHelper.COLUMN_ROTORLENGTH);
        arrayTableRotor.add(mDBHelper.COLUMN_ROTORNUMBER);
    }

    List<String> arrayTableAnchor = new ArrayList<>();
    {
        arrayTableAnchor.add(mDBHelper.COLUMN_ANCHORNAME);
        arrayTableAnchor.add(mDBHelper.COLUMN_ANCHORNUMBER);
        arrayTableAnchor.add(mDBHelper.COLUMN_ANCHORMINDIAM);
        arrayTableAnchor.add(mDBHelper.COLUMN_ANCHORMAXDIAM);
    }

    List<String> arrayTableRodsName = new ArrayList<>();
    {
        arrayTableRodsName.add(mDBHelper.COLUMN_RODSNAME1);
        arrayTableRodsName.add(mDBHelper.COLUMN_RODSNAME2);
        arrayTableRodsName.add(mDBHelper.COLUMN_RODSNAME3);
    }

    List<String> arrayTableRodsQuantity = new ArrayList<>();
    {
        arrayTableRodsQuantity.add(mDBHelper.COLUMN_RODSQUANTITY1);
        arrayTableRodsQuantity.add(mDBHelper.COLUMN_RODSQUANTITY2);
        arrayTableRodsQuantity.add(mDBHelper.COLUMN_RODSQUANTITY3);
    }

    List<String> arrayTableRodsNotes = new ArrayList<>();
    {
        arrayTableRodsNotes.add(mDBHelper.COLUMN_RODSNOTES1);
        arrayTableRodsNotes.add(mDBHelper.COLUMN_RODSNOTES2);
        arrayTableRodsNotes.add(mDBHelper.COLUMN_RODSNOTES3);
    }

    List<String> arrayOilWellMain = new ArrayList<>();
    {
        arrayOilWellMain.add(mDBHelper.COLUMN_STARTDATA);

    }

    List<String> arrayTableDeep = new ArrayList<>();
    {
        arrayTableDeep.add(mDBHelper.COLUMN_DEEP);
        arrayTableDeep.add(mDBHelper.COLUMN_NKTQUANTITY);

    }

    // Метод для получения названий колонок
    public String getColumn(List<String> strCol, int i){
        return strCol.get(i);
    }

    // Получаем таблицу из базы
    public Cursor getTableDB(Cursor c, String tableName){
        c = mDb.query(tableName, null, null, null, null, null, null);
        return c;
    }

    // Достаём данные из курсора
    @SuppressLint("Range")
    void logCursC(Cursor c, int i, TextView tv, List<String> tableDB) {

        if (c != null) {
            if (c.moveToPosition(idOilN)) {
                String str;
                str = c.getString(c.getColumnIndex(getColumn(tableDB, i)));
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

        logCursC(getTableDB(userCC, mDBHelper.TABLE_DRIVE), 0, dvNameF, tableDrive);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_DRIVE), 1, dvNumF, tableDrive);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_DRIVE), 2, dvLeadF, tableDrive);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_DRIVE), 3, dvSlaveF, tableDrive);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_ENGINE), 0, сvCurrDriveD, tableDataEngine);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ENGINE), 1, cvCurrDrNumD, tableDataEngine);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ENGINE), 2, cvTurnD, tableDataEngine);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ENGINE), 3, cvTurn50D, tableDataEngine);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_PUMP), 1, tvPumpE, arrayTablePump);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_PUMP), 0, tvPumpManufE, arrayTablePump);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_STATORCOMPLECT), 0, tvElaqq11, arrayTableStator);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_STATORCOMPLECT), 1, tvElaqq12, arrayTableStator);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_STATORCOMPLECT), 2, tvElaqq13, arrayTableStator);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_ROTOR), 0, tvRotorMaterialE, arrayTableRotor);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ROTOR), 1, tvRotorLengthE, arrayTableRotor);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ROTOR), 2, tvRotorNumberE, arrayTableRotor);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_ANCHOR), 0, tvAnkerE, arrayTableAnchor);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ANCHOR), 1, tvAnkerNumberE, arrayTableAnchor);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ANCHOR), 2, tvAnkerMinDE, arrayTableAnchor);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_ANCHOR), 3, tvAnkerMaxDE, arrayTableAnchor);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSNAME), 0, tvRodsNameE1, arrayTableRodsName);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSNAME), 1, tvRodsNameE2, arrayTableRodsName);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSNAME), 2, tvRodsNameE3, arrayTableRodsName);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSQUANTITY), 0, tvRodsQuantityE1, arrayTableRodsQuantity);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSQUANTITY), 1, tvRodsQuantityE2, arrayTableRodsQuantity);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSQUANTITY), 2, tvRodsQuantityE3, arrayTableRodsQuantity);

        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSNOTES), 0, tvRodsNoteE1, arrayTableRodsNotes);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSNOTES), 1, tvRodsNoteE2, arrayTableRodsNotes);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_RODSNOTES), 2, tvRodsNoteE3, arrayTableRodsNotes);

        logCursC(getTableDB(userCC, mDBHelper.TABLE), 0, tvDateStartE, arrayOilWellMain);
        logCursC(getTableDB(userCC, mDBHelper.TABLE_DEEP), 0, tvDeepE, arrayTableDeep);

    }

    public void add(View view){
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mDb.close();
//        userCursor.close();
//        userC.close();
//        userCC.close();
    }




    @Override
    public void onClick(View view) {

    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//        //вебвью наверное всё же стоит объявить в классе в не ка локальную переменную
////        MainActivity.goBack();
//    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            onBackPressed();
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    public void onBackPressed() {
//        Intent myIntent;
//        myIntent = new Intent( this, MainActivity.class);
//
//        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(myIntent);
//        finish();
//        return;
//    }

}