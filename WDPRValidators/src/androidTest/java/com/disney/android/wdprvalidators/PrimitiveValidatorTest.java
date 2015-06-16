package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class PrimitiveValidatorTest extends TestCase {

    String mStringArray[] = {"venk","kat","gonu"};  // It's an array
    String mString = "v,e,n,k,a,t";           // Not an array
    int[] mIntArray = {102,133,345,475};        // It's an array
    double[] mDoubleArray = {10.9};                   // It's an array

    PrimitiveValidator arrayObj = new PrimitiveValidator();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testForArray(){
        assertEquals(true, arrayObj.isAnArray(mStringArray));
        assertEquals(true, arrayObj.isAnArray(mIntArray));
        assertEquals(true, arrayObj.isAnArray(mDoubleArray));
    }

    @SmallTest
    public void testForNotArray(){
        assertEquals(false, arrayObj.isAnArray(mString));
    }

    @SmallTest
    public void testForString(){
        assertEquals(true,arrayObj.isAString(mString));
    }

    public void testForNotString(){
        assertEquals(false, arrayObj.isAString(mIntArray));
        assertEquals(false, arrayObj.isAString(mStringArray));
        assertEquals(false, arrayObj.isAString(mDoubleArray));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
