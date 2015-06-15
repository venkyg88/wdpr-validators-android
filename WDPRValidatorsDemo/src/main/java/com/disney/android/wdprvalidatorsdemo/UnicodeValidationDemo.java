package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.disney.android.wdprvalidators.UnicodeValidator;

/**
 * Created by gonuv001 on 6/3/2015.
 */
public class UnicodeValidationDemo extends Activity{
    //Logger for this class
    private static final String TAG = "UnicodeValidatorDemo";

    //Input field where user enters unicode
    private EditText mUnicdoeText;

    //Textview for displaying the result, if Unicode format is good.
    private TextView mResultText;

    //The validator for unicode input field.
    private UnicodeValidator unicodeValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unicode);

        mUnicdoeText = (EditText) findViewById(R.id.mUnicdoeText);

        mResultText = (TextView) findViewById(R.id.show_text_view);

        unicodeValidator = new UnicodeValidator();

        Button button = (Button) findViewById(R.id.unicodeValidate);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onUnicodeValidateClick(v);
            }
        });
    }

    /**
     * Called when the "Validate" button is clicked.
     */
    public void onUnicodeValidateClick(View view) {
        String value = mUnicdoeText.getText().toString();
        boolean result = unicodeValidator.aUnicodeString(value);
        if (result) {
            mResultText.setText("It's Unicode");
        } else {
            mUnicdoeText.setError("It's not Unicode");
            mResultText.setText("");
        }
    }
}
