https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1?page=1&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        int fo = findFirst(arr,n,x);
        int lo = findLast(arr,n,x);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(fo);
        ans.add(lo);
        return ans;
    }
    int findFirst(int arr[], int n, int x)
    {
        int fo = -1; int st =0; int ed = n-1;
        while(st<=ed)
        {
            int mid = (st+ed)/2;
            if(arr[mid]==x)
            {
                fo = mid;
                ed= mid-1;
            }else if(arr[mid]>x)    ed=mid-1;
            else st=mid+1;
        }
        return fo;
    }
    int findLast(int arr[], int n, int x)
    {
        int lo = -1; int st =0; int ed = n-1;
        while(st<=ed)
        {
            int mid = (st+ed)/2;
            if(arr[mid]==x)
            {
                lo = mid;
                st= mid+1;
            }else if(arr[mid]>x)    ed=mid-1;
            else st=mid+1;
        }
        return lo;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends