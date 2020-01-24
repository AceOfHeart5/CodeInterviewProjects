package com.company;

import java.util.ArrayList;
import java.util.List;

public class CeasarCipherVariation {
    public static List<String> movingShift(String s, int shift) {
        StringBuilder code = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) code.setCharAt(i, bumpChar(s.charAt(i), shift++));
        int charsPerRunner = (int)Math.ceil(code.toString().length() / 5.0);
        List<String> result = new ArrayList();
        for (int i = 0; i < 5; i++) result.add("");
        StringBuilder segment = new StringBuilder();
        int runnerIndex = 0;
        for (int i = 0; i < code.length(); i++) {
            if (segment.length() < charsPerRunner) {
                segment.append(code.charAt(i));
            } else {
                result.set(runnerIndex, segment.toString());
                runnerIndex++;
                segment = new StringBuilder();
                segment.append(code.charAt(i));
            }
        }
        if (segment.length() > 0) result.set(runnerIndex, segment.toString());
        return result;
    }

    private static char bumpChar(char c, int n) {
        if (n <= 0 || !Character.isLetter(c)) return c;
        char result = c;
        switch (Character.toLowerCase(c)) {
            case 'a':
                result = 'b';
                break;
            case 'b':
                result = 'c';
                break;
            case 'c':
                result = 'd';
                break;
            case 'd':
                result = 'e';
                break;
            case 'e':
                result = 'f';
                break;
            case 'f':
                result = 'g';
                break;
            case 'g':
                result = 'h';
                break;
            case 'h':
                result = 'i';
                break;
            case 'i':
                result = 'j';
                break;
            case 'j':
                result = 'k';
                break;
            case 'k':
                result = 'l';
                break;
            case 'l':
                result = 'm';
                break;
            case 'm':
                result = 'n';
                break;
            case 'n':
                result = 'o';
                break;
            case 'o':
                result = 'p';
                break;
            case 'p':
                result = 'q';
                break;
            case 'q':
                result = 'r';
                break;
            case 'r':
                result = 's';
                break;
            case 's':
                result = 't';
                break;
            case 't':
                result = 'u';
                break;
            case 'u':
                result = 'v';
                break;
            case 'v':
                result = 'w';
                break;
            case 'w':
                result = 'x';
                break;
            case 'x':
                result = 'y';
                break;
            case 'y':
                result = 'z';
                break;
            case 'z':
                result = 'a';
                break;
        }
        if (n > 1) result = bumpChar(result, n - 1);
        if (Character.isUpperCase(c)) result = Character.toUpperCase(result);
        return result;
    }

    public static String  demovingShift(List<String> s, int shift) {
        StringBuilder complete = new StringBuilder();
        for (int i = 0; i < s.size(); i++) complete.append(s.get(i));
        StringBuilder deCode = new StringBuilder(complete.toString());
        for (int i = 0; i < complete.length(); i++) deCode.setCharAt(i, deBumpChar(complete.charAt(i), shift++));
        return deCode.toString();
    }

    private static char deBumpChar(char c, int n) {
        if (n <= 0 || !Character.isLetter(c)) return c;
        char result = c;
        switch (Character.toLowerCase(c)) {
            case 'a':
                result = 'z';
                break;
            case 'b':
                result = 'a';
                break;
            case 'c':
                result = 'b';
                break;
            case 'd':
                result = 'c';
                break;
            case 'e':
                result = 'd';
                break;
            case 'f':
                result = 'e';
                break;
            case 'g':
                result = 'f';
                break;
            case 'h':
                result = 'g';
                break;
            case 'i':
                result = 'h';
                break;
            case 'j':
                result = 'i';
                break;
            case 'k':
                result = 'j';
                break;
            case 'l':
                result = 'k';
                break;
            case 'm':
                result = 'l';
                break;
            case 'n':
                result = 'm';
                break;
            case 'o':
                result = 'n';
                break;
            case 'p':
                result = 'o';
                break;
            case 'q':
                result = 'p';
                break;
            case 'r':
                result = 'q';
                break;
            case 's':
                result = 'r';
                break;
            case 't':
                result = 's';
                break;
            case 'u':
                result = 't';
                break;
            case 'v':
                result = 'u';
                break;
            case 'w':
                result = 'v';
                break;
            case 'x':
                result = 'w';
                break;
            case 'y':
                result = 'x';
                break;
            case 'z':
                result = 'y';
                break;
        }
        if (n > 1) result = deBumpChar(result, n - 1);
        if (Character.isUpperCase(c)) result = Character.toUpperCase(result);
        return result;
    }
}
