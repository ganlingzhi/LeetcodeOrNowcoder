package com.longestPalindrome;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(longestPalindrome(str));
    }

    private static String longestPalindrome(String str) {
        if (str.length() < 2) {
            return str;
        }
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        char[] charArray = str.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (j - i + 1 > maxLen && dp[i][j]) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return str.substring(begin, begin + maxLen);
    }
}
