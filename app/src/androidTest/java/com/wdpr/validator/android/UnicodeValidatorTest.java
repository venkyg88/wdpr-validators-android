package com.wdpr.validator.android;

import android.test.suitebuilder.annotation.SmallTest;

import com.wdpr.validator.android.UnicodeValidator;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 5/26/15.
 */
public class UnicodeValidatorTest extends TestCase{

    String arrayForTrueUnicode[] = {"abcdefghijklmnopqrstuvwxyz0123456789-. ","Wo ist meine SchnÃ¼r weg, groÃŸer ein?","上海迪士尼度假区的人","+^","Z͑ͫ̓ͪ̂ͫ̽͏̴̙̤̞͉̯̞̠͍A̴̵̜̰͔ͫ͗͢L̠ͨͧͩG̴̻͈͍͔̹̑͗̎̅́Ǫ̵̹̻̝̳͂̌̌!͖̬̰̙̗̿̋ͥͥ̂ͣ̐́́͞"};

    UnicodeValidator UnicodeObj = new UnicodeValidator();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    @SmallTest
    public void testForUnicode(){
        for(int i=0;i<arrayForTrueUnicode.length;i++) {
            boolean result3 = UnicodeObj.aUnicodeString(arrayForTrueUnicode[i]);
            assertEquals(false, result3);
        }
    }

    @SmallTest
    public void testForNotUnicode(){
        boolean result3 = UnicodeObj.aUnicodeString("");
        assertEquals(false,result3);
    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
