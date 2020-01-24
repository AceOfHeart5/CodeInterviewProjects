package com.company;
import java.util.List;
public class SumOfK {
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        if (ls.size() < k) return null;
        int[] karray = new int[k];
        for (int i = 0; i < k; i++) karray[i] = i;
        int sum = ls.get(0);
        for (int i = 1; i < k; i++) sum += ls.get(i);
        if (sum > t) sum = -1;
        while (karray[0] < ls.size() - k) {
            //process array
            int sumcheck = ls.get(karray[0]);
            for (int i = 1; i < karray.length; i++) {
                sumcheck += ls.get(karray[i]);
            }
            if (sumcheck > sum && sumcheck <= t) sum = sumcheck;
            //find next combination
            for (int i = k-1; i >= 0; i--) {
                if (karray[i]+1 <= ls.size()-k+i) {
                    karray[i]+=1;
                    for (int j = i+1; j < k; j++) {
                        karray[j] = karray[j-1]+1;
                    }
                    i = -1;//this kills the loop
                }
            }
        }
        if (sum == -1) return null;
        else return sum;
    }
}