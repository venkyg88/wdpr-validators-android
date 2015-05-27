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


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    @SmallTest
    public void testForArray(){
        assertEquals(true, ArrayValidator.isAnArray(anArray));
        assertEquals(true, ArrayValidator.isAnArray(alsoArry));
        assertEquals(true, ArrayValidator.isAnArray(anArr));
    }

    @SmallTest
    public void testForNotArray(){
        assertEquals(false,ArrayValidator.isAnArray(notArray));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
