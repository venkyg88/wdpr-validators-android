package com.example.venkatgonuguntala.emailvalidator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by venkatgonuguntala on 5/6/15.
 */
public class MainActivity extends Activity {

    //Logger for this class
    private static final String TAG = "MainActivity";

    //Input field where user enters his email address
    private EditText mEmailText;

    private TextView mResultText;

    //The validator for email input field.
    private EmailValidatorClass emailValidatorClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailText = (EditText) findViewById(R.id.emailInput);
        //String email = mEmailText.getText().toString();

        mResultText = (TextView) findViewById(R.id.show_text_view);
        
        emailValidatorClass = new EmailValidatorClass();
        mEmailText.addTextChangedListener(emailValidatorClass);
    }


    /**
     * Called when the "Validate" button is clicked.
     */
    public void onValidateClick(View view) {
        String email = mEmailText.getText().toString();
            String result = emailValidatorClass.checkEmail(email);
            if (result=="200"){
                mResultText.setText("Email format is good");
            }
            else {
                mEmailText.setError((CharSequence) HashMapValues.hashMethod().get(result));
                mResultText.setText("");
            }
    }


}
