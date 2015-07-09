package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/21/15.
 */
public class DateValidator
{

    private static final String DATE_PATTERN = "^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?$";

    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);

    /**
     * @description Validate date format with regular expression
     * @param date date address for validation
     * @return true valid date format, false invalid date format
     */
    public boolean isISO8601(CharSequence date)
    {
        boolean result = false;
        if(pattern.matcher(date).matches())
        {
            result = true;
        }
        return result;
    }

    /**
     * @desc Method to validate valid ISO8601 Date and return message and code as Array. alphanumric charcter, Hyphen(-), Colon (:)
     * @param date
     * @return List of Strings
     */
    public List<String> checkIsoDate(final String date)
    {
        final List<String> isoList = new ArrayList<>();
        if(date != null )
        {
            final int datelen = date.length();
            //condition to check empty input which is not null.
            if (datelen == 0)
            {
                isoList.add("ERR_EMPTY_INPUT");
            }
            else if (!this.isISO8601(date))
            {
                isoList.add("ERR_ISO_DATE");
            }
        }
        else
        {
            isoList.add("ERR_EMPTY_INPUT");
        }
        return isoList;
    }

    /**
     * @description Method to validate date range.
     * @param startDate in YYYY-MM-DD format/NULL
     * @param endDate in YYYY-MM-DD format
     * @param userDate in YYYY-MM-DD format
     * @return List of Strings
     */
    public List<String> checkDateRange(final Date startDate, final Date endDate, final Date userDate)
    {
        final List<String> dateRangeList = new ArrayList<>();
        if (startDate != null && endDate != null && userDate != null)
        {
            if (!isInRange(startDate, endDate, userDate))
            {
                if (userDate.before(startDate))
                {
                    dateRangeList.add("ERR_DATE_RANGE_BEFORE");
                }
                if (userDate.after(endDate))
                {
                    dateRangeList.add("ERR_DATE_RANGE_AFTER");
                }
            }
        }
        else
        {
            dateRangeList.add("ERR_EMPTY_INPUT");
        }
        return dateRangeList;
    }

    /**
     * @description validate date range inclusively with Java built-in funtions before & after
     * @param startDate
     * @param endDate
     * @param userDate
     * @return boolean
     */
    private boolean isInRange(final Date startDate, final Date endDate, final Date userDate)
    {
        return !userDate.before(startDate) && !userDate.after(endDate);
    }
}
