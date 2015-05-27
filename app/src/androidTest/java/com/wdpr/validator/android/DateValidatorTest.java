package com.wdpr.validator.android;

import android.test.suitebuilder.annotation.SmallTest;

import com.wdpr.validator.android.DateValidator;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/22/15.
 */
public class DateValidatorTest extends TestCase{

    String[] arrayForValid = {"2009-12T12:34","2009","2009-05-19","20090519","2009123","2009-05","2009-123","2009-222",
            "2009-001","2009-W01-1","2009-W51-1","2009-W511","2009-W33","2009W511","2009-05-19","2009-05-19 00:00",
            "2009-05-19 14","2009-05-19 14:31","2009-05-19 14:39:22","2009-05-19T14:39Z","2009-W21-2","2009-W21-2T01:22",
            "2009-139","2009-05-19 14:39:22-06:00","2009-05-19 14:39:22+0600","2009-05-19 14:39:22-01","20090621T0545Z",
            "2007-04-06T00:00","2007-04-05T24:00","2010-02-18T16:23:48.5","2010-02-18T16:23:48,444",
            "2010-02-18T16:23:48,3-06:00","2010-02-18T16:23.4","2010-02-18T16:23,25","2010-02-18T16:23.33+0600",
            "2010-02-18T16.23334444","2010-02-18T16,2283","2009-05-19 143922.500","2009-05-19 1439,55"};


    String[] arrayforInvalid ={"200905","2009367","2009-","2007-04-05T24:50","2009-000","2009-M511","2009M511",
            "2009-05-19T14a39r","2009-05-19T14:3924","2009-0519","2009-05-1914:39","2009-05-19 14:","2009-05-19r14:39",
            "2009-05-19r14:39","200912-01","2009-05-19 14:39:22+06a00","2009-05-19 146922.500","2010-02-18T16.5:23.35:48",
            "2010-02-18T16:23.35:48","2010-02-18T16:23.35:48.45","2009-05-19 14.5.44","2010-02-18T16:23.33.600",
            "2010-02-18T16,25:23:48,444"};

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    @SmallTest
    public void testForValidDate() {
        for(int i=0;i<arrayForValid.length;i++){
            String result2 = DateValidator.checkIsoDate(arrayForValid[i]);
            assertEquals("200", result2);
        }

    }

    @SmallTest
    public void testForInvalidDate(){
        for(int i=0;i< arrayforInvalid.length;i++) {
            String result2 = DateValidator.checkIsoDate(arrayforInvalid[i]);
            assertEquals("114", result2);
        }
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
