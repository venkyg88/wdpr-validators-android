package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.disney.android.wdprvalidators.UrlValidator;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by venkatgonuguntala on 7/16/15.
 */
public class UrlValidationDemo extends Activity{

    private static final String TAG = "UrlValidationDemo";

    private EditText mURLText;

    private Switch mSwitchField;

    private TextView mSwitchState;

    private UrlValidator urlValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        mURLText = (EditText) findViewById(R.id.urlInput);

        mSwitchState = (TextView) findViewById(R.id.swithState);

        mSwitchField = (Switch) findViewById(R.id.switch1);

        urlValidator = new UrlValidator();

        Button button = (Button) findViewById(R.id.validateButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    onValidateClick(v);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

        Button button1 = (Button) findViewById(R.id.isURL);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    onUrlClick(view);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    /**
     * Called when the "Validate" button is clicked.
     */
    public void onValidateClick(View view) throws MalformedURLException
    {
        if (mURLText != null){

        String url = mURLText.getText().toString();

        boolean relaxed;

        if(mSwitchField.isChecked())
        {
            relaxed = true;

            mSwitchState.setText("ON");
        }
        else
        {
            relaxed = false;

            mSwitchState.setText("OFF");
        }
        List<String> result =  urlValidator.checkURL(url, relaxed);

        String errorCode="";

        for (String str : result)
        {
            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if(errorCode.equals(""))
        {
            Toast.makeText(this, "It is a Valid Url", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();
        }
        }
    }

    public void onUrlClick(View view) throws MalformedURLException{
        if (mURLText != null) {

            String url = mURLText.getText().toString();

            boolean relaxed;

            if (mSwitchField.isChecked()) {
                relaxed = true;

                mSwitchState.setText("ON");
            } else {
                relaxed = false;

                mSwitchState.setText("OFF");
            }

            boolean result =  urlValidator.isValidURL(url, relaxed);

            if(result){
                Toast.makeText(this,"true",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
