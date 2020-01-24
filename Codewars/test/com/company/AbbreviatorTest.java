package com.company;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class AbbreviatorTest {

    private Abbreviator abbr = new Abbreviator();

    @Test
    public void testInternationalization() {
        assertEquals("i18n", abbr.abbreviate("internationalization"));
    }

}