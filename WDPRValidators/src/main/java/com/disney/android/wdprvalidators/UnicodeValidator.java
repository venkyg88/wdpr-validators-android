package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/24/15.
 */
public class UnicodeValidator{

    private static final String UNICODE_PATTERN = "^[\\p{L}\\p{M}\\p{N}\\p{Z}\\p{P}]*$";

    private static final Pattern pattern = Pattern.compile(UNICODE_PATTERN);

    /**
     * @desc Public method to validate input as Unicode String / Charatcer (TRUE | FALSE). It accepts UTF-8 based chacratcer including international language
     * @param  value
     * @return Boolean (true | false)
     */
    public boolean aUnicodeString(String value)
    {
        boolean result = false;
        if (pattern.matcher(value).matches())
        {
            result = true;
        }
        return result;
    }

    /**
     * @desc checker for Unicode Valdiation
     * @param value
     * @return List
     */
    public List<String> unicodeChecker(String value)
    {
        List<String> unicodeList = new ArrayList<>();
        if(value != null && !value.equals("")){
            unicodeList.add("ERR_UNICODE_STRING");
        }
        else
        {
            unicodeList.add("ERR_EMPTY_INPUT");
        }
        return unicodeList;
    }
}
