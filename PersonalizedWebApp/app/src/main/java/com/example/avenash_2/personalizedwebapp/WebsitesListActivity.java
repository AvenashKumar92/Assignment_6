package com.example.avenash_2.personalizedwebapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class WebsitesListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lvWebsiteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites_list);
        lvWebsiteList=findViewById(R.id.lvWebsitesList);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        final String tabPersonalSite=getResources().getString(R.string.tabPersonalSite);
        final String tabSoftware=getResources().getString(R.string.tabSoftware);
        final String tabFood=getResources().getString(R.string.tabFood);
        final String tabLogout=getResources().getString(R.string.tabLogout);

        ActionBar.TabListener listener=new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                Intent intent = null;
                if(tab.getText().equals(tabPersonalSite))
                   displayPersonalSites();
                if(tab.getText().equals(tabSoftware))
                    displaySoftwares();
                if(tab.getText().equals(tabFood))
                    displayFood();
                if(tab.getText().equals(tabLogout))
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

        actionBar.addTab(actionBar.newTab().setText(tabPersonalSite).setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText(tabSoftware).setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText(tabFood).setTabListener(listener));
        actionBar.addTab(actionBar.newTab().setText(tabLogout).setTabListener(listener));
    }


    private void displayPersonalSites(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.lstPersonalSites));
        lvWebsiteList.setAdapter(adapter);
        lvWebsiteList.setOnItemClickListener(this);
    }

    private void displayFood(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.lstFood));
        lvWebsiteList.setAdapter(adapter);
        lvWebsiteList.setOnItemClickListener(this);
    }

    private void displaySoftwares(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.lstSoftwares));
        lvWebsiteList.setAdapter(adapter);
        lvWebsiteList.setOnItemClickListener(this);
    }



    private void alert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert Message");
        builder.setMessage("Are you sure you want to logout from the app?");
        builder.setIcon(R.drawable.alerticon);
        AlertDialog.OnClickListener listener=new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if(which==dialog.BUTTON_POSITIVE) {
                    LoginManager.getInstance().logout(getApplicationContext());
                    finish();
                }
            }
        };
        builder.setPositiveButton("Yes", listener);
        builder.setNegativeButton("No", listener);
        builder.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String webUrl=parent.getItemAtPosition(position).toString();
        Intent intent=new Intent(this, WebviewActivity.class);
        intent.putExtra(getResources().getString(R.string.keyWebUrl), webUrl);
        Toast.makeText(getApplicationContext(), webUrl, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
