package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by venkatgonuguntala on 5/6/15.
 */

public class MainActivity extends Activity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
        String[] items = new String[] { "Select an option","Email Validation", "Date Validation",
                "Unicode Validation", "Hostname Validation", "Url Validation","Credit Card Validation",
                "Boolean Validation", "Password Validation", "Unchecked funtion", "Number Validator",
                "Numeric Range Validators", "Object Length Validators", "RegExp Validator"};
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
                        break;
                    case 1:
                        //Email Validation.
                        emailIntent();
                        break;
                    case 2:
                        //Date Validation.
                        dateIntent();
                        break;
                    case 3:
                        //Unicode Validation.
                        unicodeIntent();
                        break;
                    case 4:
                        //Hostname Validation
                        HostnameIntent();
                        break;
                    case 5:
                        //Url Validation
                        urlIntent();
                        break;
                    case 6:
                        //Credit Card Validation
                        creditCardIntent();
                        break;
                    case 7:
                        //Boolean Validation
                        booleanIntent();
                        break;
                    case 8:
                        //Password Validation
                        passwordIntent();
                        break;
                    case 9:
                        //Unchecked Function
                        uncheckedIntent();
                        break;

                    case 10:
                        //Number Validator
                        numberIntent();
                        break;
                    case 11:
                        //Numeric Range Validator
                        numericRangeIntent();
                        break;
                    case 12:
                        //Object Length Validator
                        objectLengthIntent();
                        break;
                    case 13:
                        //Regex Validator
                        regexIntent();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void regexIntent() {
        intent = new Intent(this, RegularExpressionValidatorDemo.class);
        startActivity(intent);
    }

    private void objectLengthIntent() {
        intent = new Intent(this, ObjectLengthValidatorDemo.class);
        startActivity(intent);
    }

    private void numericRangeIntent() {
        intent =  new Intent(this, NumericRangeValidatorDemo.class);
        startActivity(intent);
    }

    private void numberIntent() {
        intent =  new Intent(this, NumberValidatorDemo.class);
        startActivity(intent);
    }

    private void uncheckedIntent() {
        intent = new Intent(this, UncheckedDemo.class);
        startActivity(intent);
    }

    private void passwordIntent() {
        intent = new Intent(this, PasswordValidatorDemo.class);
        startActivity(intent);
    }


    public void emailIntent(){
        intent = new Intent(this, EmailValidationDemo.class);
        startActivity(intent);
    }

    public void dateIntent(){
        intent = new Intent(this, DateValidationDemo.class);
        startActivity(intent);
    }

    public void unicodeIntent(){
        intent = new Intent(this, UnicodeValidationDemo.class);
        startActivity(intent);
    }

    public void HostnameIntent(){
        intent = new Intent(this, HostnameValidationDemo.class);
        startActivity(intent);
    }

    public void urlIntent(){
        intent = new Intent(this, UrlValidationDemo.class);
        startActivity(intent);
    }

    public void creditCardIntent(){
        intent =  new Intent(this, CreditCardValidatorDemo.class);
        startActivity(intent);
    }

    private void booleanIntent() {
        intent = new Intent(this, BooleanValidatorDemo.class);
        startActivity(intent);
    }
}


