/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    static TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    static TreeNode first=null;
    static TreeNode second=null;
    
    public static void func(TreeNode root){
        
        if(root==null){
            return ;
        }
        
        func(root.left);
        
        if(first==null && root.val<prev.val){
            first=prev;
            second=root;
        }
        else if(root.val<prev.val){
            second=root;
        }
        
        prev=root;
        
        func(root.right);
        
    }
    
    
    public ArrayList<Integer> recoverTree(TreeNode root) {
        
        prev=new TreeNode(Integer.MIN_VALUE);
        first=null;
        second=null;
        
        func(root);
        
        ArrayList<Integer> list=new ArrayList<>();
        list.add(second.val);
        list.add(first.val);
        
        return list;
        
    }
}
