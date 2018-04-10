package com.example.avenash_2.walmartextendedapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ElectronicsProductDVActivity extends AppCompatActivity {

    ImageView ivProductImg;
    TextView lblColor;
    TextView lblTitle;
    TextView lblItemNumber;
    TextView lblDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_product_dv);
        Intent intent = getIntent();
        Product product=intent.getParcelableExtra("Key");

        ivProductImg=findViewById(R.id.ivElecDtlImage);
        lblColor=findViewById(R.id.lblElecDtlColor);
        lblTitle=findViewById(R.id.lblElecDtlTitle);
        lblItemNumber=findViewById(R.id.lblElecDtlItemNum);
        lblDesc=findViewById(R.id.lblElecDtlDesc);

        ivProductImg.setImageResource(product.getItemId());
        lblColor.setText(lblColor.getText()+product.getColor());
        lblTitle.setText(product.getTitle());
        lblItemNumber.setText(lblItemNumber.getText()+String.valueOf(product.getItemId()));
        lblDesc.setText(lblDesc.getText()+product.getDescription());
    }
}
