package com.srgiovine.zenairlines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Provides employees several options:
 * <p/>
 * 1. Check their schedule
 * 2. Look up their employee id
 */
public class EmployeeOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onCheckScheduleButtonClicked(View view) {
        startActivity(new Intent(this, CheckEmployeeScheduleActivity.class));
    }

    public void onLookupEmployeeIdButtonClicked(View view) {
        startActivity(new Intent(this, LookupEmployeeIdActivity.class));
    }
}
