package com.srgiovine.zenairlines.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.srgiovine.zenairlines.model.Aircraft;
import com.srgiovine.zenairlines.model.Billing;
import com.srgiovine.zenairlines.model.Customer;
import com.srgiovine.zenairlines.model.Employee;
import com.srgiovine.zenairlines.model.FlightDescription;
import com.srgiovine.zenairlines.model.Seating;

/**
 * Provides {@link ContentValues} for model objects.
 */
final class ZenSQLContentValues {

    static Customer getCustomer(Cursor cursor) {
        return new Customer.Builder()
                .setId(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.CUSTOMER_ID)))
                .setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.FIRST_NAME)))
                .setLastName(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.LAST_NAME)))
                .setSsn(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.SSN)))
                .setPhoneNumber(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.PHONE_NUMBER)))
                .setEmail(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.EMAIL)))
                .setAddress(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.ADDRESS)))
                .setCity(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.CITY)))
                .setState(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.STATE)))
                .setZip(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Customer.ZIP)))
                .createCustomer();
    }

    static Employee getEmployee(Cursor cursor) {
        return new Employee.Builder()
                .setId(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.EMPLOYEE_ID)))
                .setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.FIRST_NAME)))
                .setLastName(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.LAST_NAME)))
                .setSsn(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.SSN)))
                .setSsn(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.JOB_DESCRIPTION)))
                .setPhoneNumber(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.PHONE_NUMBER)))
                .setEmail(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.EMAIL)))
                .setAddress(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.ADDRESS)))
                .setCity(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.CITY)))
                .setState(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.STATE)))
                .setZip(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Employee.ZIP)))
                .createEmployee();
    }

    static Aircraft getAircraft(Cursor cursor) {
        return new Aircraft.Builder()
                .setVin(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Aircraft.VIN)))
                .setFlightNumber(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Aircraft.FLIGHT_NUMBER)))
                .setModel(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Aircraft.MODEL)))
                .setCrewCapacity(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Aircraft.CREW_CAPACITY)))
                .setFuelRange(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.Aircraft.FUEL_RANGE)))
                .setFirstClass(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Aircraft.FIRST_CLASS)))
                .setBusinessClass(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Aircraft.BUSINESS_CLASS)))
                .setEconomyClass(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Aircraft.ECONOMY_CLASS)))
                .createAircraft();
    }

    static FlightDescription getFlightDescription(Cursor cursor) {
        return new FlightDescription.Builder()
                .setFlightNumber(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.FLIGHT_NUMBER)))
                .setDeparture(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.DEPARTURE)))
                .setDepartureCity(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.DEPARTURE_CITY)))
                .setDepartureState(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.DEPARTURE_STATE)))
                .setDepartureTime(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.DEPARTURE_TIME)))
                .setArrival(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.ARRIVAL)))
                .setArrivalCity(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.ARRIVAL_CITY)))
                .setArrivalState(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.ARRIVAL_STATE)))
                .setArrivalTime(cursor.getString(cursor.getColumnIndexOrThrow(ZenSQLContract.FlightDescription.ARRIVAL_TIME)))
                .createFlightDescription();
    }

    static Billing getBilling(Cursor cursor) {
        return new Billing.Builder()
                .setTransactionNumber(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Billing.TRANSACTION_NUMBER)))
                .setFlightNumber(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Billing.FLIGHT_NUMBER)))
                .setCustomerId(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Billing.CUSTOMER_ID)))
                .setTicketNumber(cursor.getLong(cursor.getColumnIndexOrThrow(ZenSQLContract.Billing.TICKET_NUMBER)))
                .createBilling();
    }

    static ContentValues getCustomerContentValues(Customer customer) {
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

    static ContentValues getSeatingContentValues(Seating seating) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ZenSQLContract.Seating.CUSTOMER_ID, seating.customerId);
        contentValues.put(ZenSQLContract.Seating.FLIGHT_NUMBER, seating.flightNumber);
        contentValues.put(ZenSQLContract.Seating.SEAT_NUMBER, seating.seatNumber);
        contentValues.put(ZenSQLContract.Seating.COST, seating.cost);
        contentValues.put(ZenSQLContract.Seating.CLASS, seating.seatClass);
        return contentValues;
    }

    static ContentValues getBillingContentValues(Billing billing) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ZenSQLContract.Billing.FLIGHT_NUMBER, billing.flightNumber);
        contentValues.put(ZenSQLContract.Billing.CUSTOMER_ID, billing.customerId);
        contentValues.put(ZenSQLContract.Billing.TICKET_NUMBER, billing.ticketNumber);
        return contentValues;
    }

}
