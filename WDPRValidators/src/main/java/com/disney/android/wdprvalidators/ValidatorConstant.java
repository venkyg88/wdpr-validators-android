package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 7/26/15.
 */
public final class ValidatorConstant
{
    /*************************** Empty inputs found ******************************************/
    public static final String ERR_EMPTY_INPUT = "ERR_EMPTY_INPUT";
    /************************ Credit Card RegExp Pattern Fails *******************************/
    public static final String ERR_CC_OTHER =   "ERR_CC_OTHER";
    /************************* Invalid Length ************************************************/
    public static final String ERR_CC_LEN = "ERR_CC_LEN";
    /************************* Credit Card failed Luhn check *********************************/
    public static final String ERR_CC_LUHN = "ERR_CC_LUHN";
    /************************* Credit Card is expired ****************************************/
    public static final String ERR_CC_EXP = "ERR_CC_EXP";
    /**
     *
     */
    private ValidatorConstant()
    {
    }
}
