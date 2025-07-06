// User function Template for Java

class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
        // Start from the last non-leaf node and heapify down to build max-heap
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapifyDown(i, arr, N);
        }
    }

    static void heapifyDown(int idx, int[] arr, int n) {
        int leftc = 2 * idx + 1;
        int rightc = 2 * idx + 2;
        int max = idx;

        if (leftc < n && arr[leftc] > arr[max]) max = leftc;
        if (rightc < n && arr[rightc] > arr[max]) max = rightc;

        if (max != idx) {
            // Swap
            int temp = arr[max];
            arr[max] = arr[idx];
            arr[idx] = temp;

            heapifyDown(max, arr, n);
        }
    }
}

