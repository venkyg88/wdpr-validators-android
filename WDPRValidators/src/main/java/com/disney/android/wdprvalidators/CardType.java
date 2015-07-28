package com.disney.android.wdprvalidators;

import java.util.regex.Pattern;
/**
 * Created by venkatgonuguntala on 7/20/15.
 */

public enum CardType
{
    UNKNOWN, VISA("^4[0-9]*$"),
    MASTERCARD("^5[1-5][0-9]*$"),
    AMEX("^3[47][0-9]*$"),
    DINERS("^3(?:0[0-5]|[68])[0-9]*$"),
    DISCOVER("^6(?:011|5)[0-9]*$"),
    JCB("^(?:2131|1800|35)[0-9]*$");


    final transient private Pattern pattern;
    /**
     *
     */
    CardType()
    {
        this.pattern = null;
    }

    /**
     *
     * @param pattern
     */
    CardType(final String pattern)
    {
        this.pattern = Pattern.compile(pattern);
    }

    /**
     *
     * @param cardNumber
     * @return
     */
    public static CardType getCardType(final String cardNumber)
    {

        for (final CardType cardType : CardType.values())
        {
            if (null == cardType.pattern)
            {
                continue;
            }
            if (cardType.pattern.matcher(cardNumber).matches())
            {
                return cardType;
            }
        }
        return UNKNOWN;
    }
}
