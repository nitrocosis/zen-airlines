package com.srgiovine.zenairlines;

import android.os.Bundle;
import android.view.View;

import com.srgiovine.zenairlines.data.ZenDB;
import com.srgiovine.zenairlines.model.Customer;

/**
 * Allows passengers to look up their customer id.
 */
public class LookupCustomerIdActivity extends ZenAirlinesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup_customer_id);
    }

    public void onLookupCustomerIdButtonClicked(View view) {
        if (!validateEditTexts(R.id.ssn_or_email)) {
            return;
        }

        getZenDB().selectCustomerAsync(getEditTextValue(R.id.ssn_or_email, String.class),
                new ZenDB.Callback<Customer>() {
                    @Override
                    public void success(Customer customer) {
                        showAlertDialog("Success", "Customer ID: " + customer.id);
                    }

                    @Override
                    public void failed() {
                        showAlertDialog("Failed", "Failed to lookup customer id");
                    }
                });
    }

}
