package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class PrimitiveValidatorTest extends TestCase {

    String mStringArray[] = {"venk","kat","gonu"};  // It's an array
    String emptyArray[] = {};
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
        assertEquals(0, arrayObj.arrayChecker(mStringArray).size());
        assertEquals(0, arrayObj.arrayChecker(mIntArray).size());
        assertEquals(0, arrayObj.arrayChecker(mDoubleArray).size());
    }

    @SmallTest
    public void testForNotArray(){
        assertEquals(false, arrayObj.isAnArray(mString));
        assertEquals("ERR_ARRAY", arrayObj.arrayChecker(mString).get(0));
        assertEquals("ERR_EMPTY_INPUT", arrayObj.arrayChecker(null).get(0));

    }

    @SmallTest
    public void testForString(){
        assertEquals(true,arrayObj.isAString(mString));
        assertEquals(0,arrayObj.stringChecker(mString).size());
    }

    @SmallTest
    public void testForNotString(){
        assertEquals(false, arrayObj.isAString(mIntArray));
        assertEquals(false, arrayObj.isAString(mStringArray));
        assertEquals(false, arrayObj.isAString(mDoubleArray));
        assertEquals(false, arrayObj.isAString(mDoubleArray));
        assertEquals("ERR_STRING", arrayObj.stringChecker(mDoubleArray).get(0));
        assertEquals("ERR_STRING", arrayObj.stringChecker(mStringArray).get(0));
        assertEquals("ERR_EMPTY_INPUT", arrayObj.stringChecker(null).get(0));

    }

    @SmallTest
    public void testForEmptyArray(){
        assertEquals(true, arrayObj.isAnArray(emptyArray));
        assertEquals(0, arrayObj.arrayChecker(emptyArray).size());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
