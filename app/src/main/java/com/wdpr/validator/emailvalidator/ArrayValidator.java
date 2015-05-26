package com.wdpr.validator.emailvalidator;

/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class ArrayValidator {

    public static boolean isAnArray(Object o){
        if(o.getClass().isArray()){
            return true;
        }
        else{
            return false;
        }

    }
}
