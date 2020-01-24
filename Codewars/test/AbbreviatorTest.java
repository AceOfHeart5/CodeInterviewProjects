import org.junit.Test;
import static org.junit.Assert.*;

public class AbbreviatorTest {

    private Abbreviator abbr = new Abbreviator();

    @Test
    public void testInternationalization() {
        assertEquals("i18n", abbr.abbreviate("internationalization"));
    }

}