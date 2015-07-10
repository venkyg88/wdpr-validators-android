package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class UnicodeValidatorTest extends TestCase{

    String arrayForTrueUnicode[] = {"abcdefghijklmnopqrstuvwxyz0123456789-. ","Wo ist meine SchnÃ¼r weg, groÃŸer ein?","上海迪士尼度假区的人"};

    UnicodeValidator UnicodeObj = new UnicodeValidator();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testForUnicode(){
        for(int i=0;i<arrayForTrueUnicode.length;i++) {
            boolean result = UnicodeObj.aUnicodeString(arrayForTrueUnicode[i]);
            assertEquals(true, result);
        }
    }

    @SmallTest
    public void testForNotUnicode(){
        boolean result = UnicodeObj.aUnicodeString("U+F024");
        assertEquals(false, result);
    }

    @SmallTest
    public void testForInvalidUnicodeChecker(){
        assertEquals("ERR_UNICODE_STRING",UnicodeObj.unicodeChecker("U+F024").get(0));
    }

    @SmallTest
    public void testForNULLUnicodeChecker(){

        assertEquals("ERR_EMPTY_INPUT",UnicodeObj.unicodeChecker(null).get(0));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
