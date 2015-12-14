package com.srgiovine.zenairlines.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

import com.srgiovine.zenairlines.model.Customer;

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
    public void insertCustomerAsync(final Customer customer, final InsertCallback insertCallback) {
        getWritableDatabaseAsync(new GetDBCallback() {
            @Override
            public void onObtainedSQLiteDatabase(SQLiteDatabase sqLiteDatabase) {
                ContentValues contentValues = ZenSQLContentValues.getCustomerContentValues(customer);
                long result = sqLiteDatabase.insert(ZenSQLContract.Customer.TABLE_NAME, null, contentValues);
                if (result != -1l) {
                    insertCallback.insertSuccess(result);
                } else {
                    insertCallback.insertFailed();
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
