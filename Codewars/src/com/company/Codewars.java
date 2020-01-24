package com.company;

public class Codewars {
    public static String oddOrEven (int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        String result;
        if (sum%2 == 0) result = "even";
        else result = "odd";
        return result;
    }
}
