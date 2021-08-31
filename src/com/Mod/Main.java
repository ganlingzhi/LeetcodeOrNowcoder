package com.Mod;

import java.util.*;

public class Main {
    static long mod = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long A = scanner.nextInt();
            long B = scanner.nextInt();
            int n = scanner.nextInt();
            A %= mod;
            B %= mod;
            System.out.println(solve(A, B, n));
        }
    }

    private static Long solve(long a, long b, int n) {
        long[] res = new long[n + 1];
        res[1] =a ;
        res[2] = ((a * a) % mod - (2 * b) % mod + mod) % mod;
        if (n == 1) {
            return res[1];
        }
        if (n == 2) {
            return res[2];
        }
        for (int i = 3; i <= n; i++) {
            res[i] = (a * res[i - 1] % mod - b * res[i - 2] % mod + mod) % mod;
        }
        return res[n];
    }
}
