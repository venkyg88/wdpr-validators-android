package com.disney.android.wdprvalidators;

import org.apache.commons.lang3.math.NumberUtils;

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
     * predicate method to determine where or not the input is a valid boolean input.
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
     * Checker method to determine where or not the input is a valid boolean input.
     * @param value
     * @return List
     */
    public List<String> booleanChecker(final String value){

        final List<String> errorList = new ArrayList<>();

        if(value != null && !value.isEmpty())
        {
            if (!(BOOLEAN_FALSE.equalsIgnoreCase(value) || BOOLEAN_TRUE.equalsIgnoreCase(value)))
            {
                errorList.add(ValidatorConstant.ERR_BOOL);
            }
        }
        else{
            errorList.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }

        return errorList;
    }

    /**
     * Unchecked predicate method which always returns true
     * @return true
     */

    public boolean isUncheked(){
        return true;
    }

    /**
     * checker method for unchecked to return a error message if at all it fails to return true otherwise return false
     * @return
     */
    public List<String> checkUnchecked()
    {
        List<String> errorList = new ArrayList<>();
        if(!isUncheked())
        {
            errorList.add(ValidatorConstant.ERR_UNCHECK);
        }
        return errorList;
    }


    /**
     * Predicate method to determine whether input value is a Number(that is Byte, Short, Integer, Long, Float, and Double)
     * and also supports if the Number is passed in the form of string.
     * @param number
     * @return boolean
     */
    public boolean isNumber(final Object number)
    {
        boolean result = false;
        if(number != null)
        {
            if(number instanceof Number)
            {
                result = true;
            }
            else if(number instanceof String)
            {
                final String mNumber = number.toString();
                if(!mNumber.isEmpty())
                {
                    try
                    {
                        NumberUtils.createNumber(mNumber);
                        result = true;
                    }
                    catch (NumberFormatException e)
                    {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Checker method to determine whether the input is a number and return empty list on success otherwise return a list of error messages on failure.
     * @param number
     * @return List<String>
     */
    public List<String> checkNumber(final Object number)
    {
        List<String> list = new ArrayList<>();
        boolean flag = false;
        if(number == null)
        {
            list.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        else
        {
            if(!isNumber(number))
            {
                if(number instanceof String)
                {
                    final String mNumber = number.toString();
                    if(mNumber.isEmpty())
                    {
                        list.add(ValidatorConstant.ERR_EMPTY_INPUT);
                        flag = true;
                    }
                }
                if(!flag)
                {
                    list.add(ValidatorConstant.ERR_NUM);
                }
            }
        }
        return list;
    }
}
