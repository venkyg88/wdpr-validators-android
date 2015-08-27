package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by venkatgonuguntala on 8/27/15.
 */
public class PasswordValidator {

    private static final int PASSWORD_MIN_LEN = 6;

    private static final int PASSWORD_MAX_LEN = 25;

    private static final int PASSWORD_STRENGTH_MIN_COUNT = 2;

    private static final String PATTERN = "^[A-Za-z0-9!<#%{}|\\^~\\]\\[`;\\/\\?:@=\\_\\-\\.&\\\\]+$";

    /**
     * predicate method to find the password is a valid password confining to the RA security specified length(6-25) and
     * at least having the minimum count of two categories(lower/upper case characters, digits, symbols) for achieving required password strength
     * @param password
     * @return boolean
     */
    public boolean isPassword(String password)
    {
        boolean result = false;
        if (password != null && !password.isEmpty())
        {
            if (checkPasswordLength(password) && checkPasswordStrength(password) >= 2 && password.matches(PATTERN))
            {
                result = true;
            }
        }
        return result;
    }


    /**
     * checker method to return a list of possible error/errors for passwords not specific to RA security standards otherwise return empty list.
     * @param password
     * @return list
     */
    public List<String> checkPassword(String password)
    {
        List<String> errorList = new ArrayList<>();
        if (password != null && !password.isEmpty())
        {
            if (!checkPasswordLength(password))
            {
                if (password.length() < PASSWORD_MIN_LEN)
                {
                    errorList.add(ValidatorConstant.ERR_PASSWORD_MIN_LEN);
                }
                if (password.length() > PASSWORD_MAX_LEN)
                {
                    errorList.add(ValidatorConstant.ERR_PASSWORD_MAX_LEN);
                }
            }
            if (checkPasswordStrength(password) < PASSWORD_STRENGTH_MIN_COUNT )
            {
                errorList.add(ValidatorConstant.ERR_PASSWORD_STRENGTH);
            }
            if (!password.matches(PATTERN))
            {
                errorList.add(ValidatorConstant.ERR_PASSWORD_OTHER);
            }
        }
        else
        {
            errorList.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        return errorList;
    }

    /**
     * private method to check the password length specific to RA security standards.
     * @param password
     * @return boolean
     */
    private boolean checkPasswordLength(String password)
    {
        int passwordLength = password.length();
        return (passwordLength >= PASSWORD_MIN_LEN && passwordLength <= PASSWORD_MAX_LEN);
    }

    /**
     * private method to check the password strength specific to RA security standards.
     * @param password
     * @return int
     */
    private int checkPasswordStrength(String password)
    {
        int categoriesCount=0;
        String[] partialRegexChecks = { ".*[a-z]+.*", // lower
                ".*[A-Z]+.*", // upper
                ".*[\\d]+.*", // digits
                ".*[!<#%{}|\\^~\\]\\[`;\\/\\?:@=\\_\\-\\.&\\\\]+.*" // symbols
        };
        if (password.matches(partialRegexChecks[0]) || password.matches(partialRegexChecks[1]))
        {
            categoriesCount+=1;
        }
        if (password.matches(partialRegexChecks[2]))
        {
            categoriesCount+=1;
        }
        if (password.matches(partialRegexChecks[3]))
        {
            categoriesCount+=1;
        }
        return categoriesCount;
    }
}
