package com.stackroute.hackerrankchallenge;

import java.math.BigInteger;

public class MakingCandies {
//    private static final Logger logger = LoggerFactory.getLogger(MakingCandies.class);
//
//    public static void main(String[] args) {
//
//        logger.info(String.valueOf(minimumPasses(3, 1, 2, 12)));
//
//        logger.info(String.valueOf(minimumPasses(1, 1, 6, 45)));
//
//        logger.info(String.valueOf(minimumPasses(5184889632L, 5184889632L, 20, 10000)));
//    }

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {

        if (BigInteger.valueOf(m).multiply(BigInteger.valueOf(w))
                .compareTo(BigInteger.valueOf(n)) > 0) {
            return 1;
        }

        long minPass = Long.MAX_VALUE;
        long passes = 0;
        long candies = 0;

        while (true) {

            long remainPass = divideToCeil(n - candies, m * w);
            minPass = Math.min(minPass, passes + remainPass);

            if (remainPass == 1) {
                break;
            }

            if (candies < p) {

                long extraPass = divideToCeil(p - candies, m * w);

                passes += extraPass;
                candies += extraPass * m * w;

                if (candies >= n) {
                    minPass = Math.min(minPass, passes);
                    break;
                }
            }

            candies -= p;

            if (m <= w) {
                m++;
            } else {
                w++;
            }
        }

        return minPass;
    }

    static long divideToCeil(long x, long y) {
        return x / y + (x % y == 0 ? 0 : 1);
    }
}
