package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class PrimitiveValidator
{
    private static final String ERR_ARRAY = "ERR_ARRAY";

    private static final String ERR_EMPTY_INPUT = "ERR_EMPTY_INPUT";

    private static final String ERR_STRING = "ERR_STRING";

    private static final String BOOLEAN_FALSE = "false";

    private static final String BOOLEAN_TRUE = "true";

    /**
     * @Description Array Predicate to check for an array.
     * @param arrayObject
     * @return boolean (True | False)
     */
    public boolean isAnArray(final Object arrayObject)
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
    public List<String> arrayChecker(final Object object)
    {
        List<String> arrayList = new ArrayList<>();
        if (object != null)
        {
            if (!this.isAnArray(object))
            {
                arrayList.add(ERR_ARRAY);
            }
        }
        else
        {
            arrayList.add(ERR_EMPTY_INPUT);
        }
        return arrayList;
    }

    /**
     * @Description String Predicate to check for a String.
     * @param
     * @return boolean (True | False)
     */
    public boolean isAString(final Object stringObject)
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
    public List<String> stringChecker(final Object stringObject)
    {
        final List<String> arrayList = new ArrayList<>();
        if (stringObject != null && !stringObject.equals(""))
        {
            if (!(stringObject instanceof String))
            {
                arrayList.add(ERR_STRING);
            }
        }
        else
        {
            arrayList.add(ERR_EMPTY_INPUT);
        }
        return arrayList;
    }

    /**
     * boolean predicate
     * @param value
     * @return boolean
     */
    public boolean booleanPredicate(final String value){

        boolean result = false;

        if(value != null && !value.isEmpty())
        {
            if(BOOLEAN_FALSE.equalsIgnoreCase(value) || BOOLEAN_TRUE.equalsIgnoreCase(value))
            {
                result = true;
            }
        }
        return result;
    }

    /**
     * boolean checker
     * @param value
     * @return List
     */
    public List<String> booleanChecker(final String value){

        final List<String> errorList = new ArrayList<>();

        if(value != null && !value.isEmpty())
        {
            if (!booleanPredicate(value))
            {
                errorList.add(ValidatorConstant.ERR_BOOL);
            }
        }
        else{
            errorList.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }

        return errorList;
    }
}
