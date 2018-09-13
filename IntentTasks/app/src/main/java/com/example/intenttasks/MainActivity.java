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
    Button googleButton;

    private static final int REQUEST_ID_URI = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profilePic = findViewById(R.id.profilePic);
        editButton = findViewById(R.id.buttonEdit);
        googleButton = findViewById(R.id.googleButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                String filledEmail = getIntent().getStringExtra("email");
                String filledName = getIntent().getStringExtra("name");
                String filledNumber = getIntent().getStringExtra("number");
                if (filledEmail != null && filledName != null && filledNumber != null) {
                    email = findViewById(R.id.email);
                    name = findViewById(R.id.name);
                    phoneNumber = findViewById(R.id.phoneNumber);
                    email.setText(filledEmail);
                    name.setText(filledName);
                    phoneNumber.setText(filledNumber);
                }
                startActivity(intent);
            }
        });

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://google.com";
                Intent intentGoogle = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivityForResult(intentGoogle,REQUEST_ID_URI);
            }
        });

    }
}
