package com.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LongestUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] nums = new int[n][2];
            for (int j = 0; j < n; j++) {
                nums[j][0] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                nums[j][1] = scanner.nextInt();
            }
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] > o2[0]) {
                        return 1;
                    } else if (o1[0] < o2[0]) {
                        return -1;
                    } else {
                        if (o1[1] > o2[1]) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            });
            int[] numY = new int[n];
            for (int j = 0; j < n; j++) {
                numY[j] = nums[j][1];
            }
            System.out.println(longestSubArray(numY));
        }
    }

    private static int getLongest(int[] numY) {
        int len = numY.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numY[i] > numY[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    private static int longestSubArray(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0;
            int r = res;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (tails[m] < num)
                    l = m + 1;
                else
                    r = m;
            }
            tails[l] = num;
            if (r == res) {
                res++;
            }
        }
        return res;
    }
}
