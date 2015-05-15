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
    public void test1(){
       String result = EmailValidatorClass.checkEmail("venkyg@gmail.com");
        assertEquals("200", result);
    }

    @SmallTest
    public void test2(){
        assertEquals("107", EmailValidatorClass.checkEmail("@gmail.com"));
    }

    @SmallTest
    public void test3(){
        assertEquals("106", EmailValidatorClass.checkEmail("venky@vip@xsm.com"));
    }

    @SmallTest
    public void test4(){
        assertEquals("111",EmailValidatorClass.checkEmail("venky@xsm.com."));
    }

    @SmallTest
    public void test5(){
        assertEquals("111",EmailValidatorClass.checkEmail(".venky@vip@xsm.com"));
    }

    @SmallTest
    public void test6(){
        assertEquals("111",EmailValidatorClass.checkEmail("venky@xsm.com."));
    }

    @SmallTest
    public void test7(){
        assertEquals("112",EmailValidatorClass.checkEmail("venky..vip@xsm.com"));
    }

    @SmallTest
    public void test8(){
        assertEquals("200",EmailValidatorClass.checkEmail("example@domain.subdomain.com"));
    }

    @SmallTest
    public void test9(){
        assertEquals("108",EmailValidatorClass.checkEmail(invalidLenghtDomain));
    }

    @SmallTest
    public void test10(){
        assertEquals("100",EmailValidatorClass.checkEmail(""));
    }

    @SmallTest
    public void test11(){
        assertEquals("105",EmailValidatorClass.checkEmail(invalidLengthEmail));
    }

    @SmallTest
    public void test12(){
        assertEquals("110",EmailValidatorClass.checkEmail("venkygmail.com"));
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
