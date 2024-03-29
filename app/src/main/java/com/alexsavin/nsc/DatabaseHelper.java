package com.alexsavin.nsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "OilWell201.db";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 2;

    static final String TABLE = "oilWellMain";
    static final String COLUMN_ID = "_id";
    static final String COLUMN_NUMBER = "oilWellNumber";
    static final String COLUMN_STARTDATA = "startData";
    static final String COLUMN_OILFIELDID = "oilFieldID";
    static final String COLUMN_OILWELLTYPE = "oilWellType";

    static final String TABLE_DRIVE = "driveComplect";
    static final String COLUMN_DRIVENAME = "driveName";
    static final String COLUMN_DRIVENUMBER = "driveNumber";
    static final String COLUMN_LEADINGPULLEY = "LeadingPulley";
    static final String COLUMN_SLAVEPULLEY = "SlavePulley";
    static final String COLUMN_OILWELLID = "oilWellID";
    static final String COLUMN_DRIVEID = "_id";

    static final String TABLE_ENGINE = "engineComplect";
    static final String COLUMN_ENGINEID = "_id";
    static final String COLUMN_ENGINENAME = "engineName";
    static final String COLUMN_ENGNUMBER = "engineNumber";
    static final String COLUMN_TURNMIN = "turnoverMin";
    static final String COLUMN_TURNGC = "turnover50Gc";
    static final String COLUMN_OILID = "oilWellID";
    static final String COLUMN_KVT = "kWt";

    static final String TABLE_PUMP = "pumpComplect";
    static final String COLUMN_PUMPMANUFACTURER = "pumpManufacturer";
    static final String COLUMN_PUMPNAME = "pumpName";

    static final String TABLE_STATORCOMPLECT = "statorComplect";
    static final String COLUMN_ELASTOMER = "elastomer";
    static final String COLUMN_LENGTHSTATOR = "lengthStator";
    static final String COLUMN_NUMBERSTATOR = "numberStator";

    static final String TABLE_ROTOR = "rotorComplect";
    static final String COLUMN_ROTORMATERIAL = "rotorMaterial";
    static final String COLUMN_ROTORLENGTH = "rotorLength";
    static final String COLUMN_ROTORNUMBER = "rotorNumber";

    static final String TABLE_ANCHOR = "anchorComplect";
    static final String COLUMN_ANCHORNAME = "anchorName";
    static final String COLUMN_ANCHORNUMBER = "anchorNumber";
    static final String COLUMN_ANCHORMINDIAM = "minDiametr";
    static final String COLUMN_ANCHORMAXDIAM = "maxDiametr";

    static final String TABLE_RODS = "rodsComplect";
    static final String COLUMN_RODSNAME = "rodsName";
    static final String COLUMN_RODSQUANTITY = "quantity";
    static final String COLUMN_RODSNOTES = "notes";
    static final String COLUMN_RODSOILID = "oilWellID";

    static final String TABLE_RODSNAME = "rodsName";
    static final String COLUMN_RODSNAME1 = "rodsName1";
    static final String COLUMN_RODSNAME2 = "rodsName2";
    static final String COLUMN_RODSNAME3 = "rodsName3";

    static final String TABLE_RODSQUANTITY = "rodsQuantity";
    static final String COLUMN_RODSQUANTITY1 = "quantity1";
    static final String COLUMN_RODSQUANTITY2 = "quantity2";
    static final String COLUMN_RODSQUANTITY3 = "quantity3";

    static final String TABLE_RODSNOTES = "rodsNotes";
    static final String COLUMN_RODSNOTES1 = "notes1";
    static final String COLUMN_RODSNOTES2 = "notes2";
    static final String COLUMN_RODSNOTES3 = "notes3";

    static final String TABLE_DEEP = "descentOilWell";
    static final String COLUMN_DEEP = "deep";
    static final String COLUMN_NKTQUANTITY = "NKTQuantity";


    private SQLiteDatabase mDatabase;
    private final Context mContext;
    private boolean mNeedUpdate = false;

    public DatabaseHelper (Context context){
        super(context, DB_NAME, null, DB_VERSION );

        this.mContext = context;
        DB_PATH = context.getFilesDir().getPath() + DB_NAME;

    }

    void create_db(){

        File file = new File(DB_PATH);
        if(!file.exists()) {
            try(InputStream myInput = mContext.getAssets().open(DB_NAME);
            OutputStream myOutput = new FileOutputStream(DB_PATH)) {

            byte[] buffer = new byte[1024];
            int length;

                while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            }
            catch(IOException ex){
                Log.d("DatabaseHelper", ex.getMessage());

            }
        }
    }

    public SQLiteDatabase open() throws SQLException {

        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }



}