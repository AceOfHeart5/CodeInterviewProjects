import java.util.Vector;

public class MaxSubarraySum {
    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;
        int[] best = new int[0];
        Vector<Integer> test = new Vector();
        for (int baseIndex = 0; baseIndex < arr.length - 1; baseIndex++) {
            if (arr[baseIndex] >= 0) {
                test.add(arr[baseIndex]);
                for (int i = baseIndex + 1; i < arr.length; i++) {
                    test.add(arr[i]);
                    if (getSum(test) > getSum(best)) {
                        int count = 0; best = new int[test.size()];
                        for (int k: test) best[count++] = k;
                    }
                }
                test.clear();
            }
        }
        return getSum(best);
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        return sum;
    }

    private static int getSum(Vector<Integer> vec) {
        int sum = 0;
        for (int i = 0; i < vec.size(); i++) sum += vec.elementAt(i);
        return sum;
    }
}
