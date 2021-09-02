package com.huawei;

import java.util.Scanner;

public class LastString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' '){
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
