/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    static TreeNode head=new TreeNode(-1);
    static TreeNode t=null;
    
    public static void func(TreeNode root){
        
        if(root==null){
            return ;
        }
        
        TreeNode l=root.left;
        TreeNode r=root.right;
        
        root.left=null;
        root.right=null;
        
        t.right=root;
        t=root;
        
        func(l);
        func(r);
        
        return ;
        
    }
    
    public TreeNode flatten(TreeNode root) {
        
        head=new TreeNode(-1);
        t=head;
        
        func(root);
        
        return head.right;
        
    }
}
