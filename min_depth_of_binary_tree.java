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
            return Integer.MAX_VALUE;
        }
        
        if(root.left==null && root.right==null){
            return 1;
        }
        
        int l=func(root.left);
        int r=func(root.right);
        
        int ans=Math.min(l,r);
        
        if(ans!=Integer.MAX_VALUE){
            ans++;
        }
        
        return ans;
        
    }
    
    public int minDepth(TreeNode root) {
    
        return func(root);
    }
}
