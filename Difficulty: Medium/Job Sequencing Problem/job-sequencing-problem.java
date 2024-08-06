//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the maximum profit and the number of jobs done.
     int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.profit==o2.profit) return o1.deadline-o2.deadline;
                else return o2.profit - o1.profit;
            }
        });
        int[] timeSlot = new int[n+1];
        for(int i =0;i<n+1;i++) timeSlot[i] = -1;

        int count =0;int p=0;
        for(int i =0;i<n;i++){
            if(timeSlot[arr[i].deadline]==-1) {
                p+=arr[i].profit;
                count++;
                timeSlot[arr[i].deadline]=1;
            }else{
                for(int j = arr[i].deadline ;j > 0 ;j--){
                    if(timeSlot[j]==-1){
                        p+=arr[i].profit;
                        count++;
                        timeSlot[j]=1;
                        break;
                    }
                }
            }
        }
        return new int[]{count,p};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/