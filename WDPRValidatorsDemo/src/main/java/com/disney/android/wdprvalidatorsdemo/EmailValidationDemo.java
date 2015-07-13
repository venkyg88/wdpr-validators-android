package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.disney.android.wdprvalidators.EmailValidator;

import java.util.List;

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
        List<String> result = emailValidator.checkEmail(email);
        String errorCode="";
        for (String str : result) {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        if (result.size() == 0) {
            Toast.makeText(this, "It is a Valid Email", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();
        }
        mResultText.setText("");
    }
}




