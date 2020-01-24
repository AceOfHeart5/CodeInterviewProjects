// Java program to print all combination of size r in an array of size n
// Original Author: Devesh Agrawal
// Edited by: Evan Conway

class Combination {

    private static int combinationNum = 1;

    public static void main (String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6};
        int r = 4;
        printCombination(arr, r);
    }

    static void printCombination(int arr[], int r) {
        int data[]=new int[r];
        combinationUtil(arr, data, 0, 0);
    }

    static void combinationUtil(int arr[], int data[], int start, int index) {

        if (index >= data.length) printData(data);
        else {
            for (int i = start; i < arr.length; i++) {
                data[index] = arr[i];
                combinationUtil(arr, data, i + 1, index + 1);
            }
        }
        /*
        "&& end-i+1 >= data.length-index" makes sure that including one element at
        index will make a combination with remaining elements at remaining positions.
        Removing it does not appear to change the behavior, so we're leaving it out
        until we better understand what it does.
        */
    }

    static void printData(int[] data) {
        System.out.print("#" + combinationNum++ + ": \t");
        for (int j=0; j<data.length; j++) {
            System.out.print(data[j] + " ");
        }
        System.out.println("");
    }
} 