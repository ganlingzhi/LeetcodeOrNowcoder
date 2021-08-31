package com.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Quick {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 5, 7, 2, 4, 5};
        quickSort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
        Map<Integer, Integer> hashmap = new HashMap<>();
        hashmap.keySet().iterator();
    }

    private static void quickSort(int[] arrays, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        if (left < right) {
            stack.push(left);
            stack.push(right);
        } else {
            return;
        }
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            if (right <= left) {
                continue;
            }
            int mid = partition(arrays, left, right);
            if (left < mid - 1) {
                stack.push(left);
                stack.push(mid - 1);
            }
            if (right > mid + 1) {
                stack.push(mid + 1);
                stack.push(right);
            }
        }

    }

    private static int partition(int[] arrays, int left, int right) {
        int start = left;
        int key = arrays[left];
        while (left < right) {
            //从右往左找到比key小的数
            while (left < right && arrays[right] > key) {
                right--;
            }
            //从左往右找到比key大的数，注意要把=加上，不然left无法移动
            while (left < right && arrays[left] <= key) {
                left++;
            }
            swap(arrays, right, left);//交换left，right，重复这个过程，直到left==right
        }
        swap(arrays, start, left);
        return left;
    }

    private static void swap(int[] arrays, int right, int left) {
        int temp = arrays[left];
        arrays[left] = arrays[right];
        arrays[right] = temp;
    }
}
