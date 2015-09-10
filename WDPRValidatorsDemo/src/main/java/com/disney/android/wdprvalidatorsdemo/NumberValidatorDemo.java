package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.disney.android.wdprvalidators.*;

import java.util.List;

/**
 * Created by venkatgonuguntala on 9/10/15.
 */
public class NumberValidatorDemo extends Activity {

    private static final String TAG = "PasswordValidatorDemo";

    //text field for entering password
    private EditText mNumberText;

    //validator object
    private PrimitiveValidator mPrimitiveValidator;

    //button for password predicate
    private Button mPredicateButton;

    //button for password checker
    private Button mCheckerButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        mPrimitiveValidator = new PrimitiveValidator();

        mNumberText = (EditText) findViewById(R.id.numberInput);

        mPredicateButton = (Button) findViewById(R.id.isNumber);

        mPredicateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPredicateClick(v);
            }
        });

        mCheckerButton = (Button) findViewById(R.id.checkNumber);

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
        if (mNumberText != null){

            String number = mNumberText.getText().toString();

            List<String> result =  mPrimitiveValidator.checkNumber(number);

            String errorCode="";

            for (String str : result)
            {
                str ="\n"+str;

                errorCode=errorCode.concat(str);
            }

            if(errorCode.equals(""))
            {
                Toast.makeText(this, number + " is a number", Toast.LENGTH_LONG).show();
            }
            else
            {
                mNumberText.setError(errorCode);

                Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onPredicateClick(View view){
        if (mNumberText != null) {

            String number = mNumberText.getText().toString();

            boolean result =  mPrimitiveValidator.isNumber(number);

            if(result){
                Toast.makeText(this,"true",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
