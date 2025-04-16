import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerTest {
    Passenger myPass;

    @BeforeEach
    void setup()
    {
        myPass = new Passenger("Mr", "Lance", "Cruz");
    }

    @Test
    void ConstructorSuccess()
    {
        assertEquals("Mr", myPass.getTitle());
        assertEquals("Lance", myPass.getFirstName());
        assertEquals("Cruz", myPass.getLastName());
    }

    @Test
    void testTitleSuccess()
    {
        assertEquals("Mr", myPass.getTitle());
        Passenger myPass2 = new Passenger("Mrs", "Lance", "Cruz");
        assertEquals("Mrs", myPass2.getTitle());
        Passenger myPass3 = new Passenger("Ms", "Lance", "Cruz");
        assertEquals("Ms", myPass3.getTitle());
    }
    @Test
    void testTitleFail()
    {
        assertThrows(IllegalArgumentException.class, () -> {new Passenger("Mrrr", "Lance", "Cruz");});
        assertThrows(IllegalArgumentException.class, () -> {new Passenger("", "Lance", "Cruz");});
    }

    @Test
    void testFirstNameSuccess()
    {
        assertEquals("Lance", myPass.getFirstName());
        Passenger myPass2 = new Passenger("Mrs", "Tommy", "Cruz");
        assertEquals("Tommy", myPass2.getFirstName());
        Passenger myPass3 = new Passenger("Ms", "John", "Cruz");
        assertEquals("John", myPass3.getFirstName());
    }

    @Test
    void testFirstNameFail()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {new Passenger("Mr", "La", "Cruz");});
        assertEquals("Invalid first name length", ex.getMessage());
    }

    @Test
    void testLastNameSuccess()
    {
        assertEquals("Cruz", myPass.getLastName());
        Passenger myPass2 = new Passenger("Mrs", "Lance", "Cruise");
        assertEquals("Cruise", myPass2.getLastName());
    }

    @Test
    void testLastNameFailure()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {new Passenger("Mr", "Lance", "Cr");});
        assertEquals("Invalid last name length", ex.getMessage());
    }
}
