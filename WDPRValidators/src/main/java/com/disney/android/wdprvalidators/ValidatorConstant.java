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
    /************************* URL exceeds max length (2048) *********************************/
    public static final String ERR_URL_LEN = "ERR_URL_LEN";
    /************************* URL scheme does not match *************************************/
    public static final String ERR_URL_SCHEME = "ERR_URL_SCHEME";
    /************************* URL RegExp pattern fails **************************************/
    public static final String ERR_URL_OTHER = "ERR_URL_OTHER";
    /*************************  Hostname has invalid length (256) ****************************/
    public static final String ERR_HOSTNAME_LEN = "ERR_HOSTNAME_LEN";
    /************************* Hostname TLD is of invalid length (2-20) **********************/
    public static final String ERR_HOSTNAME_TLD_LEN = "ERR_HOSTNAME_TLD_LEN";
    /************************* Hostname subdomain has invalid length(63) *********************/
    public static final String ERR_HOSTNAME_SUBDOMAIN_LEN = "ERR_HOSTNAME_SUBDOMAIN_LEN";
    /************************* Hostname is missing a TLD *************************************/
    public static final String ERR_HOSTNAME_TLD = "ERR_HOSTNAME_TLD";
    /************************* Hostname is an IP Address which is invalid ********************/
    public static final String ERR_HOSTNAME_IP = "ERR_HOSTNAME_IP";
    /************************* Hostname RegExp/validation fails ******************************/
    public static final String ERR_HOSTNAME_OTHER = "ERR_HOSTNAME_OTHER";
    /************************* Input not a BOOL **********************************************/
    public static final String ERR_BOOL = "ERR_BOOL";
    /************************* Password string doesn't contain minimum string length (6) *****/
    public static final String ERR_PASSWORD_MIN_LEN = "ERR_PASSWORD_MIN_LEN";
    /********* Password string contain more characters than maximum allowed length (25) ******/
    public static final String ERR_PASSWORD_MAX_LEN = "ERR_PASSWORD_MAX_LEN";
    /**** Password string should contain atleast 2 categories to meet Password strength ******/
    public static final String ERR_PASSWORD_STRENGTH = "ERR_PASSWORD_STRENGTH";
    /************************* Invalid Character(s) ******************************************/
    public static final String ERR_PASSWORD_OTHER ="ERR_PASSWORD_OTHER";
    /*********************** Unchecked check fails *******************************************/
    public static final String ERR_UNCHECK = "ERR_UNCHECK";
    /************************* Input not a number ********************************************/
    public static final String ERR_NUM = "ERR_NUM";
    /************************* Number fails with lower limit bound ***************************/
    public static final String ERR_NUM_RANGE_MIN ="ERR_NUM_RANGE_MIN";
    /************************* Number fails with upper limit bound ***************************/
    public static final String ERR_NUM_RANGE_MAX = "ERR_NUM_RANGE_MAX";
    /************************* Invalid number range entries **********************************/
    public static final String ERR_NUM_INVALID_RANGE = "ERR_NUM_INVALID_RANGE";
    /************************* Input not an object *******************************************/
    public static final String ERR_OBJECT = "ERR_OBJECT";
     /**
     *
     */
    private ValidatorConstant()
    {
    }
}
