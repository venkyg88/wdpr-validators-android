package com.wdpr.validator.emailvalidator;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import java.lang.String;
import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/6/15.
 */
public class EmailValidator implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        /*NO-OP*/
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        /*NO-OP*/
    }

    @Override
    public void afterTextChanged(Editable editableText) {
        //checkEmail(editableText);
    }

    /**
     * Validates if the given input is a valid email address.
     */
    public static boolean isValidEmail(Pattern emailPattern, CharSequence email) {
        return emailPattern.matcher(email).matches();
    }

    public static String checkEmail(String email) {

        //code to check for email containing more than one consecutive '.'s.
        if (email.contains("..")) { //Email cannot have two repeating adjacent .(dots)
            return "112";
        }

        //code to check for email starting with or ending with '.'.
        if (email.startsWith(".") || email.endsWith(".")) {
            return "111";
        }


        if (email.startsWith("@")) {
            return "107";
        } else {
            String arryval[] = email.split("@");
            if (arryval[0].length() > 64) {
                return "108";
            }
        }

        //code to check whether email is valid or not using pre-defined function.
        if (isValidEmail(Patterns.EMAIL_ADDRESS, email)) {//return message on valid email.
            return "200";
        }

        if( email == null){
            return "113";
        }

        //check whether the email is empty.
        if (email == "") {
            return "100";
        }


        if (email.length() > 254) {
            return "105";
        }

        //code to check for more than one '@'.
        int count = email.length() - email.replaceAll("@", "").length();
        if (count > 1) {
            return "106";
        } else {
            if (count == 0) {
                return "110";
            }
        }

        //For all other invalid email entries show below msg.
        return "113";

    }

}
