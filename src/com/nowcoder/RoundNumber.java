package com.nowcoder;

import java.util.Scanner;

public class RoundNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        num = num + 0.5d;
        System.out.println(((int) num));
    }
}
