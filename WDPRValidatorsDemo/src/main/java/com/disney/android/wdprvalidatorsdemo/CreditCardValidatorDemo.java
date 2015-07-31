package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.disney.android.wdprvalidators.CreditCardValidators;
import java.util.List;

/**
 * Created by venkatgonuguntala on 7/21/15.
 */
public class CreditCardValidatorDemo extends Activity{

    private static final String TAG = "CCValidationDemo";

    //Input field where user enter credit card number for type
    private EditText mCreditCardNumberForTypeText;

    private CreditCardValidators creditCardValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_creditcard);

        mCreditCardNumberForTypeText = (EditText) findViewById(R.id.creditCardNumberForType);

        creditCardValidator =  new CreditCardValidators();

        Button button = (Button) findViewById(R.id.checkCreditCard);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onValidateClick(v);
            }
        });

        Button button1 = (Button) findViewById(R.id.checkCreditCardType);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onValidateClickType(v);
            }
        });

    }

    /**
     * Called when the "Validate" button is clicked.
     */
    public void onValidateClick(View view) {

        String ccNumber = null;

        ccNumber = mCreditCardNumberForTypeText.getText().toString();

        boolean result =  creditCardValidator.isCreditCard(ccNumber);

        if(result){
            Toast.makeText(this, "Card is Valid and supported by disney", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Invalid Card", Toast.LENGTH_LONG).show();
        }
    }

    public void onValidateClickType(View view){

        String ccNUmber = mCreditCardNumberForTypeText.getText().toString();

        List<String> result = creditCardValidator.checkCreditCard(ccNUmber);

        String errorCode = "";

        for (String str : result) {

            str ="\n"+str;

            errorCode=errorCode.concat(str);
        }

        if(result.isEmpty())
        {
            Toast.makeText(this, "It is a Valid Credit Card with Type", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();

            result.clear();
        }
    }
}
