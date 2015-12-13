package com.srgiovine.zenairlines;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.srgiovine.zenairlines.widgets.SeatClassSpinner;
import com.srgiovine.zenairlines.widgets.StateSpinner;

/**
 * Allows passengers to look up their flight information.
 */
public class LookupFlightActivity extends AppCompatActivity {

    private EditText flightNumber;
    private EditText departureCity;
    private EditText arrivalCity;
    private EditText cost;

    private StateSpinner departureState;
    private StateSpinner arrivalState;

    private SeatClassSpinner seatClass;

    private TimePicker departureTime;
    private TimePicker arrivalTime;

    private TextView vin;
    private TextView model;
    private TextView crewCapacity;
    private TextView fuelRange;
    private TextView firstClass;
    private TextView businessClass;
    private TextView economyClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup_flight);

        flightNumber = (EditText) findViewById(R.id.flight_number);
        departureCity = (EditText) findViewById(R.id.departure_city);
        arrivalCity = (EditText) findViewById(R.id.arrival_city);
        cost = (EditText) findViewById(R.id.cost);

        departureState = (StateSpinner) findViewById(R.id.departure_state);
        arrivalState = (StateSpinner) findViewById(R.id.arrival_state);

        seatClass = (SeatClassSpinner) findViewById(R.id.seat_class);

        departureTime = (TimePicker) findViewById(R.id.departure_time);
        arrivalTime = (TimePicker) findViewById(R.id.arrival_time);

        vin = (TextView) findViewById(R.id.vin);
        model = (TextView) findViewById(R.id.model);
        crewCapacity = (TextView) findViewById(R.id.crew_capacity);
        fuelRange = (TextView) findViewById(R.id.fuel_range);
        firstClass = (TextView) findViewById(R.id.first_class);
        businessClass = (TextView) findViewById(R.id.business_class);
        economyClass = (TextView) findViewById(R.id.economy_class);

        departureCity.setEnabled(false);
        arrivalCity.setEnabled(false);
        cost.setEnabled(false);

        departureState.setEnabled(false);
        arrivalState.setEnabled(false);

        seatClass.setEnabled(false);

        departureTime.setEnabled(false);
        arrivalTime.setEnabled(false);
    }

    public void onLookupFlightButtonClicked(View view) {
        departureCity.setText("Atlanta");
        arrivalCity.setText("Las Vegas");
        cost.setText("200");

        departureState.setSelection(9, true);
        arrivalState.setSelection(27, true);

        seatClass.setSelection(1, true);

        departureTime.setCurrentHour(8);
        departureTime.setCurrentMinute(0);
        arrivalTime.setCurrentHour(11);
        arrivalTime.setCurrentMinute(0);
        
        vin.setText("VIN: " + "1D3HW28K76S591323");
        model.setText("Model: " + "BOEING 757-300 (75Y)");
        crewCapacity.setText("Crew Capacity: " + "8");
        fuelRange.setText("Fuel Range: " + "3,228mi");
        firstClass.setText("First Class: " + "24");
        businessClass.setText("Business Class: " + "32");
        economyClass.setText("Economy Class: " + "178");
    }
}
