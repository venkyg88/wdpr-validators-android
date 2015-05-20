package com.example.venkatgonuguntala.emailvalidator;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/13/15.
 */
public class EmailVaildatorClassTest extends TestCase{

    static final String invalidLengthEmail ="vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv@vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv" +
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" +
            "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkakaaaakaaaaaaaaaaaaaaaaaaaaaaa.ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt";

    static final String invalidLenghtDomain = "vvvvvvvvvvvvvvveeeeeeeeeeeennnnnnnnnnnnnnnnnkkkkkkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaattttttttttttttttttttttttttttttttttttttttttttttttttttttttvip@gmail.com";
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testForValidEmail(){
       String result = EmailValidatorClass.checkEmail("venkyg@gmail.com");
        assertEquals("200", result);
    }

    @SmallTest
    public void testForEmptyLocal(){
        assertEquals("107", EmailValidatorClass.checkEmail("@gmail.com"));
    }

    @SmallTest
    public void testForMultipleAtTheRateSymbols(){
        assertEquals("106", EmailValidatorClass.checkEmail("venky@vip@xsm.com"));
    }

    @SmallTest
    public void testForEmailEndingWithDot(){
        assertEquals("111",EmailValidatorClass.checkEmail("venky@xsm.com."));
    }

    @SmallTest
    public void testForEmailStartingWithDot(){
        assertEquals("111",EmailValidatorClass.checkEmail(".venky@vip@xsm.com"));
    }

    @SmallTest
    public void testForRepeatingDots(){
        assertEquals("112",EmailValidatorClass.checkEmail("venky..vip@xsm.com"));
    }

    @SmallTest
    public void testForEmailWithSubdomain(){
        assertEquals("200",EmailValidatorClass.checkEmail("example@domain.subdomain.com"));
    }

    @SmallTest
    public void testForInvalidDomainLenth(){
        assertEquals("108",EmailValidatorClass.checkEmail(invalidLenghtDomain));
    }

    @SmallTest
    public void testForEmptyEmail(){
        assertEquals("100",EmailValidatorClass.checkEmail(""));
    }

    @SmallTest
    public void testForInvalidEmailLenth(){
        assertEquals("105",EmailValidatorClass.checkEmail(invalidLengthEmail));
    }

    @SmallTest
    public void testForMissingAtTheRateSymbol(){
        assertEquals("110",EmailValidatorClass.checkEmail("venkygmail.com"));
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
