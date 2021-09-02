package com.nowcoder;

import java.util.HashMap;

public class LongestUniqueArray {
    public static void main(String[] args) {


    }

    public int maxLength(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = 0;
        int left = -1;
        int right = 0;
        for (right = 0; right < arr.length; right++) {
            if (hashMap.containsKey(arr[right])) {
                left = Math.max(left, hashMap.get(arr[right]));
            }
            res = Math.max(res, right - left);

            hashMap.put(arr[right], right);
        }
        return res;
    }
}
