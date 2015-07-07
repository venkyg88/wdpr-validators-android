package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class PrimitiveValidator
{
    /**
     * @Description Array Predicate to check for an array.
     * @param arrayObject
     * @return boolean (True | False)
     */
    public boolean isAnArray(Object arrayObject)
    {
        boolean result = false;
        if ( arrayObject != null )
        {
            if (arrayObject.getClass().isArray())
            {
                result = true;
            }
        }
        return result;
    }

    /**
     * @Description Array checker funtion
     * @param object
     * @return String
     */
    public List<String> arrayChecker(Object object)
    {
        List<String> arrayList = new ArrayList<>();
        if (object != null)
        {
            if (!isAnArray(object))
            {
                arrayList.add("ERR_ARRAY");
            }
        }
        else
        {
            arrayList.add("ERR_EMPTY_INPUT");
        }
        return arrayList;
    }

    /**
     * @Description String Predicate to check for a String.
     * @param
     * @return boolean (True | False)
     */
    public boolean isAString(Object stringObject)
    {
        boolean result = false;
        if (stringObject != null)
        {
            if (stringObject.getClass() == String.class)
            {
                result = true;
            }
        }
        return result;
    }

    /**
     * @Description String checker funtion
     * @param stringObject
     * @return string
     */
    public List<String> stringChecker(Object stringObject)
    {
        List<String> arrayList = new ArrayList<>();
        if (stringObject != null && !stringObject.equals(""))
        {
            if (stringObject.getClass() != String.class)
            {
                arrayList.add("ERR_STRING");
            }
        }
        else
        {
            arrayList.add("ERR_EMPTY_INPUT");
        }
        return arrayList;
    }
}
