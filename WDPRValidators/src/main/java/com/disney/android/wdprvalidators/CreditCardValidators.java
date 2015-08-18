package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 7/26/15.
 */
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CreditCardValidators
{
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private static final String SPECIAL_CHARACTER = "[- ]";

    private static final String SLASH = "/";

    private static final String MM_YYYY = "MM/yyyy";

    /**
     * @description predicate method to determine the input
     * @param creditCardNumber
     * @return boolean
     */
    public boolean isCreditCard(String creditCardNumber)
    {
        boolean result = false;

        if(creditCardNumber != null && !creditCardNumber.isEmpty())
        {
            creditCardNumber = trimSpecialCharacter(creditCardNumber);

            if (isNumber(creditCardNumber) && luhnTestForCreditCardNumber(creditCardNumber) && lengthCheckForCreditCardNumber(creditCardNumber))
            {
                result = true;
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
        int variableOne = 0;

        int variableTwo = 0;

        final String reverse = new StringBuffer(number).reverse().toString();

        final int numberLength = reverse.length();

        for (int i = 0 ; i < numberLength; i++)
        {
            final int digit = Character.digit(reverse.charAt(i), 10);

            if(i % 2 == 0)
            {
                //this is for odd digits, they are 1-indexed in the algorithm
                variableOne += digit;
            }
            else
            {
                //add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                variableTwo += 2 * digit;

                if(digit >= 5)
                {
                    variableTwo -= 9;
                }
            }
        }
        return (variableOne + variableTwo) % 10 == 0;
    }

    /**
     *
     * @param creditcardNumber
     * @return
     */
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

    /**
     *
     * @param creditcardNumber
     * @return
     */
    private boolean isNumber(String creditcardNumber)
    {
        return creditcardNumber.matches(NUMBER_REGEX);
    }

    private String trimSpecialCharacter(String creditCard)
    {
        creditCard = creditCard.replaceAll(SPECIAL_CHARACTER, "");
        return creditCard;
    }

    /**
     *
     * @param year
     * @param month
     * @return
     * @throws ParseException
     */
    private boolean validateCardExpiryDate(final int year, final int month) throws ParseException
    {
        boolean result = false;
        if(month>0 && month<=12 && year>=1000)
        {
            result = true;
        }
        return result;
    }
    /**
     *
     * @param year
     * @param month
     * @return
     * @throws ParseException
     */
    public boolean isValidCreditCardDate(final int year, final int month) throws ParseException
    {
        boolean result = false;
        final int _year = getFourDigitYear(year);
        if ( validateCardExpiryDate(_year,month) )
        {

            if ( !checkExpired(_year, month) )
            {
                result = true;
            }
        }
        return result;
    }
    /**
     *
     * @param year
     * @return
     */
    private int getFourDigitYear(final int year)
    {
        if ( year >= 00 && year <= 99 )
        {
            return year + 2000;
        }
        return year;
    }
    /**
     *
     * @param year
     * @param month
     * @return
     * @throws ParseException
     */
    public  List<String> checkCreditCardDate(final int year, final int month) throws ParseException
    {
        final  List<String> cardDateList = new ArrayList<String>();
        if ( month == 0 )
        {
            cardDateList.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        else
        {
            final int _year = getFourDigitYear(year);
            if ( !isValidCreditCardDate(_year,month) )
            {
                if ( validateCardExpiryDate(_year,month) )
                {
                    cardDateList.add(ValidatorConstant.ERR_CC_EXP);
                }
                else
                {
                    cardDateList.add(ValidatorConstant.ERR_CC_OTHER);
                }
            }
        }
        return cardDateList;
    }
    /**
     *
     * @param year
     * @param month
     * @return
     */
    private StringBuilder formatCreditCardDate(final String year, final String month)
    {
        final StringBuilder creditCardDate = new StringBuilder();
        creditCardDate.append(month);
        creditCardDate.append(SLASH);
        creditCardDate.append(year);
        return creditCardDate;
    }


    private boolean checkExpired(int year, int month) throws ParseException
    {
        StringBuilder creditCardDate = formatCreditCardDate(String.valueOf(year), String.valueOf(month));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MM_YYYY);
        Date expiry = simpleDateFormat.parse(creditCardDate.toString());
        boolean expiredCard = expiry.before(new Date());
        return expiredCard;
    }

    /**
     * predicate method to determine the input string is a valid cvc.
     * Note: The input is taken as string instead of int because to preserve the leading zeros. Eg: '001' or '0002'.etc
     * @param cvc
     * @return
     */
    public boolean isCreditCardCVC(String cvc)
    {
        boolean result = false;
        if(cvc != null && !cvc.isEmpty())
        {
            cvc = trimSpecialCharacter(cvc);
            if (isNumber(cvc))
            {
                if (cvcLengthCheck(cvc))
                {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * checker method to determine the input string is valid cvc or not. return an empty list on success and error list of failure.
     * Note: The input is taken as string instead of int because to preserve the leading zeros. Eg: '001' or '0002'.etc
     * @param cvc
     * @return
     */
    public List<String> checkCreditCardCVC(String cvc)
    {
        List<String> listCVC = new ArrayList<>();
        if(cvc != null && !cvc.isEmpty())
        {
            cvc = trimSpecialCharacter(cvc);
            if (!isCreditCardCVC(cvc))
            {
                if (!cvcLengthCheck(cvc) && isNumber(cvc))
                {
                    listCVC.add("ERR_CC_CVC_LEN");
                }
                if(listCVC.isEmpty())
                {
                    listCVC.add("ERR_CC_CVC");
                }
            }
        }
        else
        {
            listCVC.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        return listCVC;
    }

    /**
     * method to check the cvc length
     * @param cvc
     * @return
     */
    private boolean cvcLengthCheck(String cvc)
    {
        int cvcLength = cvc.length();
        return (cvcLength == 3 || cvcLength == 4);
    }

}

