package com.disney.android.wdprvalidators;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 8/27/15.
 */
public class PasswordValidatorTest extends TestCase {

    PasswordValidator mPasswordValidator = new PasswordValidator();

    //password with more than 25 characters
    private String mLongPassword = "disneyisthebestplacetoworkinOrlando";

    //password with less than 6 charaters
    private String mShortPassword = "qwert";

    //password with strength level less than 2
    private String mWeakPassword = "ABCDefgh";

    //password with strength level more or equal to 2
    private String mStrongPassword = "ABCDefgh_123";

    //password with illegal charaters
    private String mIllegalPassword = "ABCDefgh_123$";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testForPassword(){
        //predicate tests
        assertEquals(false, mPasswordValidator.isPassword(mLongPassword));
        assertEquals(false, mPasswordValidator.isPassword(mShortPassword));
        assertEquals(false, mPasswordValidator.isPassword(mWeakPassword));
        assertEquals(true, mPasswordValidator.isPassword(mStrongPassword));
        assertEquals(false, mPasswordValidator.isPassword(mIllegalPassword));

        //checker test for short password
        assertEquals("ERR_PASSWORD_MIN_LEN", mPasswordValidator.checkPassword(mShortPassword).get(0));

        //checker test for long password
        assertEquals("ERR_PASSWORD_MAX_LEN", mPasswordValidator.checkPassword(mLongPassword).get(0));

        //checker test for weak password(not strong - less than two category password)
        assertEquals("ERR_PASSWORD_STRENGTH", mPasswordValidator.checkPassword(mWeakPassword).get(0));

        //checker test for Strong password
        assertEquals(true, mPasswordValidator.checkPassword(mStrongPassword).isEmpty());

        //checker test for illegal password(with unsupported characters)
        assertEquals("ERR_PASSWORD_OTHER", mPasswordValidator.checkPassword(mIllegalPassword).get(0));

        //Special test cases by kk
        assertEquals("ERR_PASSWORD_OTHER", mPasswordValidator.checkPassword("Ab2!$3c").get(0));

        assertEquals("ERR_PASSWORD_OTHER", mPasswordValidator.checkPassword(">kk.son.com").get(0));

        //checker test for null input
        assertEquals("ERR_EMPTY_INPUT", mPasswordValidator.checkPassword(null).get(0));

        //checker test for empty input
        assertEquals("ERR_EMPTY_INPUT", mPasswordValidator.checkPassword("").get(0));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
