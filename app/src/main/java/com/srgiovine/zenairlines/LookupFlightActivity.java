package com.srgiovine.zenairlines;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Allows passengers to look up their flight information.
 */
public class LookupFlightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup_flight);
    }
}
