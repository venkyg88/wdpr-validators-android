package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 7/26/15.
 */
import java.util.ArrayList;
import java.util.List;
public class CreditCardValidators
{


    /**
     * @description predicate method to determine the input
     * @param creditCard
     * @return boolean
     */
    public boolean isCreditCard(String creditcardNumber)
    {
        boolean result = false;

        if(creditcardNumber != null && !creditcardNumber.isEmpty())
        {
            if (luhnTestForCreditCardNumber(creditcardNumber))
            {
                if (lengthCheckForCreditCardNumber(creditcardNumber))
                {
                    result = true;
                }
            }
        }
        return result;
    }


    /**
     * @description checker method to determine the input card is valid or not.
     * @param creditCard
     * @return list
     */
    public List<String> checkCreditCard(final String creditCard)
    {
        final List<String> creditCardList = new ArrayList<String>();

        if (creditCard == null || creditCard.isEmpty())
        {
            creditCardList.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        else
        {
            if (!isCreditCard(creditCard))
            {
                if (!luhnTestForCreditCardNumber(creditCard))
                {
                    creditCardList.add(ValidatorConstant.ERR_CC_LUHN);
                }
                if (!lengthCheckForCreditCardNumber(creditCard))
                {
                    creditCardList.add(ValidatorConstant.ERR_CC_LEN);
                }
            }
        }
        return creditCardList;
    }


    /**
     * @desc luhn Algorithm to check the input number is valid credit card number
     * @param number
     * @return boolean
     */

    private static boolean luhnTestForCreditCardNumber(String number)
    {
        int s1 = 0, s2 = 0;

        String reverse = new StringBuffer(number).reverse().toString();

        int numberLength = reverse.length();

        for (int i = 0 ; i < numberLength; i++)
        {
            int digit = Character.digit(reverse.charAt(i), 10);

            if(i % 2 == 0)
            {
                //this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }
            else
            {
                //add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;

                if(digit >= 5)
                {
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }


    private boolean lengthCheckForCreditCardNumber(String creditcardNumber)
    {
        boolean result = false;

        int creditCardLength = creditcardNumber.length();

        if (creditCardLength >= 11 && creditCardLength <= 16)
        {
            result = true;
        }
        return result;
    }
}
