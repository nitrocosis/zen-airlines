package com.srgiovine.zenairlines;

import android.os.Bundle;
import android.view.View;

import com.srgiovine.zenairlines.data.ZenSQL;
import com.srgiovine.zenairlines.model.Employee;

/**
 * Allows employees to look up their employee id.
 */
public class LookupEmployeeIdActivity extends ZenAirlinesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup_employee_id);
    }

    public void onLookupEmployeeIdButtonClicked(View view) {
        if (!validateEditTexts(R.id.ssn_or_email)) {
            return;
        }

        getZenSQL().selectEmployeeAsync(getEditTextValue(R.id.ssn_or_email, String.class),
                new ZenSQL.Callback<Employee>() {
                    @Override
                    public void success(Employee employee) {
                        showAlertDialog("Success", "Employee ID: " + employee.id);
                    }

                    @Override
                    public void failed() {
                        showAlertDialog("Failed", "Failed to lookup employee id");
                    }
                });
    }

}
