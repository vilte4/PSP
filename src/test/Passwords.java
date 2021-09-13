package test;

public class Passwords {
    int hasLenght(String password){
        int lenght=0;
        lenght = password.length();

        return lenght;
    }
    boolean upperCase(String password){
        int upper = 0;
        for(int i=0; i<password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                upper++;
            }
        }
        if(upper == 0)
            return false;
            else
                return true;

    }
    boolean checkSymb(String password, String specSym){
        for(int i=0; i<password.length(); i++) {
            char ch = password.charAt(i);
            for(int j=0; j<specSym.length(); j++){
                char spec = specSym.charAt(j);
                if(ch == spec)
                    return true;
            }
        }
        return false;
    }
}
