https://leetcode.com/problems/course-schedule-ii/description/

class Solution {
    public int[] findOrder(int V, int[][]edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<edges.length ; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(v).add(u);
        }
        int[] indegree = new int[V];
        for(int i=0; i<V; i++)
        {
            for(int nbr: adj.get(i))
                indegree[nbr]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        int[]topo = new int[V];
        int i=0;
        while(q.size()>0)
        {
            int node = q.peek();
            q.remove();
            topo[i++]=node;
            for(int nbr: adj.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0)
                    q.add(nbr);
            }
        }

        if(i==V)  return topo;
        int[]arr = {};
        return arr;
    }
}