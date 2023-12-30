https://www.geeksforgeeks.org/problems/quick-sort/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//Quick Sort is a Divide and Conquer algorithm. It picks an element as a pivot and partitions the given array around the picked pivot.
//Given an array arr[], its starting position is low (the index of the array) and its ending position is high(the index of the array).
//
//Note: The low and high are inclusive.
//
//Implement the partition() and quickSort() functions to sort the array.
//
//Example 1:
//
//Input:
//N = 5
//arr[] = { 4, 1, 3, 9, 7}
//Output:
//1 3 4 7 9

//{ Driver Code Starts
import java.util.*;
class Sorting
{
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();


            new Solution().quickSort(arr,0,n-1);
            printArray(arr);
            T--;
        }
    } }
// } Driver Code Ends

// Quick sort - select a pivot element (mostly the first element) and place
// all elements lesser than pivot on its left and all elements greater than pivot on its right

//TC: O(N log2N) -> best, case, worst
//SC: 1 -> as we dont consume any extra space

class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low>=high)   return;
        int partIndex = partition(arr,low,high);
        quickSort(arr,low,partIndex-1);
        quickSort(arr,partIndex+1,high);
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pivot = arr[low];
        int i=low;
        int j=high;
        while(i<j)
        {
            while(arr[i]<= pivot    &&  i<=high-1)
                i++;
            while(arr[j]>=pivot     && j>=low+1)
                j--;
            if(i<j)
                swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    static void swap( int[]arr, int a, int b)
    {
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
