//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1?page=1&category=Greedy&sortBy=submissions
//
//There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
//What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?
//
//Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
//
//
//Example 1:
//
//Input:
//N = 6
//start[] = {1,3,0,5,8,5}
//end[] =  {2,4,6,7,9,9}
//Output:
//4
//Explanation:
//Maximum four meetings can be held with
//given start and end timings.
//The meetings are - (1, 2),(3, 4), (5,7) and (8,9)


//Tc:- O(N log N);
//    N log N for sorting
//Sc:- O(N)


//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class meeting{
    int start;
    int end;
    int pos;
    meeting(int start, int end, int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}
class meetingComparator implements Comparator<meeting>{
    @Override
    public int compare(meeting m1, meeting m2)
    {
        if(m1.end<m2.end)   return -1;
        else if(m1.end>m2.end)  return 1;
        else if(m1.pos<m2.pos)  return -1;
        return 1;
    }
}
class Solution
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i=0; i<n; i++)
            meet.add(new meeting(start[i],end[i],i+1));

        meetingComparator mc = new meetingComparator();
        Collections.sort(meet,mc);

        ArrayList<Integer>ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for(int i=1; i<n; i++)
        {
            if(meet.get(i).start>limit)
            {
                limit=meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        return ans.size();
    }
}
