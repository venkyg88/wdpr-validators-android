package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;
import java.util.List;
import com.disney.android.wdprvalidators.*;
import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/13/15.
 */
public class EmailValidatorTest extends TestCase{

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
        assertEquals(0, emailObj.checkEmail("venkyg@gmail.com").size());
    }

    @SmallTest
    public void testForEmptyLocal(){
        String email = "@gmail.com";
        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMAIL_LEN_LOCAL",result.get(0));
    }

    @SmallTest
    public void testForMultipleAtTheRateSymbols(){
        String email = "venky@vip@xsm.com";
        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMAIL_INVALID_AT",result.get(0));
    }

    @SmallTest
    public void testForEmailEndingWithDot(){
        String email = "venky@xsm.com.";
        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMAIL_END_DOT",result.get(0));
    }

    @SmallTest
    public void testForEmailStartingWithDot(){
        String email = ".venky@vip@xsm.com";
        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMAIL_STRT_DOT",result.get(0));
    }


    @SmallTest
    public void testForRepeatingDots(){
        String email = "venky..vip@xsm.com";
        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMAIL_DBL_DOT",result.get(0));
    }

    @SmallTest
    public void testForEmailWithSubdomain(){
        assertEquals(0,emailObj.checkEmail("example@domain.subdomain.com").size());
    }


    @SmallTest
    public void testForEmptyEmail(){
        String email = "";
        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMPTY_INPUT",result.get(0));
    }

    @SmallTest
    public void testForLongLocal(){
        String email = "aaaaaaaaaaaaagithubaaaaaaaaaaaaaaaaa  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@aaaa.123";
        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMAIL_LEN_LOCAL",result.get(0));
        assertEquals("ERR_EMAIL_SPACES",result.get(1));
    }

    @SmallTest
    public void testForOtherError(){
        String email = "aaaaaaaaa@aaaa.123";
        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMAIL_OTHER",result.get(0));
    }

    @SmallTest
    public void testForInvalidEmail(){
        String email = ".jaff..ada@aaaaaaaaaaaaaaaaaaaaaasssssssssssssdddfgggggggggggggggggggghjklmpooooooooooooiiiiiiijnqqqqqqqqqqaaaaaaaaaaaaaaaaaaaaasssssssssssssdddfgggggggggggggggggggghjklmpooooooooooooiiiiiiijnqqqqqqqqqqaaaaaaaaaaaaaaaaaaaaasssssssssssssdddfgggggggggggggggggggghjklmpooooooooooooiiiii.iijnqqqqqqqqqq.";

        List<String> result = emailObj.checkEmail(email);
        assertEquals("ERR_EMAIL_DBL_DOT",result.get(0));
        assertEquals("ERR_EMAIL_STRT_DOT",result.get(1));
        assertEquals("ERR_EMAIL_END_DOT",result.get(2));
        assertEquals("ERR_EMAIL_LEN",result.get(3));
        assertEquals("ERR_HOSTNAME_LEN",result.get(4));
        assertEquals("ERR_HOSTNAME_TLD_LEN",result.get(5));
        assertEquals("ERR_HOSTNAME_SUBDOMAIN_LEN",result.get(6));
        assertEquals("ERR_HOSTNAME_TLD",result.get(7));
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}