package com.shashank.platform.carrental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RentalBuddyLogIn extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    Button signUpButton;
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_buddy_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(error())
                {

                    Intent intent = new Intent(RentalBuddyLogIn.this, RentalBuddyDashBoard.class);
                    startActivity(intent);

                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RentalBuddyLogIn.this, RentalBuddyRegistration.class);
                startActivity(intent);
            }
        });

    }

    public boolean error()
    {

        if(emailEditText.getText().toString().length() == 0) {

            Toast.makeText(RentalBuddyLogIn.this, "Enter Your Email", Toast.LENGTH_LONG).show();
            return false;

        }else if(passwordEditText.getText().toString().length() == 0) {

            Toast.makeText(RentalBuddyLogIn.this, "Please Input Valid Number!", Toast.LENGTH_LONG).show();
            return false;

        }
        return true;
    }
}
