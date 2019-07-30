/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head==null || head.next==null || m==n){
            return head;
        }
        
        int count=1;
        
        if(m==1){
            
            ListNode t1=head;
            ListNode prev=null;
            ListNode curr=t1;
            ListNode ahead=t1.next;
            
            while(count!=n){
                count++;
                ahead=curr.next;
                curr.next=null;
                curr.next=prev;
                prev=curr;
                curr=ahead;
            }
            
            ListNode second_part=curr.next;
            curr.next=prev;
            head.next=second_part;
            head=curr;
            
            return head;
            
        }
        
        else{
            
            ListNode p1=null;
            ListNode t1=head;
            while(count!=m){
                count++;
                p1=t1;
                t1=t1.next;
            }
            
            // head to p1 is one part of linked list
            p1.next=null;
            ListNode temp=t1;
            
            ListNode prev=null;
            ListNode curr=t1;
            ListNode ahead=t1.next;
            
            while(count!=n){
                count++;
                ahead=curr.next;
                curr.next=null;
                curr.next=prev;
                prev=curr;
                curr=ahead;
            }
            
            ListNode third_part=curr.next;
            curr.next=prev;
            p1.next=curr;
            temp.next=third_part;
            
            
            return head;
        }
        
    }
}
