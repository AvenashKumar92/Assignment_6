package com.example.avenash_2.walmartextendedapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity {

    TextView lblWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        lblWelcome=findViewById(R.id.lblWelcome);
        Intent intent = getIntent();
        String userEmail = intent.getStringExtra(String.valueOf(R.id.txtEmail));
        lblWelcome.setText(lblWelcome.getText()+" "+userEmail);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener listener=new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                Intent intent = null;
                if(tab.getText().equals("Beauty"))
                    intent = new Intent(getApplicationContext(),BeautyProductActivity.class);
                if(tab.getText().equals("Clothing"))
                    intent = new Intent(getApplicationContext(),ClothActivity.class);
                if(tab.getText().equals("Food"))
                    intent=new Intent(getApplicationContext(), FoodActivity.class);
                if(tab.getText().equals("Electronics"))
                    intent =new Intent(getApplicationContext(), ElectronicsActivity.class);
                if(tab.getText().equals("Logout"))
                    alert();

                if(intent!=null)
                    startActivity(intent);
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText("Beauty").setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText("Clothing").setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText("Food").setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText("Electronics").setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText("Logout").setTabListener(listener));
    }


    private void logout(){
        String preferencesName=getResources().getString(R.string.preferenceName);
        SharedPreferences sharedPreferences=getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.remove(getResources().getString(R.string.useremail));
        editor.remove(getResources().getString(R.string.password));
        editor.commit();
    }


    public void alert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert Message");
        builder.setMessage("Are you sure you want to logout from the app?");
        builder.setIcon(R.drawable.alerticon);
        AlertDialog.OnClickListener listener=new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if(which==dialog.BUTTON_POSITIVE) {
                    logout();
                    finish();
                }
            }
        };
        builder.setPositiveButton("Yes", listener);
        builder.setNegativeButton("No", listener);
        builder.show();
    }
}
