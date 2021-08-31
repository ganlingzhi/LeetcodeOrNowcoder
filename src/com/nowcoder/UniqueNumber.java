package com.nowcoder;

import java.util.Scanner;

public class UniqueNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = num + "";
        char[] chars = str.toCharArray();
        String res = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!res.contains(chars[i] + "")) {
                res += chars[i];
            }
        }
        System.out.println(Integer.parseInt(res));
    }
}
