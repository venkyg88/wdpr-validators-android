package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by venkatgonuguntala on 10/14/15.
 */

public class ArrayContentsValidator {

    /**
     * Predicate method to validate the input array that has the array contents of intended type.
     * The intended type is passed as a `Class` argument.
     * @param objectArray
     * @param arrayType
     * @return boolean
     */
    public boolean isArrayOfIntendedType(final Object objectArray[], final Class arrayType)
    {
        boolean result = false;
        if(objectArray != null)
        {
            for(Object object : objectArray)
            {
                if (object.getClass() != arrayType)
                {
                    result = false;
                    break;
                }
                else
                {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Checker method to validate the array contents of the input array, which returns an empty
     * list if the array is of intended `Class` type and a list of applicable error on failure.
     * @param objectArray
     * @param arrayType
     * @return List<String>
     */
    public List<String> checkArrayOfIntendedType(final Object objectArray[], final Class arrayType)
    {
        List<String> list = new ArrayList<>();
        if( objectArray != null)
        {
            if(!isArrayOfIntendedType(objectArray,arrayType))
            {
                list.add(ValidatorConstant.ERR_CONTENTS_MISMATCH);
            }
        }
        else
        {
            list.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        return list;
    }
}
