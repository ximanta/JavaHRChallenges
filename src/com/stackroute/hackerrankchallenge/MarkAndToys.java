package com.stackroute.hackerrankchallenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarkAndToys {
//    private static final Logger logger = LoggerFactory.getLogger(MarkToys.class);
//
//    public static void main(String[] args) {
//
//        int[] prices1 = {1, 12, 5, 111, 200, 1000, 10};
//        logger.info(String.valueOf(maximumToys(prices1, 50)));
//
//        int[] prices2 = {1, 2, 3, 4};
//        logger.info(String.valueOf(maximumToys(prices2, 7)));
//
//        int[] prices3 = {3, 7, 2, 9, 4};
//        logger.info(String.valueOf(maximumToys(prices3, 15)));
//    }

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {

        int sumPrices = 0;
        int maxToys = 0;

        if(prices.length == 0 || k == 0) return maxToys;

        List<Integer> toysPrices = Arrays.stream(prices).boxed().sorted().collect(Collectors.toList());

        while(sumPrices < k) {
            sumPrices = sumPrices + toysPrices.get(maxToys);
            if(sumPrices < k) maxToys++;
        }

        return maxToys;
    }
}
