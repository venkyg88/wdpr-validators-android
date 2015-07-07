package com.disney.android.wdprvalidatorsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.disney.android.wdprvalidators.DateValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by gonuv001 on 6/3/2015.
 */
public class DateValidationDemo extends Activity {

    //Logger for this class
    private static final String TAG = "DateValidationDemo";

    //Input field where user enter to check ISO date
    private EditText mDateText;
    //Input field where user enter date to check, if it falls in range.
    private EditText mUserDateText;
    private EditText mStartDateText;
    private EditText mEndDateText;
    //Textview for displaying the result, if date format is good.
    private TextView mResultText;
    ///The validator for date input field.
    private DateValidator dateValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        mDateText = (EditText) findViewById(R.id.dateInput);
        mResultText = (TextView) findViewById(R.id.show_text_view);
        dateValidator = new DateValidator();
        Button button = (Button) findViewById(R.id.dateValidate);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onDateValidateClick(v);
            }
        });

        mUserDateText = (EditText) findViewById(R.id.dateUserInput);
        mStartDateText = (EditText) findViewById(R.id.dateStartDate);
        mEndDateText = (EditText) findViewById(R.id.dateEndDate);
        Button button1 = (Button) findViewById(R.id.rangeValidate);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                try {
                    onDateRangeValidateClick(v);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(DateValidationDemo.this, "Exception at onClick method",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Called when the "Validate" button is clicked.
     */
    public void onDateValidateClick(View view) {
        String date = mDateText.getText().toString();
        List<String> result = dateValidator.checkIsoDate(date);
        if (result.size() == 0) {
            mResultText.setText("date format is good");
        } else {
            for(int i = 0; i < result.size(); i++) {
                mDateText.setError(result.get(i));
            }
            mResultText.setText("");
        }
    }

    public void onDateRangeValidateClick(View view) throws ParseException {
        String userDate = mUserDateText.getText().toString();
        String startDate = mStartDateText.getText().toString();
        String endDate = mEndDateText.getText().toString();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sDate=null,eDate = null,uDate=null;
        try {
            sDate = formatter.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            eDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            uDate =  formatter.parse(userDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(sDate == null){
            mStartDateText.setError("Start Date cannot be empty");
        }

        if(eDate == null){
            mEndDateText.setError("End Date cannot be empty");
        }

        if(uDate == null) {
            mUserDateText.setError("Target Date cannot be empty");
        }

        List<String> result = dateValidator.checkDateRange(sDate,eDate,uDate);
        if(result.size() == 0){
            Toast.makeText(this,"Falls in the range",Toast.LENGTH_SHORT).show();
        }
        else {
            for(int i = 0; i < result.size(); i++) {
                Toast.makeText(this,result.get(i),Toast.LENGTH_SHORT).show();
            }

        }
    }
}
