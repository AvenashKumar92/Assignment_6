package com.example.avenash_2.walmartextendedapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.*;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail;
    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initList();
        txtEmail=findViewById(R.id.txtEmail);
        txtPass=findViewById(R.id.txtPassword);
    }

    private void initList()
    {
        UserDataUtils.getInstance().addUser(new User("Avenash@yahoo.com", "123"));
        UserDataUtils.getInstance().addUser(new User("Rahul@yahoo.com", "321"));
        UserDataUtils.getInstance().addUser(new User("Rajesh@yahoo.com", "123"));
        UserDataUtils.getInstance().addUser(new User("Malik@yahoo.com", "321"));
        UserDataUtils.getInstance().addUser(new User("Osman@yahoo.com", "123"));
    }

    private void resetEmailPassword(){
        txtEmail.setText("");
        txtPass.setText("");
    }
    public void OnSignIn(View view) {
        UtilityClass.hideSoftKeyboard(this);
        User loginUser=new User(txtEmail.getText().toString().trim(), txtPass.getText().toString());
        if(!UserDataUtils.getInstance().validateUser(loginUser)) {
            Toast.makeText(getApplicationContext(), "Invalid login email or password!",
                    Toast.LENGTH_LONG).show();
            resetEmailPassword();
            return;
        }
        Intent intent = new Intent(this,ShoppingActivity.class);
        intent.putExtra(String.valueOf(R.id.txtEmail), loginUser.getEmail());
        startActivity(intent);
    }



    public void OnCreateAccount(View view) {
        UtilityClass.hideSoftKeyboard(this);
        Intent intend=new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intend);
    }
}
