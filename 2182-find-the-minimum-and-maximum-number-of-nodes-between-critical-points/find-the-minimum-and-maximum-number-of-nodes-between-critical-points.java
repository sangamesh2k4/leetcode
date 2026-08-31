/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode curr=head;
        int index=1;
        int first=-1;
        int last=-1;
        int minDist=Integer.MAX_VALUE;
        while(curr.next!=null){
            if((curr.val>prev.val && curr.val > curr.next.val) ||
             (curr.val<prev.val && curr.val<curr.next.val)){
                if(first==-1) {
                    first=index;
                }else{
                    minDist=Math.min(minDist,index-last);
                }
                last=index;
             }
             prev=curr;
             curr=curr.next;
             index++;
        }
        if(first==last) return new int[] {-1,-1};
        int maxDist=last-first;
        return new int[] {minDist,maxDist};
    }
}