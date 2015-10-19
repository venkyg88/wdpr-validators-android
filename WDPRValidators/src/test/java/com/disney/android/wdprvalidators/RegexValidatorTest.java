package com.disney.android.wdprvalidators;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 10/8/15.
 */
public class RegexValidatorTest extends TestCase {

    private RegexValidator mRegexValidator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mRegexValidator = new RegexValidator();
    }

    public void testForEmailRegex(){
        String inputPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        assertEquals(true, mRegexValidator.isRegex(inputPattern));
        assertEquals(true, mRegexValidator.checkRegex(inputPattern).isEmpty());
    }

    public void testForInvalidEmailRegex(){
        String inputPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        assertEquals(false, mRegexValidator.isRegex(inputPattern));
        assertEquals(false, mRegexValidator.checkRegex(inputPattern).isEmpty());
        assertEquals(ValidatorConstant.ERR_REGEXP, mRegexValidator.checkRegex(inputPattern).get(0));
    }

    public void testForHostNameRegex(){
        String inputPattern = "^([a-z0-9][a-z0-9-]{0,63}\\.)+([a-z]{2,20})$";
        assertEquals(true, mRegexValidator.isRegex(inputPattern));
        assertEquals(true, mRegexValidator.checkRegex(inputPattern).isEmpty());
    }

    public void testForInvalidHostNameRegex(){
        String inputPattern = "a-z0-9][a-z0-9-]{0,+([a-z]{2,20})$";
        assertEquals(false, mRegexValidator.isRegex(inputPattern));
        assertEquals(false, mRegexValidator.checkRegex(inputPattern).isEmpty());
        assertEquals(ValidatorConstant.ERR_REGEXP, mRegexValidator.checkRegex(inputPattern).get(0));
    }

    public void testForIPRegex(){
        String inputPattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        assertEquals(true, mRegexValidator.isRegex(inputPattern));
        assertEquals(true, mRegexValidator.checkRegex(inputPattern).isEmpty());
    }

    public void testForInvalidIPRegex(){
        String inputPattern = "^([01]?d?|2[0-4]\\d|25[0-5])\\."
                + "01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-";
        assertEquals(false, mRegexValidator.isRegex(inputPattern));
        assertEquals(false, mRegexValidator.checkRegex(inputPattern).isEmpty());
        assertEquals(ValidatorConstant.ERR_REGEXP, mRegexValidator.checkRegex(inputPattern).get(0));
    }

    public void testForURLRegex(){
        String inputPattern = "\\b(https|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        assertEquals(true, mRegexValidator.isRegex(inputPattern));
        assertEquals(true, mRegexValidator.checkRegex(inputPattern).isEmpty());
    }


    public void testForInvalidURLRegex(){
        String inputPattern = "\\b(https|h://[-a-zA-Z0-9+&@#/%?=~_|!:,.*[-a-zA-Z0-9+&@#/%=~_|]";
        assertEquals(false, mRegexValidator.isRegex(inputPattern));
        assertEquals(false, mRegexValidator.checkRegex(inputPattern).isEmpty());
        assertEquals(ValidatorConstant.ERR_REGEXP, mRegexValidator.checkRegex(inputPattern).get(0));
    }

    public void testForPasswordRegex(){
        String inputPattern = "^[A-Za-z0-9!<#%{}|\\^~\\]\\[`;\\/\\?:@=\\_\\-\\.&\\\\]+$";
        assertEquals(true, mRegexValidator.isRegex(inputPattern));
        assertEquals(true, mRegexValidator.checkRegex(inputPattern).isEmpty());
    }

    public void testForInvalidPasswordRegex(){
        String inputPattern = "^[A-Za-z0-9!<#%{}|\\/\\?:@=\\_\\-\\.&\\\\";
        assertEquals(false, mRegexValidator.isRegex(inputPattern));
        assertEquals(false, mRegexValidator.checkRegex(inputPattern).isEmpty());
        assertEquals(ValidatorConstant.ERR_REGEXP, mRegexValidator.checkRegex(inputPattern).get(0));
    }

    public void testForEmptyInput(){
        assertEquals(false, mRegexValidator.isRegex(null));
        assertEquals(false, mRegexValidator.checkRegex(null).isEmpty());
        assertEquals(false, mRegexValidator.isRegex(""));
        assertEquals(false, mRegexValidator.checkRegex("").isEmpty());
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, mRegexValidator.checkRegex("").get(0));
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
