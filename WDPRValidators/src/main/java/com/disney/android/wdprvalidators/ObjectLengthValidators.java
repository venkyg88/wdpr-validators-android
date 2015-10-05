package com.disney.android.wdprvalidators;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 9/22/15.
 */

public class ObjectLengthValidators {

    private final PrimitiveValidator mPrimitiveValidator = new PrimitiveValidator();

    public int getObjectLength(Object object)
    {
        int objectLength = -1;

        if (object != null)
        {
            if (mPrimitiveValidator.isAnArray(object))
            {
                objectLength = Array.getLength(object);
            }
            else if (object instanceof Collection<?>)
            {
                objectLength = ((Collection) object).size();
            } else if (object instanceof Map<?, ?>)
            {
                objectLength = ((Map) object).size();
            }
            else if (object instanceof JSONObject) {
                objectLength = ((JSONObject) object).length();
            }
            else if (object instanceof JSONArray)
            {
                objectLength = ((JSONArray) object).length();
            }
            else
            {
                if (object instanceof String)
                {
                    if (!StringUtils.isEmpty(object.toString()))
                    {
                        objectLength = object.getClass().getFields().length;
                    }
                }
                else
                {
                    objectLength = object.getClass().getFields().length;
                }
            }
        }
        return objectLength;
    }


    public boolean isObjectLengthInRange(Object object, int lower, int upper)
    {
        boolean result = false;
        if(object != null && lower >= 0 && upper >= 0 && lower <= upper)
        {
            int objectLength = getObjectLength(object);
            result = mPrimitiveValidator.isNumberInRange(objectLength, lower, upper);
        }
        return result;
    }

    public List<String> checkObjectLengthInRange(Object object, int lower, int upper)
    {
        List<String> list = new ArrayList<>();
        if (object != null)
        {
            if(lower > 0 && upper > 0)
            {
                int objectLength = getObjectLength(object);
                if (objectLength >= 0)
                {
                    list.addAll(mPrimitiveValidator.checkNumberInRange(objectLength, lower, upper));
                }
                else
                {
                    list.add(ValidatorConstant.ERR_OBJECT);
                }
            }
            else
            {
                list.add(ValidatorConstant.ERR_INT_POSITIVE); //ERR_INT_POSITIVE
            }
        }
        else
        {
            list.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        return list;
    }
}