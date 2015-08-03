package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 7/26/15.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CreditCardValidators
{
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private static final String SPECIAL_CHARACTER = "[- ]";

    private static final Pattern numberPattern = Pattern.compile(NUMBER_REGEX);
    /**
     * @description predicate method to determine the input
     * @param creditCard
     * @return boolean
     */
    public boolean isCreditCard(String creditCardNumber)
    {
        boolean result = false;

        if(creditCardNumber != null && !creditCardNumber.isEmpty())
        {
            creditCardNumber = trimSpecialCharacter(creditCardNumber);

            if (isNumber(creditCardNumber))
            {
                if (luhnTestForCreditCardNumber(creditCardNumber))
                {
                    if (lengthCheckForCreditCardNumber(creditCardNumber))
                    {
                        result = true;
                    }
                }
            }
        }
        return result;
    }


    /**
     * @description checker method to determine the input card is valid or not.
     * @param creditCardNumber
     * @return list
     */
    public List<String> checkCreditCard(String creditCardNumber)
    {
        final List<String> creditCardList = new ArrayList<String>();

        if (creditCardNumber == null || creditCardNumber.isEmpty())
        {
            creditCardList.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        else
        {
            creditCardNumber = trimSpecialCharacter(creditCardNumber);
            if (!isCreditCard(creditCardNumber))
            {
                if(!isNumber(creditCardNumber)){
                    creditCardList.add(ValidatorConstant.ERR_CC_OTHER);
                }
                else
                {
                    if (!luhnTestForCreditCardNumber(creditCardNumber))
                    {
                        creditCardList.add(ValidatorConstant.ERR_CC_LUHN);
                    }
                    if (!lengthCheckForCreditCardNumber(creditCardNumber))
                    {
                        creditCardList.add(ValidatorConstant.ERR_CC_LEN);
                    }
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

    private boolean isNumber(String creditcardNumber)
    {
        return numberPattern.matcher(creditcardNumber).matches();
    }

    private String trimSpecialCharacter(String creditCard)
    {
        creditCard = creditCard.replaceAll(SPECIAL_CHARACTER, "");
        return creditCard;
    }
}
