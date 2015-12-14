package com.srgiovine.zenairlines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Provides passengers several options:
 * <p/>
 * 1. Make an account
 * 2. Book a flight
 * 3. Look up their customer id
 * 4. Look up their flight information
 */
public class PassengerOptionsActivity extends ZenAirlinesActivity {

    private static final int RC_CREATE_CUSTOMER_ACC = 101;
    private static final int RC_BOOK_FLIGHT = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }

        String message = "";

        switch (requestCode) {
            case RC_CREATE_CUSTOMER_ACC:
                if (resultCode == RESULT_FAILED) {
                    message = "Failed to create new account";
                } else {
                    long customerId = data.getLongExtra(CreateCustomerAccountActivity.RESULT_CUSTOMER_ID, -1l);
                    message = "Customer ID: " + customerId;
                }
                break;

            case RC_BOOK_FLIGHT:
                String ticketNumber = data.getStringExtra(BookFlightActivity.RESULT_TICKET_NUMBER);
                String flightNumber = data.getStringExtra(BookFlightActivity.RESULT_FLIGHT_NUMBER);
                String seatNumber = data.getStringExtra(BookFlightActivity.RESULT_SEAT_NUMBER);
                message = "\nTicket Number: " + ticketNumber + "\nFlight Number: " + flightNumber
                        + "\nSeat Number: " + seatNumber;
                break;
        }

        showAlertDialog(resultCode == RESULT_FAILED ? "Failed" : "Success", message);
    }

    public void onCreateAccountButtonClicked(View view) {
        startActivityForResult(new Intent(this, CreateCustomerAccountActivity.class), RC_CREATE_CUSTOMER_ACC);
    }

    public void onBookFlightButtonClicked(View view) {
        startActivityForResult(new Intent(this, BookFlightActivity.class), RC_BOOK_FLIGHT);
    }

    public void onLookupCustomerIdButtonClicked(View view) {
        startActivity(new Intent(this, LookupCustomerIdActivity.class));
    }

    public void onLookupFlightButtonClicked(View view) {
        startActivity(new Intent(this, LookupFlightActivity.class));
    }

}
