package com.srgiovine.zenairlines;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Allows passengers to create a customer account.
 */
public class CreateCustomerAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customer_account);
    }

    public void onCreateCustomerAccountButtonClicked(View view) {
        // TODO Replace with real implementation
        new AlertDialog.Builder(this)
                .setMessage("Your customer id is " + 1)
                .setPositiveButton("Got it!", null)
                .show();
    }

}
