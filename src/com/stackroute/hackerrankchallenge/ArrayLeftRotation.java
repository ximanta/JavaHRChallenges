package com.stackroute.hackerrankchallenge;

import java.util.Scanner;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = (i + n - k) % n;
            a[idx] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        in.close();
    }
}
