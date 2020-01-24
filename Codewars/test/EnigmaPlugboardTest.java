import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnigmaPlugboardTest {
    @Test
    public void testValidPlugboard() throws InvalidPlugboardWiresException {
        EnigmaPlugboard plugboard = new EnigmaPlugboard("AB");
        assertEquals("B", plugboard.process("A"));
        assertEquals("A", plugboard.process("B"));
        assertEquals("C", plugboard.process("C"));
        assertEquals(".", plugboard.process("."));
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard1() throws InvalidPlugboardWiresException {
        EnigmaPlugboard plugboard = new EnigmaPlugboard("ABC");
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard2() throws InvalidPlugboardWiresException {
        EnigmaPlugboard plugboard = new EnigmaPlugboard("ABAD");
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard3() throws InvalidPlugboardWiresException {
        EnigmaPlugboard plugboard = new EnigmaPlugboard("ABCDEFGHIJKLMNOPQRSTUV");
    }
}