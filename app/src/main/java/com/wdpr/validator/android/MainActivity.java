package com.wdpr.validator.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wdpr.validator.android.R;

/**
 * Created by venkatgonuguntala on 5/6/15.
 */

public class MainActivity extends Activity {

    //Logger for this class
    private static final String TAG = "MainActivity";

    //Input field where user enters his email address
    private EditText mEmailText;

    //Input field where user enter his date
    private EditText mDateText;

    private TextView mResultText;

    //The validator for email input field.
    private EmailValidator emailValidator;

    //The validator for date input field.
    private DateValidator dateValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailText = (EditText) findViewById(R.id.emailInput);

        mDateText = (EditText) findViewById(R.id.dateInput);

        mResultText = (TextView) findViewById(R.id.show_text_view);

        emailValidator = new EmailValidator();
        mEmailText.addTextChangedListener(emailValidator);
        //--------------------------------------------------
        dateValidator = new DateValidator();
        //mDateText.addTextChangedListener(dateValidator);
    }


    /**
     * Called when the "Validate" button is clicked.
     */
    public void onValidateClick(View view) {
        String email = mEmailText.getText().toString();
        String result = emailValidator.checkEmail(email);
        if (result == "200") {
            mResultText.setText("Email format is good");
        } else {
            mEmailText.setError((CharSequence) CodeDescription.getCodeDescription().get(result));
            mResultText.setText("");
        }
    }


   /* public void onDateValidateClick(View view){
        String date = "2009-05-19 14:39:22-06:00";//"200905";//
        // String date = mDateText.getText().toString();
        String result2 = dateValidator.checkIsoDate(date);
        if(result2 == "200"){
            mResultText.setText("Date format is good");
        }
        else{
            mDateText.setError((CharSequence) CodeDescription.getCodeDescription().get(result2));
            mResultText.setText("");
        }
    }*/



}
