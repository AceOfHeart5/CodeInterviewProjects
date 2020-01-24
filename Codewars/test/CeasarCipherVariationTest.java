import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.*;
public class CeasarCipherVariationTest {

    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
        assertEquals(v, CeasarCipherVariation.movingShift(u, 1));
        assertEquals(u, CeasarCipherVariation.demovingShift(CeasarCipherVariation.movingShift(u, 1), 1));
    }
}