package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import com.disney.android.wdprvalidators.HostnameValidation;

/**
 * Created by GONUV001 on 6/22/2015.
 */
public class HostnameValidationDemo extends Activity{
    //Logger for this class
    private static final String TAG = "HostnameValidationDemo";

    //Input field where user enters his email address
    private EditText mHostnameText;

    //Textview for displaying the result, if email format is good.
    private TextView mResultText;


    //The validator for email input field.
    private HostnameValidation hostnameValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostname);

        mHostnameText = (EditText) findViewById(R.id.hostnameInput);

        mResultText = (TextView) findViewById(R.id.text_view);

        hostnameValidator = new HostnameValidation();

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
        String hostname = mHostnameText.getText().toString();
        List<String> result =  hostnameValidator.checkHostName(hostname);
        String errorCode="";
        for (String str : result) {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        //mResultText.setError((CharSequence) errorCode);
        if(errorCode.equals("")){
            Toast.makeText(this, "It is a Valid Hostname", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();
        }

    }
}
