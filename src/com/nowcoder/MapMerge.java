package com.nowcoder;

import java.util.TreeMap;
import java.util.Scanner;

public class MapMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            int val = scanner.nextInt();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + val);
            } else {
                map.put(key, val);
            }
        }
        for (int key : map.keySet()) {
            System.out.println(key+ " "+map.get(key));
        }
    }
}
