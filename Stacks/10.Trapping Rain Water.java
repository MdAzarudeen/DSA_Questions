https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            //calling trappingWater() function
            System.out.println(obj.trappingWater(arr, n));
        }
    }
}


// } Driver Code Ends


class Solution{

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {
        int[]rmax = new int[n];
        rmax[n-1]=0;
        for(int i=n-2; i>=0; i--)
        {
            rmax[i]=Math.max(rmax[i+1],arr[i+1]);
        }

        int[]lmax= new int[n];
        lmax[0]=0;
        for(int i=1; i<n; i++)
        {
            lmax[i]=Math.max(lmax[i-1],arr[i-1]);
        }

        long ans =0;

        for(int i=0; i<n; i++)
        {
            int totalHeight = Math.min(rmax[i],lmax[i]);
            if(totalHeight>arr[i])
            {
                int waterHeight = totalHeight - arr[i];
                ans += waterHeight * 1;

            }
        }
        return ans;
    }
}


