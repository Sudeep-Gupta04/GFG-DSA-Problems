//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
#define N 105
using namespace std;
void printArray(vector<int> arr, int size)
{
for (int i=0; i < size; i++)
	cout << arr[i] << " ";
}


// } Driver Code Ends

//User function Template for C++



class Solution {
    public:
    // Function to merge K sorted arrays.
    vector<int> mergeKArrays(vector<vector<int>> arr, int K) {
        vector<int> result;
        
        // Store all elements in a single list (vector)
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                result.push_back(arr[i][j]);
            }
        }
        
        // Sort the combined list
        sort(result.begin(), result.end());
        
        return result;
    }
};


//{ Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--){
	    int k;
	    cin>>k;
	    vector<vector<int>> arr(k, vector<int> (k, 0));
	    for(int i=0; i<k; i++){
	        for(int j=0; j<k; j++)
	        {
	            cin>>arr[i][j];
	        }
	    }
	    Solution obj;
    	vector<int> output = obj.mergeKArrays(arr, k);
    	printArray(output, k*k);
    	cout<<endl;
    
cout << "~" << "\n";
}
	return 0;
}






// } Driver Code Ends