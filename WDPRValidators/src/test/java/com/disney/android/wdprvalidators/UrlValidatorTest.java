package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;
import java.net.MalformedURLException;

/**
 * Created by venkatgonuguntala on 7/8/15.
 */

public class UrlValidatorTest extends TestCase{

    UrlValidator urlObj =  new UrlValidator();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testForValidUrl() throws MalformedURLException {
        assertEquals(0, urlObj.checkURL("https://google.com", true).size());
    }

    @SmallTest
    public void testForInvalidScheme() throws MalformedURLException {
        assertEquals("ERR_URL_SCHEME",urlObj.checkURL("ftp://google.com/android", true).get(0));
    }

    @SmallTest
    public void testForEmptyURL() throws MalformedURLException {
        assertEquals("ERR_EMPTY_INPUT",urlObj.checkURL("", true).get(0));
    }

    @SmallTest
    public void testForNull() throws MalformedURLException {
        assertEquals("ERR_EMPTY_INPUT",urlObj.checkURL(null, true).get(0));
    }

    @SmallTest
    public void testForURLLength() throws MalformedURLException {
        String url="https://";
        for(int i = 0; i < 2050; i++){
            url = url+"a";
        }
        assertEquals("ERR_URL_LEN",urlObj.checkURL(url, false).get(0));
    }


    @SmallTest
    public void testForRestHostname() throws MalformedURLException {
        String urlString = "http://google.com";
        assertEquals(0,urlObj.checkURL(urlString, true).size());
    }

    @SmallTest
    public void testForManyErrors() throws MalformedURLException {
        String urlString  = "https://google.com.";
        assertEquals("ERR_HOSTNAME_TLD_LEN",urlObj.checkURL(urlString, false).get(0));
        assertEquals("ERR_HOSTNAME_TLD",urlObj.checkURL(urlString, false).get(1));
    }

    @SmallTest
    public void testForOtherErrors() throws MalformedURLException {
        String urlString  = "https://google";
        assertEquals("ERR_HOSTNAME_OTHER",urlObj.checkURL(urlString, false).get(0));
    }

    @SmallTest
    public void testForOtherError() throws MalformedURLException {
        String urlString = "https://";
        assertEquals("ERR_EMPTY_INPUT",urlObj.checkURL(urlString, false).get(0));// we get empty input bcoz hosname gets "", which is empty hostname.
    }

    @SmallTest
    public void testForRelaxedOnOffParamer() throws MalformedURLException {
        String urlString = "http://123.23.04.12";

        //With relaxed parameter = false
        assertEquals("ERR_HOSTNAME_IP", urlObj.checkURL(urlString, false).get(0));

        //With relaxed parameter = true
        assertEquals(true, urlObj.checkURL(urlString, true).isEmpty());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

