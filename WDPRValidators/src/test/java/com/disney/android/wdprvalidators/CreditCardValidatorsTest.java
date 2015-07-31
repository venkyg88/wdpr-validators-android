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
        assertEquals(true, creditCardValidators.checkCreditCard("378282246310005").isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCard("378282246310005").isEmpty());
        assertEquals(false, creditCardValidators.isCreditCard("41111"));
        assertEquals(false, creditCardValidators.isCreditCard("11111111111911"));

        //Visa check
        assertEquals(true, creditCardValidators.checkCreditCard("4111111111111111").isEmpty());
        assertEquals(true, creditCardValidators.isCreditCard("4111111111111111"));

        //Master Card check
        assertEquals(true, creditCardValidators.checkCreditCard("5555555555554444").isEmpty());
        assertEquals(true, creditCardValidators.isCreditCard("5555555555554444"));

        //Discover check
        assertEquals(true, creditCardValidators.checkCreditCard("6011111111111117").isEmpty());
        assertEquals(true, creditCardValidators.isCreditCard("6011111111111117"));

        //Diners Club check
        assertEquals(true, creditCardValidators.checkCreditCard("30569309025904").isEmpty());
        assertEquals(true, creditCardValidators.isCreditCard("30569309025904"));

        //Jcb check
        assertEquals(true, creditCardValidators.checkCreditCard("3530111333300000").isEmpty());
        assertEquals(true, creditCardValidators.isCreditCard("3530111333300000"));

        //Invalid  Cards

        //Amex check
        assertEquals(false, creditCardValidators.checkCreditCard("3782822463100050").isEmpty());
        assertEquals(false, creditCardValidators.isCreditCard("3782822463100050"));

        //Visa check
        assertEquals(false, creditCardValidators.checkCreditCard("41111111111111110").isEmpty());
        assertEquals(false, creditCardValidators.isCreditCard("41111111111111110"));

        //Master Card
        assertEquals(false, creditCardValidators.checkCreditCard("55555555555544440").isEmpty());
        assertEquals(false, creditCardValidators.isCreditCard("55555555555544440"));

        //Discover
        assertEquals(false, creditCardValidators.checkCreditCard("60111111111111170").isEmpty());
        assertEquals(false, creditCardValidators.isCreditCard("60111111111111170"));

        //DINERS card
        assertEquals(false, creditCardValidators.checkCreditCard("305693090259040").isEmpty());
        assertEquals(false, creditCardValidators.isCreditCard("305693090259040"));

        //Jcb
        assertEquals(false, creditCardValidators.checkCreditCard("35301113333000000").isEmpty());
        assertEquals(false, creditCardValidators.isCreditCard("35301113333000000"));

        //Returning error messages
        assertEquals("ERR_CC_LUHN", creditCardValidators.checkCreditCard("35301113333000000").get(0));
        assertEquals("ERR_CC_LEN", creditCardValidators.checkCreditCard("35301113333000000").get(1));

        //Test for null
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, creditCardValidators.checkCreditCard("").get(0));
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, creditCardValidators.checkCreditCard(null).get(0));
        assertEquals(false, creditCardValidators.isCreditCard(""));
        assertEquals(false, creditCardValidators.isCreditCard(null));


        }
}