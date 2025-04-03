//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<vector<int>>> dp(n+1, vector<vector<int>>(2, vector<int>(3, -1)));
        return helper(0, 0, 2, dp, prices);
    }

    int helper(int i, int valid, int c, vector<vector<vector<int>>>& dp, vector<int>& prices) {
        int n = prices.size();
        if (i >= n) return 0;
        if (c <= 0) return 0;
        if (dp[i][valid][c] != -1) return dp[i][valid][c];

        // Buy
        int buy = 0;
        if (valid == 0 && c > 0) {
            buy = -prices[i] + helper(i + 1, 1, c, dp, prices);
        }

        // Hold
        int hold = helper(i + 1, valid, c, dp, prices);

        // Sell
        int sell = 0;
        if (valid == 1) {
            sell = prices[i] + helper(i + 1, 0, c - 1, dp, prices);
        }

        return dp[i][valid][c] = max(sell, max(hold, buy));
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;

        // Read first array
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int res = ob.maxProfit(arr);

        cout << res << endl << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends