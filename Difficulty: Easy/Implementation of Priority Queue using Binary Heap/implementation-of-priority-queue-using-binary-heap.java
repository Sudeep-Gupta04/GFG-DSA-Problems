// User function Template for Java

//  public static int H[]=new int[10009];
//  public static int s=-1;
// 1. parent(i): Function to return the parent node of node i
// 2. leftChild(i): Function to return index of the left child of node i
// 3. rightChild(i): Function to return index of the right child of node i
// 4. shiftUp(int i): Function to shift up the node in order to maintain the
// heap property
// 5. shiftDown(int i): Function to shift down the node in order to maintain the
// heap property.
// int s=-1, current index value of the array H[].

// You have to make a class of GFG to access the above functionalities like this - GFG
// obj=new GFG(); You can check the driver code for better understanding.
class Solution {
    public int extractMax() {
        // your code here
        GFG obj=new GFG();
        int n = obj.H.length;
        int ans = obj.H[0];
        obj.H[0] = obj.H[obj.s];
        obj.s--;
        obj.shiftDown(0);
        return ans;
    }
};
