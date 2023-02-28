package com.shashank.platform.carrental;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RentalBuddyCars extends AppCompatActivity {

    TabItem exploreTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_buddy_cars);

        exploreTab = findViewById(R.id.explore);

        exploreTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RentalBuddyCars.this, RentalBuddyDashBoard.class);
                startActivity(intent);
            }
        });
    }
}