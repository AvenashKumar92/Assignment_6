package com.example.avenash_2.walmartextendedapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail;
    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        try {
            LoginManager.getInstance().signIn(this,null);
        } catch (LoginException e) {
            e.printStackTrace();
        }

        txtEmail=findViewById(R.id.txtEmail);
        txtPass=findViewById(R.id.txtPassword);
    }




    private void resetEmailPasswordFields(){
        txtEmail.setText("");
        txtPass.setText("");
    }




    public void OnSignIn(View view) {
        UtilityClass.hideSoftKeyboard(this);
        User loginUser=new User(txtEmail.getText().toString().trim(), txtPass.getText().toString());

        try {
            LoginManager.getInstance().signIn(this,loginUser);
        } catch (LoginException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
        resetEmailPasswordFields();
    }





    public void OnCreateAccount(View view) {
        Intent intend=new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intend);
    }
}
