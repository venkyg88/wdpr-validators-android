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

    private boolean mIsValid = false;

    public boolean ismIsValid() {
        return mIsValid;
    }

    /**
     * Validates if the given input is a valid email address.
     *
     * @param emailPattern The {@link Pattern} used to validate the given email.
     * @param email The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(Pattern emailPattern, CharSequence email) {
        return email != null && emailPattern.matcher(email).matches();
    }

    public static CharSequence checkEmail(CharSequence email){
        //check weather the email is valid or not


        return email;
    }

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

       mIsValid = isValidEmail(android.util.Patterns.EMAIL_ADDRESS, editableText);
    }
}
