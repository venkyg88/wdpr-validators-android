package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.disney.android.wdprvalidators.RegexValidator;
import java.util.List;

/**
 * Created by venkatgonuguntala on 10/12/15.
 */
public class RegularExpressionValidatorDemo extends Activity {

    private static final String TAG = "RegularExpressionValidatorDemo";

    RegexValidator mRegexValidator = new RegexValidator();

    private Button mButton;

    private Button mButtonPredicate;

    private EditText mEditText;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_regexp);

        mEditText = (EditText) findViewById(R.id.editTextRegExp);

        mTextView = (TextView) findViewById(R.id.textViewRegexp);

        mButton = (Button) findViewById(R.id.regexButton);

        mButtonPredicate = (Button) findViewById(R.id.regexButtonTwo);

        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validateChecker(v);
            }
        });

        mButtonPredicate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validatePredicate(v);
            }
        });
    }

    private void validatePredicate(View view)
    {
        String mRegExp = mEditText.getText().toString();

        boolean result =  mRegexValidator.isRegex(mRegExp);

        if(result)
        {
            mTextView.setText("True");
        }
        else
        {
            mTextView.setText("False");
        }
    }

    private void validateChecker(View view) {

        String mRegExp = mEditText.getText().toString();

        List<String> result = mRegexValidator.checkRegex(mRegExp);

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
}
