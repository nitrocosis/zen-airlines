package com.srgiovine.zenairlines.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

import com.srgiovine.zenairlines.model.Aircraft;
import com.srgiovine.zenairlines.model.Billing;
import com.srgiovine.zenairlines.model.Customer;
import com.srgiovine.zenairlines.model.Employee;
import com.srgiovine.zenairlines.model.EmployeeSchedule;
import com.srgiovine.zenairlines.model.FlightDescription;
import com.srgiovine.zenairlines.model.Seating;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides an implementation of {@link ZenDB}.
 */
public class ZenSQL extends SQLiteOpenHelper implements ZenDB {

    private static final String DB_NAME = "ZenAirlines.db";
    private static final int DB_VERSION = 1;

    public ZenSQL(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(ZenSQLContract.Customer.CREATE_TABLE);
            db.execSQL(ZenSQLContract.Customer.INITIAL_INSERT);
            db.execSQL(ZenSQLContract.Employee.CREATE_TABLE);
            db.execSQL(ZenSQLContract.Employee.INITIAL_INSERT);
            db.execSQL(ZenSQLContract.FlightDescription.CREATE_TABLE);
            db.execSQL(ZenSQLContract.FlightDescription.INITIAL_INSERT);
            db.execSQL(ZenSQLContract.EmployeeSchedule.CREATE_TABLE);
            db.execSQL(ZenSQLContract.EmployeeSchedule.INITIAL_INSERT);
            db.execSQL(ZenSQLContract.Billing.CREATE_TABLE);
            db.execSQL(ZenSQLContract.Billing.INITIAL_INSERT);
            db.execSQL(ZenSQLContract.Aircraft.CREATE_TABLE);
            db.execSQL(ZenSQLContract.Aircraft.INITIAL_INSERT);
            db.execSQL(ZenSQLContract.Seating.CREATE_TABLE);
            db.execSQL(ZenSQLContract.Seating.INITIAL_INSERT);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade will delete old db and create a new one
        db.beginTransaction();
        try {
            db.execSQL(ZenSQLContract.Customer.DROP_TABLE);
            db.execSQL(ZenSQLContract.Employee.DROP_TABLE);
            db.execSQL(ZenSQLContract.FlightDescription.DROP_TABLE);
            db.execSQL(ZenSQLContract.EmployeeSchedule.DROP_TABLE);
            db.execSQL(ZenSQLContract.Billing.DROP_TABLE);
            db.execSQL(ZenSQLContract.Aircraft.DROP_TABLE);
            db.execSQL(ZenSQLContract.Seating.DROP_TABLE);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        onCreate(db);
    }

    @Override
    public void insertCustomerAsync(final Customer customer, Callback<Long> callback) {
        doDBWriteOperationInBackground(new DBOperation<Long>(callback) {
            @Override
            public Long doInBackground(SQLiteDatabase sqLiteDatabase) {
                ContentValues contentValues = ZenSQLContentValues.getCustomerContentValues(customer);
                long newCustomerId = sqLiteDatabase.insert(ZenSQLContract.Customer.TABLE_NAME, null, contentValues);
                if (newCustomerId != -1l) {
                    return newCustomerId;
                }
                return null;
            }
        });
    }

    @Override
    public void insertSeatingAsync(final Seating seating, Callback<Long> callback) {
        doDBWriteOperationInBackground(new DBOperation<Long>(callback) {
            @Override
            public Long doInBackground(SQLiteDatabase sqLiteDatabase) {
                ContentValues contentValues = ZenSQLContentValues.getSeatingContentValues(seating);
                long newSeatingId = sqLiteDatabase.insert(ZenSQLContract.Seating.TABLE_NAME, null, contentValues);
                if (newSeatingId != -1l) {
                    return newSeatingId;
                }
                return null;
            }
        });
    }

    @Override
    public void bookFlightAsync(final long flightNumber, final long customerId, Callback<Billing> callback) {
        doDBWriteOperationInBackground(new DBOperation<Billing>(callback) {
            @Override
            public Billing doInBackground(SQLiteDatabase sqLiteDatabase) {
                // get largest ticket number
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT MAX(" + ZenSQLContract.Billing.TICKET_NUMBER + ")" +
                        " FROM " + ZenSQLContract.Billing.TABLE_NAME, null);
                if (!cursor.moveToFirst()) {
                    return null;
                }

                // create new billing
                long largestTicketNumber = cursor.getLong(0);
                Billing tempBilling = new Billing.Builder()
                        .setFlightNumber(flightNumber)
                        .setCustomerId(customerId)
                        .setTicketNumber(largestTicketNumber + 1l)
                        .createBilling();

                ContentValues contentValues = ZenSQLContentValues.getBillingContentValues(tempBilling);
                long newTransactionId = sqLiteDatabase.insert(ZenSQLContract.Billing.TABLE_NAME, null, contentValues);
                if (newTransactionId == -1l) {
                    return null;
                }

                // retrieve the newly created billing
                cursor = sqLiteDatabase.query(ZenSQLContract.Billing.TABLE_NAME, null,
                        ZenSQLContract.Billing.TRANSACTION_NUMBER + " = ? COLLATE NOCASE",
                        new String[]{String.valueOf(newTransactionId)},
                        null, null, null);

                if (cursor.moveToFirst()) {
                    return ZenSQLContentValues.getBilling(cursor);
                }
                return null;
            }
        });
    }

    @Override
    public void selectCustomerAsync(final String ssnOrEmail, Callback<Customer> callback) {
        doDBReadOperationInBackground(new DBOperation<Customer>(callback) {
            @Override
            public Customer doInBackground(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.Customer.TABLE_NAME, null,
                        ZenSQLContract.Customer.SSN + " = ? OR " +
                                ZenSQLContract.Customer.EMAIL + " = ? COLLATE NOCASE",
                        new String[]{ssnOrEmail, ssnOrEmail},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    return ZenSQLContentValues.getCustomer(cursor);
                }
                return null;
            }
        });
    }

    @Override
    public void selectEmployeeAsync(final String ssnOrEmail, Callback<Employee> callback) {
        doDBReadOperationInBackground(new DBOperation<Employee>(callback) {
            @Override
            public Employee doInBackground(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.Employee.TABLE_NAME, null,
                        ZenSQLContract.Employee.SSN + " = ? OR " +
                                ZenSQLContract.Employee.EMAIL + " = ? COLLATE NOCASE",
                        new String[]{ssnOrEmail, ssnOrEmail},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    return ZenSQLContentValues.getEmployee(cursor);
                }
                return null;
            }
        });
    }

    @Override
    public void selectEmployeeSchedulesAsync(final String employeeId, Callback<List<EmployeeSchedule>> callback) {
        doDBReadOperationInBackground(new DBOperation<List<EmployeeSchedule>>(callback) {
            @Override
            protected List<EmployeeSchedule> doInBackground(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.EmployeeSchedule.TABLE_NAME, null,
                        ZenSQLContract.EmployeeSchedule.EMPLOYEE_ID + " = ?",
                        new String[]{employeeId},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    List<EmployeeSchedule> employeeSchedules = new ArrayList<>();
                    employeeSchedules.add(ZenSQLContentValues.getEmployeeSchedule(cursor));
                    while (cursor.moveToNext()) {
                        employeeSchedules.add(ZenSQLContentValues.getEmployeeSchedule(cursor));
                    }
                    return employeeSchedules;
                }
                return null;
            }
        });
    }

    @Override
    public void selectAircraft(final String flightNumber, Callback<Aircraft> callback) {
        doDBReadOperationInBackground(new DBOperation<Aircraft>(callback) {
            @Override
            public Aircraft doInBackground(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.Aircraft.TABLE_NAME, null,
                        ZenSQLContract.Aircraft.FLIGHT_NUMBER + " = ?",
                        new String[]{flightNumber},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    return ZenSQLContentValues.getAircraft(cursor);
                }
                return null;
            }
        });
    }

    @Override
    public void selectFlightAsync(final String departureCity, final String departureState,
                                  final String departureTime, final String arrivalCity,
                                  final String arrivalState, final String arrivalTime,
                                  Callback<FlightDescription> callback) {
        doDBReadOperationInBackground(new DBOperation<FlightDescription>(callback) {
            @Override
            public FlightDescription doInBackground(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.FlightDescription.TABLE_NAME, null,
                        ZenSQLContract.FlightDescription.DEPARTURE_CITY + " = ? AND " +
                                ZenSQLContract.FlightDescription.DEPARTURE_STATE + " = ? AND " +
                                ZenSQLContract.FlightDescription.DEPARTURE_TIME + " = ? AND " +
                                ZenSQLContract.FlightDescription.ARRIVAL_CITY + " = ? AND " +
                                ZenSQLContract.FlightDescription.ARRIVAL_STATE + " = ? AND " +
                                ZenSQLContract.FlightDescription.ARRIVAL_TIME + " = ? COLLATE NOCASE",
                        new String[]{
                                departureCity, departureState, departureTime,
                                arrivalCity, arrivalState, arrivalTime,
                        },
                        null, null, null);
                if (cursor.moveToFirst()) {
                    return ZenSQLContentValues.getFlightDescription(cursor);
                }
                return null;
            }
        });
    }

    @Override
    public void selectFlightAsync(final String flightNumber, Callback<FlightDescription> callback) {
        doDBReadOperationInBackground(new DBOperation<FlightDescription>(callback) {
            @Override
            public FlightDescription doInBackground(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.FlightDescription.TABLE_NAME, null,
                        ZenSQLContract.FlightDescription.FLIGHT_NUMBER + " = ?",
                        new String[]{flightNumber},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    return ZenSQLContentValues.getFlightDescription(cursor);
                }
                return null;
            }
        });
    }

    private <C> void doDBWriteOperationInBackground(final DBOperation<C> dbOperation) {
        new AsyncTask<Void, Void, C>() {

            @Override
            protected C doInBackground(Void... params) {
                return dbOperation.doInBackground(getWritableDatabase());
            }

            @Override
            protected void onPostExecute(C c) {
                super.onPostExecute(c);
                dbOperation.onPostExecute(c);
            }
        }.execute();
    }

    private <C> void doDBReadOperationInBackground(final DBOperation<C> dbOperation) {
        new AsyncTask<Void, Void, C>() {

            @Override
            protected C doInBackground(Void... params) {
                return dbOperation.doInBackground(getReadableDatabase());
            }

            @Override
            protected void onPostExecute(C c) {
                super.onPostExecute(c);
                dbOperation.onPostExecute(c);
            }
        }.execute();
    }

    private static abstract class DBOperation<C> {

        private final Callback<C> callback;

        private DBOperation(Callback<C> callback) {
            this.callback = callback;
        }

        protected abstract C doInBackground(SQLiteDatabase sqLiteDatabase);

        protected void onPostExecute(C result) {
            if (result != null) {
                callback.success(result);
            } else {
                callback.failed();
            }
        }

    }

}
