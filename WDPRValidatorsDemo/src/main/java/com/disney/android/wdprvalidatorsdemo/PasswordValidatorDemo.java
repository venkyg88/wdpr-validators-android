package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.disney.android.wdprvalidators.PasswordValidator;

import java.util.List;

/**
 * Created by venkatgonuguntala on 8/27/15.
 */
public class PasswordValidatorDemo extends Activity{

    private static final String TAG = "PasswordValidatorDemo";

    //text field for entering password
    private EditText mPasswordText;

    //validator object
    private PasswordValidator mPasswordValidator;

    //button for password predicate
    private Button mPredicateButton;

    //button for password checker
    private Button mCheckerButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        mPasswordValidator = new PasswordValidator();

        mPasswordText = (EditText) findViewById(R.id.passwordInput);

        mPredicateButton = (Button) findViewById(R.id.isPassword);
        mPredicateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPredicateClick(v);
            }
        });

        mCheckerButton = (Button) findViewById(R.id.checkPassword);
        mCheckerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onCheckerClick(v);
            }
        });
    }


    /**
     * Called when the "Validate" button is clicked.
     */
    public void onCheckerClick(View view)
    {
        if (mPasswordText != null){

            String password = mPasswordText.getText().toString();

            List<String> result =  mPasswordValidator.checkPassword(password);

            String errorCode="";

            for (String str : result)
            {
                str ="\n"+str;

                errorCode=errorCode.concat(str);
            }

            if(errorCode.equals(""))
            {
                Toast.makeText(this, password+" is a Valid password", Toast.LENGTH_LONG).show();
            }
            else
            {
                mPasswordText.setError(errorCode);

                Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onPredicateClick(View view){
        if (mPasswordText != null) {

            String password = mPasswordText.getText().toString();

            boolean result =  mPasswordValidator.isPassword(password);

            if(result){
                Toast.makeText(this,"true",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
