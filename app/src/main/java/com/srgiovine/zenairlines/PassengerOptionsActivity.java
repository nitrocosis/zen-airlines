package com.srgiovine.zenairlines;

import android.app.AlertDialog;
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

    private static final int RC_CREATE_CUSTOMER_ACC = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (RC_CREATE_CUSTOMER_ACC == requestCode
                && RESULT_OK == resultCode) {
            String customerId = data.getStringExtra(CreateCustomerAccountActivity.RESULT_CUSTOMER_ID);
            new AlertDialog.Builder(this)
                    .setMessage("Your customer id is " + customerId)
                    .setPositiveButton("Got it!", null)
                    .show();
        }
    }

    public void onCreateAccountButtonClicked(View view) {
        startActivityForResult(new Intent(this, CreateCustomerAccountActivity.class), RC_CREATE_CUSTOMER_ACC);
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
