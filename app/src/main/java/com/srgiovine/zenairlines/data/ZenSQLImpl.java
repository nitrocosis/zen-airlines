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
import com.srgiovine.zenairlines.model.FlightDescription;
import com.srgiovine.zenairlines.model.Seating;

/**
 * Provides an implementation of {@link ZenSQL}.
 */
public class ZenSQLImpl extends SQLiteOpenHelper implements ZenSQL {

    private static final String DB_NAME = "ZenAirlines.db";
    private static final int DB_VERSION = 1;

    private final Context context;

    public ZenSQLImpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
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
    public void insertCustomerAsync(final Customer customer, final Callback<Long> callback) {
        getWritableDatabaseAsync(new GetDBCallback() {
            @Override
            public void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
                ContentValues contentValues = ZenSQLContentValues.getCustomerContentValues(customer);
                long newCustomerId = sqLiteDatabase.insert(ZenSQLContract.Customer.TABLE_NAME, null, contentValues);
                if (newCustomerId != -1l) {
                    callback.success(newCustomerId);
                } else {
                    callback.failed();
                }
            }
        });
    }

    @Override
    public void insertSeatingAsync(final Seating seating, final Callback<Long> callback) {
        getWritableDatabaseAsync(new GetDBCallback() {
            @Override
            public void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
                ContentValues contentValues = ZenSQLContentValues.getSeatingContentValues(seating);
                long newSeatingId = sqLiteDatabase.insert(ZenSQLContract.Seating.TABLE_NAME, null, contentValues);
                if (newSeatingId != -1l) {
                    callback.success(newSeatingId);
                } else {
                    callback.failed();
                }
            }
        });
    }

    @Override
    public void bookFlightAsync(final long flightNumber, final long customerId, final Callback<Billing> callback) {
        getWritableDatabaseAsync(new GetDBCallback() {
            @Override
            public void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
                // get largest ticket number
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT MAX(" + ZenSQLContract.Billing.TICKET_NUMBER + ")" +
                        " FROM " + ZenSQLContract.Billing.TABLE_NAME, null);
                if (!cursor.moveToFirst()) {
                    callback.failed();
                    return;
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
                    callback.failed();
                    return;
                }

                // retrieve the newly created billing
                cursor = sqLiteDatabase.query(ZenSQLContract.Billing.TABLE_NAME, null,
                        ZenSQLContract.Billing.TRANSACTION_NUMBER + " = ? COLLATE NOCASE",
                        new String[]{String.valueOf(newTransactionId)},
                        null, null, null);

                if (cursor.moveToFirst()) {
                    callback.success(ZenSQLContentValues.getBilling(cursor));
                } else {
                    callback.failed();
                }
            }
        });
    }

    @Override
    public void selectCustomerAsync(final String ssnOrEmail,
                                    final Callback<Customer> callback) {
        getReadableDatabaseAsync(new GetDBCallback() {
            @Override
            public void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.Customer.TABLE_NAME, null,
                        ZenSQLContract.Customer.SSN + " = ? OR " +
                                ZenSQLContract.Customer.EMAIL + " = ? COLLATE NOCASE",
                        new String[]{ssnOrEmail, ssnOrEmail},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    callback.success(ZenSQLContentValues.getCustomer(cursor));
                } else {
                    callback.failed();
                }
            }
        });
    }

    @Override
    public void selectAircraft(final String flightNumber, final Callback<Aircraft> callback) {
        getReadableDatabaseAsync(new GetDBCallback() {
            @Override
            public void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.Aircraft.TABLE_NAME, null,
                        ZenSQLContract.Aircraft.FLIGHT_NUMBER + " = ?",
                        new String[]{flightNumber},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    callback.success(ZenSQLContentValues.getAircraft(cursor));
                } else {
                    callback.failed();
                }
            }
        });
    }

    @Override
    public void selectFlightAsync(final String departureCity, final String departureState,
                                  final String departureTime, final String arrivalCity,
                                  final String arrivalState, final String arrivalTime,
                                  final Callback<FlightDescription> callback) {
        getReadableDatabaseAsync(new GetDBCallback() {
            @Override
            public void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
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
                    callback.success(ZenSQLContentValues.getFlightDescription(cursor));
                } else {
                    callback.failed();
                }
            }
        });
    }

    @Override
    public void selectFlightAsync(final String flightNumber, final Callback<FlightDescription> callback) {
        getReadableDatabaseAsync(new GetDBCallback() {
            @Override
            public void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
                Cursor cursor = sqLiteDatabase.query(ZenSQLContract.FlightDescription.TABLE_NAME, null,
                        ZenSQLContract.FlightDescription.FLIGHT_NUMBER + " = ?",
                        new String[]{flightNumber},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    callback.success(ZenSQLContentValues.getFlightDescription(cursor));
                } else {
                    callback.failed();
                }
            }
        });
    }

    private void getWritableDatabaseAsync(final GetDBCallback getDBCallback) {
        new AsyncTask<Void, Void, SQLiteDatabase>() {

            @Override
            protected SQLiteDatabase doInBackground(Void... params) {
                return getWritableDatabase();
            }

            @Override
            protected void onPostExecute(SQLiteDatabase sqLiteDatabase) {
                getDBCallback.onObtainedSQLiteDatabase(sqLiteDatabase);
            }
        }.execute();
    }

    private void getReadableDatabaseAsync(final GetDBCallback getDBCallback) {
        new AsyncTask<Void, Void, SQLiteDatabase>() {

            @Override
            protected SQLiteDatabase doInBackground(Void... params) {
                return getReadableDatabase();
            }

            @Override
            protected void onPostExecute(SQLiteDatabase sqLiteDatabase) {
                getDBCallback.onObtainedSQLiteDatabase(sqLiteDatabase);
            }
        }.execute();
    }

    private interface GetDBCallback {

        void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase);

    }

}
