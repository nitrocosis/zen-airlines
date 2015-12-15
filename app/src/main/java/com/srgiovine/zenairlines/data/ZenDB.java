package com.srgiovine.zenairlines.data;

import com.srgiovine.zenairlines.model.Aircraft;
import com.srgiovine.zenairlines.model.Billing;
import com.srgiovine.zenairlines.model.Customer;
import com.srgiovine.zenairlines.model.Employee;
import com.srgiovine.zenairlines.model.FlightDescription;
import com.srgiovine.zenairlines.model.Seating;

/**
 * Provides read and write access to the Zen Airlines database.
 */
public interface ZenDB {

    void insertCustomerAsync(Customer customer, Callback<Long> callback);

    void insertSeatingAsync(Seating seating, Callback<Long> callback);

    void selectCustomerAsync(String ssnOrEmail, Callback<Customer> callback);

    void selectEmployeeAsync(String ssnOrEmail, Callback<Employee> callback);

    void selectAircraft(String flightNumber, Callback<Aircraft> callback);

    void selectFlightAsync(String flightNumber, Callback<FlightDescription> callback);

    void selectFlightAsync(String departureCity, String departureState, String departureTime,
                           String arrivalCity, String arrivalState, String arrivalTime,
                           Callback<FlightDescription> callback);

    void bookFlightAsync(long flightNumber, long customerId, Callback<Billing> callback);

    interface Callback<T> {

        void success(T item);

        void failed();

    }
}
