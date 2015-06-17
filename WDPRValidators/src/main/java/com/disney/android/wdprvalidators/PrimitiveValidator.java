package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class PrimitiveValidator {

    /**
     * @Description Array Predicate to check for an array.
     * @param arrayObject
     * @return boolean (True | False)
     */
    public boolean isAnArray(Object arrayObject){
        boolean result = false;
        if(arrayObject != null) {
            if (arrayObject.getClass().isArray()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @Description String Predicate to check for a String.
     * @param
     * @return boolean (True | False)
     */
    public boolean isAString(Object stringObject){
        boolean result = false;
        if(stringObject != null) {
            if (stringObject.getClass() == String.class) {
                result = true;
            }
        }
        return result;
    }
}
