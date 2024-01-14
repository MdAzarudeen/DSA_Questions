https://leetcode.com/problems/middle-of-the-linked-list/description/

class Solution {
    public ListNode middleNode(ListNode head) {
        int ct = 0;
        ListNode curr = head;
        while(curr!=null)
        {
            curr=curr.next;
            ct++;
        }
        int pos = ct/2;
        while(pos>0)
        {
            head = head.next;
            pos--;
        }
        return head;

    }
}