package com.leetcode;
// use this quick select algorithm to find kth smallest element
public class QuickSelect {

    public int partition(int[] A, int l, int r) {
        int pivot = A[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }

        swap(A, i, r);
        return i;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int kthSmallest(int[] A, int l, int r, int K) {
        if (K < 0 || K > r - l + 1) {
            throw new RuntimeException("K is not valid");
        }

        int index = partition(A, l, r);
        if (index - l == K - 1) {
            return A[index];
        }

        if (index - l > K - 1) {
            return kthSmallest(A, l, index - 1, K);
        }
        return kthSmallest(A, index + 1, r, K - index + l - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 4, 5, 8 ,6 ,11, 26};
        int k = 3;
        QuickSelect quickSelect = new QuickSelect();
        System.out.println(quickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }
}
