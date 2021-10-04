package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViltesTests {

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
    void phoneValidator_TestPhoneNumberPrefix()
    {
        assertEquals("+37061234567", phone.addCountryPrefix("861234567"));
    }

    @Test
    void phoneValidator_TestIsValidForCountry()
    {
        assertTrue(phone.checkIsValidForCountry("+37061234567", "+370"));
    }

    @Test
    void passwordValidator_TestIsOfCorrectLength()
    {
        assertTrue(password.isOfCorrectLength("Slaptazodis132_"));
    }

    @AfterEach
    void tearDown(){

    }
}
