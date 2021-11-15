package com.company;

import received2lab.validators.*;

public class ValidatorsCoordinator {

    static EmailValidator emailValidator = new EmailValidator();
    static PasswordChecker passValidator = new PasswordChecker();
    static PhoneValidator numValidator = new PhoneValidator();

    static char[] specialSymbols = {'!','@','#','$','%','^','&','*','(',')','-','=','+'};
    static int passwordLength = 8;

    static Boolean isEmailValid(String email)
    {
        if (emailValidator.validateEmail(email))
            return true;
        else return false;
    }

    static Boolean isPhoneNumberValid(String number)
    {
        if (numValidator.validatePhone_Digits(number))
            return true;
        else return false;
    }

    static Boolean isPasswordValid(String password)
    {
        if (passValidator.validatePassword(password, passwordLength, specialSymbols))
            return true;
        else return false;
    }
}