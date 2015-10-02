package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import junit.framework.TestCase;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 9/23/15.
 */
public class ObjectLengthValidatorsTest extends TestCase{

    ObjectLengthValidators mObjectLengthValidators = new ObjectLengthValidators();
    List<String> list = new ArrayList<>();
    String []array =  {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    int []intArray = {1,2,3,4,5,6,7,8,9};
    String []nullArray = null;
    Map<String, Integer> mMap = new HashMap<String, Integer>();
    String myJSONString = "";
    BufferedReader bufferedReader = null;

    class NestedClass{
        private int i = 0;
        public String value1;
        public String value2;
        public String value3;
        public String value4;
        public String value5;
        public String value6;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        for(String value :array){
            list.add(value);
        }

        for (String a : array) {
            Integer freq = mMap.get(a);
            mMap.put(a, (freq == null) ? 1 : freq + 1);
        }
    }

    @SmallTest
    public void testForCollection(){
        assertEquals(true, mObjectLengthValidators.isObjectLengthInRange(list, 2, 9));
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(list, 2, 9).isEmpty());
    }

    @SmallTest
    public void testForArray(){
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(intArray, 8, 10).isEmpty());
        assertEquals(true, mObjectLengthValidators.isObjectLengthInRange(intArray, 8, 10));
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(array, 1, 10).isEmpty());
        assertEquals(true, mObjectLengthValidators.isObjectLengthInRange(array, 1, 11));
    }

    @SmallTest
    public void testForErrorChecker(){
        assertEquals(ValidatorConstant.ERR_NUM_INVALID_RANGE, mObjectLengthValidators.checkObjectLengthInRange(list, 5, 1).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MAX, mObjectLengthValidators.checkObjectLengthInRange(list, 1, 1).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, mObjectLengthValidators.checkObjectLengthInRange(list, 12, 20).get(0));
    }

    @SmallTest
    public void testForNullArray() {
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, mObjectLengthValidators.checkObjectLengthInRange(nullArray, 12, 20).get(0));
    }

    public void testForNegativeValueBound() {
        assertEquals(ValidatorConstant.ERR_INT_POSITIVE, mObjectLengthValidators.checkObjectLengthInRange(list, -12, -20).get(0));
    }

    @SmallTest
    public void testForInvalidObject() {
        Object object="jaffa"; //object of size one
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(object, 1, 2).isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM_INVALID_RANGE, mObjectLengthValidators.checkObjectLengthInRange(object, 2, 1).get(0));
    }

    @SmallTest
    public void testForJsonObjectReadFromFile() throws JSONException {

       try {

           String sCurrentLine;
           bufferedReader = new BufferedReader(new FileReader("/Users/venkatgonuguntala/wdpr-validators-android/WDPRValidators/src/test/java/com/disney/android/wdprvalidators/myFile"));
           while ((sCurrentLine = bufferedReader.readLine()) != null) {
               myJSONString = myJSONString + sCurrentLine;
               }
           } catch (IOException e) {
           e.printStackTrace();
           } finally {
           try {
               if (bufferedReader != null){
                   bufferedReader.close();
                   }
               } catch (IOException ex) {
               ex.printStackTrace();
               }
           }
       Gson gson = new Gson();
        Object object = gson.toJson(myJSONString);
       assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(object, 1, 4).isEmpty());
        assertEquals(true, mObjectLengthValidators.isObjectLengthInRange(object, 1, 4));
    }

    @SmallTest
    public void testForClassInstanceLength() {
        NestedClass nestedClass = new NestedClass(); //object of length six
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(nestedClass, 3, 8).isEmpty());
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(nestedClass, 3, 6).isEmpty());
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(nestedClass, 6, 8).isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MAX, mObjectLengthValidators.checkObjectLengthInRange(nestedClass, 3, 5).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, mObjectLengthValidators.checkObjectLengthInRange(nestedClass, 7, 8).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_INVALID_RANGE, mObjectLengthValidators.checkObjectLengthInRange(nestedClass, 9, 3).get(0));
    }

    @SmallTest
    public void testForMap() {
        //mMap is an object of nine
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(mMap, 8, 10).isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM_INVALID_RANGE, mObjectLengthValidators.checkObjectLengthInRange(mMap, 11, 10).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, mObjectLengthValidators.checkObjectLengthInRange(mMap, 11, 13).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MAX, mObjectLengthValidators.checkObjectLengthInRange(mMap, 7, 8).get(0));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

