package com.nowcoder;

import java.util.Scanner;

public class HexadecimalConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(Integer.parseInt(str.substring(2),16));
        }
    }
}
