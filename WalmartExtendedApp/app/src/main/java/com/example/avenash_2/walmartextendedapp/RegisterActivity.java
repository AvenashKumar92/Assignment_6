package com.example.avenash_2.walmartextendedapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtFirstName;
    private EditText txtLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmail=findViewById(R.id.txtSignUpEmailAddress);
        txtPassword=findViewById(R.id.txtSignUpPassword);
        txtFirstName=findViewById(R.id.txtFirstName);
        txtLastName=findViewById(R.id.txtLastName);
    }

    public void OnSignUpCreateAccount(View view) {
        UtilityClass.hideSoftKeyboard(this);

        User user=new User(txtFirstName.getText().toString().trim(),
                txtLastName.getText().toString().trim(),
                txtEmail.getText().toString().trim(),
                txtPassword.getText().toString().trim());

        if(user.getEmail().isEmpty() ||
            user.getPassword().isEmpty() ||
            user.getFisrtName().isEmpty() ||
            user.getLastName().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fields must be non empty", Toast.LENGTH_LONG).show();
            return;
        }

        UserDataUtils.getInstance().addUser(user);
        resetFields();
    }

    private void resetFields(){
        txtEmail.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPassword.setText("");
    }
}
