package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.disney.android.wdprvalidators.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private TextView textViewR;

    //button for password predicate
    private Button mPredicateButton;

    //button for password checker
    private Button mCheckerButton;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    Date mDate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        mPrimitiveValidator = new PrimitiveValidator();

        textViewR = (TextView) findViewById(R.id.textViewResult);
    }
    
    public void onNilClick(View view){
        Object number = null;
        List<String> result =  mPrimitiveValidator.checkNumber(number);
        String errorCode="";
        for (String str : result)
        {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        if(errorCode.isEmpty())
        {
            textViewR.setText("Success - Input passed");
        }
        else
        {
            textViewR.setText(errorCode);
        }
    }

    public void onNumberClick(View view){
        List<String> result =  mPrimitiveValidator.checkNumber(72);
        String errorCode="";
        for (String str : result)
        {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        if(errorCode.isEmpty())
        {
            textViewR.setText("Success - Input passed");
        }
        else
        {
            textViewR.setText(errorCode);
        }
    }

    public void onStringNumberClick(View view){
        List<String> result =  mPrimitiveValidator.checkNumber("42");
        String errorCode="";
        for (String str : result)
        {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        if(errorCode.isEmpty())
        {
            textViewR.setText("Success - Input passed");
        }
        else
        {
            textViewR.setText(errorCode);
        }
    }

    public void onDateClick(View view){

        try {
            mDate = formatter.parse("2005-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> result =  mPrimitiveValidator.checkNumber(mDate);
        String errorCode="";
        for (String str : result)
        {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        if(errorCode.isEmpty())
        {
            textViewR.setText("Success - Input passed");
        }
        else
        {
            textViewR.setText(errorCode);
        }
    }

    public void onStringClick(View view){
        List<String> result =  mPrimitiveValidator.checkNumber("cow");
        String errorCode="";
        for (String str : result)
        {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        if(errorCode.isEmpty())
        {
            textViewR.setText("Success - Input passed");
        }
        else
        {
            textViewR.setText(errorCode);
        }
    }


}
