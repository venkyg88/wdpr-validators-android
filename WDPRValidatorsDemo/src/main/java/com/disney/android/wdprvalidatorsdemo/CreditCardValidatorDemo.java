package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.disney.android.wdprvalidators.CreditCardValidators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by venkatgonuguntala on 7/21/15.
 */
public class CreditCardValidatorDemo extends Activity{
    private static final String TAG = "CCValidationDemo";

    //Input field where user enter credit card number for type
    private EditText mCreditCardNumberForTypeText;

    private CreditCardValidators creditCardValidator;

    //Input field where user selects the card type from the dropdown
    private String dropDownCard = new String();

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

        final Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        String[] items = new String[] { "Select a Card", "AMEX", "VISA", "MASTER CARD", "DISCOVER", "DINERS CLUB", "JCB"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        //Do nothing, to show the option
                        dropDownCard = null;
                        break;
                    case 1:
                        dropDownCard = "AMEX";
                        break;
                    case 2:
                        //Date Validation.
                        dropDownCard = "VISA";
                        break;
                    case 3:
                        //Unicode Validation.
                        dropDownCard = "MASTERCARD";
                        break;
                    case 4:
                        //Hostname Validation
                        dropDownCard = "DISCOVER";
                        break;
                    case 5:
                        //Url Validation
                        dropDownCard = "DINERS";
                        break;
                    case 6:
                        //Credit Card Validation
                        dropDownCard = "JCB";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    /**
     * Called when the "Validate" button is clicked.
     */
    public void onValidateClick(View view) {

        String ccNumber = null;

        ccNumber = mCreditCardNumberForTypeText.getText().toString();

        boolean result =  creditCardValidator.isCreditCard(ccNumber, dropDownCard);

        if(result){
            Toast.makeText(this, "Card is Valid and supported by disney", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Invalid Card", Toast.LENGTH_LONG).show();
        }
    }

    public void onValidateClickType(View view){

        String ccNUmber = mCreditCardNumberForTypeText.getText().toString();

        List<String> result = creditCardValidator.checkCreditCard(ccNUmber, dropDownCard);

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
