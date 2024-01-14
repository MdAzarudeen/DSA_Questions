https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        //Reading total number of testcases
        int t= sc.nextInt();

        while(t-- >0)
        {
            //reading the string
            String st = sc.next();

            //calling ispar method of Paranthesis class
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }
    }
}
// } Driver Code Ends



class Solution
{
    static boolean compare(char a, char b)
    {
        if(a=='{' && b=='}')    return true;
        else  if(a=='[' && b==']')    return true;
        else  if(a=='(' && b==')')    return true;

        return false;
    }
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        int n = x.length();
        Stack<Character> s = new Stack<>();
        for(int i=0; i<n; i++)
        {
            if(x.charAt(i)=='[' || x.charAt(i)=='{'   || x.charAt(i)=='(')
                s.push(x.charAt(i));
            else if(x.charAt(i)==']' || x.charAt(i)=='}'   || x.charAt(i)==')')
            {
                if(s.isEmpty()==true || !compare(s.peek(),x.charAt(i)))
                    return false;
                else
                    s.pop();
            }
        }
        if(s.isEmpty() == true)
            return true;
        else
            return false;
    }
}
