package com.wdpr.validator.android;

import android.test.suitebuilder.annotation.SmallTest;

import com.wdpr.validator.android.EmailValidator;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/13/15.
 */
public class EmailVaildatorTest extends TestCase{

    static final String invalidLengthEmail ="vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv@vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv" +
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
            "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkakaaaakaaaaaaaaaaaaaaaaaaaaaaa.ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt";

    static final String invalidLenghtDomain = "vvvvvvvvvvvvvvveeeeeeeeeeeennnnnnnnnnnnnnnnnkkkkkkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaattttttttttttttttttttttttttttttttttttttttttttttttttttttttvip@gmail.com";

    static final String nullString = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testForValidEmail(){
       String result = EmailValidator.checkEmail("venkyg@gmail.com");
        assertEquals("200", result);
    }

    @SmallTest
    public void testForEmptyLocal(){
        assertEquals("107", EmailValidator.checkEmail("@gmail.com"));
    }

    @SmallTest
    public void testForMultipleAtTheRateSymbols(){
        assertEquals("106", EmailValidator.checkEmail("venky@vip@xsm.com"));
    }

    @SmallTest
    public void testForEmailEndingWithDot(){
        assertEquals("111",EmailValidator.checkEmail("venky@xsm.com."));
    }

    @SmallTest
    public void testForEmailStartingWithDot(){
        assertEquals("111",EmailValidator.checkEmail(".venky@vip@xsm.com"));
    }


    @SmallTest
    public void testForRepeatingDots(){
        assertEquals("112",EmailValidator.checkEmail("venky..vip@xsm.com"));
    }

    @SmallTest
    public void testForEmailWithSubdomain(){
        assertEquals("200",EmailValidator.checkEmail("example@domain.subdomain.com"));
    }

    @SmallTest
    public void testForInvalidDomainLenth(){
        assertEquals("108",EmailValidator.checkEmail(invalidLenghtDomain));
    }

    @SmallTest
    public void testForEmptyEmail(){
        assertEquals("100",EmailValidator.checkEmail(""));
    }

   /* @SmallTest
    public void testForNullEmail(){
        assertEquals("113",EmailValidator.checkEmail(nullString));
    }*/


    @SmallTest
    public void testForInvalidEmailLenth(){
        assertEquals("105",EmailValidator.checkEmail(invalidLengthEmail));
    }

    @SmallTest
    public void testForMissingAtTheRateSymbol(){
        assertEquals("110",EmailValidator.checkEmail("venkygmail.com"));
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
