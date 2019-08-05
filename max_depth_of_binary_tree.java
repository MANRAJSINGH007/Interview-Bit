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
    
    public static int func(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        int l=func(root.left)+1;
        int r=func(root.right)+1;
        
        return Math.max(l,r);
        
    }
    
    public int maxDepth(TreeNode root) {
        
        return func(root);
    }
}
