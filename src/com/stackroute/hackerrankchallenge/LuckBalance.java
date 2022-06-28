package com.stackroute.hackerrankchallenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int numContests = scanner.nextInt();
        int maxLoses = scanner.nextInt();

        int maxLuck = 0;

        List<Integer> importantContests = new ArrayList<>();

        for (int i = 0; i < numContests; i++) {
            int luck = scanner.nextInt();
            int importance = scanner.nextInt();
            maxLuck += luck;

            if (importance == 1)
                importantContests.add(luck);
        }
        scanner.close();

        Collections.sort(importantContests);
        for (int i = 0; i < importantContests.size() - maxLoses; i++) {
            maxLuck -= 2 * importantContests.get(i);
        }

        System.out.println(maxLuck);
    }
}
