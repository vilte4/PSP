package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.CompoundName;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    String emailgood = "arijusrancas@gmail.com";
    String passwordgood = "Labas456_";
    String numbergood1 = "861245737";
    String numbergood2 = "+37061245733";
    int lengthOfPassword = 8;
    String specialSymbols = "~!$%^&*_=+}{'?-.";
    String IllegalSymbols = "¡¢£¤€";
    Passwords password;
    phone phone;
    email email;

    @BeforeEach
    void setUp(){
        password = new Passwords();
        phone = new phone();
        email = new email();
    }

    @Test
    void passwordChecker_Length(){
        assert(password.hasLength(passwordgood)>=lengthOfPassword);
    }
    @Test
    void passwordChecker_UpperCase(){
        assert(password.upperCase(passwordgood));
    }
    @Test
    void passwordChecker_SpecialSym(){ assertTrue(password.checkSymb(passwordgood, specialSymbols));
    }
    @Test
    void phoneValidator_OnlyNumbers(){
        assert(phone.onlyNumbers(numbergood2));
    }
    @Test
    void phoneValidator_Beginning(){
        assert(phone.check(numbergood1));
    }
    @Test
    void phoneValidator_New(){
    assert(phone.checkLength(numbergood1, 9));
    assert(phone.checkPrefix(numbergood1, "8"));
    }
    @Test
    void EmailValidator_AtSign(){
        assertTrue(email.atSign(emailgood));
    }
    @Test
    void EmailValidator_Illegal(){
        assertTrue(email.checkSymb(emailgood, IllegalSymbols));
    }
    @Test
    void EmailValidator_Correct(){
        assertTrue(email.checkTLD(emailgood));
        assertTrue(email.checkDomain(emailgood));
    }

    @AfterEach
    void tearDown(){

    }
}
