package com.srgiovine.zenairlines.data;

import android.content.ContentValues;

import com.srgiovine.zenairlines.model.Customer;

/**
 * Provides {@link ContentValues} for model objects.
 */
public final class ZenSQLContentValues {

    public static ContentValues getCustomerContentValues(Customer customer) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ZenSQLContract.Customer.FIRST_NAME, customer.firstName);
        contentValues.put(ZenSQLContract.Customer.LAST_NAME, customer.lastName);
        contentValues.put(ZenSQLContract.Customer.SSN, customer.ssn);
        contentValues.put(ZenSQLContract.Customer.PHONE_NUMBER, customer.phoneNumber);
        contentValues.put(ZenSQLContract.Customer.EMAIL, customer.email);
        contentValues.put(ZenSQLContract.Customer.ADDRESS, customer.address);
        contentValues.put(ZenSQLContract.Customer.CITY, customer.city);
        contentValues.put(ZenSQLContract.Customer.STATE, customer.state);
        contentValues.put(ZenSQLContract.Customer.ZIP, customer.zip);
        return contentValues;
    }

}
