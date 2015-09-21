package com.disney.android.wdprvalidators;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
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
            if (number instanceof String)
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

    /**
     * predicate method which takes in three parameters upper bound, lower bound, and user input and
     * returns true if user input falls in the range of lower and upper bound inclusively.
     * @param input
     * @param lower
     * @param upper
     * @return boolean
     */
    public boolean isNumberRange(final Object input, final Object lower, final Object upper)
    {
        boolean result = false;
        final BigDecimal nInput = getNumber(input);
        final BigDecimal nLower = getNumber(lower);
        final BigDecimal nUpper = getNumber(upper);
        if (nInput != null && nLower != null && nUpper != null)
        {
            if (nInput.compareTo(nLower) >= 0 && nInput.compareTo(nUpper) <= 0 && nLower.compareTo(nUpper) <= 0)
            {
                result = true;
            }
        }
        return result;
    }

    private BigDecimal getNumber(Object object) throws NumberFormatException
    {
        if (object instanceof String)
        {
            final String sObject = object.toString();
            if (NumberUtils.isNumber(sObject))
            {
                return new BigDecimal(NumberUtils.createNumber(sObject.toString()).toString());
            }
        }
        if (object instanceof Number)
        {
            return new BigDecimal(object.toString());
        }
        else
        {
            return null;
        }
    }


    /**
     * checker method which returns empty list when the input falls in between lower and upper bound
     * inclusively otherwise return a list of applicable error code/codes.
     * @param input
     * @param lower
     * @param upper
     * @return List<String>
     */
    public List<String> checkNumberRange(final Object input, final Object lower, final Object upper)
    {
        List<String> list = new ArrayList<>();
        if (input == null || lower == null || upper == null)
        {
            list.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        else
        {
            final BigDecimal nInput = getNumber(input);
            final BigDecimal nLower = getNumber(lower);
            final BigDecimal nUpper = getNumber(upper);
            if(nInput != null && nLower != null && nUpper != null)
            {
                if (nLower.compareTo(nUpper) > 0)
                {
                    list.add(ValidatorConstant.ERR_NUM_INVALID_RANGE);
                }
                if (nInput.compareTo(nUpper) > 0)
                {
                    list.add(ValidatorConstant.ERR_NUM_RANGE_MAX);
                }
                if (nInput.compareTo(nLower) < 0)
                {
                    list.add(ValidatorConstant.ERR_NUM_RANGE_MIN);
                }
            }
            else
            {
                list.add(ValidatorConstant.ERR_NUM);
            }
        }
        return list;
    }

}
