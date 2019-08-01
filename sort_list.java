/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    public static ListNode findMiddle(ListNode head){
        
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
        
    }
    
    public static ListNode merge_sort(ListNode head){
        
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode middle=findMiddle(head);
        
        ListNode temp=middle.next;
        middle.next=null;
        
        ListNode first=merge_sort(head);
        ListNode second=merge_sort(temp);
        
        return merge(first,second);
        
    }
    
    
    public static ListNode merge(ListNode head1, ListNode head2){
        
        if(head1==null){
            return head2;
        }
        
        if(head2==null){
            return head2;
        }
        
        ListNode a=head1;
        ListNode b=head2;
        ListNode p=null;
        
        if(head1.val<=head2.val){
            
            while(a!=null && b!=null){
                if(a.val<=b.val){
                    p=a;
                    a=a.next;
                }
                
                else{
                    p.next=b;
                    b=b.next;
                    p=p.next;
                    p.next=a;
                }
            }
            
            if(a==null){
                p.next=b;
                
            }
            
            return head1;
            
        }
        
        else{
            while(a!=null && b!=null){
                if(b.val<=a.val){
                    p=b;
                    b=b.next;
                }
                
                else{
                    p.next=a;
                    a=a.next;
                    p=p.next;
                    p.next=b;
                }
            }
            
            if(b==null){
                p.next=a;
                
            }
            
            return head2;
        }
        
        
    }
    
    public ListNode sortList(ListNode head) {
        
        return merge_sort(head);
    }
}
