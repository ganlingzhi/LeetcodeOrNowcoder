package com.jumpGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int maxMost = 0;
        for (int i = 0; i < n; i++) {
            if (maxMost >= n-1) {
                System.out.println("true");
                return;
            }
            if (maxMost >= i) {
                maxMost = Math.max(maxMost, i + nums[i]);
            }
        }
        System.out.println("false");
    }
}
