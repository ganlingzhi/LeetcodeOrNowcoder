package com.calculate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char target = scanner.nextLine().charAt(0);
        char upLowTarget ;
        int count = 0;
        if (target >= 'a' && target <= 'z') {
            upLowTarget = (char) (target + 'A' - 'a');
        } else {
            upLowTarget = (char) (target + 'a' - 'A');
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == upLowTarget || str.charAt(i) == target) {
                count++;
            }
        }
        System.out.println(count);
    }
}
