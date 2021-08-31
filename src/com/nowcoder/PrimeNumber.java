package com.nowcoder;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long data = sc.nextLong();
        for (long i = 2; i <= Math.sqrt(data); i++) {
            while (data % i == 0) {
                System.out.print(i + " ");
                data = data / i;
            }
        }
        if (data != 1) {
            System.out.println(data + " ");
        }
    }
}
