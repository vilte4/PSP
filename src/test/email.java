package test;

public class email {
    boolean dotSign(String email){
        int howMany = 0;
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            if (ch == '.') {
                howMany++;
            }
        }
        char end = email.charAt(email.length()-1);
        if(!(howMany != 0 && end == '.'))
            return true;
        else
            return false;
    }
    boolean checkTLD(String email){
        int howManyLetters = 0;
        int iligis = email.length();
        for (int i = email.length(); i > 1 ; i--) {
            char ch = email.charAt(i-1);
            if (ch != '.') {
                howManyLetters++;
            }
            else
                break;
        }
        if(howManyLetters > 1)
            return true;
        else
            return false;
    }
    boolean checkDomain(String email){
        int howManyLetters = 0;
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            if (ch != '@') {
                email = email.replace(Character.toString(ch),"");
            }
            else break;
        }
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            if (ch != '.') {
                howManyLetters++;
            }
        }
        if(howManyLetters > 1)
            return true;
        else
            return false;
    }

    boolean atSign(String email) {
        int howMany = 0;
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            if (ch == '@') {
                howMany++;
            }
        }
        if(howMany == 1)
            return true;
        else
            return false;
    }
    boolean checkSymb(String email, String specSym){
        for(int i=0; i<email.length(); i++) {
            char ch = email.charAt(i);
            for(int j=0; j<specSym.length(); j++){
                char spec = specSym.charAt(j);
                if(ch == spec)
                    return false;
            }
        }
        return true;
    }
}
