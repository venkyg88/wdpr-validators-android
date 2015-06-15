package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.disney.android.wdprvalidators.CodeDescription;
import com.disney.android.wdprvalidators.EmailValidator;

/**
 * Created by gonuv001 on 6/3/2015.
 */
public class EmailValidationDemo extends Activity {

    //Logger for this class
    private static final String TAG = "EmailValidationDemo";

    //Input field where user enters his email address
    private EditText mEmailText;

    //Textview for displaying the result, if email format is good.
    private TextView mResultText;

    //The validator for email input field.
    private EmailValidator emailValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        mEmailText = (EditText) findViewById(R.id.emailInput);

        mResultText = (TextView) findViewById(R.id.show_text_view);

        emailValidator = new EmailValidator();

        Button button = (Button) findViewById(R.id.validateButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onValidateClick(v);
            }
        });
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
}
