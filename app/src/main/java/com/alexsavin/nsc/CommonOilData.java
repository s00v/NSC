package com.alexsavin.nsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CommonOilData extends AppCompatActivity implements View.OnClickListener {
    Button butEquipment;
    Button butMeasuring;
    Button butEvents;
    Button butPassport;
    Button butPhotos;
    TextView breadCrumbs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_oil_data);

        butEquipment = (Button) findViewById(R.id.butEquipment);
        butMeasuring = (Button) findViewById(R.id.butMeasuring);
        butEvents = (Button) findViewById(R.id.butEvents);
        butPassport = (Button) findViewById(R.id.butPassport);
        butPhotos = (Button) findViewById(R.id.butPhotos);
        breadCrumbs = (TextView) findViewById(R.id.breadCrumbs);

        butEquipment.setOnClickListener(this);
        butEvents.setOnClickListener(this);
        butMeasuring.setOnClickListener(this);
        butPassport.setOnClickListener(this);
        butPhotos.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Equipment.class);

        switch (view.getId()){
            case R.id.butEquipment:
                startActivity(intent);
                break;
            case R.id.butMeasuring:
                startActivity(intent);
                break;
            case R.id.butPassport:
                startActivity(intent);
                break;
            case R.id.butPhotos:
                startActivity(intent);
                break;
            case R.id.butEvents:
                startActivity(intent);
                break;


        }


    }



}