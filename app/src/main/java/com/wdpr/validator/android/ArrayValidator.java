package com.wdpr.validator.android;

/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class ArrayValidator {

    public static boolean isAnArray(Object arrayObject){
        if(arrayObject != null) {
            if (arrayObject.getClass().isArray()) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }

    }
}
