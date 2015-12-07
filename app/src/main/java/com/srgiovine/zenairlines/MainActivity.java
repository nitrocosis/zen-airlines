package com.srgiovine.zenairlines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Prompts users to select whether they are a passenger or an employee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPassengerButtonClicked(View view) {
        startActivity(new Intent(this, PassengerOptionsActivity.class));
    }

    public void onEmployeeButtonClicked(View view) {
        startActivity(new Intent(this, EmployeeOptionsActivity.class));
    }
}
