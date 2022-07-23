package com.alexsavin.nsc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainButtons extends DatabaseHelper implements View.OnClickListener {

//    Context ct = new MainActivity();
    Context ct;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;

    LinearLayout LinearDin;
    LinearLayout linearOne;

//    setContentView(R.layout.activity_main);
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

//    void multiButtons(Cursor c){
//        if(c.moveToFirst()) {
//            do {
//
//                createButtonTest();
//
//            }
//            while (c.moveToNext());
//        }
//    }



    @SuppressLint({"Range", "ResourceAsColor"})
    void createButton(Cursor c){

        String str = "";
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                matchParent, 200);
        Button btnNew = new Button(ct);
        btnNew.setPadding(5, 5, 5, 5);

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

        linearOne.setPadding(30,10,10,30);
        linearOne.addView(btnNew, lParams);

        lParams.gravity = Gravity.CENTER_HORIZONTAL;

    }

    void createButtonTest(){

        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                wrapContent, wrapContent);
        Button btnNew = new Button(ct);
        btnNew.setPadding(5, 5, 5, 5);

        btnNew.setHeight(60);
        btnNew.setWidth(180);
        btnNew.setTextSize(60);
        btnNew.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

        btnNew.setOnClickListener(this);

        linearOne.setPadding(30,10,10,30);
        linearOne.addView(btnNew, lParams);

        lParams.gravity = Gravity.CENTER_HORIZONTAL;

    }

    public MainButtons(Context context) {
        super(context);
    }

    @Override
    public void onClick(View view) {

    }
}
