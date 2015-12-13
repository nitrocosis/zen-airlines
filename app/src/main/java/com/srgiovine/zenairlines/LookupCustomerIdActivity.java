package com.srgiovine.zenairlines;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Allows passengers to look up their customer id.
 */
public class LookupCustomerIdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup_customer_id);
    }

    public void onLookupCustomerIdButtonClicked(View view) {
        TextView messageView = (TextView) getLayoutInflater().inflate(R.layout.text_view_dialog, null, false);
        messageView.setText("Customer ID: " + "1");

        new AlertDialog.Builder(this)
                .setTitle("Success")
                .setView(messageView)
                .setIcon(android.R.drawable.ic_menu_info_details)
                .setPositiveButton("Got it!", null)
                .show();
    }

}
