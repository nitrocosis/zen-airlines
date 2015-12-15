package com.srgiovine.zenairlines;

import android.app.AlertDialog;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.srgiovine.zenairlines.data.ZenSQL;

/**
 * Base activity that provides subclasses simpler access to {@link ZenSQL}. This also provides
 * other convenience methods.
 */
public class ZenAirlinesActivity extends AppCompatActivity {

    public static final int RESULT_FAILED = RESULT_FIRST_USER + 1;

    protected void showAlertDialog(String title, String message) {
        TextView messageView = (TextView) getLayoutInflater().inflate(R.layout.text_view_dialog, null, false);
        messageView.setText(message);

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setIcon(android.R.drawable.ic_menu_info_details)
                .setView(messageView)
                .setPositiveButton("Got it!", null)
                .show();
    }

    protected ZenSQL getZenSQL() {
        return ((ZenAirlinesApplication) getApplication()).getZenSQL();
    }

    @SuppressWarnings("unchecked")
    protected <C> C getEditTextValue(@IdRes int editTextId, Class<C> clazz) {
        String value = ((EditText) findViewById(editTextId)).getText().toString();
        if (Integer.class == clazz) {
            return (C) Integer.valueOf(value);
        }
        return (C) value;
    }

    @SuppressWarnings("unchecked")
    protected <C> C getSpinnerValue(@IdRes int spinnerId, Class<C> clazz) {
        String value = ((Spinner) findViewById(spinnerId)).getSelectedItem().toString();
        if (Integer.class == clazz) {
            return (C) Integer.valueOf(value);
        }
        return (C) value;
    }

    protected String getTimePickerValue(@IdRes int timePickerId) {
        TimePicker timePicker = (TimePicker) findViewById(timePickerId);
        return String.format("%02d:%02d", timePicker.getCurrentHour(), timePicker.getCurrentMinute());
    }

    protected boolean validateEditTexts(@IdRes int... editTextIds) {
        boolean isValid = true;
        for (int editTextId : editTextIds) {
            EditText editText = (EditText) findViewById(editTextId);
            String editTextValue = editText.getText().toString();
            if (TextUtils.isEmpty(editTextValue)) {
                isValid = false;
                editText.setError("This field is required");
            } else {
                editText.setError(null);
            }
        }
        return isValid;
    }

}
