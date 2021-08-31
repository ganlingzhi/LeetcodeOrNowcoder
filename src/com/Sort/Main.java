package com.Sort;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        int[] topK = new int[k];
        MnHeap minHeap = new MnHeap(topK);
        int o = 0;
        for (int i = 0; i < t; i++) {
            int p = scanner.nextInt();
            for (int j = 0; j < p; j++) {
                int temp = scanner.nextInt();
                System.out.println(minHeap.getRoot());
                if (temp > minHeap.getRoot()) {
                    minHeap.setRoot(temp);
                }
            }
        }
        topK = minHeap.data();
        Arrays.sort(topK);
        for (int i = topK.length - 1; i >= 0; i--) {
            System.out.println(topK[i]);
        }
    }
}


class MnHeap {
    private int[] data;

    public MnHeap(int[] data) {
        this.data = data;
        buildHeap();
    }

    private void buildHeap() {
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public int length() {
        return data.length;
    }

    public int[] data() {
        return data;
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if (left < data.length && data[left] < data[i]) {
            smallest = left;
        }
        if (right < data.length && data[right] < data[smallest]) {
            smallest = right;
        }
        if (i == smallest) {
            return;
        }
        swap(i, smallest);
        heapify(smallest);

    }

    private void swap(int i, int smallest) {
        int temp = data[i];
        data[i] = data[smallest];
        data[smallest] = temp;
    }

    private int left(int i) {
        return ((i + 1) << 1) - 1;
    }

    private int right(int i) {
        return (i + 1) << 1;
    }

    public int getRoot() {
        return data[0];
    }

    public void setRoot(int root) {
        data[0] = root;
        heapify(0);
    }
}
