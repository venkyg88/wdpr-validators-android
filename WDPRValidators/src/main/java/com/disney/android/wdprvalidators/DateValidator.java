package com.disney.android.wdprvalidators;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/21/15.
 */
public class DateValidator {

    private static final String DATE_PATTERN =
            "^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?$";

    private static Pattern pattern = Pattern.compile(DATE_PATTERN);

    /**
     * @description Validate date format with regular expression
     * @param date date address for validation
     * @return true valid date format, false invalid date format
     */
    public boolean isISO8601(final String date){
        boolean result = false;
        if(pattern.matcher(date).matches()){
            result = true;
        }
        return result;
    }

    /**
     * @desc Method to validate valid ISO8601 Date and return message and code as Array. alphanumric charcter, Hyphen(-), Colon (:)
     * @param date
     * @return Array key and value about status
     */
    public String checkIsoDate(String date){
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

    /**
     * @description Method to validate date range.
     * @param startDate in YYYY-MM-DD format/NULL
     * @param endDate in YYYY-MM-DD format
     * @param userDate in YYYY-MM-DD format
     * @return Array key and value about status
     */
    public String checkDateRange(Date startDate,Date endDate, Date userDate) throws ParseException {
        if (startDate == null) {
            startDate = new Date();
        }

        String result = "102";
        if(startDate!=null && endDate!=null && userDate!=null) {
            //Then perform the main operation to check whether the userdate falls in between the start and end date
            if(isInRange(startDate,endDate,userDate) == true){
                result="200";
            }
        }
        return result;
    }

    /**
     * @description validate date range inclusively with Java built-in funtions before & after
     * @param startDate
     * @param endDate
     * @param userDate
     * @return boolean
     */
    private boolean isInRange(Date startDate, Date endDate, Date userDate) {
        return !userDate.before(startDate) && !userDate.after(endDate);
    }
}
