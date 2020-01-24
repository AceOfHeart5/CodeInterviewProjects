package com.company;

public class Arge {

    public static int nbYear(int p0, double percent, int aug, int p) {
        double pop = p0;
        int years = 0;
        while (pop <= p) {
            pop += pop*(percent*0.01);
            pop += aug;
            years++;
        }
        return years;
    }
}
