package com.srgiovine.zenairlines;

import android.app.AlertDialog;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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

}
