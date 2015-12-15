package com.srgiovine.zenairlines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.srgiovine.zenairlines.data.ZenDB;
import com.srgiovine.zenairlines.model.Billing;
import com.srgiovine.zenairlines.model.Customer;
import com.srgiovine.zenairlines.model.FlightDescription;
import com.srgiovine.zenairlines.model.Seating;

/**
 * Allows passengers to book a flight.
 */
public class BookFlightActivity extends ZenAirlinesActivity {

    public static final String RESULT_TICKET_NUMBER = "ticket_number";
    public static final String RESULT_FLIGHT_NUMBER = "flight_number";

    private long flightNumber;
    private long customerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_flight);

        ((Spinner) findViewById(R.id.seat_number)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSeatInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void onBookFlightButtonClicked(View view) {
        if (!validateEditTexts(R.id.ssn_or_email, R.id.departure_city, R.id.arrival_city)) {
            return;
        }

        final ZenDB.Callback<Billing> bookFlightCallback = new ZenDB.Callback<Billing>() {
            @Override
            public void success(Billing billing) {
                Intent data = new Intent();
                data.putExtra(RESULT_TICKET_NUMBER, billing.ticketNumber);
                data.putExtra(RESULT_FLIGHT_NUMBER, billing.flightNumber);
                setResult(RESULT_OK, data);
                finish();
            }

            @Override
            public void failed() {
                showAlertDialog("Failed", "Failed to book flight. Please contact our customer support.");
            }
        };

        final ZenDB.Callback<Long> insertSeatingCallback = new ZenDB.Callback<Long>() {
            @Override
            public void success(Long item) {
                getZenDB().bookFlightAsync(flightNumber, customerId, bookFlightCallback);
            }

            @Override
            public void failed() {
                showAlertDialog("Failed", "Failed to reserve seat. The seat may have already been reserved by someone else.");
            }
        };

        final ZenDB.Callback<FlightDescription> selectFlightCallback = new ZenDB.Callback<FlightDescription>() {
            @Override
            public void success(FlightDescription flightDescription) {
                flightNumber = flightDescription.flightNumber;
                getZenDB().insertSeatingAsync(getSeatingFromViews(), insertSeatingCallback);
            }

            @Override
            public void failed() {
                showAlertDialog("Failed", "Flight not found!");
            }
        };

        getZenDB().selectCustomerAsync(getEditTextValue(R.id.ssn_or_email, String.class), new ZenDB.Callback<Customer>() {
            @Override
            public void success(Customer customer) {
                customerId = customer.id;
                getZenDB().selectFlightAsync(
                        getEditTextValue(R.id.departure_city, String.class),
                        getSpinnerValue(R.id.departure_state, String.class),
                        getTimePickerValue(R.id.departure_time),
                        getEditTextValue(R.id.arrival_city, String.class),
                        getSpinnerValue(R.id.arrival_state, String.class),
                        getTimePickerValue(R.id.arrival_time),
                        selectFlightCallback
                );
            }

            @Override
            public void failed() {
                showAlertDialog("Failed", "Customer ssn or email not recognized");
            }
        });

    }

    private void updateSeatInfo() {
        int selectedSeatNumber = ((Spinner) findViewById(R.id.seat_number)).getSelectedItemPosition();
        ((TextView) findViewById(R.id.seat_class)).setText(getResources().getStringArray(R.array.seat_class)[selectedSeatNumber]);
        ((TextView) findViewById(R.id.seat_cost)).setText(String.valueOf(getResources().getIntArray(R.array.seat_cost)[selectedSeatNumber]));
    }

    private Seating getSeatingFromViews() {
        int selectedSeatNumber = ((Spinner) findViewById(R.id.seat_number)).getSelectedItemPosition();
        return new Seating.Builder()
                .setCustomerId(customerId)
                .setFlightNumber(flightNumber)
                .setSeatNumber(getSpinnerValue(R.id.seat_number, String.class))
                .setSeatClass(getResources().getStringArray(R.array.seat_class)[selectedSeatNumber])
                .setCost((long) getResources().getIntArray(R.array.seat_cost)[selectedSeatNumber])
                .createSeating();
    }

}
