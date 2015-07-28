package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 7/26/15.
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreditCardValidatorsTest {

    @Test
    public void testisCreditCard() {
        CreditCardValidators creditCardValidators = new CreditCardValidators();

        //Valid cards
        assertEquals(true, creditCardValidators.checkCreditCard("378282246310005", "AMEX").isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCard("378282246310005", null).isEmpty());


        assertEquals(true, creditCardValidators.checkCreditCard("4111111111111111", "VISA").isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCard("4111111111111111", null).isEmpty());

        assertEquals(true, creditCardValidators.checkCreditCard("5555555555554444", "MASTERCARD").isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCard("5555555555554444", null).isEmpty());

        assertEquals(true, creditCardValidators.checkCreditCard("6011111111111117", "DISCOVER").isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCard("6011111111111117", null).isEmpty());

        assertEquals(true, creditCardValidators.checkCreditCard("30569309025904", "DINERS").isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCard("30569309025904", null).isEmpty());

        assertEquals(true, creditCardValidators.checkCreditCard("3530111333300000", "JCB").isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCard("3530111333300000", null).isEmpty());

        //Invalid  Cards

        assertEquals(false, creditCardValidators.checkCreditCard("3782822463100050", "AMEX").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCard("3782822463100050", null).isEmpty());

        assertEquals(false, creditCardValidators.checkCreditCard("41111111111111110", "VISA").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCard("41111111111111110", null).isEmpty());

        assertEquals(false, creditCardValidators.checkCreditCard("55555555555544440", "MASTERCARD").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCard("55555555555544440", null).isEmpty());

        assertEquals(false, creditCardValidators.checkCreditCard("60111111111111170", "DISCOVER").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCard("60111111111111170", null).isEmpty());

        assertEquals(false, creditCardValidators.checkCreditCard("305693090259040", "DINERS").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCard("305693090259040", null).isEmpty());

        assertEquals(false, creditCardValidators.checkCreditCard("35301113333000000", "JCB").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCard("35301113333000000", null).isEmpty());

        //Credit Card with Null value
        assertEquals(false, creditCardValidators.checkCreditCard(null, null).isEmpty());

        //Credit Card with Blank value
        assertEquals(false, creditCardValidators.checkCreditCard("", null).isEmpty());

        //Valid Card with Wrong Type
        assertEquals(false, creditCardValidators.checkCreditCard("378282246310005", "VISA").isEmpty());

        //Valid Credit Card not Support by Disney
        assertEquals(false, creditCardValidators.checkCreditCard("5610591081018250", null).isEmpty());

    }
}