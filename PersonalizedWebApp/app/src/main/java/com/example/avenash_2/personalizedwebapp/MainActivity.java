package com.example.avenash_2.personalizedwebapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView wvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            LoginManager.getInstance().signIn(this, WebsitesListActivity.class, null);
        } catch (LoginException e) {
            e.printStackTrace();
        }

        wvLogin=findViewById(R.id.wvLogin);
        wvLogin.getSettings().setJavaScriptEnabled(true);
        wvLogin.loadUrl("file:///android_asset/login.html");
        wvLogin.addJavascriptInterface(this, "myinterface");
    }

    @JavascriptInterface // Annotation that allows exposing methods to JavaScript.
    public void displayMsg(String name,String pass){
        User loginUser=new User(name.trim(), pass);

        try {
            LoginManager.getInstance().signIn(this, WebsitesListActivity.class,loginUser);
        } catch (LoginException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }
}
