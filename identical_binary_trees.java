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
        
        if(root1==null || root2==null){
            return false;
        }
        
        if(root1.val!=root2.val){
            return false;
        }
        
        return func(root1.left,root2.left) && func(root1.right,root2.right);
        
    }
    
    public int isSameTree(TreeNode root1, TreeNode root2) {
        
        if(func(root1,root2)){
            return 1;
        }
        return 0;
    }
}
