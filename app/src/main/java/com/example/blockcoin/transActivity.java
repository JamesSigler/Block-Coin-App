package com.example.blockcoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.util.Log;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

//James Sigler, Aaron Pingo
public class transActivity extends AppCompatActivity {

    //Setting a tag for output text
    private static final String TAG = "transActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final CheckBox transCheck = findViewById(R.id.checkBox);
        Button find = findViewById(R.id.transferButton);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Finding text boxes from XML Files
                EditText balText = findViewById(R.id.dispBal);
                EditText transAmount = findViewById(R.id.takeTrans);

                //Parsing float numbers from user input
                float bal = Float.parseFloat(balText.getText().toString());
                float tranInput = Float.parseFloat(transAmount.getText().toString());

                //Checking if user input is greater than balance
                if(bal > tranInput)
                {
                    //Checking for Check Box confirmation.
                    if(transCheck.isChecked())
                    {
                        //Asking the user if they want to continue doing transactions
                        customDialog("Transaction Complete" ,"Would you like to make another transaction?", "cancelMethod1","okMethod1");
                    }
                }
                else
                {
                    //Creating error if not enough funds
                    customDialog("Insufficient funds", "Would you like to re-attempt transaction?", "cancelTrans", "reAttempt");
                }
            }
        });
    }

    private void cancelMethod1(){
        Log.d(TAG, "cancelMethod1: Called.");
        toastMessage("Moving to menu.");
    }
    private void cancelTrans(){
        Log.d(TAG, "cancelMethod1: Called.");
        toastMessage("Moving to menu.");
    }
    private void okMethod1() {
        Log.d(TAG, "okMethod1: Called.");
        toastMessage("Searching for users.");
    }
    private void reAttempt() {
        Log.d(TAG, "okMethod1: Called.");
        toastMessage("Searching for users.");
    }

    //Creating dialog box method to display messages
    public void customDialog(String title, String message, final String cancelMethod, final String okMethod)
    {
            final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
            builderSingle.setTitle(title);
            builderSingle.setMessage(message);


            //Checking  if user gives a "No" to dialog box
            builderSingle.setNegativeButton(
                    "Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d(TAG, "onClick: Cancel Called.");
                            //for new transaction
                            if (cancelMethod.equals("cancelMethod1")) {
                                cancelMethod1();
                                goWelcomeActivity();
                            }
                            //for invalid transaction
                            if (cancelMethod.equals("cancelTrans")) {
                                cancelTrans();
                                goWelcomeActivity();
                            }
                        }
                    });

        //Checking for a "Yes" input in dialog boxes
        builderSingle.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick: OK Called.");
                        //for new transaction
                        if(okMethod.equals("okMethod1")){
                            okMethod1();
                            goConnectActivity();
                        }
                        //for invalid transaction
                        if(okMethod.equals("reAttempt")){
                            reAttempt();
                            return;
                        }
                    }
                });
        //show the dialog box
        builderSingle.show();
    }

    //Outputting messages
    public void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    //Method for going back if user does not want to continue
    public void goWelcomeActivity(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    //Method for searching for partner if user does want to continue
    public void goConnectActivity(){
        Intent intent = new Intent(this, ConnectActivity.class);
        startActivity(intent);
    }

}
