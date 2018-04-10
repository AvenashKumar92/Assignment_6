package com.example.avenash_2.walmartextendedapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ClothActivity extends AppCompatActivity {

    ListView lstCloths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth);
        lstCloths =findViewById(R.id.lstCloths);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ClothActivity.this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.lstCloth));
        lstCloths.setAdapter(adapter);

        lstCloths.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected beauty product is : "+parent.getItemIdAtPosition(position), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
