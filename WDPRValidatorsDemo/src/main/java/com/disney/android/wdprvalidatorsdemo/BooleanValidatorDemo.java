package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

/**
 * Created by venkatgonuguntala on 8/19/15.
 */
public class BooleanValidatorDemo extends Activity {

    private EditText mboolText;

    private TextView mResultText;

    private PrimitiveValidator mPrimitiveValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boolean_activity);

        mboolText = (EditText) findViewById(R.id.booleanInput);

        mResultText = (TextView) findViewById(R.id.show_booleantext_view);

        mPrimitiveValidator = new PrimitiveValidator();

        Button button = (Button) findViewById(R.id.booleanButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBooleanClick(view);
            }
        });
    }

    private void onBooleanClick(View view) {
        String value = mboolText.getText().toString();
        List<String> result = mPrimitiveValidator.booleanChecker(value);
        String errorCode="";
        for (String str : result) {
            str ="\n"+str;
            errorCode=errorCode.concat(str);
        }
        if (result.size() == 0) {
            Toast.makeText(this, "It is boolean", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();
        }
        mResultText.setText("");
    }
}

