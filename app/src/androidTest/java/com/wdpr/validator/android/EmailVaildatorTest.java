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

    EmailValidator emailObj = new EmailValidator();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testForValidEmail(){
       String result = emailObj.checkEmail("venkyg@gmail.com");
        assertEquals("200", result);
    }

    @SmallTest
    public void testForEmptyLocal(){
        assertEquals("107", emailObj.checkEmail("@gmail.com"));
    }

    @SmallTest
    public void testForMultipleAtTheRateSymbols(){
        assertEquals("106", emailObj.checkEmail("venky@vip@xsm.com"));
    }

    @SmallTest
    public void testForEmailEndingWithDot(){
        assertEquals("111",emailObj.checkEmail("venky@xsm.com."));
    }

    @SmallTest
    public void testForEmailStartingWithDot(){
        assertEquals("111",emailObj.checkEmail(".venky@vip@xsm.com"));
    }


    @SmallTest
    public void testForRepeatingDots(){
        assertEquals("112",emailObj.checkEmail("venky..vip@xsm.com"));
    }

    @SmallTest
    public void testForEmailWithSubdomain(){
        assertEquals("200",emailObj.checkEmail("example@domain.subdomain.com"));
    }

    @SmallTest
    public void testForInvalidDomainLenth(){
        assertEquals("108",emailObj.checkEmail(invalidLenghtDomain));
    }

    @SmallTest
    public void testForEmptyEmail(){
        assertEquals("100",emailObj.checkEmail(""));
    }

    @SmallTest
    public void testForInvalidEmailLenth(){
        assertEquals("105",emailObj.checkEmail(invalidLengthEmail));
    }

    @SmallTest
    public void testForMissingAtTheRateSymbol(){
        assertEquals("110",emailObj.checkEmail("venkygmail.com"));
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
