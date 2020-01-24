import org.junit.Test;
import static org.junit.Assert.*;

public class KataTest {

    //Find The Unique Number
    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, Kata.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, Kata.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }

    //Simple Encryption #1 - Alternating Split
    @Test
    public void testEncrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", Kata.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", Kata.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", Kata.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", Kata.encrypt("This is a test!", 3));
        assertEquals("This is a test!", Kata.encrypt("This is a test!", 4));
        assertEquals("This is a test!", Kata.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", Kata.encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", Kata.decrypt("This is a test!", 0));
        assertEquals("This is a test!", Kata.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", Kata.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", Kata.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", Kata.decrypt("This is a test!", 4));
        assertEquals("This is a test!", Kata.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", Kata.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", Kata.encrypt("", 0));
        assertEquals("", Kata.decrypt("", 0));
        assertEquals(null, Kata.encrypt(null, 0));
        assertEquals(null, Kata.decrypt(null, 0));
    }


    private static final double DELTA = 1e-15;

    @Test
    public void find_average() {
        assertEquals(1, Kata.find_average(new int[]{1,1,1}), DELTA);
        assertEquals(2, Kata.find_average(new int[]{1, 2, 3}), DELTA);
    }

    @Test
    public void countPositivesSumNegatives_BasicTest() {
        int[] expectedResult = new int[] {10, -65};
        assertArrayEquals(expectedResult, Kata.countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
    }

    @Test
    public void countPositivesSumNegatives_InputWithZeroes() {
        int[] expectedResult = new int[] {8, -50};
        assertArrayEquals(expectedResult, Kata.countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
    }

    @Test
    public void countPositivesSumNegatives_InputIsEmpty() {
        int[] expectedResult = new int[] {};
        assertArrayEquals(expectedResult, Kata.countPositivesSumNegatives(new int[] {}));
    }

    @Test
    public void countPositivesSumNegatives_InputIsNull() {
        int[] expectedResult = new int[] {};
        assertArrayEquals(expectedResult, Kata.countPositivesSumNegatives(null));
    }
}