package com.disney.android.wdprvalidators;

import android.util.Log;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by venkatgonuguntala on 10/8/15.
 */
public class RegexValidator
{
    public boolean isRegex(String inputPattern)
    {
        boolean result = false;
        if (StringUtils.isNotEmpty(inputPattern))
        {
            try
            {
                Pattern.compile(inputPattern);
                result = true;
            }
            catch (PatternSyntaxException exception)
            {
                Log.e("RegexValidator", exception.getDescription());
            }
        }
        return result;
    }


    public List<String> checkRegex(String inputPattern)
    {
        List<String> list = new ArrayList<>();
        if(StringUtils.isNotEmpty(inputPattern))
        {
            if (!isRegex(inputPattern))
            {
                list.add(ValidatorConstant.ERR_REGEXP);
            }
        }
        else
        {
            list.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        return list;
    }
}
