package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 10/26/15.
 */
public class MapKeysValidatorTest extends TestCase {

    MapKeysValidator mMapKeysValidator = new MapKeysValidator();
    Map<String,String> map = new HashMap<>();

    Map<String, Integer> emptyMap = new HashMap<>();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        map.put("Amit", "Akshaj");
        map.put("Naren", "Bavisha");
        map.put("KK", "Sanskar");
    }


    public void testForMapKeys(){
        String []stringArray = {"key1", "key2", "key3"};
        String []stringMatchingArray = {"Amit", "Naren", "KK"};
        String []stringEmptyArray = null;

        assertEquals(ValidatorConstant.ERR_MAP_MISSING_KEYS,
                mMapKeysValidator.checkForMapKeys(map, stringArray).get(0));

        assertEquals(ValidatorConstant.ERR_MAP_NO_KEYS,
                mMapKeysValidator.checkForMapKeys(emptyMap, stringMatchingArray).get(0));

        assertEquals(false,
                mMapKeysValidator.hasMapKeys(map, stringArray));

        assertEquals(true, mMapKeysValidator.checkForMapKeys(map, stringMatchingArray).isEmpty());

        assertEquals(true, mMapKeysValidator.hasMapKeys(map, stringMatchingArray));

        assertEquals(false, mMapKeysValidator.hasMapKeys(emptyMap, stringMatchingArray));

        assertEquals(false, mMapKeysValidator.hasMapKeys(map, stringEmptyArray));

    }

    public void testForEmptyMap(){
        Map<String,String> mMap = null;
        String []stringArray = {"key1", "key2", "key3"};
        String []nullArray = null;
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT,
                mMapKeysValidator.checkForMapKeys(mMap, stringArray).get(0));

        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT,
                mMapKeysValidator.checkForMapKeys(map, nullArray).get(0));
    }

    public void testForEmptyArray(){
        String[] stringArray = {};
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT,
                mMapKeysValidator.checkForMapKeys(map, stringArray).get(0));
    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
