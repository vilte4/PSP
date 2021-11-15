package received2lab.test.java.MyUnitTests;

import received2lab.validators.EmailValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EmailValidator_Tests {

    @ParameterizedTest
    @ValueSource(strings = {
            "vardenis.pavardenis@mif.stud.vu.lt",
            "labasvakaras@gmail.com",
            "\"/><{||]raNdOM\"@vps.random.com",
            "cia.leidziamas.email@email.eu",
            "ciakomentaras(komentaras)@mail.net"
    })

    public void testSomeEmails(String email) {

        EmailValidator emailValidator = new EmailValidator();

        boolean result = emailValidator.validateEmail(email);

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "sitas@nebeleidziamas@wowow.com",
            "kazkasneleidziamo@cia..nope",
            "nesamone",
            "wow@wow",
            "",
    })
    public void testSomeBadEmails(String email) {

        EmailValidator emailValidator = new EmailValidator();

        boolean result = emailValidator.validateEmail(email);

        assertFalse(result);
    }

}
