package com.shashank.platform.carrental;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RentalBuddyDashBoard extends AppCompatActivity {

    TabItem carsTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_buddy_dashboard);

        carsTab = findViewById(R.id.cars);

        carsTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RentalBuddyDashBoard.this, RentalBuddyCars.class);
                startActivity(intent);
            }
        });
    }
}