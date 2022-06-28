package com.stackroute.hackerrankchallenge;

public class SortingBubbleSort {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        countSwaps(a);

        int[] b = {3,2,1};
        countSwaps(b);
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {

        int totalSwaps = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {

            int numberOfSwaps = 0;

            for (int j = 0; j < length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }

            totalSwaps += numberOfSwaps;

            //If the array is sorted
            if (numberOfSwaps == 0) break;
        }

        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[length-1]);
    }

    private static void swap(int a[], int element1, int element2) {
        int temp = a[element1];
        a[element1] = a[element2];
        a[element2] = temp;
    }
}
