package com.example.blockcoin;

//James Sigler, Aaron Pingo
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.bluetooth.*;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating a bluetooth adapter
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Button find = findViewById(R.id.butSearch);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Check if the users bluetooth is on
                    if (!bluetoothAdapter.isEnabled()) {
                        //If bluetooth is not on ask to enable
                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enableBtIntent, 9);
                        return;
                    }
                }
                //If the device has no bluetooth functionality
                catch(java.lang.NullPointerException e){
                    //Display error message and do not go on
                    Toast errBT = Toast.makeText(WelcomeActivity.this, "Error: This device has no bluetooth capabilities.", Toast.LENGTH_SHORT);
                    errBT.show();
                    return;
                }

                //Go to connection list if bluetooth is enabled
                goConnectActivity();

            }
        });

        //If no bluetooth capabilities but want to go on anyway
        Button demoSkip = findViewById(R.id.buttonDemo);
        demoSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goConnectActivity();
            }
        });
    }

    //Method to go to connections screen
    public void goConnectActivity()
    {
        Intent intent = new Intent(this, ConnectActivity.class);
        this.startActivity(intent);
    }


    //Auto generated passed here
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
