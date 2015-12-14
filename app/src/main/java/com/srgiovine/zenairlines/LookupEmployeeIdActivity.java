package com.srgiovine.zenairlines;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Allows employees to look up their employee id.
 */
public class LookupEmployeeIdActivity extends ZenAirlinesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup_employee_id);
    }

    public void onLookupEmployeeIdButtonClicked(View view) {
        TextView messageView = (TextView) getLayoutInflater().inflate(R.layout.text_view_dialog, null, false);
        messageView.setText("Employee ID: " + "1");

        new AlertDialog.Builder(this)
                .setTitle("Success")
                .setView(messageView)
                .setIcon(android.R.drawable.ic_menu_info_details)
                .setPositiveButton("Got it!", null)
                .show();
    }

}
