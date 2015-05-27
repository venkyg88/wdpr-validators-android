package com.wdpr.validator.android;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/21/15.
 */
public class DateValidator{

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String DATE_PATTERN =
            "^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?$";


    /**
     * Validate date format with regular expression
     * @param date date address for validation
     * @return true valid date format, false invalid date format
     */
    public static boolean isISO8601(String date){
        pattern = Pattern.compile(DATE_PATTERN);
        matcher = pattern.matcher(date);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    /**
     * @desc Method to validate valid ISO8601 Date and return message and code as Array. alphanumric charcter, Hyphen(-), Colon (:)
     * @param date
     * @return Array key and value about status
     */

    public static String checkIsoDate(String date){
        if(date != null) {
            if (isISO8601(date)) {
                return "200";
            } else {
                return "114";
            }
        }
        else{
            return "114";
        }

    }


}
