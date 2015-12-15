package com.srgiovine.zenairlines.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.srgiovine.zenairlines.R;

public class SeatNumberSpinner extends Spinner {

    public SeatNumberSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(context,
                R.array.seat_numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setAdapter(adapter);
    }
}
