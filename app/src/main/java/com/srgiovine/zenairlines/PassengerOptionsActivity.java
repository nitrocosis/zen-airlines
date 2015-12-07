package com.srgiovine.zenairlines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Provides passengers several options:
 * <p/>
 * 1. Make an account
 * 2. Book a flight
 * 3. Look up their customer id
 * 4. Look up their flight information
 */
public class PassengerOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onCreateAccountButtonClicked(View view) {
        startActivity(new Intent(this, CreateCustomerAccountActivity.class));
    }

    public void onBookFlightButtonClicked(View view) {
        startActivity(new Intent(this, BookFlightActivity.class));
    }

    public void onLookupCustomerIdButtonClicked(View view) {
        startActivity(new Intent(this, LookupCustomerIdActivity.class));
    }

    public void onLookupFlightButtonClicked(View view) {
        startActivity(new Intent(this, LookupFlightActivity.class));
    }

}
