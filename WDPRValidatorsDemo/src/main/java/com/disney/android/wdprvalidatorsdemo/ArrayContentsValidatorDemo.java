package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.disney.android.wdprvalidators.ArrayContentsValidator;
import com.disney.android.wdprvalidators.RegexValidator;

import java.util.List;

/**
 * Created by venkatgonuguntala on 10/16/15.
 */
public class ArrayContentsValidatorDemo extends Activity {

    private static final String TAG = "ArrayContentValidatorsDemo";

    ArrayContentsValidator mArrayContentsValidator = new ArrayContentsValidator();

    private Button mButtonDemo1;

    private Button mButtonDemo2;

    private Button mButtonDemo3;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arraycontents);

        mTextView = (TextView) findViewById(R.id.textViewArrayContents);

        mButtonDemo1 = (Button) findViewById(R.id.buttonDemo1);

        mButtonDemo2 = (Button) findViewById(R.id.buttonDemo2);

        mButtonDemo3 = (Button) findViewById(R.id.buttonDemo3);

    }


    public void validateCheckerDemo1(View view) {

        Integer integer[] = {1,1,1,1};
        List<String> result = mArrayContentsValidator.checkArrayOfIntendedType(integer, Integer.class);

        String errorCode="";

        for (String str : result)
        {
            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if(errorCode.isEmpty())
        {
            mTextView.setText("success");
        }
        else
        {
            mTextView.setText(errorCode);
        }
    }

    public void validateCheckerDemo2(View view) {

        String string[] = {"big", "pig", "hen", "dog"};
        List<String> result = mArrayContentsValidator.checkArrayOfIntendedType(string, Boolean.class);

        String errorCode="";

        for (String str : result)
        {
            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if(errorCode.isEmpty())
        {
            mTextView.setText("success");
        }
        else
        {
            mTextView.setText(errorCode);
        }
    }

    public void validateCheckerDemo3(View view) {

        Object objectArray[] = {new Holder(20), new HolderTwo("android"), new Holder(16)};
        List<String> result = mArrayContentsValidator.checkArrayOfIntendedType(objectArray, Holder.class);

        String errorCode="";

        for (String str : result)
        {
            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if(errorCode.isEmpty())
        {
            mTextView.setText("success");
        }
        else
        {
            mTextView.setText(errorCode);
        }
    }

    public class Holder{
        private int anInt;
        Holder(int anInt){
            this.anInt = anInt;
        }
    }

    public class HolderTwo{
        private String anInt;
        HolderTwo(String anInt){
            this.anInt = anInt;
        }
    }

}
