package com.srgiovine.zenairlines;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
        if (resultCode != RESULT_OK) {
            return;
        }

        String message = "";

        switch (requestCode) {
            case RC_CREATE_CUSTOMER_ACC:
                String customerId = data.getStringExtra(CreateCustomerAccountActivity.RESULT_CUSTOMER_ID);
                message = "Customer ID: " + customerId;
                break;

            case RC_BOOK_FLIGHT:
                String ticketNumber = data.getStringExtra(BookFlightActivity.RESULT_TICKET_NUMBER);
                String flightNumber = data.getStringExtra(BookFlightActivity.RESULT_FLIGHT_NUMBER);
                String seatNumber = data.getStringExtra(BookFlightActivity.RESULT_SEAT_NUMBER);
                message = "\nTicket Number: " + ticketNumber + "\nFlight Number: " + flightNumber
                        + "\nSeat Number: " + seatNumber;
                break;
        }

        TextView messageView = (TextView) getLayoutInflater().inflate(R.layout.text_view_dialog, null, false);
        messageView.setText(message);

        new AlertDialog.Builder(this)
                .setTitle("Success")
                .setIcon(android.R.drawable.ic_menu_info_details)
                .setView(messageView)
                .setPositiveButton("Got it!", null)
                .show();
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
