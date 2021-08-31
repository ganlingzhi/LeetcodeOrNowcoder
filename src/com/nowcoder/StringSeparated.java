package com.nowcoder;

import java.util.Scanner;

public class StringSeparated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(str);
            int size = str.length();
            int addZero = 8 - size % 8;
            while (addZero > 0 && addZero<8) {
                stringBuilder.append("0");
                addZero--;
            }
            str = stringBuilder.toString();
            while (str.length() > 0) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }
        }
    }
}
