//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends



class Solution {
   
    void buildHeap(int arr[], int n) {
        if (n == 1 || n == 0) {
            return;
        }
        int[] ans = new int[n + 1];
        ans[0] = Integer.MIN_VALUE; 
        ans[1] = arr[0]; 
        for (int i = 1; i < n; i++) {
            int k = i + 1;
            ans[k] = arr[i];  
            while (k > 1 && ans[k] > ans[k / 2]) {
                int temp = ans[k];
                ans[k] = ans[k / 2];
                ans[k / 2] = temp;
                k = k / 2;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = ans[i + 1];
        }
    }

    
    void heapify(int arr[], int n, int i) {
        while (2 * i + 1 < n) { 
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                i = largest;
            } else {
                break;
            }
        }
    }
    public void heapSort(int arr[], int n) {
        buildHeap(arr, n); 

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

  
}