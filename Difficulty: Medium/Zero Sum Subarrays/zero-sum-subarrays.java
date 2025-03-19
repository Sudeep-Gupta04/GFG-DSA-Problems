//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline

        while (t-- > 0) {
            String input = sc.nextLine(); // Input array as a space-separated string
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            // Parse the input array
            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr));
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
     public int findSubarray(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int c  =0 ;
        for(int i =0;i<arr.length;i++){
            sum += arr[i];
            if(sum==0) c++;
            if(hm.containsKey(sum)){
                c += hm.get(sum);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
       // System.out.println(hm);
        return c;
    }
}
