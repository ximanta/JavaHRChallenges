package com.stackroute.hackerrankchallenge;

public class NewYearChaos {
//    private static final Logger logger = LoggerFactory.getLogger(NewYearChaos.class);
//
//    public static void main(String[] args) {
//
//        int[] queue1 = {2, 1, 5, 3, 4};
//        minimumBribes(queue1);
//
//        int[] queue2 = {5, 1, 2, 3, 7, 8, 6, 4};
//        minimumBribes(queue2);
//
//        int[] queue3 = {1, 2, 5, 3, 4, 7, 8, 6};
//        minimumBribes(queue3);
//
//        minimumBribes(null);
//
//    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        if(q == null) {
//            logger.info("Too chaotic");
            return;
        }

        int swapCount = 0;

        //Swap on inverse order
        for (int i=q.length -1; i>=0; i--) {
            if(q[i] != i+1) {
                if(((i -1) >=0) && q[i-1] == (i+1)) {
                    swapCount++;
                    swap(q, i, i-1);
                }else if(((i-2) >=0) && q[i-2]==(i+1)) {
                    swapCount+=2;
                    swap(q, i-2, i-1);
                    swap(q, i-1, i);
                }else {
//                    logger.info("Too chaotic");
                    return;
                }
            }
        }

//        logger.info(String.valueOf(swapCount));
    }

    private static void swap(int[] queue, int i, int j) {
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }
}
