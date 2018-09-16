package com.example.intenttasks;

import android.app.Activity;
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



        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPost = new Intent();
                intentPost.putExtra("email", emailEdit.getText().toString());
                intentPost.putExtra("name", nameEdit.getText().toString());
                intentPost.putExtra("number", phoneNumberEdit.getText().toString());
                setResult(RESULT_OK,intentPost);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelIntent = new Intent(Main2Activity.this,MainActivity.class);

                startActivity(cancelIntent);

            }
        });

      /*  profilePicEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePhotoIntent = new Intent(Intent.ACTION_PICK);
                changePhotoIntent.setType("image/*");
                startActivity(changePhotoIntent);
            }
        });*/

    }
}
