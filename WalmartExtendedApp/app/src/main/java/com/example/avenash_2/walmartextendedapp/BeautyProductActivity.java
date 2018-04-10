package com.example.avenash_2.walmartextendedapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class BeautyProductActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_product);
        spinner =  findViewById(R.id.spBeauty);
        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Toast.makeText(getApplicationContext(),"Selected beauty product is : "+parent.getItemIdAtPosition(pos),Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
}
