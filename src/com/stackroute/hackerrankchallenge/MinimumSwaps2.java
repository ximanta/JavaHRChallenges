package com.stackroute.hackerrankchallenge;

public class MinimumSwaps2 {
//    private static final Logger logger = LoggerFactory.getLogger(MinimumSwaps2.class);
//
//    public static void main(String[] args) {
//        int[] arr1 = {4,3,1,2};
//        logger.info(String.valueOf(minimumSwaps(arr1)));
//
//        int[] arr2 = {2,3,4,1,5};
//        logger.info(String.valueOf(minimumSwaps(arr2)));
//
//        int[] arr3 = {1,3,5,2,4,6,7};
//        logger.info(String.valueOf(minimumSwaps(arr3)));
//    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int length = arr.length - 1;
        int minSwaps = 0;

        for (int i = 0; i < length; i++) {
            if (i < arr[i] - 1) {
                swap(arr, i, Math.min(length, arr[i] - 1));
                minSwaps++;
                i--;
            }
        }

        return minSwaps;
    }

    private static void swap(int a[], int element1, int element2) {
        int temp = a[element1];
        a[element1] = a[element2];
        a[element2] = temp;
    }
}
