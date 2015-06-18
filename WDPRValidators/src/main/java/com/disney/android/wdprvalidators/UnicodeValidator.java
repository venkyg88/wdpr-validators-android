package com.disney.android.wdprvalidators;

import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/24/15.
 */
public class UnicodeValidator{

    private static final String UNICODE_PATTERN = "^[\\p{L}\\p{M}\\p{N}\\p{Z}\\p{P}]*$";

    private static Pattern pattern = Pattern.compile(UNICODE_PATTERN);

    /**
     * @desc Public method to validate input as Unicode String / Charatcer (TRUE | FALSE). It accepts UTF-8 based chacratcer including international language
     * @param  value
     * @return Boolean (true | false)
     */
    public boolean aUnicodeString(final String value){
        boolean result = false;
        if (pattern.matcher(value).matches()) {
            result = true;
        }
        return result;
    }
}