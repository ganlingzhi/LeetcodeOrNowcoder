package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorUtil {
    public static int[][] compare(int[][] t) {
        Arrays.sort(t, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    if (o1[1] > o2[1]) {
                        return -1;
                    } else if (o1[1] < o2[1]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        return t;
    }
}
