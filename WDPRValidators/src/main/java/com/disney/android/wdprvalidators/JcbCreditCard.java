package com.disney.android.wdprvalidators;

import java.util.regex.Pattern;
/**
 * Created by venkatgonuguntala on 7/26/15.
 */

public class JcbCreditCard
{
    /**
     *
     * @param card
     * @return
     */
    public boolean matches(final String card)
    {
        return Pattern.compile("^(?:2131|1800|35\\d{3})\\d{11}$").matcher(card).matches();
    }

}
