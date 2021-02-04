package com.example.blockcoin;

//James Sigler, Aaron Pingo
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Finding the button for the user
        Button find = findViewById(R.id.connectDemo);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                //If button is clicked go to the transaction screen
                goTransActivity();

            }
        });
    }

    //Method to go to the transaction screen
    public void goTransActivity()
    {
        Intent intent = new Intent(this, transActivity.class);
        this.startActivity(intent);
    }
}
