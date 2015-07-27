package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 7/26/15.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.validator.routines.CreditCardValidator;
import org.apache.commons.validator.routines.checkdigit.CheckDigit;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;

public class CreditCardValidators
{
    private static final String _5 = "5";
    private static final String _6011 = "6011";
    private static final String _35 = "35";
    private static final String _2131_1800 = "2131,1800,";
    private static final String DINERS = "DINERS";
    private static final String DISCOVER = "DISCOVER";
    private static final String MASTERCARD = "MASTERCARD";
    private static final String VISA = "VISA";
    private static final String AMEX = "AMEX";
    private static final String JCB = "JCB";
    static final Map<String, Long> CARDTYPEMAP = new HashMap<String, Long>();
    private static final CheckDigit LUHN_VALIDATOR = LuhnCheckDigit.LUHN_CHECK_DIGIT;
    private final transient List<String> creditCardList = new ArrayList<String>();

    /**
     *
     * @return
     */
    public static Map<String, Long> supportedCardType()
    {
        CARDTYPEMAP.put(AMEX, Long.valueOf(1));
        CARDTYPEMAP.put(VISA, Long.valueOf(2));
        CARDTYPEMAP.put(MASTERCARD, Long.valueOf(4));
        CARDTYPEMAP.put(DISCOVER, Long.valueOf(8));
        CARDTYPEMAP.put(DINERS, Long.valueOf(16));
        CARDTYPEMAP.put(JCB, Long.valueOf(32));
        return CARDTYPEMAP;
    }

    /**
     *
     * @param creditCard
     * @param cardType
     * @return
     */
    public boolean isCreditCard(final String creditCard, final String cardType)
    {
        boolean result = false;
        String type;
        if (creditCard != null && !creditCard.isEmpty())
        {
            if (cardType == null || cardType.isEmpty())
            {
                type = getCreditCardType(creditCard);
            }
            else
            {
                type = cardType;
            }
            result = validateCard(creditCard, type);
        }
        return result;
    }
    /**
     *
     * @param creditCard
     * @param cardType
     * @return
     */
    private boolean validateCard(final String creditCard, final String cardType)
    {
        boolean result = false;
        CreditCardValidator ccValidator;
        if (supportedCardType().containsKey(cardType))
        {
            if (cardType.equalsIgnoreCase(JCB))
            {
                result = validateJcb(creditCard);
            }
            else
            {
                ccValidator = new CreditCardValidator((Long) supportedCardType().get(cardType));
                result = ccValidator.isValid(creditCard);
            }
        }
        return result;
    }

    /**
     *
     * @param creditCard
     * @return
     */
    private boolean validateJcb(final String creditCard)
    {
        boolean result = false;
        final JcbCreditCard jcbCreditCard = new JcbCreditCard();
        if (jcbCreditCard.matches(creditCard) && LUHN_VALIDATOR.isValid(creditCard.trim()))
        {
            result = true;
        }
        return result;
    }

    /**
     *
     * @param creditCard
     * @param cardType
     * @return
     */
    public List<String> checkCreditCard(final String creditCard, final String cardType)
    {
        if (creditCard == null || creditCard.isEmpty())
        {
            creditCardList.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        else
        {
            if (!isCreditCard(creditCard, cardType))
            {
                if (cardType != null && !cardType.isEmpty())
                {
                    validateCCType(creditCard, cardType);
                }
                validateLUHN(creditCard);
                if (cardType != null && !validateCCLength(creditCard, cardType))
                {
                    creditCardList.add(ValidatorConstant.ERR_CC_LEN);
                }
                if (creditCardList.isEmpty())
                {
                    creditCardList.add(ValidatorConstant.ERR_CC_OTHER);
                }
            }
        }
        return creditCardList;
    }

    /**
     *
     * @param creditCard
     * @return
     */
    private void validateCCType(final String creditCard, final String ccType)
    {
        final String cardType = getCreditCardType(creditCard);
        if (!ccType.equals(cardType))
        {
            creditCardList.add(ValidatorConstant.ERR_CC_UNSUP_TYP);
        }
    }
    /**
     *
     * @param creditCard
     * @return
     */
    private void validateLUHN(final String creditCard)
    {
        if(!LUHN_VALIDATOR.isValid(creditCard.trim()))
        {
            creditCardList.add(ValidatorConstant.ERR_CC_LUHN);
        }
    }

    /**
     *
     * @param creditCard
     * @return
     */
    public String getCreditCardType(final String creditCard)
    {
        return CardType.getCardType(creditCard).toString();
    }

    /**
     *
     * @param creditCard
     * @param type
     * @return
     */
    private boolean validateCCLength(final String creditCard, final String type)
    {
        boolean result = true;
        final int cardLength = creditCard.length();
        if (AMEX.equals(type))
        {
            result = validateAmexLength(cardLength);
        }
        if (VISA.equals(type))
        {
            result = validateVisaLength(cardLength);
        }
        if (MASTERCARD.equals(type))
        {
            result = validateMasterCLength(cardLength);
        }
        if (DISCOVER.equals(type))
        {
            result = validateDiscoverLength(creditCard, cardLength);
        }
        if (DINERS.equals(type))
        {
            result = validateDinersLength(cardLength);
        }
        if (JCB.equals(type))
        {
            result = validateJCBLength(creditCard, cardLength);
        }
        return result;
    }

    /**
     *
     * @param cardLength
     * @return
     */
    private boolean validateJCBLength(final String creditCard, final int cardLength)
    {
        boolean result = false;
        if(cardLength == 15)
        {
            final String PREFIX = _2131_1800;
            final String prefix2 = creditCard.substring(0, 4) + ",";
            result =  PREFIX.indexOf(prefix2) != -1;
        }
        if(cardLength == 16)
        {
            result = creditCard.substring(0, 2).equals(_35);
        }
        return result;
    }

    /**
     *
     * @param cardLength
     * @return
     */
    private boolean validateDinersLength(final int cardLength)
    {
        boolean result = false;
        if (cardLength == 14)
        {
            result = true;
        }
        return result;
    }

    /**
     *
     * @param cardLength
     * @return
     */
    private boolean validateDiscoverLength(final String creditCard, final int cardLength)
    {
        boolean result = false;
        if (cardLength == 16 && creditCard.startsWith(_6011))
        {
            result = true;
        }
        if (cardLength == 15 && creditCard.startsWith(_5))
        {
            result = true;
        }
        return result;
    }

    /**
     *
     * @param cardLength
     * @return
     */
    private boolean validateMasterCLength(final int cardLength)
    {
        boolean result = false;
        if (cardLength == 16)
        {
            result = true;
        }
        return result;
    }

    /**
     *
     * @param cardLength
     * @return
     */
    private boolean validateVisaLength(final int cardLength)
    {
        boolean result = false;
        if (cardLength == 13 || cardLength == 16)
        {
            result = true;
        }
        return result;
    }

    /**
     *
     * @param cardLength
     * @return
     */
    private boolean validateAmexLength(final int cardLength)
    {
        boolean result = false;
        if (cardLength == 15)
        {
            result = true;
        }
        return result;
    }
}
