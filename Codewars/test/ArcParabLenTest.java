import static org.junit.Assert.*;
import java.text.DecimalFormat;
import org.junit.Test;

public class ArcParabLenTest {
    @Test
    public void test1() {
        System.out.println("Fixed Tests: lenCurve");
        assertEquals(1.414213562, ArcParabLen.lenCurve(1), 1e-9);
        assertEquals(1.478197397, ArcParabLen.lenCurve(10), 1e-9);
    }
}
