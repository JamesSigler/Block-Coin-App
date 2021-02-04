package com.example.blockcoin;

//James Sigler, Aaron Pingo
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //Initializing Buttons and Editable Text boxes.
    Button Register, login;
    EditText username, password;

    //Initializing Account function
    Account getAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Setting the buttons to buttons in XML files
        Register = (Button) findViewById(R.id.btnNewUser_login);
        login = (Button) findViewById(R.id.btnLogin);

        //Setting listener to check if clicked
        login.setOnClickListener(this);
        Register.setOnClickListener(this);
    }
    protected void onStart(){
        super.onStart();
    }


    public void onClick(View v){

        //Getting Text Boxes from XML Files
        username = (EditText) findViewById(R.id.username_login);
        password = (EditText) findViewById(R.id.password_login);


        //When clicking on login button

        //Find text inputted into Username and Password boxes
        String uName = username.getText().toString().intern();
        String Pass = password.getText().toString().intern();

        //Creating a message for invalid credentials
        Toast invLog = Toast.makeText(this, "Username or Password invalid please re-enter information.", Toast.LENGTH_SHORT);

        switch(v.getId()){
            case R.id.btnLogin:
                //Setting the default Manager login data
                if(uName.equals("Manager"))
                {
                    if(Pass.equals("123"))
                    {
                        goWelcomeActivity();
                    }
                }
                else {
                    //If not manager...
                    try {
                        //Check for username in List of accounts
                        for (int i = 0; i < getAcc.accList.size(); i++) {
                            Account checkAcc = getAcc.accList.get(i);
                            //If username is found
                            if (uName.equals(checkAcc.getUserName()) == true) {
                                //If password matches the username
                                if (Pass.equals(checkAcc.getPassword())) {
                                    //continue to next page
                                    goWelcomeActivity();
                                }
                            //Iterating through list of usernames
                            } else if (uName.equals(checkAcc.getUserName()) == false) {
                                continue;
                            //If username not found or password does not match, show error
                            } else {
                                invLog.show();
                            }
                        }

                        //If list of user information is empty, show error
                    } catch (NullPointerException e) {
                        invLog.show();
                    }
                }
                break;
            case R.id.btnNewUser_login:
                //If user wants to make an account
                goRegisterActivity();
                break;
        }
    }


    //Going to the next page
    public void goWelcomeActivity(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    //Going to the registration page
    public void goRegisterActivity()
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
