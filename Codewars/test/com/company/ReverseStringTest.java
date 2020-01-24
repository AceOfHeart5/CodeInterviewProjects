package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {

    @Test
    public void reverseString() {
        assertEquals("dlrow", ReverseString.reverseString("world"));
    }
}