package com.nowcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MixK {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6, 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28, 33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69, 47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83, 69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75};
        GetLeastNumbers_Solution(nums, 75);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = input[i];
        }
        MyHeap heap = new MyHeap(ans);

        for (int i = k; i < input.length; i++) {
            if (input[i] < heap.getRoot()) {
                heap.setRoot(input[i]);
            }
        }
        ans = heap.getData();
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
            res.add(ans[i]);
        }
        return res;
    }

    static class MyHeap {
        int[] data;

        public MyHeap(int[] data) {
            this.data = data;
            buildHeap();
        }

        private void buildHeap() {
            for (int i = 0; i <= (data.length / 2 - 1); i++) {
                heapify(i);
            }
        }

        private void heapify(int i) {
            int left = left(i);
            int right = right(i);
            int max = i;
            if (left < data.length && data[left] > data[i]) {
                max = left;
            }
            if (right < data.length && data[right] > data[max]) {
                max = right;
            }
            if (max == i) return;

            int temp = data[max];
            data[max] = data[i];
            data[i] = temp;

            heapify(max);

        }

        private int left(int i) {
            return i * 2 -1;
        }

        private int right(int i) {
            return i * 2 + 2;
        }

        public int size() {
            return data.length;
        }

        public int[] getData() {
            return data;
        }

        public int getRoot() {
            return data[0];
        }

        public void setRoot(int root) {
            data[0] = root;
            heapify(0);
        }
    }

}
