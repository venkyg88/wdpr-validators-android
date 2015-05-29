package com.wdpr.validator.android;

import android.test.suitebuilder.annotation.SmallTest;

import com.wdpr.validator.android.ArrayValidator;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class ArrayValidatorTest extends TestCase {

    String anArray[] = {"venk","kat","gonu"};  // It's an array
    String notArray = "v,e,n,k,a,t";           // Not an array
    int[] alsoArry = {102,133,345,475};        // It's an array
    double[] anArr = {10.9};                   // It's an array

    ArrayValidator arrayObj = new ArrayValidator();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    @SmallTest
    public void testForArray(){
        assertEquals(true, arrayObj.isAnArray(anArray));
        assertEquals(true, arrayObj.isAnArray(alsoArry));
        assertEquals(true, arrayObj.isAnArray(anArr));
    }

    @SmallTest
    public void testForNotArray(){
        assertEquals(false,arrayObj.isAnArray(notArray));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
