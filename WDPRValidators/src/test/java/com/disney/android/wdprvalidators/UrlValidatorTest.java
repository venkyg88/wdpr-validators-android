
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

    /*@SmallTest
    public void testForValidUrl() throws MalformedURLException {
        assertEquals(1, urlObj.checkURL("https://google.com").size());
    }

    @SmallTest
    public void testForInvalidScheme() throws MalformedURLException {
        assertEquals("ERR_URI_SCHEME",urlObj.checkURL("ftp://google.com/android").get(0));
    }

    @SmallTest
    public void testForEmptyURL() throws MalformedURLException {
        assertEquals("ERR_EMPTY_INPUT",urlObj.checkURL("").get(0));
    }

    @SmallTest
    public void testForNull() throws MalformedURLException {
        assertEquals("ERR_EMPTY_INPUT",urlObj.checkURL(null).get(0));
    }

    @SmallTest
    public void testForURLLength() throws MalformedURLException {
        String url="https://";
        for(int i = 0; i < 2050; i++){
            url = url+"a";
        }
        assertEquals("ERR_URI_LEN",urlObj.checkURL(url).get(0));
    }

    @SmallTest
    public void testForOtherURLError() throws MalformedURLException {
        assertEquals("ERR_URI_SCHEME",urlObj.checkURL("http://").get(0));
    }*/

    @SmallTest
    public void testForRestHostname() throws MalformedURLException {
        String urlString = "http://google.com";
        assertEquals("ERR_URI_SCHEME",urlObj.checkURL(urlString).get(0));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

