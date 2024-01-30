https://www.codingninjas.com/studio/problems/sorted-array_6613259?leftPanelTabValue=PROBLEM

import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        int n = a.length;
        int m = b.length;
        int i=0; int j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<n && j<m)
        {
            if(a[i]<=b[j])
            {
                if(list.size()==0 || list.get(list.size()-1)!=a[i])
                    list.add(a[i]);
                i++;
            }
            else
            {
                if(list.size()==0 || list.get(list.size()-1)!=b[j])
                    list.add(b[j]);
                j++;
            }
        }
        while(i<n)
        {
            if( list.get(list.size()-1)!=a[i])
                list.add(a[i]);
            i++;
        }
        while(j<m)
        {
            if( list.get(list.size()-1)!=b[j])
                list.add(b[j]);
            j++;
        }
        return list;
    }
}