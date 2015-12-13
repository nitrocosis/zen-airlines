package com.srgiovine.zenairlines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Allows passengers to create a customer account.
 */
public class CreateCustomerAccountActivity extends AppCompatActivity {

    public static final String RESULT_CUSTOMER_ID = "customer_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customer_account);
    }

    public void onCreateCustomerAccountButtonClicked(View view) {
        Intent data = new Intent();
        data.putExtra(RESULT_CUSTOMER_ID, "1");
        setResult(RESULT_OK, data);
        finish();
    }

}
