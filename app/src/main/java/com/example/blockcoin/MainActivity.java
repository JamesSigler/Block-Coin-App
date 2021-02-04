package com.example.blockcoin;

//James Sigler, Aaron Pingo
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Setting the login button from XML File
        Button btnLogin = (Button)(findViewById(R.id.btnLog_in_Screen));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If clicked go to login page
                openLoginActivity();
            }
        });

        //Setting register button from XML File
        Button btnNewUser = (Button) (findViewById(R.id.btnRegister_screen));
        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If clicked go to registration page
                openRegisterActivity();
            }
        });


    }

    //Method to go to login screen
    public void openLoginActivity( )
    {
        Intent strtlogin = new Intent(this, LoginActivity.class);
        startActivity(strtlogin);


    }

    //Method to go to register screen
    public void openRegisterActivity( )
    {
        Intent strtregister = new Intent(this, RegisterActivity.class);
        startActivity(strtregister);


    }


    //Auto Generated passed here...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
