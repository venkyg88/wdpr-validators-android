package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import com.disney.android.wdprvalidators.PrimitiveValidator;

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

            }
        });
    }
}

