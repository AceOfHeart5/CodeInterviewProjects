package com.company;

import java.util.LinkedList;
import java.util.List;

public class SumDigPower {
    public static List<Long> sumDigPow(long a, long b) {
        List<Long> valids = new LinkedList<>();
        for (long i = a; i <= b; i++) {
            if (isSumOfDigRaisedToConPwrs(i)) valids.add(i);
        }
        return valids;
    }
    private static boolean isSumOfDigRaisedToConPwrs(long e) {
        String s = String.valueOf(e);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            long temp = Long.parseLong(Character.toString(s.charAt(i)));
            sum += Math.pow((double)temp, i+1);
        }
        if (sum == e) return true;
        else return false;
    }
}
