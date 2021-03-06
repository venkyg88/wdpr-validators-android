package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 7/26/15.
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

public class CreditCardValidatorsTest {

    CreditCardValidators creditCardValidators = new CreditCardValidators();

    @Test
    public void testCreditCard() {


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

        assertEquals(true, creditCardValidators.checkCreditCard("378-282 2 46310005").isEmpty());
        assertEquals(true, creditCardValidators.isCreditCard("3782-8224-6310  005"));

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
        assertEquals("ERR_CC_LUHN", creditCardValidators.checkCreditCard("123455686758575885").get(0));
        assertEquals("ERR_CC_LEN", creditCardValidators.checkCreditCard("123455686758575885").get(1));

        //Test for strings
        assertEquals("ERR_CC_OTHER", creditCardValidators.checkCreditCard("disney").get(0));

        //Test for null
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, creditCardValidators.checkCreditCard("").get(0));
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, creditCardValidators.checkCreditCard(null).get(0));
        assertEquals(false, creditCardValidators.isCreditCard(""));
        assertEquals(false, creditCardValidators.isCreditCard(null));
    }

    @Test
    public void testCreditCardDate() throws ParseException{

        int month = getcurrentMonth();
        int year =  getcurrentYear();

        assertEquals(true, creditCardValidators.checkCreditCardDate(year, month).isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCardDate(year, month-1).isEmpty());

        assertEquals(false, creditCardValidators.isValidCreditCardDate(0, 8));
        assertEquals(false, creditCardValidators.isValidCreditCardDate(year, 0));
        assertEquals(false, creditCardValidators.isValidCreditCardDate(0, 0));

        // Since input is integer, Empty Input error msg on passing '0'.
        assertEquals(ValidatorConstant.ERR_CC_EXP, creditCardValidators.checkCreditCardDate(0, 8).get(0));
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, creditCardValidators.checkCreditCardDate(year, 0).get(0));
        assertEquals(ValidatorConstant.ERR_EMPTY_INPUT, creditCardValidators.checkCreditCardDate(0, 0).get(0));

        assertEquals(true, creditCardValidators.checkCreditCardDate(35, 12).isEmpty());

        // Single Digit Month with error message
        assertEquals(ValidatorConstant.ERR_CC_EXP, creditCardValidators.checkCreditCardDate(year-1, month).get(0));
        assertEquals(ValidatorConstant.ERR_CC_EXP, creditCardValidators.checkCreditCardDate(year, month-2).get(0));
        assertEquals(ValidatorConstant.ERR_CC_EXP, creditCardValidators.checkCreditCardDate(year, month-1).get(0));

        // Single Digit Month
        assertEquals(true, creditCardValidators.checkCreditCardDate(year, month).isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCardDate(year, month).isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCardDate(3000, month).isEmpty());

        assertEquals(ValidatorConstant.ERR_CC_OTHER, creditCardValidators.checkCreditCardDate(year, 17).get(0));

        assertEquals(false, creditCardValidators.checkCreditCardDate(1, month-1).isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCardDate(111, 8).isEmpty());
    }

    private int getcurrentMonth()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.get(Calendar.MONTH)+2;
    }

    private int getcurrentYear()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.get(Calendar.YEAR);
    }

    @Test
    public void testCreditCardCVC(){
        //Test for Valid(number & length) cvc
        assertEquals(true, creditCardValidators.checkCreditCardCVC("007").isEmpty());
        assertEquals(true, creditCardValidators.checkCreditCardCVC("0000").isEmpty());

        //Test for Invalid length but number
        assertEquals(false, creditCardValidators.checkCreditCardCVC("30001").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCardCVC("31").isEmpty());
        assertEquals("ERR_CC_CVC_LEN", creditCardValidators.checkCreditCardCVC("30001").get(0));
        assertEquals("ERR_CC_CVC_LEN", creditCardValidators.checkCreditCardCVC("31").get(0));

        //Test for Invalid length and non-number
        assertEquals(false, creditCardValidators.checkCreditCardCVC("assdfg").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCardCVC("v").isEmpty());
        assertEquals("ERR_CC_CVC_LEN", creditCardValidators.checkCreditCardCVC("assdfg").get(0));
        assertEquals("ERR_CC_CVC", creditCardValidators.checkCreditCardCVC("assdfg").get(1));
        assertEquals("ERR_CC_CVC_LEN", creditCardValidators.checkCreditCardCVC("v").get(0));
        assertEquals("ERR_CC_CVC", creditCardValidators.checkCreditCardCVC("v").get(1));

        //Test for valid length and non-number
        assertEquals(false, creditCardValidators.checkCreditCardCVC("asd").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCardCVC("disn").isEmpty());
        assertEquals("ERR_CC_CVC", creditCardValidators.checkCreditCardCVC("asd").get(0));
        assertEquals("ERR_CC_CVC", creditCardValidators.checkCreditCardCVC("disn").get(0));

        //Test for empty cvc
        assertEquals(false, creditCardValidators.checkCreditCardCVC("").isEmpty());
        assertEquals(false, creditCardValidators.checkCreditCardCVC(null).isEmpty());
        assertEquals("ERR_EMPTY_INPUT", creditCardValidators.checkCreditCardCVC("").get(0));
        assertEquals("ERR_EMPTY_INPUT", creditCardValidators.checkCreditCardCVC(null).get(0));

    }
}