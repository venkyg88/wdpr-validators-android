package com.example.venkatgonuguntala.emailvalidator;

import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

/**
 * Created by venkatgonuguntala on 5/13/15.
 */


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();


        mainActivity = getActivity();

    }

    @SmallTest
    public void textViewNotNull(){
        TextView textView = (TextView) mainActivity.findViewById(R.id.show_text_view);
        assertNotNull(textView);
    }
}