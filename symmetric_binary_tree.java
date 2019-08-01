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
    
    public static boolean func(TreeNode root1, TreeNode root2){
        
        if(root1==null && root2==null){
            return true;
        }
        
        if(root1==null && root2!=null){
            return false;
        }
        
        if(root1.val!=root2.val){
            return false;
        }
        
        return (func(root1.left,root2.right) && func(root1.right,root2.left));
        
    }
    
    public int isSymmetric(TreeNode root) {
        
        if(func(root,root)){
            return 1;
        }
        
        return 0;
    }
}
