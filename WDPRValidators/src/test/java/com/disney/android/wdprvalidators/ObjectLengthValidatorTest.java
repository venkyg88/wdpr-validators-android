package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;

import com.google.gson.Gson;

import junit.framework.TestCase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 9/23/15.
 */
public class ObjectLengthValidatorTest extends TestCase{

    ObjectLengthValidator mObjectLengthValidators;
    List<String> list = new ArrayList<>();
    String []array =  {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    int []intArray = {1,2,3,4,5,6,7,8,9};
    String []nullArray = null;
    Map<String, Integer> mMap = new HashMap<String, Integer>();

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
        mObjectLengthValidators = new ObjectLengthValidator();

        for (String a : array) {
            Integer freq = mMap.get(a);
            mMap.put(a, (freq == null) ? 1 : freq + 1);
        }

    }

    @SmallTest
    public void testForPredicateAndCheker(){
        assertEquals(true, mObjectLengthValidators.isObjectLengthInRange(list, 2, 9));
        assertEquals(true, mObjectLengthValidators.isObjectLengthInRange(array, 1, 11));
        assertEquals(true, mObjectLengthValidators.isObjectLengthInRange(intArray, 8, 10));
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(list, 2, 9).isEmpty());
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(array, 1, 10).isEmpty());
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(intArray, 8, 10).isEmpty());
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



   // @SmallTest
    //public void testForJsonObject() throws JSONException {
     //   String jsonObjectText="{\"Accept-Language\": \"en-US,en;q=0.8\",\"Host\": \"headers.jsontest.com\",\"Accept-Charset\": \"ISO-8859-1,utf-8;q=0.7,​*;q=0.3\",\"Accept\": \"text/html,application/xhtml+xml,application/xml;q=0.9,*/*​;q=0.8\"}";
      //  JSONObject jsonObject = new JSONObject(jsonObjectText);
        //assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, mObjectLengthValidators.checkObjectLengthInRange(jsonObject, 12, 20).get(0));
      //  assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(jsonObject, 1, 4).get(0));
   // }


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

    public void testForMap() {
        //mMap is an object of nine
        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(mMap, 8, 10).isEmpty());
        assertEquals(ValidatorConstant.ERR_NUM_INVALID_RANGE, mObjectLengthValidators.checkObjectLengthInRange(mMap, 11, 10).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MIN, mObjectLengthValidators.checkObjectLengthInRange(mMap, 11, 13).get(0));
        assertEquals(ValidatorConstant.ERR_NUM_RANGE_MAX, mObjectLengthValidators.checkObjectLengthInRange(mMap, 7, 8).get(0));
    }

    /*public void testForJsonArray(){
        String jsonArray = "[{\"name\":\"IMG_20130403_140457.jpg\"},{\"name\":\"IMG_20130403_145006.jpg\"}," +
                "{\"name\":\"IMG_20130403_145112.jpg\"},{\"name\":\"IMG_20130404_085559.jpg\"}," +
                "{\"name\":\"IMG_20130404_113700.jpg\"},{\"name\":\"IMG_20130404_113713.jpg\"}," +
                "{\"name\":\"IMG_20130404_135706.jpg\"},{\"name\":\"IMG_20130404_161501.jpg\"}," +
                "{\"name\":\"IMG_20130405_082413.jpg\"},{\"name\":\"IMG_20130405_104212.jpg\"}," +
                "{\"name\":\"IMG_20130405_160524.jpg\"},{\"name\":\"IMG_20130408_082456.jpg\"},{\"name\":\"test.jpg\"}]";
        try {
            JSONArray jsonArrayObject = new JSONArray(jsonArray);
            assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(jsonArrayObject, 0, 20).get(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        assertEquals(true, mObjectLengthValidators.checkObjectLengthInRange(gson.toJson(jsonArray), 1, 2).get(0));
    }*/

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

