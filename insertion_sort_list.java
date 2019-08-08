/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    public static ListNode sort(ListNode head){
        
        ListNode t=head.next;
        
        head.next=null;
        
        while(t!=null){
            
            ListNode temp=t;
            t=t.next;
            temp.next=null;
            
            ListNode p=null;
            ListNode t2=head;
            while(t2!=null && t2.val<temp.val){
                p=t2;
                t2=t2.next;
            }
            
            if(p==null){
                temp.next=head;
                head=temp;
            }
            
            else{
                p.next=temp;
                temp.next=t2;
            }
            
        }
        
        return head;
        
        
    }
    
    public ListNode insertionSortList(ListNode head) {
    
        if(head==null || head.next==null){
            return head;
        }
        
        return sort(head);
    }
}
