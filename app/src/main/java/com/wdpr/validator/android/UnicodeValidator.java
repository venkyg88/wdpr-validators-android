package com.wdpr.validator.android;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/24/15.
 */
public class UnicodeValidator{

    private static final String UNICODE_PATTERN =
            "^[\\p{L}\\p{M}\\p{N}\\p{Z}\\p{P}]*$/u";

    /**
     * @desc Public method to validate input as Unicode String / Charatcer (TRUE | FALSE). It accepts UTF-8 based chacratcer including international language
     * @param  value
     * @return Boolean (true | false)
     */

    public boolean aUnicodeString(String value){Pattern pattern = Pattern.compile(UNICODE_PATTERN);
        //Pattern pattern =Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(value);
        if(value!=null) {
            if (matcher.matches()) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }

    }

}
