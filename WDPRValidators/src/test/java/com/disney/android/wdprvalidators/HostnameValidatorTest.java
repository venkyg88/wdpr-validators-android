package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import java.util.List;


/**
 * Created by GONUV001 on 6/22/2015.
 */
public class HostnameValidatorTest extends TestCase {

    HostnameValidation hostnameValidator = new HostnameValidation();


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testForEmptyInput(){
        String hostname = "";
        List<String> result =  hostnameValidator.checkHostName(hostname);
        for (String str : result) {
            assertEquals("ERR_EMPTY_INPUT",str);
        }
    }

    @SmallTest
    public void testForNullHostname(){
        String hostname = null;
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_EMPTY_INPUT",result.get(0));

    }

    @SmallTest
    public void testForValidHostname(){
        String hostname = "disney.com";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals(0,result.size());
    }


    @SmallTest
    public void testForInvalidDomainlength(){
        String hostname = "vqwertyuioplkjhgfdsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaalllllllllrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrllllllltttlllllllllllllllllllll.com";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_LEN",result.get(0));
    }

    @SmallTest
    public void testForMinInvalidDomainLength(){
        String hostname = "a";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_LEN",result.get(0));
    }


    @SmallTest
    public void testForInvalidMinTldLength(){
        String hostname = "disney.n";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_TLD_LEN",result.get(0));
    }

    @SmallTest
    public void testForInvalidLongTldLength(){
        String hostname = "disney.nnnnnnnnnnnnnnnnnnnnnnnn";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_TLD_LEN",result.get(0));
    }

    @SmallTest
    public void testForInvalidDomainAndTld(){
        String hostname = "vqwertyuioplkjhgfdsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaalllllllllllllllllllllllllllllllllllltttlllllllllllllllllllll.c";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_TLD_LEN",result.get(0));
        assertEquals("ERR_HOSTNAME_SUBDOMAIN_LEN",result.get(1));
    }

    @SmallTest
    public void testForInvalidDomain(){
        String hostname ="disney.";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_TLD_LEN",result.get(0));
        assertEquals("ERR_HOSTNAME_TLD", result.get(1));

    }

    @SmallTest
    public void testForNoTld(){
        String hostname = "disney";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_OTHER",result.get(0));
    }

    @SmallTest
    public void testForValidIpAddress(){
        String hostname = "127.0.0.255";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_SUBDOMAIN_LEN",result.get(0));
        assertEquals("ERR_HOSTNAME_IP",result.get(1));
    }

    @SmallTest
    public void testForInValidIpAdress(){
        String hostname = "2222.345.0.1";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_TLD_LEN",result.get(0));
    }

    @SmallTest
    public void testForTldNotBeingNumber(){// If TLD is number the error is handled in the ERROR_HOSTNAME_OTHER.
        String hostname = "disney.123";
        List<String> result = hostnameValidator.checkHostName(hostname);
        assertEquals("ERR_HOSTNAME_OTHER",result.get(0));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
