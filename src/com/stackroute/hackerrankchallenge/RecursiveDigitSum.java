package com.stackroute.hackerrankchallenge;

public class RecursiveDigitSum {
    //private static final Logger logger = LoggerFactory.getLogger(RecursiveDigitSum.class);

//    public static void main(String[] args) {
//        logger.info(String.valueOf(superDigit("148", 3)));
//        logger.info(String.valueOf(superDigit("9875", 4)));
//        logger.info(String.valueOf(superDigit("123", 3)));
//    }

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";
        return (n.length() > 1) ? superDigit(n, 1) : Character.getNumericValue(n.charAt(0));

    }
}
