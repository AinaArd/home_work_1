package com.example.intenttasks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView email;
    TextView name;
    TextView phoneNumber;
    ImageView profilePic;
    Button editButton;
    Button sendButton;

    private static final int REQUEST_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);

        profilePic = findViewById(R.id.profilePic);
        editButton = findViewById(R.id.buttonEdit);
        sendButton = findViewById(R.id.sendButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, 0);
            }
        });


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String send =  email.getText().toString() + name.getText().toString() + phoneNumber.getText().toString();

                Intent intentSend = new Intent(Intent.ACTION_SEND);
                intentSend.putExtra(Intent.EXTRA_TEXT, send);
                intentSend.setType("text/plain");
                startActivity(Intent.createChooser(intentSend, "Share text"));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String filledEmail = data.getStringExtra("email");
        String filledName = data.getStringExtra("name");
        String filledNumber = data.getStringExtra("number");

        email.setText(filledEmail);
        name.setText(filledName);
        phoneNumber.setText(filledNumber);

    }
}
