package com.srgiovine.zenairlines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Allows passengers to book a flight.
 */
public class BookFlightActivity extends AppCompatActivity {

    public static final String RESULT_TICKET_NUMBER = "ticket_number";
    public static final String RESULT_FLIGHT_NUMBER = "flight_number";
    public static final String RESULT_SEAT_NUMBER = "seat_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_flight);
    }

    public void onBookFlightButtonClicked(View view) {
        Intent data = new Intent();
        data.putExtra(RESULT_TICKET_NUMBER, "2017");
        data.putExtra(RESULT_FLIGHT_NUMBER, "20A");
        data.putExtra(RESULT_SEAT_NUMBER, "1010");
        setResult(RESULT_OK, data);
        finish();
    }

}
