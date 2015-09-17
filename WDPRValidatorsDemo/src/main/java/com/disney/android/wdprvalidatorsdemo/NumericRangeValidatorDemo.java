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

/*    @Override
    protected void onResume() {
        super.onResume();
        input = mInput.getText().toString();
        lower = mInput.getText().toString();
        upper = mInput.getText().toString();
    }*/

    public void onPredicateClick(View view){
        String input = mInput.getText().toString();
        String lower = mLower.getText().toString();
        String upper = mUpper.getText().toString();

        boolean result = mPrimitiveValidator.isNumberRange(input, lower, upper);
        if(result){
            mtextViewResult.setText("true");
        }else{
            mtextViewResult.setText("false");
        }
    }

    public void onCheckerClick(View view){
        String input = mInput.getText().toString();
        String lower = mLower.getText().toString();
        String upper = mUpper.getText().toString();
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
}
