/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    public static ListNode kReverse(ListNode head, int k){
        
        int count=0;
        
        ListNode prev=null;
        ListNode curr=head;
        ListNode ahead=head.next;
        
        while(count<k){
            
            curr.next=prev;
            prev=curr;
            curr=ahead;
            if(ahead!=null)
                ahead=ahead.next;
            count++;
            
        }
        
        if(curr==null){
            return prev;
        }
        
        ListNode new_head=prev;
        
        ListNode t=head;
        
        ListNode start=curr;
        
        count=0;
        prev=null;
        
        while(true){
            
            count=0;
            
            while(count<k){
                
                curr.next=prev;
                prev=curr;
                curr=ahead;
                if(ahead!=null)
                    ahead=ahead.next;
                count++;
                
            }
            
            start.next=curr;
            t.next=prev;
            if(curr==null){
                return new_head;
            }
            
            t=start;
            start=curr;
            prev=null;
            
        }
        
    }
    
    public ListNode reverseList(ListNode head, int k) {
    
        if(head==null || head.next==null || k==1 || k==0){
            return head;
        }
        
        return kReverse(head,k);
    }
}
