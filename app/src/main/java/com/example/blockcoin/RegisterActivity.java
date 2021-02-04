package com.example.blockcoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//James Sigler, Aaron Pingo
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Initializing buttons and Text boxes
    Button Register;
    EditText password_get, username_get, first_name_get, last_name_get;

    //Creating a new Account from Account.java
    Account regAcc = new Account();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Setting values to visuals from XML Files
        Register = (Button) findViewById(R.id.btnRegister);
        password_get = (EditText) findViewById(R.id.password_register);
        username_get = (EditText) findViewById(R.id.username_register);
        first_name_get = (EditText) findViewById(R.id.first_name);
        last_name_get = (EditText) findViewById(R.id.last_name);
        Register.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            //If register button clicked...
            case R.id.btnRegister:

                //Get user input and set to a string variable
                String usrname = username_get.getText().toString();
                String pssword = password_get.getText().toString();
                String firstname = first_name_get.getText().toString();
                String lastname = last_name_get.getText().toString();


                //Setting user information to Account
                regAcc.setFirstName(firstname);
                regAcc.setLastName(lastname);
                regAcc.setUserName(usrname);
                regAcc.setPassword(pssword);

                //Adding account to list of accounts
                regAcc.accList.add(regAcc);

                //Going to login once registered
                goLoginActivity();
        }
    }


    //Method to go to login screen
    public void goLoginActivity()
    {
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }
}
