package com.example.intenttasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    TextView emailEdit;
    TextView nameEdit;
    TextView phoneNumberEdit;
    ImageButton profilePicEdit;
    Button confirmButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emailEdit = findViewById(R.id.emailEdit);
        nameEdit = findViewById(R.id.nameEdit);
        phoneNumberEdit = findViewById(R.id.phoneNumberEdit);
        profilePicEdit = findViewById(R.id.profilePicEdit);
        confirmButton = findViewById(R.id.confirmButton);
        cancelButton = findViewById(R.id.cancelButton);

        final String filledEmail = emailEdit.getText().toString();
        final String filledName = nameEdit.getText().toString();
        final String filledNumber = phoneNumberEdit.getText().toString();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPost = new Intent(Main2Activity.this, MainActivity.class);
                intentPost.putExtra("email", filledEmail);
                intentPost.putExtra("name", filledName);
                intentPost.putExtra("number", filledNumber);

                startActivity(intentPost);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelIntent = new Intent(Main2Activity.this,MainActivity.class);
                Toast toast = Toast.makeText(getApplicationContext(),"Cancel the edit",Toast.LENGTH_LONG);
                toast.show();
                startActivity(cancelIntent);

            }
        });

        profilePicEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePhotoIntent = new Intent(Intent.ACTION_PICK);
                changePhotoIntent.setType("image/*");
                startActivity(changePhotoIntent);
            }
        });

    }
}
