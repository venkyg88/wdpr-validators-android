package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.disney.android.wdprvalidators.CreditCardValidators;

import java.text.ParseException;
import java.util.List;

/**
 * Created by venkatgonuguntala on 7/21/15.
 */
public class CreditCardValidatorDemo extends Activity{

    private static final String TAG = "CCValidationDemo";

    //Input field where user enter credit card number for type
    private EditText mCreditCardNumberForTypeText;

    private EditText mCreditCardDateYearText;

    private EditText mCreditCardDateMonthText;

    private CreditCardValidators creditCardValidator;

    private EditText mCreditCardCvcText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_creditcard);

        mCreditCardNumberForTypeText = (EditText) findViewById(R.id.creditCardNumberForType);

        mCreditCardDateMonthText = (EditText) findViewById(R.id.editTextMonth);

        mCreditCardDateYearText = (EditText) findViewById(R.id.editTextYear);

        creditCardValidator =  new CreditCardValidators();

        mCreditCardCvcText = (EditText) findViewById(R.id.editTextCvc);

        Button button = (Button) findViewById(R.id.checkCreditCard);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onValidateClick(v);
            }
        });

        Button button1 = (Button) findViewById(R.id.checkCreditCardType);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onValidateClickType(v);
            }
        });

    }

    /**
     * Called when the "Predicate" button is clicked.
     */
    public void onValidateClick(View view) {

        String ccNumber = null;

        ccNumber = mCreditCardNumberForTypeText.getText().toString();

        boolean result =  creditCardValidator.isCreditCard(ccNumber);

        if(result){
            Toast.makeText(this, "Card is Valid", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Invalid Card", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Called when the "Checker" button is clicked.
     */
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
            Toast.makeText(this, "It is a Valid Credit Card", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();

            result.clear();
        }
    }

    public void isCreditCardDate(View view) throws ParseException {

        String year = mCreditCardDateYearText.getText().toString();

        String month = mCreditCardDateMonthText.getText().toString();

        if(year == null || month == null || year.isEmpty() || year.isEmpty()){
            if (year == null || year.isEmpty()){
                mCreditCardDateYearText.setError("empty");
            }
            if (month == null || month.isEmpty()){
                mCreditCardDateMonthText.setError("empty");
            }
        }else {

            boolean result = creditCardValidator.isValidCreditCardDate(Integer.parseInt(year), Integer.parseInt(month));

            if (result) {
                Toast.makeText(CreditCardValidatorDemo.this, "date is Valid", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(CreditCardValidatorDemo.this, "date is not valid", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void checkCreditCardDate(View view) throws ParseException {

        String year = mCreditCardDateYearText.getText().toString();

        String month = mCreditCardDateMonthText.getText().toString();

        if(year == null || month == null || year.isEmpty() || year.isEmpty())
        {
            if (year == null || year.isEmpty())
            {
                mCreditCardDateYearText.setError("empty");
            }
            if (month == null || month.isEmpty())
            {
                mCreditCardDateMonthText.setError("empty");
            }
        }else {

            List<String> result = creditCardValidator.checkCreditCardDate(Integer.parseInt(year), Integer.parseInt(month));

            String errorCode = "";

            for (String str : result) {

                str = "\n" + str;

                errorCode = errorCode.concat(str);
            }

            if (result.isEmpty()) {
                Toast.makeText(this, "It is a Valid Credit Card", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();

                result.clear();
            }
        }
    }

    public void isCreditCardCVC(View view) {

        String cvc = mCreditCardCvcText.getText().toString();

        boolean result = creditCardValidator.isCreditCardCVC(cvc);

        if(result){
            Toast.makeText(CreditCardValidatorDemo.this,"true", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(CreditCardValidatorDemo.this,"false", Toast.LENGTH_SHORT).show();
        }

    }
    public void checkCreditCardCVC(View view){

        String cvc = mCreditCardCvcText.getText().toString();

        List<String> result = creditCardValidator.checkCreditCardCVC(cvc);

        String errorCode = "";

        for (String str : result) {

            str ="\n"+str;

            errorCode = errorCode.concat(str);
        }

        if(result.isEmpty())
        {
            Toast.makeText(this, "It is a Valid CVC", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, errorCode, Toast.LENGTH_LONG).show();

            result.clear();
        }
    }
}
