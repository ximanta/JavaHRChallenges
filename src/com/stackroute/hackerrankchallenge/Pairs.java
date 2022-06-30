package com.stackroute.hackerrankchallenge;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pairs {
//    private static final Logger logger = LoggerFactory.getLogger(Pairs.class);
//
//    public static void main(String[] args) {
//
//        int[] arr1 = {1,5,3,4,2};
//        logger.info(String.valueOf(pairs(2, arr1)));
//
//        int[] arr2 = {1,3,5,8,6,4,2};
//        logger.info(String.valueOf(pairs(2, arr2)));
//
//        int[] arr3 = {363374326, 364147530, 61825163, 1073065718, 1281246024,
//                1399469912, 428047635, 491595254, 879792181, 1069262793};
//        logger.info(String.valueOf(pairs(1, arr3)));
//
//    }

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {

        Set<Integer> numbers = IntStream.of(arr).boxed().collect(Collectors.toSet());
        Long numPairs = numbers.stream()
                .filter(i -> numbers.contains(i - k))
                .count();

        return numPairs.intValue();
    }
}
