package com.srgiovine.zenairlines.data;

import com.srgiovine.zenairlines.model.Customer;

/**
 * Provides read and write access to the Zen Airlines database.
 */
public interface ZenSQL {

    void insertCustomerAsync(Customer customer, InsertCallback insertCallback);

    interface InsertCallback {

        void insertSuccess(long newRowId);

        void insertFailed();

    }

}
