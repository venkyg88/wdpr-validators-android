package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/6/15.
 */
public class EmailValidator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static Pattern emailPattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    /**
     * @description Validates if the given input is a valid email address.
     * @param email
     * @return boolean (true | false)
     */
    public boolean isValidEmail(String email)
    {
        return emailPattern.matcher(email).matches();
    }

    /**
     * @description Method to validate Email and return message.
     * @param email
     * @return Array key and value about status
     */
    public List<String> checkEmail(String email)
    {
        List<String> emailList = new ArrayList<>();

        List<String> hostnameList = new ArrayList<>();

        HostnameValidation hnvalidation = new HostnameValidation();

        if (email != null && !email.equals(""))
        {

            if (!isValidEmail(email))
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
                int count = email.length() - email.replaceAll("@", "").length();
                if (count > 1  || count == 0)
                {
                    emailList.add("ERR_EMAIL_INVALID_AT");
                }

                int localLength;
                String hostname = null;
                if (count == 1 && !email.endsWith("@")) {
                    String arryval[] = email.split("@");
                    localLength = arryval[0].length();
                    hostname = arryval[1];
                    hostnameList = hnvalidation.checkHostName(hostname);
                    if (localLength > 64) {
                        emailList.add("ERR_EMAIL_LEN_LOCAL");
                    }
                }

                if (email.length() > 254 || email.length() < 6)
                {
                    emailList.add("ERR_EMAIL_LEN");
                }

                if (email.indexOf(" ") != -1)
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
