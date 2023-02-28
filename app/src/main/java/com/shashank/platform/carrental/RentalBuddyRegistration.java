package com.shashank.platform.carrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RentalBuddyRegistration extends AppCompatActivity {

    EditText proof;
    EditText emailEdit;
    EditText fullNameEdit;
    EditText passwordEdit;
    EditText confirmPasswordEdit;
    EditText phoneNumberEdit;
    Button register;
    String driversLicense = "";
    String phoneNumber = "";
    String fullName = "";
    String confirmPass = "";
    String password = "";
    String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_buddy_registration);

        register = findViewById(R.id.register);

        final DatabaseHelper databaseHelper = new DatabaseHelper(RentalBuddyRegistration.this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proof = findViewById(R.id.proof);
                emailEdit = findViewById(R.id.emailEditText);
                fullNameEdit = findViewById(R.id.name);
                passwordEdit = findViewById(R.id.passwordEditText);
                confirmPasswordEdit = findViewById(R.id.confirmPassword);
                phoneNumberEdit = findViewById(R.id.phoneNumber);

                RentalBuddyModel rentalBuddyModel;

                driversLicense = proof.getText().toString();
                password = passwordEdit.getText().toString();
                fullName = fullNameEdit.getText().toString();
                confirmPass = confirmPasswordEdit.getText().toString();
                phoneNumber = phoneNumberEdit.getText().toString();
                email = emailEdit.getText().toString();


                rentalBuddyModel = new RentalBuddyModel(driversLicense, email, password, confirmPass, phoneNumber, fullName);
                boolean successfullyInserted = databaseHelper.addBuddy(rentalBuddyModel);

                if(successfullyInserted)
                {

                    Toast.makeText(RentalBuddyRegistration.this, "Buddy Added Successfully " + email, Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(RentalBuddyRegistration.this, "Sorry Bud, Better Luck Next Time ", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public boolean error()
    {

        /*if(fullName.toString().length() == 0) {

            Toast.makeText(RentalBuddyRegistration.this, "Input Valid Characters", Toast.LENGTH_LONG).show();
            return false;

        }*/if(email.toString().length() == 0) {

            Toast.makeText(RentalBuddyRegistration.this, "Email Required!", Toast.LENGTH_LONG).show();
            return false;

        }/*else if(password.toString().length() == 0) {

            Toast.makeText(RentalBuddyRegistration.this, "Input Valid Characters", Toast.LENGTH_LONG).show();
            return false;

        }else if(confirmPassword.toString().length() == 0) {

            Toast.makeText(RentalBuddyRegistration.this, "Input Valid Characters", Toast.LENGTH_LONG).show();
            return false;

        }else if(phoneNumber.toString().length() == 0) {

            Toast.makeText(RentalBuddyRegistration.this, "Input Valid Characters", Toast.LENGTH_LONG).show();
            return false;

        }*/else if(driversLicense.toString().length() == 0) {

            Toast.makeText(RentalBuddyRegistration.this, "Input Valid Characters", Toast.LENGTH_LONG).show();
            return false;

        }
        return true;
    }
}
