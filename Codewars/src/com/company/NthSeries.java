package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NthSeries {

    public static String seriesSum(int n) {
        double total = 0;
        if (n != 0) {
            total = 1;
            for (int i = 1; i < n; i++) {
                double value = 1 / (1 + 3*(double)i);
                total += value;
            }
        }
        BigDecimal bd = new BigDecimal(total);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return String.valueOf(bd);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
