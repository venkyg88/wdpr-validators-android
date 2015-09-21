package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.disney.android.wdprvalidators.PrimitiveValidator;

import java.util.List;

/**
 * Created by venkatgonuguntala on 9/17/15.
 */
public class NumericRangeValidatorDemo extends Activity {

    private static final String TAG = "NumbericRangeValidatorDemo";
    private EditText mInput;
    private EditText mLower;
    private EditText mUpper;
    private TextView mtextViewResult;
    PrimitiveValidator mPrimitiveValidator;
    private String input, lower, upper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeric_range);
        mPrimitiveValidator = new PrimitiveValidator();
        mtextViewResult = (TextView) findViewById(R.id.textViewNumericResult);
        mInput = (EditText) findViewById(R.id.editTextInput);
        mLower = (EditText) findViewById(R.id.editTextLower);
        mUpper = (EditText) findViewById(R.id.editTextUpper);
    }


    public void onPredicateClick(View view){
        input = mInput.getText().toString();
        lower = mLower.getText().toString();
        upper = mUpper.getText().toString();
        boolean result = mPrimitiveValidator.isNumberRange(input, lower, upper);
        if(result){
            mtextViewResult.setText("true");
        }else{
            mtextViewResult.setText("false");
        }
    }

    public void onCheckerClick(View view){
        getValues();
        List<String> result =  mPrimitiveValidator.checkNumberRange(input, lower, upper);
        String errorCode="";
        for (String str : result)
        {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        if(errorCode.isEmpty())
        {
            mtextViewResult.setText("Success - Input passed");
        }
        else
        {
            mtextViewResult.setText(errorCode);
        }
    }

    private void getValues(){
        input = mInput.getText().toString();
        lower = mLower.getText().toString();
        upper = mUpper.getText().toString();
        if (input.isEmpty()){
            mInput.setError(getString(R.string.dummy));
        }
        if (lower.isEmpty()){
            mLower.setError(getString(R.string.dummy));
        }
        if (upper.isEmpty()){
            mUpper.setError(getString(R.string.dummy));
        }
    }
}
