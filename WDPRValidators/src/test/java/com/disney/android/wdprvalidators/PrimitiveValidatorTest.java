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

    @SmallTest
    public void testBooleanPredicateAndChecker(){
        String[] value = {"FALSE", "False", "false", "TRUE", "TrUe", "true", "oooo", null, ""};
        //boolean predicate testing
        assertEquals(true, arrayObj.booleanPredicate(value[0]));
        assertEquals(true, arrayObj.booleanPredicate(value[1]));
        assertEquals(true, arrayObj.booleanPredicate(value[2]));
        assertEquals(true, arrayObj.booleanPredicate(value[3]));
        assertEquals(true, arrayObj.booleanPredicate(value[4]));
        assertEquals(true, arrayObj.booleanPredicate(value[5]));

        assertEquals(false, arrayObj.booleanPredicate(value[6]));
        assertEquals(false, arrayObj.booleanPredicate(value[7]));
        assertEquals(false, arrayObj.booleanPredicate(value[8]));

        //boolean checker testing
        assertEquals(true, arrayObj.booleanChecker(value[0]).isEmpty());
        assertEquals(true, arrayObj.booleanChecker(value[1]).isEmpty());
        assertEquals(true, arrayObj.booleanChecker(value[2]).isEmpty());
        assertEquals(true, arrayObj.booleanChecker(value[3]).isEmpty());
        assertEquals(true, arrayObj.booleanChecker(value[4]).isEmpty());
        assertEquals(true, arrayObj.booleanChecker(value[5]).isEmpty());
        //testing with false conditions
        assertEquals(false, arrayObj.booleanChecker(value[6]).isEmpty());
        assertEquals(false, arrayObj.booleanChecker(value[7]).isEmpty());
        assertEquals(false, arrayObj.booleanChecker(value[8]).isEmpty());
        //testing for error messages
        assertEquals("ERR_BOOL", arrayObj.booleanChecker(value[6]).get(0));
        assertEquals("ERR_EMPTY_INPUT", arrayObj.booleanChecker(value[7]).get(0));
        assertEquals("ERR_EMPTY_INPUT", arrayObj.booleanChecker(value[8]).get(0));
    }

    @SmallTest
    public void testForUnchecked(){
        assertEquals(true, arrayObj.isUncheked());
        assertEquals(true, arrayObj.checkUnchecked().isEmpty());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
