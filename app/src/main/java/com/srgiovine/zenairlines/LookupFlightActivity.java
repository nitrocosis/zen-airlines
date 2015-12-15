package com.srgiovine.zenairlines;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.srgiovine.zenairlines.data.ZenDB;
import com.srgiovine.zenairlines.model.Aircraft;
import com.srgiovine.zenairlines.model.FlightDescription;
import com.srgiovine.zenairlines.widgets.StateSpinner;

import java.util.Arrays;

/**
 * Allows passengers to look up their flight information.
 */
public class LookupFlightActivity extends ZenAirlinesActivity {

    private EditText departureCity;
    private EditText arrivalCity;

    private StateSpinner departureState;
    private StateSpinner arrivalState;

    private TimePicker departureTime;
    private TimePicker arrivalTime;

    private TextView departure;
    private TextView arrival;
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

        departureCity = (EditText) findViewById(R.id.departure_city);
        arrivalCity = (EditText) findViewById(R.id.arrival_city);

        departureState = (StateSpinner) findViewById(R.id.departure_state);
        arrivalState = (StateSpinner) findViewById(R.id.arrival_state);

        departureTime = (TimePicker) findViewById(R.id.departure_time);
        arrivalTime = (TimePicker) findViewById(R.id.arrival_time);

        departure = (TextView) findViewById(R.id.departure);
        arrival = (TextView) findViewById(R.id.arrival);
        vin = (TextView) findViewById(R.id.vin);
        model = (TextView) findViewById(R.id.model);
        crewCapacity = (TextView) findViewById(R.id.crew_capacity);
        fuelRange = (TextView) findViewById(R.id.fuel_range);
        firstClass = (TextView) findViewById(R.id.first_class);
        businessClass = (TextView) findViewById(R.id.business_class);
        economyClass = (TextView) findViewById(R.id.economy_class);

        departureCity.setEnabled(false);
        arrivalCity.setEnabled(false);

        departureState.setEnabled(false);
        arrivalState.setEnabled(false);

        departureTime.setEnabled(false);
        arrivalTime.setEnabled(false);
    }

    public void onLookupFlightButtonClicked(View view) {
        if (!validateEditTexts(R.id.flight_number)) {
            return;
        }

        final String flightNumber = getEditTextValue(R.id.flight_number, String.class);

        final ZenDB.Callback<Aircraft> selectAircraftCallback = new ZenDB.Callback<Aircraft>() {
            @Override
            public void success(Aircraft aircraft) {
                vin.setText("VIN: " + aircraft.vin);
                model.setText("Model: " + aircraft.model);
                crewCapacity.setText("Crew Capacity: " + aircraft.crewCapacity);
                fuelRange.setText("Fuel Range: " + aircraft.fuelRange);
                firstClass.setText("First Class: " + aircraft.firstClass);
                businessClass.setText("Business Class: " + aircraft.businessClass);
                economyClass.setText("Economy Class: " + aircraft.economyClass);
            }

            @Override
            public void failed() {
                Toast.makeText(LookupFlightActivity.this, "Failed to look up Aircraft information",
                        Toast.LENGTH_SHORT).show();
            }
        };

        getZenDB().selectFlightAsync(flightNumber, new ZenDB.Callback<FlightDescription>() {
            @Override
            public void success(FlightDescription flightDescription) {
                departureCity.setText(flightDescription.departureCity);
                arrivalCity.setText(flightDescription.arrivalCity);

                int departureStateIndex = Arrays.asList(getResources().getStringArray(R.array.states))
                        .indexOf(flightDescription.departureState);
                int arrivalStateIndex = Arrays.asList(getResources().getStringArray(R.array.states))
                        .indexOf(flightDescription.arrivalState);
                departureState.setSelection(departureStateIndex, true);
                arrivalState.setSelection(arrivalStateIndex, true);

                departureTime.setCurrentHour(Integer.valueOf(flightDescription.departureTime.split(":")[0]));
                departureTime.setCurrentMinute(Integer.valueOf(flightDescription.departureTime.split(":")[1]));
                arrivalTime.setCurrentHour(Integer.valueOf(flightDescription.arrivalTime.split(":")[0]));
                arrivalTime.setCurrentMinute(Integer.valueOf(flightDescription.arrivalTime.split(":")[1]));

                departure.setText(flightDescription.departure);
                arrival.setText(flightDescription.arrival);

                getZenDB().selectAircraft(flightNumber, selectAircraftCallback);
            }

            @Override
            public void failed() {
                showAlertDialog("Failed", "Failed to lookup flight information");
            }
        });
    }
}
