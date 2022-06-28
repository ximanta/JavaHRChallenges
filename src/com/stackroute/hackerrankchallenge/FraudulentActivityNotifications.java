package com.stackroute.hackerrankchallenge;

import java.util.logging.Logger;
import java.util.stream.IntStream;

public class FraudulentActivityNotifications {
//    private static final Logger logger = LoggerFactory.getLogger(FraudulentActivityNotifications.class);
//
//    public static void main(String[] args) {
//        int[] exp1 = {2, 3, 4, 2, 3, 6, 8, 4, 5};
//        logger.info(String.valueOf(activityNotifications(exp1, 5)));
//
//        int[] exp2 = {1, 2, 3, 4, 4};
//        logger.info(String.valueOf(activityNotifications(exp2, 4)));
//    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        if (d == 1) {
            return 0;
        }

        int max = IntStream.of(expenditure).max().getAsInt();
        int[] countingSort = new int[max + 1];
        int notification = 0;

        for (int i = 0; i < d; i++) {
            countingSort[expenditure[i]]++;
        }

        for (int i = 0; i < expenditure.length - d; i++) {

            double median = median(countingSort);
            if (expenditure[i + d] >= median * 2) {
                notification++;
            }

            //remove first data
            countingSort[expenditure[i]]--;
            //add last data
            countingSort[expenditure[i + d]]++;
        }

        return notification;
    }

    /**
     * Find the median spending for a trailing number of days
     * @param count
     * @return double
     */
    private static double median(int[] count) {
        int values = IntStream.of(count).filter(e -> e > 0).sum();
        if (values % 2 == 0) {
            return (getIndex(count, (values / 2)) + getIndex(count, values / 2 + 1)) / 2.0;
        } else {
            return getIndex(count, (values + 1) / 2);
        }
    }

    /**
     * Get the index between values
     * @param count
     * @param d
     * @return int
     */
    private static int getIndex(int[] count, int d) {

        for (int sum = 0, i = 0; i < count.length; ++i) {
            sum += count[i];
            if (sum >= d) return i;
        }

        return 0;
    }
}
