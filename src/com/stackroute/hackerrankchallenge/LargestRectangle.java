package com.stackroute.hackerrankchallenge;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {

//    private static final Logger logger = LoggerFactory.getLogger(LargestRectangle.class);
//
//    public static void main(String[] args) {
//        int[] arr1 = {1,2,3,4,5};
//        logger.info(String.valueOf(largestRectangle(arr1)));
//    }

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {

        //Creating stack of span = [i, j]
        Stack<int[]> stack = new Stack<>();

        int j, max = 0, numBuildings = h.length;
        //Adding the numBuilding control value
        h = Arrays.copyOf(h, numBuildings + 1);

        for(int i = 0; i <= numBuildings; i++) {
            for(j = i; !stack.isEmpty() && h[stack.peek()[0]] >= h[i];) {
                int[] result = stack.pop();
                j = result[1];
                max = Math.max(max, h[result[0]] * (i - j));
            }

            stack.push(new int[]{i, j});
        }

        return max;
    }
}
