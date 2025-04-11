//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        long mod = 1000000007;
        long minNeg = Long.MIN_VALUE;
        long product = 1;
        int cpos = 0, cneg = 0, zero = 0;

        for (int num : arr) {
            if (num < 0) {
                cneg++;
                minNeg = Math.max(minNeg, num);
                product = ((product % mod) * ((num + mod) % mod)) % mod;
            } else if (num == 0) {
                zero++;
            } else {
                cpos++;
                product = ((product % mod) * (num % mod)) % mod;
            }
        }

        if (cneg % 2 != 0) {
            if (cneg == 1 && cpos == 0 && zero > 0) {
                return 0;
            }

            if (cneg == 1 && cpos == 0 && zero == 0) {
                return minNeg;
            }
            long inverse = modInverse((minNeg + mod) % mod, mod);
            product = (product * inverse) % mod;
        }

        if (cneg == 0 && cpos == 0) {
            return 0;
        }

        return product;
    }

    public long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    public long power(long a, long b, long mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }
}
