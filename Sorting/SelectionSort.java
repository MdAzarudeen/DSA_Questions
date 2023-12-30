https://www.geeksforgeeks.org/problems/selection-sort/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//Given an unsorted array of size N, use selection sort to sort arr[] in increasing order.
//
//
//        Example 1:
//
//        Input:
//        N = 5
//        arr[] = {4, 1, 3, 9, 7}
//        Output:
//        1 3 4 7 9

//{ Driver Code Starts
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            obj.selectionSort(arr, n);

            for(int i=0;i<n;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            t--;
        }

    }
}

// } Driver Code Ends

// Tc: O(N^2) - best, worst, average
// Selection sort means selects the minimum value and push it to first
class Solution
{
    void selectionSort(int arr[], int n)
    {
        //code here
        for(int i=0; i<n-1; i++)
        {
            int min = i;
            for(int j=i; j<n; j++)
            {
                if(arr[j]<arr[min])
                    min=j;
            }
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
}
