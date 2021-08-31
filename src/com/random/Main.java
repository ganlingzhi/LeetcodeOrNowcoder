package com.random;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[1001];
            Arrays.fill(nums, 0);
            for (int i = 0; i < n; i++) {
                int k = scanner.nextInt();
                nums[k] = 1;
            }
            for (int i = 0; i < 1000; i++) {
                if (nums[i] == 1) {
                    System.out.println(i);
                }
            }
        }

    }
}
