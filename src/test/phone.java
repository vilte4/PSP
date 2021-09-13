package test;

import java.util.Scanner;

public class phone {
    boolean onlyNumbers(String password){
        int numbers = 0;
        int passwordLenght = 0;
        char ch;
        if(password.charAt(0) == '+')
            passwordLenght = password.length() - 1;
        else
            passwordLenght = password.length();
        for(int i=0; i<password.length(); i++) {
            char start = password.charAt(i);
            if(start == '+')
                ch = password.charAt(i+1);
            else
                ch = password.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numbers++;
            }
        }
        if(passwordLenght == numbers)
            return true;
        else
            return false;

    }
    String change(String number){
        if(number.charAt(0) != '8')
            return number;
        StringBuffer correctNumber = null;
        String correctBeg = "+370";
        correctNumber.append(correctBeg);
        for(int i = 1; i <number.length();i++){
            char ch = number.charAt(i);
            correctNumber.append(ch);
        }
        number = correctNumber.toString();
        return number;
    }
    boolean check(String number){
        if(number.charAt(0) != '8')
            return false;
        else
            return true;
    }
    boolean checkLength(String number, int length)
    {
        if(number.length() == length)
            return true;
        else
            return false;
    }
    boolean checkPrefix(String number, String correctPrefix)
    {
        int lengthOfPrefix = correctPrefix.length();

        for (int i = number.length()-1; i > lengthOfPrefix-1; i--) {
            char ch = number.charAt(i);
            number = number.replace(Character.toString(ch), "");
            }
        if(correctPrefix.equals(number))
            return true;
        else
            return false;
    }
}
