package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by venkatgonuguntala on 10/14/15.
 */

//TODO: Null check for both the methods.

public class ArrayContentsValidator {

    public boolean isArrayOfIntendedType(Object objectArray[], Class arrayType)
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

    public List<String> checkArrayOfIntendedType(Object objectArray[], Class arrayType)
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
