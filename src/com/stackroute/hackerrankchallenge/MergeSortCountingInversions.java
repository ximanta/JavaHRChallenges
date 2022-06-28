package com.stackroute.hackerrankchallenge;

import java.util.Arrays;

public class MergeSortCountingInversions {
//    private static final Logger logger = LoggerFactory.getLogger(MergeSortCountingInversions.class);
//
//    public static void main(String[] args) {
//
//        int[] arr1 = {1,1,1,2,2};
//        logger.info(String.valueOf(countInversions(arr1)));
//
//        int[] arr2 = {2,1,3,1,2};
//        logger.info(String.valueOf(countInversions(arr2)));
//
//        int[] arr3 = {1,5,3,7};
//        logger.info(String.valueOf(countInversions(arr3)));
//
//        int[] arr4 = {7,5,3,1};
//        logger.info(String.valueOf(countInversions(arr4)));
//    }

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {

        int n = arr.length;

        // Base Case
        if(n <= 1) return 0;

        // Recursive Case
        int mid = n >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        long inversions = countInversions(left) + countInversions(right);

        int range = n - mid;
        int leftIndex = 0, rightIndex = 0;

        for(int i = 0; i < n; i++) {
            if(leftIndex < mid && (rightIndex >= range || left[leftIndex] <= right[rightIndex])){
                arr[i] = left[leftIndex++];
                inversions += rightIndex;
            } else if(rightIndex < range) {
                arr[i] = right[rightIndex++];
            }
        }

        return inversions;
    }
}
