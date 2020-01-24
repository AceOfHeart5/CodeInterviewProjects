package com.company;

import java.util.Arrays;
import java.util.Vector;

public class IntPart {
    public static String part(long n) {
        int[][] enums = sumCombos(n);
        int[] prods = products(enums);
        int range = prods[prods.length-1] - prods[0];
        float average = 0;
        for (int i = 0; i < prods.length; i++) average += prods[i];
        average = Math.round(average/(double)prods.length * 100) / 100;
        float median = 0;
        if (prods.length % 2 != 0) {
            median = prods[(int)Math.floor((double)prods.length/2)];
        } else {
            float first = prods[prods.length/2-1];
            float second = prods[prods.length/2];
            median = (first + second) / 2;
        }
        return "Range: " + range + " Average: " + average + " Median: " + median;
    }

    private static int[][] sumCombos(long n) {
        if (n != (int)n) return new int[0][0];
        Vector<int[]> combos = new Vector();
        for (int i = 1; i <= n; i++) {
            int[][] temp = sumCombosOfNum(n, i, 1);
            for (int j = 0; j < temp.length; j++) combos.add(temp[j]);
        }
        return vectorToIntArray(combos);
    }

    private static int[][] sumCombosOfNum(long n, int b, int min) {
        if (b <= 0) return new int[0][0];
        if (b == 1) return new int[][] {{(int)n}};
        Vector<int[]> combos = new Vector();
        if (b == 2) {
            for (int i = min; i <= n / 2; i++) combos.add(new int[] {i, (int)n - i});
            return vectorToIntArray(combos);
        }
        //we only get here if b is greater than 2
        boolean calculate = true;
        int k = 1;
        Vector<int[]> parts = new Vector();
        while (calculate) {
            int[][] lowerCombo = sumCombosOfNum(n - k, b - 1, k);
            for (int i = 0; i < lowerCombo.length; i++) {
                int[] temp = new int[lowerCombo[i].length + 1];
                temp[0] = k;
                for (int j = 1; j < lowerCombo.length + 1; j++) temp[j] = lowerCombo[i][j-1];
                parts.add(lowerCombo[i]);
            }
            if (k >= lowerCombo[lowerCombo.length-1][lowerCombo[lowerCombo.length-1].length-1]) calculate = false;
            else k++;
        }
        return (int[][]) parts.toArray();
    }

    public static int[] products(int[][] enums) {
        Vector<Integer> prods = new Vector();
        for (int i = 0; i < enums.length; i++) {
            int[] temp = enums[i];
            int product = 1;
            for (int j = 0; j < temp.length; j++) {
                product = 1 * temp[j];
            }
            prods.add(product);
        }
        int[] temp = new int[prods.size()];
        for (int i = 0; i < prods.size(); i++) temp[i] = prods.get(i);
        Arrays.sort(temp);
        return temp;
    }

    private static int[][] vectorToIntArray(Vector<int[]> vector) {
        int[][] result = new int[vector.size()][vector.get(0).length];
        for (int i = 0; i < vector.size(); i++) {
            for (int j = 0; j < vector.get(i).length; j++) result[i][j] = vector.get(i)[j];
        }
        return result;
    }
}