package com.nowcoder;

public class MaxNums {
    public static void main(String[] args) {

    }

    public int maxSumOfSubArray(int[] arr) {
        int ans = 0;
        int thisSum = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum > ans) {
                ans = thisSum;
            }
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return ans;
    }
}
