package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date sDate;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        sDate = formatter.parse("2005-01-01");
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
        assertEquals(0, arrayObj.stringChecker(mString).size());
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

/***************************** Tests for Number Predicate *********************/
    public void testForInteger(){
        Integer number = 123;
        assertEquals(true, arrayObj.isNumber(number));
        assertEquals(true, arrayObj.checkNumber(number).isEmpty());
    }

    public void testForDouble(){
        Double number = 7.6E+7;
        assertEquals(true, arrayObj.isNumber(number));
        assertEquals(true, arrayObj.checkNumber(number).isEmpty());
    }

    public void testForLong(){
        Long number = 12345678910L;
        assertEquals(true, arrayObj.isNumber(number));
        assertEquals(true, arrayObj.checkNumber(number).isEmpty());
    }

    public void testForNegativeInteger(){
        Integer number = -123;
        assertEquals(true, arrayObj.isNumber(number));
        assertEquals(true,arrayObj.checkNumber(number).isEmpty());
    }

    public void testForNull(){
        Object number = null;
        assertEquals(false, arrayObj.isNumber(number));
        assertEquals("ERR_EMPTY_INPUT", arrayObj.checkNumber(number).get(0));
    }

    public void testForDate(){
        assertEquals(false, arrayObj.isNumber(sDate));
        assertEquals("ERR_NUM",arrayObj.checkNumber(sDate).get(0));
    }

    public void testForNumber(){
        String number = "1234";
        assertEquals(true, arrayObj.isNumber(number));
        assertEquals(true, arrayObj.checkNumber(number).isEmpty());
    }

    public void testForNegativeNumber(){
        String negativeNumber = "-1234";
        assertEquals(true, arrayObj.isNumber(negativeNumber));
        assertEquals(true, arrayObj.checkNumber(negativeNumber).isEmpty());
    }

    public void testForPositiveNumber(){
        String positiveNumber = "+1234";
        assertEquals(true, arrayObj.isNumber(positiveNumber));
        assertEquals(true, arrayObj.checkNumber(positiveNumber).isEmpty());
    }

    public void testForEmptyInput(){
        String number = "";
        assertEquals(false, arrayObj.isNumber(number));
        assertEquals("ERR_EMPTY_INPUT", arrayObj.checkNumber(number).get(0));
    }

    public void testForNotNumber(){
        String notNumber = "cow";
        assertEquals(false, arrayObj.isNumber(notNumber));
        assertEquals("ERR_NUM", arrayObj.checkNumber(notNumber).get(0));
        assertEquals("ERR_NUM", arrayObj.checkNumber("!@#$").get(0));
    }

    public void testForDecimalNumber(){
        String decimalNumber = "12.01";
        assertEquals(true, arrayObj.isNumber(decimalNumber));
        assertEquals(true, arrayObj.checkNumber(decimalNumber).isEmpty());
    }

    public void testForExponent(){
        String exponent = "7.6E+7";
        assertEquals(true, arrayObj.isNumber(exponent));
        assertEquals(true, arrayObj.checkNumber(exponent).isEmpty());
    }

    public void testForStringLong(){
        Long number = 12345678910L;
        assertEquals(true, arrayObj.isNumber(number));
        assertEquals(true, arrayObj.checkNumber(number).isEmpty());
    }

    public void testForHexadecimalNumber(){
        assertEquals(true, arrayObj.isNumber(0x1));
    }

    public void testForHexadecimalNumberString(){
        assertEquals(true, arrayObj.isNumber("0x1"));
    }

/************************* END of Tests for Number Predicate *****************/
/************************* START of Test for Number Range ********************/

    public void testForStringAndNumber(){
        //test cases for strings as inputs
        assertEquals(true, arrayObj.isNumberInRange("12", "-12", "20"));
        assertEquals(true, arrayObj.isNumberInRange("12l", "12l", "20l"));
        assertEquals(true, arrayObj.isNumberInRange("12", "11.5", "20"));
        assertEquals(true, arrayObj.isNumberInRange("12", "-12", "20"));
        assertEquals(false, arrayObj.isNumberInRange("20", "12.5", "15"));
        assertEquals(false, arrayObj.isNumberInRange("10", "12.5", "15"));
        assertEquals(true, arrayObj.isNumberInRange("10.23f", "2", "30l"));
        assertEquals(true, arrayObj.isNumberInRange("0x12", "0x1", "0x30"));
        assertEquals(false, arrayObj.isNumberInRange("0x1", "0x10", "0x20"));

        //test cases for Numbers as inputs
        assertEquals(true, arrayObj.isNumberInRange(12, -12, 20));
        assertEquals(true, arrayObj.isNumberInRange(12l, 12l, 20l));
        assertEquals(true, arrayObj.isNumberInRange(12, 11.5, 20));
        assertEquals(true, arrayObj.isNumberInRange(12, -12, 20));
        assertEquals(false, arrayObj.isNumberInRange(20, 12.5, 15));
        assertEquals(false, arrayObj.isNumberInRange(10, 12.5, 15));
        assertEquals(true, arrayObj.isNumberInRange(10.23f, 2, 30l));
        assertEquals(true, arrayObj.isNumberInRange(0x12, 0x1, 0x30));
        assertEquals(false, arrayObj.isNumberInRange(0x1, 0x10, 0x20));

        //test cases for strings and Numbers as inputs
        assertEquals(true, arrayObj.isNumberInRange("12", -12, "20"));
    }

    public void testForStringAndNumberCheck(){

        //Test cases for strings as inputs
        assertEquals(true, arrayObj.checkNumberInRange("12", "-12", "20").isEmpty());
        assertEquals(true, arrayObj.checkNumberInRange("12l", "12l", "20l").isEmpty());
        assertEquals(true, arrayObj.checkNumberInRange("12", "11.5", "20").isEmpty());
        assertEquals(true, arrayObj.checkNumberInRange("12", "-12", "20").isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MAX, arrayObj.checkNumberInRange("20", "12.5", "15").get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, arrayObj.checkNumberInRange("10", "12.5", "15").get(0));
        assertEquals(true, arrayObj.checkNumberInRange("10.23f", "2", "30l").isEmpty());
        assertEquals(true, arrayObj.checkNumberInRange("0x12", "0x1", "0x30").isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, arrayObj.checkNumberInRange("0x1", "0x10", "0x20").get(0));
        assertEquals(ValidatorConstant.ERR_NUM_INVALID_RANGE,arrayObj.checkNumberInRange("35", "50", "10").get(0));
        assertEquals(ValidatorConstant.ERR_NUM,arrayObj.checkNumberInRange(true, "50", "10").get(0));   //true is not number
        assertEquals(ValidatorConstant.ERR_NUM,arrayObj.checkNumberInRange("35", "disney", "10").get(0)); //disney is not number

        //test cases for Numbers as inputs
        assertEquals(true, arrayObj.checkNumberInRange(12, -12, 20).isEmpty());
        assertEquals(true, arrayObj.checkNumberInRange(12l, 12l, 20l).isEmpty());
        assertEquals(true, arrayObj.checkNumberInRange(12, 11.5, 20).isEmpty());
        assertEquals(true, arrayObj.checkNumberInRange(12, -12, 20).isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MAX, arrayObj.checkNumberInRange(20, 12.5, 15).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, arrayObj.checkNumberInRange(10, 12.5, 15).get(0));
        assertEquals(true, arrayObj.checkNumberInRange(10.23f, 2, 30l).isEmpty());
        assertEquals(true, arrayObj.checkNumberInRange(0x12, 0x1, 0x30).isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, arrayObj.checkNumberInRange(0x1, 0x10, 0x20).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_INVALID_RANGE,arrayObj.checkNumberInRange(35, 50, 10).get(0));
        assertEquals(ValidatorConstant.ERR_NUM,arrayObj.checkNumberInRange(true, 50, 10).get(0));   //true is not number

        //test cases for strings and Numbers as inputs
        assertEquals(true, arrayObj.checkNumberInRange("12", -12, "20").isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM,arrayObj.checkNumberInRange(35, "disney", "10").get(0)); //disney is not number
    }
/************************ START of Test for Number Range ********************/

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
