package com.example.venkatgonuguntala.emailvalidator;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by venkatgonuguntala on 5/6/15.
 */
public class EmailValidatorClass implements TextWatcher {

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
        checkEmail(editableText);
    }

    /**
     * Validates if the given input is a valid email address.
     */
    public static boolean isValidEmail(Pattern emailPattern, CharSequence email) {
        return emailPattern.matcher(email).matches();
    }

    public static String checkEmail(CharSequence email){

        //code to check for email containing more than one consecutive '.'s.
        //-----------------------------------
        if (email.toString().contains("..")){ //Email cannot have two repeating adjacent .(dots)
            return "112";
        }

        //-----------------------------------
        //code to check for email starting with or ending with '.'.
        if (email.toString().startsWith(".") || email.toString().endsWith(".")){
            return "111";
        }

        //-----------------------------------
        //If there are not more than one '@' then the below part will be executed.
        //handles the empty local part.
        if(email.toString().startsWith("@")){
            return "107";
        }
        else{
            String arryval[] = email.toString().split("@");
            if(arryval[0].length() > 64){
                return "108";
            }
        }

        //code to check whether email is valid or not using pre-defined function.
        //-----------------------------------
        if(isValidEmail(android.util.Patterns.EMAIL_ADDRESS, email)){//return message on valid email.
            return "200";
        }



        //------------------------------------
        //check whether the email is empty.
        if(email == ""){
            return "100";
        }

        if (email.length()>254){
                return "105";
        }

        //code to check for more than one '@'.
        //------------------------------------
        int count = email.toString().length() - email.toString().replaceAll("@", "").length();
        if(count > 1){
            return "106";
        }else {
            if (count == 0) {
                return "110";
            }
        }
        //------------------------------------
        //For all other invalid email entries show below msg.
        return "113";

            //steps to do
            //Identify the length of the email to be no more than 254 characters long.
            //
            //Identify '@' symbols in the email,
            //if only one '@' symbol is present, perform split else return the error msg.
            // -Now check the local and check the domain part.
            //local and domain - No two consecutive .(dot)  Eg: venky..gonu@example.com
            //      - No first and last dots.    Eg: venky.@example.com  or .venky@example.com
    }

}
