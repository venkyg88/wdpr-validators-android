package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/6/15.
 */
public class EmailValidator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    /**
     * @description Validates if the given input is a valid email address.
     * @param email
     * @return boolean (true | false)
     */
    public boolean isValidEmail(final String email)
    {
        return emailPattern.matcher(email).matches();
    }

    /**
     * @description Method to validate Email and return message.
     * @param email
     * @return List
     */
    public List<String> checkEmail(final String email)
    {
        final List<String> emailList = new ArrayList<>();

        List<String> hostnameList = new ArrayList<>();

        final HostnameValidation hnvalidation = new HostnameValidation();

        if (email != null && !email.equals(""))
        {

            if (!this.isValidEmail(email))
            {

                if (email.contains(".."))
                {
                    emailList.add("ERR_EMAIL_DBL_DOT");
                }

                if (email.startsWith("."))
                {
                    emailList.add("ERR_EMAIL_STRT_DOT");
                }

                if (email.endsWith("."))
                {
                    emailList.add("ERR_EMAIL_END_DOT");
                }

                if (email.startsWith("@"))
                {
                    emailList.add("ERR_EMAIL_LEN_LOCAL");
                }

                // Identify the count of '@'.
                final int count = email.length() - email.replaceAll("@", "").length();
                if (count > 1  || count == 0)
                {
                    emailList.add("ERR_EMAIL_INVALID_AT");
                }

                if (count == 1 && !email.endsWith("@")) {
                    final String[] arryval = email.split("@");
                    final int localLength = arryval[0].length();
                    final String hostname = arryval[1];
                    hostnameList = hnvalidation.checkHostName(hostname);
                    if (localLength > 64) {
                        emailList.add("ERR_EMAIL_LEN_LOCAL");
                    }
                }

                final int emailLength = email.length();
                if (emailLength > 254 || emailLength < 6)
                {
                    emailList.add("ERR_EMAIL_LEN");
                }

                if (email.contains(" "))
                {
                    emailList.add("ERR_EMAIL_SPACES");
                }

                // For all other invalid email entries show below msg.
                if (emailList.isEmpty())
                {
                    emailList.add("ERR_EMAIL_OTHER");
                }
            }
        }
        else
        {
            emailList.add("ERR_EMPTY_INPUT");
        }

        emailList.addAll(hostnameList);
        return emailList;
    }
}
