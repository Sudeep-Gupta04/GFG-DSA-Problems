//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Checker{
    int x;
    int y;
    int count;
    Checker(int x,int y,int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    static int min;
    Solution(){
        this.min = Integer.MAX_VALUE;
    }
    public static int findShortestPath(int[][] mat) {
    	int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        for(int i=0;i<mat.length;i++){
            if(mat[i][0]!=0 &&check(mat,i,0,dx,dy) ){
                findAns(mat,i,0,dx,dy);
            }
        }
        return (min==Integer.MAX_VALUE)?-1:min;
    }
    public static void findAns(int mat[][],int i,int j,int dx[],int dy[]){
        boolean visited[][] = new boolean[mat.length][mat[0].length];
        Queue<Checker> q = new LinkedList<>();
        q.add(new Checker(i,j,1));
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            Checker val = q.poll();
            if(val.y==mat[0].length-1){
                min = Math.min(min,val.count);
            }else{
                for(int k=0;k<4;k++){
                    if(find(mat,val,k,dx,dy,visited)) {
                    	q.add(new Checker(val.x+dx[k],val.y+dy[k],val.count+1));
                    	visited[val.x+dx[k]][val.y+dy[k]] = true;
                    }
                }
            }

        }
        
    }
    private static boolean find(int[][] mat, Checker val, int i, int[] dx, int[] dy,boolean visited[][]) {
		if(val.x+dx[i]<0 || val.y+dy[i]<0 || val.x+dx[i]>=mat.length || val.y+dy[i]>=mat[0].length || 
					visited[val.x+dx[i]][val.y+dy[i]]==true || mat[val.x+dx[i]][val.y+dy[i]]==0 ) {
			return false;
		}
		int ix = val.x+dx[i];
		int jy = val.y+dy[i];
		
        for(int k=0;k<4;k++){//check adjacent 0 or not.
            if( (jy+dy[k])<0  || (jy+dy[k])>=mat[0].length || (ix+dx[k])<0 || (ix+dx[k])>=mat.length ){
                //left right up down
                continue;
            }else if(mat[ix+dx[k]][jy+dy[k]]==0){
            	
                return false;
            }
        }
		return true;
	}

	public static boolean check(int mat[][],int i,int j,int dx[],int dy[]){

        for(int k=0;k<4;k++){//check adjacent 0 or not.
            if( (j+dy[k])<0  || (j+dy[k])>=mat[0].length || (i+dx[k])<0 || (i+dx[k])>=mat.length ){
                //left right up down
                continue;
            }else if(mat[i+dx[k]][j+dy[k]]==0){
            	
                return false;
            }
        }
        return true;
    }
}