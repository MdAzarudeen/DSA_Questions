https://www.geeksforgeeks.org/problems/stack-using-two-queues/1?page=1&category=Queue&sortBy=submissions

//{ Driver Code Starts
import java.util.*;


class StackUsingQueues
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            Queues g = new Queues();

            int q = sc.nextInt();
            while(q>0)
            {
                int QueryType = sc.nextInt();
                if(QueryType == 1)
                {
                    int a = sc.nextInt();
                    g.push(a);
                }
                else if(QueryType == 2)
                    System.out.print(g.pop()+" ");
                q--;
            }
            System.out.println();



            t--;
        }
    }
}


// } Driver Code Ends



class Queues
{
    Queue<Integer> main = new LinkedList<Integer>();
    Queue<Integer> aux = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    void push(int a)
    {
        // Your code here
        main.add(a);
    }

    //Function to pop an element from stack using two queues.
    int pop()
    {
        // Your code here
        if(main.size()==0)   return -1;
        while(main.size()>1)
            aux.add(main.poll());
        int ans = main.poll();
        while(aux.size()>0)
            main.add(aux.poll());

        return ans;
    }

}

