//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
public:
    int solve(int N, int k, vector<int>& arr) {
        vector<int> pre(N);
        pre[N - 1] = arr[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            int c = 1;
            int pa = pre[i + 1] + arr[i];
            int tm = arr[i];

            for (int j = i; j < min(i + k, N); j++) {
                tm = max(tm, arr[j]);
                int suffix = (j + 1 >= N) ? 0 : pre[j + 1];
                pa = max(pa, c * tm + suffix);
                c++;
            }

            pre[i] = pa;
        }

        return pre[0];
    }
};


//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--){
        int n,k; cin>>n>>k;
        vector<int> arr;
        
        for(int i=0; i<n; ++i){
            int x; cin>>x;
            arr.push_back(x);
        }
        
        Solution obj;
        cout<<obj.solve(n,k,arr)<<"\n";
    
cout << "~" << "\n";
}
    return 0;
}
// } Driver Code Ends