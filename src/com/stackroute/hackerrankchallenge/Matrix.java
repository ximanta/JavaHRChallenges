package com.stackroute.hackerrankchallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class Matrix {

//    private static final Logger logger = LoggerFactory.getLogger(Matrix.class);
//
//    public static void main(String[] args) {
//
//        int[][] roads1 = {{2,1,8},{1,0,5},{2,4,5},{1,3,4}};
//        int[] machines1 = {2,4,0};
//        logger.info(String.valueOf(minTime(roads1, machines1)));
//
//        int[][] roads2 = {{0,1,4},{1,2,3},{1,3,7},{0,4,2}};
//        int[] machines2 = {2,3,4};
//        logger.info(String.valueOf(minTime(roads2, machines2)));
//    }

    // Complete the minTime function below.
    static int minTime(int[][] roads, int[] machines) {

        int numCities = roads.length + 1;
        Arrays.sort(roads, (i, j) -> Integer.compare(j[2], i[2]));

        Map<Integer,Integer> parent = new HashMap<>();
        boolean[] redFlag = new boolean[numCities];

        for (int machine: machines) {
            redFlag[machine] = true;
        }

        // Find by Path Splitting
        IntFunction<Integer> find = i -> {
            while(i != parent.getOrDefault(i, i)) {
                i = parent.put(i, parent.get(i));
            }
            return i;
        };

        // Union by Size
        int[] size = new int[numCities];
        for(int i = 0; i < numCities; i++) {
            size[i] = 1;
        }

        ToIntFunction<int[]> union = roadArray -> {

            int rootU = find.apply(roadArray[0]);
            int rootV = find.apply(roadArray[1]);

            if(redFlag[rootU] && redFlag[rootV]) {
                return roadArray[2];
            }

            if(rootU != rootV) {

                if(size[rootU] > size[rootV]) {
                    int root = rootU;
                    rootU = rootV;
                    rootV = root;
                }

                parent.put(rootU, rootV);
                size[rootV] += size[rootU];
            }

            //bit-wise OR
            redFlag[rootU] |= redFlag[rootV];
            redFlag[rootV] |= redFlag[rootU];

            return 0;
        };

        return Arrays.stream(roads).map(union::applyAsInt).reduce(0, Integer::sum);
    }
}
