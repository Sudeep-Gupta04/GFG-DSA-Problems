//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends




/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    // Function to get the maximum total value in the knapsack.
     class element {
        int index;
        double value;

        public element(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
    double fractionalKnapsack(int w, Item arr[], int n) {
        element[] vlBywt = new element[n];
        for(int i =0;i<arr.length;i++){
            vlBywt[i] = new element( i, (double) arr[i].value /arr[i].weight);
        }
        Arrays.sort(vlBywt, new Comparator<element>() {
            @Override
            public int compare(element o1, element o2) {
              return Double.compare(o2.value, o1.value);
            }
        });
        double ans =0;
        for(int i =0;i< arr.length && w > 0;i++){
            if(w>=arr[vlBywt[i].index].weight){
                ans+=arr[vlBywt[i].index].value;
                w = w  - arr[vlBywt[i].index].weight;
            }else {
                ans += (vlBywt[i].value * w);
                w = 0;
            }
        }
        return ans;
    }
}